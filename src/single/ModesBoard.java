package single;

import design.ButtonDesign;
import gui.UserInterface;
import static gui.UserInterface.*;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import static multiple.MultipleBoard.firstPlayerName;
import tic.tac.toe.TicTacToe;


public class ModesBoard extends JFrame {
    HardClass hard;
    JPanel parentPanal, gamePanal, gameParentPanal, gameInfoPanal;
    JLabel[] arrayOfLabals;
 public  JLabel boardBackground , secondPlayerName, imageRecording,
            firstPlayerScore, secondPlayerScore, playerImage, selectMode, computerImage, backImage, choseMode,vsImage,
            hardImage,esayImage,tieScore;
    JButton btnRestart, btnEasy, btnHard;
    public static  JLabel firstPlayerName;
    int XOCounter = 0;
    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;
    static JLabel pressedLabel;
    

    private void createGamePage() {

        parentPanal = new JPanel(null);
        gameParentPanal = new JPanel(null);
        gameInfoPanal = new JPanel(null);
        selectMode = new JLabel("Easy");
        choseMode = new JLabel("Select Level");
   
        firstPlayerScore = new JLabel("0", JLabel.CENTER);
        secondPlayerScore = new JLabel("0", JLabel.CENTER);
        tieScore = new JLabel("0", JLabel.CENTER);
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
        firstPlayerName = new JLabel();
       firstPlayerName.setText(gui.UserInterface.LabelName.getText());
        secondPlayerName = new JLabel("PC");

        ImageIcon imageIconBoard = new ImageIcon(getClass().getClassLoader().getResource("images/board_1.png"));
        boardBackground.setIcon(imageIconBoard);

        ImageIcon imageIconPlayer = new ImageIcon(getClass().getClassLoader().getResource("images/player_image.png"));
        playerImage.setIcon(imageIconPlayer);

        ImageIcon imageIconComputer = new ImageIcon(getClass().getClassLoader().getResource("images/computer_image.png"));
        computerImage.setIcon(imageIconComputer);

        ImageIcon imageIconBack = new ImageIcon(getClass().getClassLoader().getResource("images/back_2.png"));
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
            arrayOfLabals[i].setFont(new Font("Verdana", Font.BOLD, 0));
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
        selectMode.setBounds(200, 10, 64, 64);
        selectMode.setForeground(new Color(255, 128, 134));
        selectMode.setFont(new Font("Arial", Font.BOLD, 25));

        gameParentPanal.add(backImage);
        backImage.setBounds(20, 20, 64, 64);

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
        gameInfoPanal.add(tieScore);
        tieScore.setForeground(Color.ORANGE);
        tieScore.setFont(new Font("Arial", Font.BOLD, 20));
        tieScore.setBounds(175, 240, 50, 50);

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
            EasyClass e = new EasyClass(arrayOfLabals, parentPanal, firstPlayerScore, secondPlayerScore, pressedLabel, XOCounter,tieScore);
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
           
            check = hard.isOnePlayerGameEnds();
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
             pressedLabel = (JLabel) e.getSource();
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
        
        for (int i =0 ; i<9 ; i++){
            
        arrayOfLabals[i].setOpaque(false);
        arrayOfLabals[i].setText("");
        arrayOfLabals[i].addMouseListener(XOListener);
        arrayOfLabals[i].setIcon(null);
        
        }

        repaint();

    }

    public ModesBoard() {
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
                
         

            }
        });
        backImage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                  dispose();
                  UserInterface mm = new UserInterface();
                  mm.setLocationRelativeTo(null);
                  mm.setVisible(true);
                  mm.score(firstPlayerName.getText(),firstPlayerScore.getText(),secondPlayerScore.getText(),tieScore.getText());
                  crd = (CardLayout) cards.getLayout();
                  crd.show(cards,"card4");
                 gui.UserInterface.LabelName.setText(firstPlayerName.getText());
            }
        });
        

        btnHard.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               selectMode.setText("Hard");
              hard = new HardClass(arrayOfLabals, parentPanal, firstPlayerScore, secondPlayerScore, XOCounter,tieScore);
            }
        });
        
        btnEasy.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
               selectMode.setText("Easy");
               if (isGameEnds == false) {
                if (!pressedLabel.getText().toString().equals("O") && !pressedLabel.getText().toString().equals("X")) {
                    System.out.println("done");
                    isOnePlayerGameEnds(pressedLabel);
            }}}
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
                new ModesBoard();
            }
        });
    }

}
