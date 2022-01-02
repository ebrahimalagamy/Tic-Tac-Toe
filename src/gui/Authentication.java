/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

public class Authentication {
    
    
    public static String signIn(String name , String password){
    return (name+"+"+password);
    }
    
    public static String signUp(String name, String password , String email){
    return (name+"+"+password+"+"+email);
    }

}
