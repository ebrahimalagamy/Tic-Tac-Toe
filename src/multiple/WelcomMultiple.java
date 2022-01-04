package multiple;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import single.SingleBoard;
import tic.tac.toe.TicTacToe;

public class WelcomMultiple  extends JFrame {
    
    JPanel parentPanal;
    JButton btnStart;
    JLabel backImage;
   public static TextField textFiledName;
    
    private void createGamePage() {
        
        parentPanal = new JPanel(null);
        btnStart = new JButton("Start");
        parentPanal.add(btnStart);
        btnStart.setBounds(325, 300, 200,40);
        
        backImage = new JLabel();
        ImageIcon imageIconBack = new ImageIcon(getClass().getClassLoader().getResource("images/back.png"));
        backImage.setIcon(imageIconBack);
        parentPanal.add(backImage);
        backImage.setBounds(20, 20, 32, 32);
        
        textFiledName = new TextField();
        parentPanal.add(textFiledName);
        textFiledName.setBounds(325, 250, 200,25);
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
                if(textFiledName.getText() == ""){
                    System.out.println("Please Enter name");
                }else{
                    
                    new MultipleBoard().setVisible(true);
                    setVisible(false);
                
                }
               
                
            }
        });
        
         backImage.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new TicTacToe().setVisible(true);
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
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WelcomMultiple();
            }
        });
    }
    
    
     
}
