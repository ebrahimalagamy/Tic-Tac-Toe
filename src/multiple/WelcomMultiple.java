package multiple;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import single.SingleBoard;
import tic.tac.toe.TicTacToe;



public class WelcomMultiple  extends JFrame {
    
    JPanel parentPanal;
    JButton btnStart;
    
    private void createGamePage() {
        
        parentPanal = new JPanel(null);
        btnStart = new JButton("Start");
        parentPanal.add(btnStart);
        btnStart.setBounds(100, 160, 200,40);
        
    }
    
    
    public WelcomMultiple() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        createGamePage();
        
        CardLayout card = new CardLayout();
        Container container = getContentPane();
        container.setLayout(card);  
        add(parentPanal);
        container.getLayout().addLayoutComponent("gamePage", parentPanal);
        
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
               new SingleBoard().setVisible(true);
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
    
    
     
}
