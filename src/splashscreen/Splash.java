/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package splashscreen;

import gui.UserInterface;

/**
 *
 * @author PC
 */
public class Splash {
    public static void main (String args[]) throws InterruptedException{
        SplashScreengui splash = new SplashScreengui();
        for(int i =0;i<=100;i++){
            Thread.sleep(40);
            splash.setLocationRelativeTo(null);
            splash.setVisible(true);
            splash.loading.setText("Loading.."+i+"%");
            splash.load.setValue(i);
            if (i==100){
                UserInterface user = new UserInterface();
                user.setLocationRelativeTo(null);
                user.setVisible(true);
                splash.setVisible(false);
            }
            
        }
    }
    
    
}
