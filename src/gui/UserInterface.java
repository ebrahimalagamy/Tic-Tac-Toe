package gui;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import tic.tac.toe.TicTacToe;

public class UserInterface extends javax.swing.JFrame {

    
    GamePlayer player;
    CardLayout crd;

    public UserInterface() {
        player = new GamePlayer(this);
        initComponents();
      
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cards = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        signInBtn = new javax.swing.JButton();
        signupBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnGuest = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        createaccountBtn = new javax.swing.JButton();
        cancelBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jPanel4 = new javax.swing.JPanel();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        label6 = new java.awt.Label();
        tName = new java.awt.TextField();
        tLoses = new java.awt.TextField();
        tEmail = new java.awt.TextField();
        tTie = new java.awt.TextField();
        tWins = new java.awt.TextField();
        tGamesPLAYED = new java.awt.TextField();
        label7 = new java.awt.Label();
        tID = new java.awt.TextField();
        btnHome = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tic Tac Toe");
        setSize(new java.awt.Dimension(724, 400));

        cards.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(214, 229, 250));
        jPanel1.setMinimumSize(new java.awt.Dimension(724, 400));
        jPanel1.setPreferredSize(new java.awt.Dimension(724, 400));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameField.setForeground(new java.awt.Color(153, 153, 153));
        usernameField.setText("Username");
        usernameField.setBorder(null);
        usernameField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usernameFieldMouseClicked(evt);
            }
        });
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });
        jPanel1.add(usernameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, 180, 20));

        passwordField.setForeground(new java.awt.Color(153, 153, 153));
        passwordField.setText("Password");
        passwordField.setBorder(null);
        passwordField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                passwordFieldMouseClicked(evt);
            }
        });
        jPanel1.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 200, 180, 20));

        signInBtn.setBackground(new java.awt.Color(204, 204, 204));
        signInBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        signInBtn.setForeground(new java.awt.Color(186, 79, 84));
        signInBtn.setText("Sign In");
        signInBtn.setBorder(null);
        signInBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInBtnActionPerformed(evt);
            }
        });
        jPanel1.add(signInBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 80, 30));

        signupBtn.setBackground(new java.awt.Color(204, 204, 204));
        signupBtn.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        signupBtn.setForeground(new java.awt.Color(186, 79, 84));
        signupBtn.setText("Sign Up");
        signupBtn.setBorder(null);
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });
        jPanel1.add(signupBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, 80, 30));

        jLabel11.setFont(new java.awt.Font("Viner Hand ITC", 1, 50)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(186, 79, 84));
        jLabel11.setText("Tic Tac Toe");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, 54));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 180, 10));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 220, 180, 10));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 200, -1, -1));
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 240, 240));
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(402, 160, -1, -1));

        btnGuest.setText("Play As A Guest");
        btnGuest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuestActionPerformed(evt);
            }
        });
        jPanel1.add(btnGuest, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, 180, -1));

        cards.add(jPanel1, "card1");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(724, 400));
        jPanel2.setPreferredSize(new java.awt.Dimension(724, 400));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(186, 79, 84));
        jLabel3.setText("Sign up for new account");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 32));

        jLabel5.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(186, 79, 84));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(186, 79, 84));
        jLabel6.setText("E-mail");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, -1));

        jLabel7.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(186, 79, 84));
        jLabel7.setText("Password");
        jLabel7.setToolTipText("");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        jTextField1.setForeground(new java.awt.Color(153, 153, 153));
        jTextField1.setText("Username");
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField1MouseClicked(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 172, 20));

        jTextField2.setForeground(new java.awt.Color(153, 153, 153));
        jTextField2.setText("E-mail");
        jTextField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jTextField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextField2MouseClicked(evt);
            }
        });
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 172, 20));

        jPasswordField1.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField1.setText("Password");
        jPasswordField1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });
        jPanel2.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 171, 20));

        jLabel8.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(186, 79, 84));
        jLabel8.setText("Confirm Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 200, -1, -1));

        jPasswordField2.setForeground(new java.awt.Color(153, 153, 153));
        jPasswordField2.setText("Password");
        jPasswordField2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), null));
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField2MouseClicked(evt);
            }
        });
        jPanel2.add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 220, 171, 20));

        createaccountBtn.setBackground(new java.awt.Color(204, 204, 204));
        createaccountBtn.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        createaccountBtn.setForeground(new java.awt.Color(186, 79, 84));
        createaccountBtn.setText("Create Account");
        createaccountBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createaccountBtnActionPerformed(evt);
            }
        });
        jPanel2.add(createaccountBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 300, 120, -1));

        cancelBtn.setBackground(new java.awt.Color(204, 204, 204));
        cancelBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelBtn.setForeground(new java.awt.Color(153, 153, 153));
        cancelBtn.setText("Cancel");
        cancelBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelBtnActionPerformed(evt);
            }
        });
        jPanel2.add(cancelBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 300, 110, -1));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 170, 10));

        jSeparator4.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 170, 10));

        jSeparator5.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 170, 10));

        jSeparator6.setForeground(new java.awt.Color(0, 0, 0));
        jPanel2.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 170, 10));

        cards.add(jPanel2, "card2");

        jPanel4.setBackground(new java.awt.Color(244, 91, 105));

        label1.setText("PLAYER NAME");

        label2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label2.setText("PLAYER EMAIL");

        label3.setText("Games PLAYED");

        label4.setText("WIN");

        label5.setText("LOSE");

        label6.setText("TIE");

        tLoses.setText("0");

        tTie.setText("0");

        tWins.setText("0");

        tGamesPLAYED.setText("0");

        label7.setText("PLAYER ID");

        btnHome.setText("Home");
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(label7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tWins, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(tLoses, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(tTie, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tGamesPLAYED, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tName, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(label7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tGamesPLAYED, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tLoses, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tWins, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(tTie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cards.add(jPanel4, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cards, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
 
    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBtnActionPerformed
        crd = (CardLayout) cards.getLayout(); 
        crd.show(cards,"card2");
    }//GEN-LAST:event_signupBtnActionPerformed

    private void cancelBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelBtnActionPerformed
        crd = (CardLayout) cards.getLayout(); 
        crd.show(cards,"card1");
    }//GEN-LAST:event_cancelBtnActionPerformed

    private void signInBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInBtnActionPerformed
        String dataSignIn = new String();
        dataSignIn=Controler.signIn(usernameField.getText(),passwordField.getText());
        player.sendSignInData(dataSignIn);
        
               
    }//GEN-LAST:event_signInBtnActionPerformed

    private void createaccountBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createaccountBtnActionPerformed
        crd = (CardLayout) cards.getLayout();
        String dataSignUp = new String();
        
        if(jTextField1.getText().equals("")||jPasswordField1.getText().equals("")||jTextField2.getText().equals("")){
            JOptionPane.showMessageDialog(null,"Must input NAME AND EMAIL AND PASSWORD","Error",1);}
        else{
            if (jPasswordField1.getText().equals(jPasswordField2.getText())){
                dataSignUp=Controler.signUp(jTextField1.getText(),jPasswordField1.getText(),jTextField2.getText());   
                player.sendSignUpData(dataSignUp);
               }
            else
            JOptionPane.showMessageDialog(null,"Don't match passwords","Error",1);}
        
    }//GEN-LAST:event_createaccountBtnActionPerformed

    private void jTextField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField1MouseClicked
        if( jTextField1.getText().equals("Username"))
        jTextField1.setText("");
    }//GEN-LAST:event_jTextField1MouseClicked

    private void jTextField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextField2MouseClicked
        if( jTextField2.getText().equals("E-mail"))
        jTextField2.setText("");
    }//GEN-LAST:event_jTextField2MouseClicked

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        if( jPasswordField1.getText().equals("Password"))
        jPasswordField1.setText("");
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField2MouseClicked
        if( jPasswordField2.getText().equals("Password"))
        jPasswordField2.setText("");
    }//GEN-LAST:event_jPasswordField2MouseClicked

    private void usernameFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameFieldMouseClicked
        if( usernameField.getText().equals("Username"))
        usernameField.setText("");
    }//GEN-LAST:event_usernameFieldMouseClicked

    private void passwordFieldMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordFieldMouseClicked
        if( passwordField.getText().equals("Password"))
        passwordField.setText("");
    }//GEN-LAST:event_passwordFieldMouseClicked

    private void btnGuestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuestActionPerformed

        new TicTacToe().setVisible(true);
        setVisible(false);
        TicTacToe.btnOnline.setVisible(false);

       // onlineBtn.setVisible(false);
        TicTacToe.btnPlayerProfile.setEnabled(false);
   
    }//GEN-LAST:event_btnGuestActionPerformed

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        crd = (CardLayout) cards.getLayout();
        crd.show(cards,"card3");
    }//GEN-LAST:event_btnHomeActionPerformed

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

    
    public static void main(String args[]) {
       
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuest;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton cancelBtn;
    private javax.swing.JPanel cards;
    private javax.swing.JButton createaccountBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label6;
    private java.awt.Label label7;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton signInBtn;
    private javax.swing.JButton signupBtn;
    private java.awt.TextField tEmail;
    private java.awt.TextField tGamesPLAYED;
    private java.awt.TextField tID;
    private java.awt.TextField tLoses;
    private java.awt.TextField tName;
    private java.awt.TextField tTie;
    private java.awt.TextField tWins;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables

    
  public void validSignIn(){
        new TicTacToe().setVisible(true);
        setVisible(false);
      //LName.setText(usernameField.getText());
      tName.setText(usernameField.getText());
      tName.setEditable(false);}
    
   public void inValidSignIn(){
    JOptionPane.showMessageDialog(null,"Error in username or password.","Error",1);}
   
   public void Duplicated(){
    JOptionPane.showMessageDialog(null,"Duplicated username","Error",1);
    crd = (CardLayout) cards.getLayout();
    crd.show(cards,"card2");}
   
   public void SignUp(){
    JOptionPane.showMessageDialog(null,"Saved data","Congratulations",1);
                new TicTacToe().setVisible(true);
                setVisible(false);
            //    LName.setText(jTextField1.getText());
                tName.setText(jTextField1.getText());
                tName.setEditable(false);}
   
    
}
