
package gui;
import gui.GamePlayer.requestTypes;
public class Controler {
    
    
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
