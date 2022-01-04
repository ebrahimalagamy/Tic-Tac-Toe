package single;

import design.ButtonDesign;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javafx.application.Application;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import tic.tac.toe.TicTacToe;
import video.VideoGame;

public class SingleBoard extends JFrame {

    JPanel parentPanal, gamePanal, gameParentPanal, gameInfoPanal;
    JLabel[] arrayOfLabals;
    JLabel boardBackground, firstPlayerName, secondPlayerName, imageRecording,
            firstPlayerScore, secondPlayerScore, playerImage, selectMode, computerImage, backImage, choseMode,vsImage,
            hardImage,esayImage;
    JButton btnRestart, btnEasy, btnHard;
    int XOCounter = 0;
    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;

    private void createGamePage() {

        parentPanal = new JPanel(null);
        gameParentPanal = new JPanel(null);
        gameInfoPanal = new JPanel(null);
        selectMode = new JLabel("Easy");
        choseMode = new JLabel("Select Level");
   
        firstPlayerScore = new JLabel("0", JLabel.CENTER);
        secondPlayerScore = new JLabel("0", JLabel.CENTER);
        gamePanal = new JPanel(new GridLayout(3, 3, 8, 8));
        arrayOfLabals = new JLabel[9];
        btnRestart = new ButtonDesign();
        btnRestart.setText("Restart");
        btnEasy = new ButtonDesign();
        btnEasy.setText("Easy");
        
        btnHard = new ButtonDesign();
        btnHard.setText("Hard");
        
        boardBackground = new JLabel();
        imageRecording = new JLabel();
        backImage = new JLabel();
        
        hardImage = new JLabel();
        esayImage = new JLabel();
        
        playerImage = new JLabel();
        computerImage = new JLabel();
        vsImage = new JLabel();
        firstPlayerName = new JLabel("Ebrahim");
        secondPlayerName = new JLabel("PC");

        ImageIcon imageIconBoard = new ImageIcon(getClass().getClassLoader().getResource("images/board_1.png"));
        boardBackground.setIcon(imageIconBoard);

        ImageIcon imageIconPlayer = new ImageIcon(getClass().getClassLoader().getResource("images/player_image.png"));
        playerImage.setIcon(imageIconPlayer);

        ImageIcon imageIconComputer = new ImageIcon(getClass().getClassLoader().getResource("images/computer_image.png"));
        computerImage.setIcon(imageIconComputer);

        ImageIcon imageIconBack = new ImageIcon(getClass().getClassLoader().getResource("images/back.png"));
        backImage.setIcon(imageIconBack);

        ImageIcon imageIconRecording = new ImageIcon(getClass().getClassLoader().getResource("images/record.png"));
        imageRecording.setIcon(imageIconRecording);
        
        ImageIcon imageIconVS = new ImageIcon(getClass().getClassLoader().getResource("images/vs.png"));
        vsImage.setIcon(imageIconVS);
        
        ImageIcon imageIconEasy = new ImageIcon(getClass().getClassLoader().getResource("images/easy.png"));
        esayImage.setIcon(imageIconEasy);
        
        ImageIcon imageIconHard = new ImageIcon(getClass().getClassLoader().getResource("images/hard.png"));
        hardImage.setIcon(imageIconHard);

        for (int i = 0; i < arrayOfLabals.length; i++) {
            arrayOfLabals[i] = new JLabel("", JLabel.CENTER);
            arrayOfLabals[i].setFont(new Font("Verdana", Font.BOLD, 50));
            arrayOfLabals[i].setBackground(Color.cyan);
            gamePanal.add(arrayOfLabals[i]);
        }

        // panal for game
        parentPanal.add(gameParentPanal);
        gameParentPanal.setBackground(new Color(214, 229, 250));
        gameParentPanal.add(boardBackground);
        boardBackground.setBounds(75, 120, 300, 300);

        gameParentPanal.setBounds(0, 0, 450, 550);
        gameParentPanal.add(gamePanal);
        gamePanal.setBounds(75, 120, 300, 300);
        gamePanal.setBackground(null);
        gameParentPanal.add(selectMode);
        selectMode.setBounds(200, 10, 50, 50);
        selectMode.setForeground(new Color(255, 249, 249));
        selectMode.setFont(new Font("Arial", Font.BOLD, 20));

        gameParentPanal.add(backImage);
        backImage.setBounds(20, 20, 32, 32);

        gameParentPanal.add(imageRecording);
        imageRecording.setBounds(380, 20, 64, 64);

        // panal for informaton 
        parentPanal.add(gameInfoPanal);
        gameInfoPanal.setBackground(new Color(255, 249, 249));
        gameInfoPanal.setBounds(450, 0, 850, 550);

        gameInfoPanal.add(choseMode);
        choseMode.setBounds(160, 10, 100, 50);
        choseMode.setForeground(new Color(112, 112, 112));

        gameInfoPanal.add(btnRestart);
        btnRestart.setBounds(80, 450, 250, 30);
        
        gameInfoPanal.add(esayImage);
        esayImage.setBounds(83, 57, 50, 50);
        
        gameInfoPanal.add(hardImage);
        hardImage.setBounds(83, 106, 50, 50);

        gameInfoPanal.add(btnEasy);
        btnEasy.setBounds(100, 70, 200, 30);

        gameInfoPanal.add(btnHard);
        btnHard.setBounds(100, 120, 200, 30);
        
        gameInfoPanal.add(playerImage);
        playerImage.setBounds(70, 200, 50, 50);

        gameInfoPanal.add(computerImage);
        computerImage.setBounds(270, 200, 50, 50);
        
        gameInfoPanal.add(vsImage);
        vsImage.setBounds(180, 170, 64, 64);
        
        gameInfoPanal.add(firstPlayerName);
        firstPlayerName.setBounds(75, 230, 64, 64);
        
        gameInfoPanal.add(secondPlayerName);
        secondPlayerName.setBounds(290, 230, 64, 64);
        
        gameInfoPanal.add(firstPlayerScore);
        firstPlayerScore.setForeground(Color.ORANGE);
        firstPlayerScore.setFont(new Font("Arial", Font.BOLD, 20));
        firstPlayerScore.setBounds(75, 260, 50, 50);

        gameInfoPanal.add(secondPlayerScore);
        secondPlayerScore.setForeground(Color.ORANGE);
        secondPlayerScore.setFont(new Font("Arial", Font.BOLD, 20));
        secondPlayerScore.setBounds(274, 260, 50, 50);

    }

