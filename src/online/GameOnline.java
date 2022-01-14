package online;

import gui.UserInterface;
import static gui.UserInterface.cards;
import static gui.UserInterface.crd;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import video.loseVideo;
import video.winVideo;

public class GameOnline extends JFrame {   

     JPanel parentPanal, gamePanal, gameParentPanal,gameInfoPanal;
     JLabel[] arrayOfLabals;
     JLabel boardBackground,secondPlayerName, imageRecording,
            firstPlayerScore, secondPlayerScore, playerImage, computerImage, backImage,vsImage,selectMode,
             savedIcon,textHistory,tieScore,searchIcon,searchText;
    
    private int rowSelected;
    private int columnSelected; 
    private boolean continueToPlay = true;
    private boolean waiting = true;
    private boolean isStandAlone = false;

    int XOCounter = 0;
    public static JLabel firstPlayerName;
    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;
    public ClientBaseClass online;
    int firstPlayer;
    int secondPlayer;
    int tie;
    
     public GameOnline() {
        createAndShowGUI();
       
    }
    
    private void createGamePage() {

       
        parentPanal = new JPanel(null);
        gameParentPanal = new JPanel(null); 
        gameInfoPanal = new JPanel(null);
         
        firstPlayerScore = new JLabel("0", JLabel.CENTER);
        secondPlayerScore = new JLabel("0", JLabel.CENTER);
        tieScore = new JLabel("0", JLabel.CENTER);
        
        firstPlayerName = new JLabel();
       
        
        secondPlayerName = new JLabel();

        boardBackground = new JLabel();
        imageRecording = new JLabel();
        backImage = new JLabel();
        playerImage = new JLabel();
        computerImage = new JLabel();
        vsImage = new JLabel();
        searchIcon = new JLabel();
        searchText = new JLabel("Searching");
        savedIcon = new JLabel();
        textHistory = new JLabel("History");
        selectMode = new JLabel("Online");
        firstPlayer = Integer.valueOf(this.firstPlayerScore.getText());
        secondPlayer = Integer.valueOf(this.secondPlayerScore.getText());
         tie = Integer.valueOf(this.tieScore.getText());
        
            
        gamePanal = new JPanel(new GridLayout(3, 3, 8, 8));
        arrayOfLabals = new JLabel[9];
           for (int i = 0; i < arrayOfLabals.length; i++) {
            arrayOfLabals[i] = new JLabel("", JLabel.CENTER);
            arrayOfLabals[i].setFont(new Font("Verdana", Font.BOLD, 0));
            arrayOfLabals[i].setBackground(Color.cyan);
            gamePanal.add(arrayOfLabals[i]);
        }
           
       ImageIcon imageIconBoard = new ImageIcon(getClass().getClassLoader().getResource("images/board_1.png"));
        boardBackground.setIcon(imageIconBoard);

       ImageIcon imageIconPlayer = new ImageIcon(getClass().getClassLoader().getResource("images/player_image.png"));
        playerImage.setIcon(imageIconPlayer);

        ImageIcon imageIconComputer = new ImageIcon(getClass().getClassLoader().getResource("images/player_image.png"));
        computerImage.setIcon(imageIconComputer);

        ImageIcon imageIconBack = new ImageIcon(getClass().getClassLoader().getResource("images/back_2.png"));
        backImage.setIcon(imageIconBack);

        ImageIcon imageIconRecording = new ImageIcon(getClass().getClassLoader().getResource("images/record.png"));
        imageRecording.setIcon(imageIconRecording);
        
        ImageIcon imageIconVS = new ImageIcon(getClass().getClassLoader().getResource("images/vs.png"));
        vsImage.setIcon(imageIconVS);
        
        ImageIcon imageIconSaved = new ImageIcon(getClass().getClassLoader().getResource("images/save.png"));
        savedIcon.setIcon(imageIconSaved);
        
        ImageIcon searchIconIamge = new ImageIcon(getClass().getClassLoader().getResource("images/search.png"));
        searchIcon.setIcon(searchIconIamge);

        // panal for game
        parentPanal.add(gameParentPanal);
        gameParentPanal.setBackground(new Color(214, 229, 250));
        gameParentPanal.add(boardBackground);
        boardBackground.setBounds(75, 120, 300, 300);

        gameParentPanal.setBounds(0, 0, 450, 550);
        gameParentPanal.add(gamePanal);
        gamePanal.setBounds(75, 120, 300, 300);
        gamePanal.setBackground(null);
        gamePanal.setOpaque(false);
        
        gameParentPanal.add(selectMode);
        selectMode.setBounds(200, 10, 100, 100);
        selectMode.setForeground(new Color(255, 128, 134));
        selectMode.setFont(new Font("Arial", Font.BOLD, 20));
        
        gameParentPanal.add(backImage);
        backImage.setBounds(20, 20, 32, 32);

        gameParentPanal.add(imageRecording);
        imageRecording.setBounds(380, 20, 64, 64);
        
        //info panal 
        parentPanal.add(gameInfoPanal);
        gameInfoPanal.setBackground(new Color(255, 249, 249));
        gameInfoPanal.setBounds(450, 0, 850, 550);

        gameInfoPanal.add(savedIcon);
        savedIcon.setBounds(270, 300, 64, 64);
        
        gameInfoPanal.add(textHistory);
        textHistory.setBounds(280, 340, 64, 64);
   
        gameInfoPanal.add(playerImage);
        playerImage.setBounds(70, 50, 50, 50);

        gameInfoPanal.add(computerImage);
        computerImage.setBounds(270, 50, 50, 50);
        
        gameInfoPanal.add(searchIcon);
        searchIcon.setBounds(270, 50, 50, 50);
        
        gameInfoPanal.add(searchText);
        searchText.setForeground(Color.GRAY);
       // searchText.setFont(new Font("Arial", Font.BOLD, 20));
        searchText.setBounds(267, 85, 60, 60);
            
        gameInfoPanal.add(vsImage);
        vsImage.setBounds(180, 20, 64, 64);
        
        gameInfoPanal.add(firstPlayerName);
        firstPlayerName.setBounds(75, 80, 64, 64);
        
        gameInfoPanal.add(secondPlayerName);
        secondPlayerName.setBounds(275, 80, 64, 64);
        
        gameInfoPanal.add(firstPlayerScore);
        firstPlayerScore.setForeground(Color.ORANGE);
        firstPlayerScore.setFont(new Font("Arial", Font.BOLD, 20));
        firstPlayerScore.setBounds(75, 110, 50, 50);

        gameInfoPanal.add(secondPlayerScore);
        secondPlayerScore.setForeground(Color.ORANGE);
        secondPlayerScore.setFont(new Font("Arial", Font.BOLD, 20));
        secondPlayerScore.setBounds(274, 110, 50, 50);
        
        gameInfoPanal.add(tieScore);
        tieScore.setForeground(Color.ORANGE);
        tieScore.setFont(new Font("Arial", Font.BOLD, 20));
        tieScore.setBounds(175, 140, 50, 50);
 
        
        
        gamePanal.setVisible(false);
        boardBackground.setVisible(false);
        computerImage.setVisible(false);
        firstPlayerScore.setVisible(false);
        secondPlayerScore.setVisible(false);
        tieScore.setVisible(false);
        
       // 
        ArrayList<Integer> positoins = new ArrayList<>();
        online = new ClientBaseClass(new ArrayList<JLabel>(Arrays.asList(arrayOfLabals)),gui.UserInterface.LabelName.getText()){
            @Override
            public void onFinsh() {
                super.onFinsh(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void onLetsPlay() {
                super.onLetsPlay(); //To change body of generated methods, choose Tools | Templates.
                searchIcon.setVisible(false);
                searchText.setVisible(false);
                
                 gamePanal.setVisible(true);
                 boardBackground.setVisible(true);
                 computerImage.setVisible(true);
                 firstPlayerScore.setVisible(true);
                 secondPlayerScore.setVisible(true);
                 tieScore.setVisible(true);
                 
                 secondPlayerName.setText(online.otherPlayerNmae);
                 firstPlayerName.setText(online.myName);
                 
            }

            @Override
            public void onDraw() {
                super.onDraw();
                tieScore.setText((tie + 1) + "");
            }

            @Override
            public void onLose() {
                super.onLose(); 
                new loseVideo().setVisible(true);
               secondPlayerScore.setText((secondPlayer + 1) + "");
            }

            @Override
            public void onWin() {
                super.onWin();
                 new winVideo().setVisible(true);
                firstPlayerScore.setText((firstPlayer + 1) + "");
                
            }

            @Override
            public void onSelect(JLabel button, String symbole) {
                super.onSelect(button, symbole); 
                if(symbole.equals(ClientBaseClass.X)){
                 button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/x.png")));
                }else{
                    button.setIcon(new ImageIcon(getClass().getClassLoader().getResource("images/o.png")));
                //     symbole.equals(ClientBaseClass.O);
                }
                
               
                
              //  positoins.add(this.getButtonPosition(button));
            }
        };

       firstPlayerName.setText(online.myName);
        secondPlayerName.setText(online.otherPlayerNmae);
        System.out.println("online: ");
        System.out.println(online.myName);
        System.out.println(online.otherPlayerNmae);
        System.out.println("end online: ");
        
         backImage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                 UserInterface mm = new UserInterface();
                  mm.setVisible(true);
                  crd = (CardLayout) cards.getLayout();
                  crd.show(cards,"card4");   
                  setVisible(false);
                   if(firstPlayerName.getText().equals("Guest")){
                     mm.onlineBtn1.setText("LOG IN");
                 }
                  mm.score(firstPlayerName.getText(),firstPlayerScore.getText(),secondPlayerScore.getText(),tieScore.getText());
                 gui.UserInterface.LabelName.setText(firstPlayerName.getText());
                 
            }
        });
        

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

}
