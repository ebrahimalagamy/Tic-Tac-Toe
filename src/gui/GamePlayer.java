package gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 
 */
public class GamePlayer {
    UserInterface mygui;
     Socket mySocket;
     DataInputStream dataIn;
     DataOutputStream dataOut;
     Thread t;
     
     public static enum requestTypes{
         register,login,getData,setData,setMove
    }
   
    public GamePlayer(UserInterface gui){
       this.mygui=gui;
        try {
            mySocket = new Socket("127.0.0.1",6060);
            dataIn = new DataInputStream(mySocket.getInputStream());
            dataOut = new DataOutputStream(mySocket.getOutputStream());
        }
        catch (IOException ex) {Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
        
         t = new Thread( () -> {
             while(true){
                 try {
                     String msg = dataIn.readUTF();
                     searchDetailsOfRecievedMsg(msg);
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
             dataOut.writeUTF(dataSignUp);
         }
         catch (IOException ex) {Logger.getLogger(GamePlayer.class.getName()).log(Level.SEVERE, null, ex);}
    }
    
    public void searchDetailsOfRecievedMsg(String msg){
      String[] arrOfStringForMsg = msg.split("\\+");
      
      switch(arrOfStringForMsg[0]){
          case "validsignin":
              mygui.validSignIn();
              break;
          
          case "invalidsignin":
              mygui.inValidSignIn();
              break;
               
       }
    }
    
}