package gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GamePlayer {
    UserInterface mygui;
     Socket mySocket;
     DataInputStream dataIn;
     DataOutputStream dataOut;
     Thread t;

    void Data() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
      public static enum requestTypes{
         register,login,getData,setData,setMove,player1,player2,createroom}
   
    public GamePlayer(UserInterface gui){
       this.mygui=gui;
        try {
            //127.0.0.1  -   192.168.1.227
            mySocket = new Socket("127.0.0.1",6060);
            dataIn = new DataInputStream(mySocket.getInputStream());
            dataOut = new DataOutputStream(mySocket.getOutputStream());
        }
        catch (IOException ex) {Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
        
         t = new Thread( () -> {
             while(true){
                 try {
                     String read = dataIn.readUTF();
                     String[] arrOfStringForMsg = read.split("\\+");
                     String msg=arrOfStringForMsg[0];
                      switch(msg){
                                case "validsignin":
                                    mygui.validSignIn();
                                    break;
                                case "invalidsignin":
                                    mygui.inValidSignIn();
                                    break;
                              case "Duplicated":
                                    mygui.Duplicated();
                                    break;
                             case "SignUp":
                                    mygui.SignUp();
                                    break;
                               case "PlayerData":
                               
                                    gui.playerID.setText(arrOfStringForMsg[1]);
                                    gui.playerUsername.setText(arrOfStringForMsg[2]);
                                   // gui.playerWin.setText(arrOfStringForMsg[3]);
                                    gui.playerEmail.setText(arrOfStringForMsg[4]);
                                    gui.playerGames.setText(arrOfStringForMsg[5]);
                                    gui.playerWin.setText(arrOfStringForMsg[6]);
                                    gui.playerLoss.setText(arrOfStringForMsg[7]);
                                    gui.playerTie.setText(arrOfStringForMsg[8]);
                                    
                                    break;
                               case "Roomclosed": 
                                   
                                   break;
              
               }
                     
                 
                 }
                 catch (IOException ex) {Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
                }
       });
            t.start();
    }
    
    public void sendSignInData(String dataSignIn){
         try {
             dataOut.writeUTF(dataSignIn);
             }
         catch (IOException ex) { Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
    } 
    public void SendGetData(String getData){
         try {
             dataOut.writeUTF(getData);
             }
         catch (IOException ex) { Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
    } 
    
    public void sendSignUpData(String dataSignUp){
         try {
            // dataIn.readUTF();
             dataOut.writeUTF(dataSignUp);
         }
         catch (IOException ex) {Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
  /* public static String[] Data(){
       String[] data = msg.split("\\+");
       return data;
   }*/
    
   /* public void searchDetailsOfRecievedMsg(String msg){
     
    }*/
      
}