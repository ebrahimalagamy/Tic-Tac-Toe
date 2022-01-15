package online;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ClientBaseClass {
    public static final int draw = 0;
    public static final int youWin = 1;
    public static final int youLose = 2;
    public static final int playing = 3;
    public static final String X= "X";
    public static final String O = "O";
    public static final String TIE= "tie";
    public static final String  move = "move";
    public static final String separator = ",";
    public static final String iWantToPlay = "iWantToPlay";
    public static final String  letsPlay= "letsPlay";
    public static final String  yourSymbole= "yourSymbole";
                public String myName;
    
    
   public int getButtonPosition(JLabel button){
       return buttons.indexOf(button);
   }
    
    public void onSelect(JLabel button,String symbole){
        button.setText(symbole);
    }
    
    public void onWin(){
        winnerSymbole = mySymbole;
        onFinsh();
       System.out.println("you win ");
    }
    
    public void onLose(){
        winnerSymbole = mySymbole.equals(X)?O:X;
        onFinsh();
        System.out.println("you lose ");
    }
    
    public void onDraw(){
        winnerSymbole = "TIE";
        onFinsh();
        System.out.println(" draw ");
    }
    
    public void onLetsPlay(){
        
    }
    
    public void onFinsh(){
        
    }

    public ClientBaseClass(ArrayList<JLabel> buttons,String myName) {
        this.myName= myName;
        try {
            this.buttons = buttons;
            
          
        for (JLabel gamePage_boardLabel : buttons) {
            gamePage_boardLabel.addMouseListener(listener);
        }
            s = new Socket("127.0.0.1",6060);
            dis= new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
                dos.writeUTF(iWantToPlay+separator+myName);
            new requestRecever().start();
        } catch (IOException ex) {
            Logger.getLogger(ClientBaseClass.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    
    public int getGameState(){
        
        System.out.println("getGameState");
        System.out.println(currentTurn==yourSymbole);
        System.out.println(currentTurn);
        System.out.println(mySymbole);
        System.out.println("end getGameState");
            for (int i =0;i<=2;i++) {
            if (
                buttons.get(i * 3).getText().equals(currentTurn) &&
                buttons.get((i * 3) + 1).getText().equals(currentTurn)&&
                buttons.get((i * 3) + 2).getText().equals(currentTurn)||

                buttons.get(i).getText().equals(currentTurn)  &&
                buttons.get(i + 3).getText().equals(currentTurn) &&
                buttons.get(i + 6).getText().equals(currentTurn)
                ) 
            {
                
                return  currentTurn.equals(mySymbole)?youWin:youLose;
            }
        } 

        if (
            buttons.get(0).getText().equals(currentTurn) &&
            buttons.get(4).getText().equals(currentTurn) &&
            buttons.get(8).getText().equals(currentTurn) ||
                
            buttons.get(2).getText().equals(currentTurn) &&
            buttons.get(4).getText().equals(currentTurn) &&
            buttons.get(6).getText().equals(currentTurn)
            )
        {
             
            return currentTurn.equals(mySymbole)?youWin:youLose;
        }
        
        for (JLabel button : buttons) {
            if(button.getText().equals(""))
               return playing;
        }
        
        return draw;
    }
    
    MouseListener listener = new MouseListener() {
        @Override
        public void mousePressed(MouseEvent e) {
            JLabel button = (JLabel)e.getSource();
            if(currentTurn.equals(mySymbole) && button.getText().equals("") && gameState==playing && !witingServer){
                try {
                    int pos = buttons.indexOf(button);
                    dos.writeUTF(move+separator+pos+separator+currentTurn);
                    witingServer = true;
                } catch (IOException ex) {
                    Logger.getLogger(ClientBaseClass.class.getName()).log(Level.SEVERE, null, ex);
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

    class requestRecever extends Thread{
        public void run(){
            while(true){
                try {
                    String message = dis.readUTF();
                    String[] request = message.split(separator);
                    System.out.println(message);
                    
                    if(request[0].equals(yourSymbole)){
                        mySymbole = request[1];
                        otherPlayerNmae = request[2];
                        
                        System.out.println(mySymbole);
                        System.out.println(otherPlayerNmae);
                        
                    }else if(request[0].equals(letsPlay)){
                        onLetsPlay();
                        currentTurn = X;
                    }else if(request[0].equals(move)){         
                        
                        System.out.println(request);
                        Integer pos = Integer.valueOf(request[1]);
                        onSelect(buttons.get(pos),currentTurn);
                        gameState = getGameState();

                        if(gameState == youWin)
                            onWin();
                        if(gameState == youLose)
                            onLose();
                        if(gameState == draw)
                            onDraw();
                        if(gameState == playing)
                            currentTurn = request[3];

                        witingServer = false;
                    }
                    
                    System.out.println(currentTurn);
                } catch (IOException ex) {
                    Logger.getLogger(ClientBaseClass.class.getName()).log(Level.SEVERE, null, ex);
                } 
                
            }
        }
    }

    public Socket s;
    public DataInputStream dis;
    public DataOutputStream dos;
    public ArrayList<JLabel> buttons;
    public boolean witingServer = false;
    public String mySymbole;
    public int gameState = playing;
    public String currentTurn = X;
    public String winnerSymbole;
    public String otherPlayerNmae;
    
    
}