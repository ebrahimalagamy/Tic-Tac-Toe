package levels;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.imageio.ImageIO;

public class GameBoard extends JFrame {

    JPanel parentPanal,gamePanal,gameParentPanal,gameInfoPanal;
    JLabel[] arrayOfLabals;
    JLabel boardBackground,firstPlayerName, secondPlayerName,
            firstPlayerScore,secondPlayerScore,startPlayer;
    JButton btnRestart;
    int XOCounter = 0;
    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;

    private void createGamePage() {
        
        parentPanal = new JPanel(null);
        firstPlayerName = new JLabel("", JLabel.CENTER);
        secondPlayerName = new JLabel("", JLabel.CENTER);
        firstPlayerScore = new JLabel("0", JLabel.CENTER);
        secondPlayerScore = new JLabel("0", JLabel.CENTER);
        startPlayer = new JLabel("", JLabel.CENTER);
        gamePanal = new JPanel(new GridLayout(3, 3, 8, 8));
        arrayOfLabals = new JLabel[9];     
        btnRestart = new JButton("Restart");
        boardBackground = new JLabel();
        parentPanal.setBackground(new Color(186, 79, 84));
        gameParentPanal = new JPanel();
               
        ImageIcon fillingIcon = new ImageIcon(getClass().getClassLoader().getResource("images/board_1.png"));
        boardBackground.setIcon(fillingIcon);
        
        for (int i = 0; i < arrayOfLabals.length; i++) {
            arrayOfLabals[i] = new JLabel("", JLabel.CENTER);
            arrayOfLabals[i].setFont(new Font("Arial", Font.BOLD, 40));
            arrayOfLabals[i].setBackground(Color.yellow);
            gamePanal.add(arrayOfLabals[i]);
        }

        parentPanal.add(firstPlayerName);
        parentPanal.add(secondPlayerName);
        parentPanal.add(firstPlayerScore);
        parentPanal.add(secondPlayerScore);
        parentPanal.add(startPlayer);
        parentPanal.add(boardBackground);
        parentPanal.add(gamePanal);
        parentPanal.add(btnRestart);    
        parentPanal.add(gameParentPanal);
        
        gameParentPanal.setBounds(0, 0, 400, 550);      
        firstPlayerName.setBounds(400, 80, 150, 30);
        secondPlayerName.setBounds(550, 80, 150, 30);
        firstPlayerScore.setBounds(400, 100, 150, 30);
        secondPlayerScore.setBounds(550, 100, 150, 30);
        startPlayer.setBounds(120, 25, 150, 30);
        boardBackground.setBounds(45, 105, 300, 300);
        gamePanal.setBounds(45, 105, 300, 300);
        btnRestart.setBounds(600, 400, 140, 30);
    }

    private void colorBackgroundWinnerLabels(JLabel l1, JLabel l2, JLabel l3) {
        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        isGameEnds = true;
    }

    private boolean isOnePlayerGameEnds(JLabel pressedLabel) {
        boolean check = false;
        
        EasyMode e =new EasyMode(arrayOfLabals,parentPanal,firstPlayerScore,secondPlayerScore,pressedLabel,XOCounter);
        check = e.isOnePlayerGameEnds();
        XOCounter += 2;
        if(check)
        {
         removeXOListener();
            repaint();
        return true;
        }else{
        return false;
        }

    }

    private void removeXOListener() {
        for (JLabel gamePage_boardLabel : arrayOfLabals) {
            gamePage_boardLabel.removeMouseListener(XOListener);
        }
    }

    MouseListener XOListener = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel pressedLabel = (JLabel) e.getSource();
            if (isGameEnds == false) {
                if(!pressedLabel.getText().toString().equals("O") && !pressedLabel.getText().toString().equals("X")){
                    System.out.println("done");
                    isOnePlayerGameEnds(pressedLabel);      
                  }               
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
    };

    private void startNewGame() {

        isGameEnds = false;
        
        arrayOfLabals[0].setOpaque(false);
        arrayOfLabals[1].setOpaque(false);
        arrayOfLabals[2].setOpaque(false);
        arrayOfLabals[3].setOpaque(false);
        arrayOfLabals[4].setOpaque(false);
        arrayOfLabals[5].setOpaque(false);
        arrayOfLabals[6].setOpaque(false);
        arrayOfLabals[7].setOpaque(false);
        arrayOfLabals[8].setOpaque(false);

        arrayOfLabals[0].setText("");
        arrayOfLabals[1].setText("");
        arrayOfLabals[2].setText("");
        arrayOfLabals[3].setText("");
        arrayOfLabals[4].setText("");
        arrayOfLabals[5].setText("");
        arrayOfLabals[6].setText("");
        arrayOfLabals[7].setText("");
        arrayOfLabals[8].setText("");

        repaint();

        arrayOfLabals[0].addMouseListener(XOListener);
        arrayOfLabals[1].addMouseListener(XOListener);
        arrayOfLabals[2].addMouseListener(XOListener);
        arrayOfLabals[3].addMouseListener(XOListener);
        arrayOfLabals[4].addMouseListener(XOListener);
        arrayOfLabals[5].addMouseListener(XOListener);
        arrayOfLabals[6].addMouseListener(XOListener);
        arrayOfLabals[7].addMouseListener(XOListener);
        arrayOfLabals[8].addMouseListener(XOListener);

    }

    public GameBoard() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        createGamePage();
        
        CardLayout card = new CardLayout();
        Container container = getContentPane();
        container.setLayout(card);
        
        add(parentPanal);
        container.getLayout().addLayoutComponent("gamePage", parentPanal);

        for (JLabel gamePage_boardLabel : arrayOfLabals) {
            gamePage_boardLabel.addMouseListener(XOListener);
        }

                firstPlayerName.setText("X - hema");
                secondPlayerName.setText("O - Computer");
                firstPlayerScore.setText("0");
                secondPlayerScore.setText("0");
                card.show(container, "gamePage");

        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XOCounter =0;
                startNewGame();
                
            }
        });

        setTitle("Tic Tac Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 550);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GameBoard();
            }
        });
    }

}
