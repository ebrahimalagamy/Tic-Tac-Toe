/*
 Method to SignUP
 Method to login
 */
package guiGame;

import guiGame.GamePlayer.requestTypes;

public class controler {
    
    
    public static String signIn(String name , String password){
    return (requestTypes.login.name()+"+"+name+"+"+password);
    }
    
    public static String signUp(String name,  String password , String email){
    return (requestTypes.register.name()+"+"+name+"+"+password+"+"+email);
    }
    
    public static String getData(String name,  String password , String email){
    return (requestTypes.getData.name());
    }

}