    private void colorBackgroundWinnerLabels(JLabel l1, JLabel l2, JLabel l3) {
        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        isGameEnds = true;
        
       
    }

    private boolean isOnePlayerGameEnds(JLabel pressedLabel) {
        
        if(selectMode.getText()=="Easy"){
            
            boolean check = false;
            EasyClass e = new EasyClass(arrayOfLabals, parentPanal, firstPlayerScore, secondPlayerScore, pressedLabel, XOCounter);
            check = e.isOnePlayerGameEnds();
            XOCounter += 2;
            if (check) {
                removeXOListener();
                repaint();
                return true;
            } else {
                return false;
            }
        }else{
           
            System.out.println("from hard");
            boolean check = false;
            EasyClass e = new EasyClass(arrayOfLabals, parentPanal, firstPlayerScore, secondPlayerScore, pressedLabel, XOCounter);
            check = e.isOnePlayerGameEnds();
            XOCounter += 2;
            if (check) {
                removeXOListener();
                repaint();
                return true;
            } else {
                return false;
            }
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
                if (!pressedLabel.getText().toString().equals("O") && !pressedLabel.getText().toString().equals("X")) {
                    System.out.println("done");
                    isOnePlayerGameEnds(pressedLabel);
                }
            }
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
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

    public SingleBoard() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        createGamePage();
        add(parentPanal);
      

        for (JLabel gamePage_boardLabel : arrayOfLabals) {
            gamePage_boardLabel.addMouseListener(XOListener);
        }
        
        btnRestart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XOCounter = 0;
                startNewGame();
                
                Application.launch(VideoGame.class);

            }
        });
        backImage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new TicTacToe().setVisible(true);
                setVisible(false);
            }
        });

        btnHard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               selectMode.setText("Hard");
            }
        });
        
          btnEasy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               selectMode.setText("Easy");
            }
        });


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
                new SingleBoard();
            }
        });
    }

}
