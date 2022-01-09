package online;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

public class GameOnline extends JFrame implements Runnable{   
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;
    public static final int PLAYER1_WON = 1;
    public static final int PLAYER2_WON = 2;
    public static final int DRAW = 3;
    public static final int CONTINUE = 4;
  
    Socket socket;
    private boolean myTurn = false;
    private char myToken = ' ', otherToken = ' ';
    private Cell [][] cell = new Cell[3][3];
    private JLabel titleLabel = new JLabel();
    private JLabel statusLabel = new JLabel();
    
    private int rowSelected;
    private int columnSelected;
    
    private DataInputStream fromServer;
    private DataOutputStream toServer;
    
    private boolean continueToPlay = true;
    private boolean waiting = true;
    private boolean isStandAlone = false;
    
    JPanel parentPanal, gamePanal, gameParentPanal;
    JLabel[] arrayOfLabals;
    JLabel boardBackground;

    int XOCounter = 0;
    public static JLabel firstPlayerName;
    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;
    
     public GameOnline() {
        createAndShowGUI();
        connectToServer();
    }
    
     private void connectToServer() {
        try {
            //if it is standalone connect to the localhost
            if (isStandAlone)
                socket = new Socket("localhost", 6060);
            else
                socket = new Socket(InetAddress.getLocalHost(), 6060);
            
            fromServer = new DataInputStream(socket.getInputStream());
            toServer = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
        
        Thread thread = new Thread(this);
        thread.start();
    }

    private void createGamePage() {

        parentPanal = new JPanel(null);
        gameParentPanal = new JPanel(null);     
       
        gamePanal = new JPanel(new GridLayout(3, 3, 8, 8));
        gamePanal.setOpaque(false);
       
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3;j ++)
               gamePanal.add(cell[i][j] = new Cell(i,j));
        
        arrayOfLabals = new JLabel[9];
        boardBackground = new JLabel();

        firstPlayerName = new JLabel();
        ImageIcon imageIconBoard = new ImageIcon(getClass().getClassLoader().getResource("images/board_1.png"));
        boardBackground.setIcon(imageIconBoard);

        // panal for game
        parentPanal.add(gameParentPanal);
        gameParentPanal.setBackground(new Color(214, 229, 250));
        gameParentPanal.add(boardBackground);
        boardBackground.setBounds(75, 120, 300, 300);

        gameParentPanal.setBounds(0, 0, 450, 550);
        gameParentPanal.add(gamePanal);
        gamePanal.setBounds(75, 120, 300, 300);
        gamePanal.setBackground(null);

    }

   

    private void createAndShowGUI() {
        createGamePage();
        add(parentPanal);
        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameOnline();
            }
        });
    }

    @Override
    public void run() {
        try {
            //read which player
            int player = fromServer.readInt();
            
            //if first player set the token to X and wait for second player to join
            if(player == PLAYER1) {
                myToken = 'X';
                otherToken = 'O';
                titleLabel.setText("Player 1 with token 'X'");
                statusLabel.setText("Waiting for player 2 to join");
                
                //notification that player 2 joined
                fromServer.readInt();
              
                statusLabel.setText("Player 2 has joined. I start first");
                
                myTurn = true;
            }
            //if second player then game can start
            else if (player == PLAYER2) {
                myToken = 'O';
                otherToken = 'X';
                titleLabel.setText("Player 2 with token '0'");
                statusLabel.setText("Waiting for player 1 to move");
            }
            
            while (continueToPlay) {
                if (player == PLAYER1) {
                    waitForPlayerAction();
                    sendMove();
                    recieveInfoFromServer();
                }
                else if (player == PLAYER2) {
                    recieveInfoFromServer();
                    waitForPlayerAction();
                    sendMove();
                }
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
        } catch (InterruptedException ex) {}
       
    }
    private void waitForPlayerAction() throws InterruptedException {
        while (waiting) {
            Thread.sleep(100);
        }
        
        waiting = true;
    }
    
    private void sendMove() throws IOException {
        toServer.writeInt(rowSelected);
        toServer.writeInt(columnSelected);
    }
    
    private void recieveInfoFromServer() throws IOException {
        int status = fromServer.readInt();
        if (status == PLAYER1_WON) {
            continueToPlay = false;
            if (myToken == 'X') {
                statusLabel.setText("I Won! (X)");
            }
            else if (myToken == 'O') {
                statusLabel.setText("Player 1 (X) has won!");
                recieveMove();
            }
        }
        else if (status == PLAYER2_WON) {
            continueToPlay = false;
            if (myToken == 'O') {
                statusLabel.setText("I Won! (O)");
            }
            else if (myToken == 'X') {
                statusLabel.setText("Player 2 (O) has won!");
                recieveMove();
            }
        }
        else if (status == DRAW) {
            continueToPlay = false;
            statusLabel.setText("Game is over, no winner!");
            
            if (myToken == 'O') {
                recieveMove();
            }
        }
        else {
            recieveMove();
            statusLabel.setText("My turn");
            myTurn = true;
        }
    }
    
    private void recieveMove() throws IOException {
        int row = fromServer.readInt();
        int column = fromServer.readInt();
        cell[row][column].setToken(otherToken);
    }
    
     public class Cell extends JPanel {
        private int row, column;
        
        private char token = ' ';
        
        public Cell (int row, int column) {
            this.row = row;
            this.column = column;
            setBorder(new LineBorder(Color.black, 1));
            addMouseListener(new ClickListener());
        }
        
        public char getToken() {
            return token;
        }
        
        public void setToken(char c) {
            token = c;
            repaint();
        }
        
        //draw the tokens X and Y on the applet 
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (token == 'X') {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            }
            else if (token == 'O') {
                g.drawOval(10, 10, getWidth() - 20, getHeight() - 20);
            }
        }
        
        private class ClickListener extends MouseAdapter {
            @Override
            public void mouseClicked(MouseEvent e) {
                if ((token == ' ') && myTurn) {
                    setToken(myToken);
                    myTurn = false;
                    rowSelected = row;
                    columnSelected = column;
                    statusLabel.setText("Waiting for the other player to move");
                    waiting = false;
                }
            }
        }
    }   


}
