package tic.tac.toe;

import multiple.WelcomMultiple;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import single.SingleBoard;  

/**
 *
 * @author Ebrah
 */
public class TicTacToe extends JFrame {

    JPanel parentPanal,buttonPanal,gifPanal;
    JButton btnSingle,btnMultiple,btnOnline;
    JLabel boardBackground;
          
    private void createGamePage() {
        
        parentPanal = new JPanel(null);
        
        buttonPanal = new JPanel(null);
        gifPanal = new JPanel(null);
 
        
        btnSingle = new JButton("Single");
        btnMultiple = new JButton("Multiple");
        btnOnline = new JButton("Online");
        boardBackground = new JLabel();
        
        ImageIcon fillingIcon = new ImageIcon(getClass().getClassLoader().getResource("images/image.png"));
        boardBackground.setIcon(fillingIcon);
        
        parentPanal.add(buttonPanal);
        parentPanal.add(gifPanal);
        
        buttonPanal.add(btnSingle);
        buttonPanal.add(btnMultiple);
        buttonPanal.add(btnOnline);
        
        
        buttonPanal.setBounds(450, 0, 850, 550);
        gifPanal.setBounds(0, 0, 450, 550);
        gifPanal.add(boardBackground);
        
        btnSingle.setBounds(100, 160, 200,40);
        btnMultiple.setBounds(100, 220, 200,40);
        btnOnline.setBounds(100, 280, 200,40);
        boardBackground.setBounds(60,0,450,500);
        
        
        
        buttonPanal.setBackground(new Color(44, 7, 53));
        gifPanal.setBackground(Color.WHITE);
        
       
    }
    public TicTacToe() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        createGamePage();
        
        CardLayout card = new CardLayout();
        Container container = getContentPane();
        container.setLayout(card);  
        add(parentPanal);
        container.getLayout().addLayoutComponent("gamePage", parentPanal);
        
        btnSingle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               new SingleBoard().setVisible(true);
                setVisible(false);
                
            }
        });
        
        btnMultiple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
              new WelcomMultiple().setVisible(true);
              setVisible(false);
   
                
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
    
        new TicTacToe().setVisible(true);
        
        
    }  
    
    
}
