package Snake;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

class GamePanel extends JPanel implements ActionListener{

static final int SCREEN_WIDTH = 1000;
static final int SCREEN_HEIGHT = 700;
static final int UNIT_SIZE = 16;
static final int GAME_UNITS = (SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE;
int DELAY = 80;
final int x[] = new int[GAME_UNITS];
final int y[] = new int[GAME_UNITS];
int bodyParts = 5;
int applesEaten;
int appleX;
int appleY;
char direction = 'R';
boolean running = false;
Timer timer;
Random random;
JFrame frame = new JFrame("Snake");
JButton replay = new JButton("Home");
JButton exit2 = new JButton("Exit");
JButton level1 = new JButton("Easy");
JButton level2 = new JButton("Normal");
JButton level3 = new JButton("Hard");
JButton level4 = new JButton("Super");

GamePanel(){

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
frame.setResizable(false);
this.setLayout(null);
replay.setBackground(Color.WHITE);
replay.setForeground(Color.BLACK);
replay.setContentAreaFilled(false);
replay.setFocusPainted(false);
replay.setBorderPainted(false);
replay.setFont(new Font("MV Boli",Font.PLAIN,20));
replay.setBounds(995, 540, 102, 50);

exit2.setBackground(Color.WHITE);
exit2.setForeground(Color.BLACK);
exit2.setContentAreaFilled(false);
exit2.setFocusPainted(false);
exit2.setBorderPainted(false);
exit2.setFont(new Font("MV Boli",Font.PLAIN,20));
exit2.setBounds(995, 610, 102, 50);

level1.setBackground(Color.WHITE);
level1.setForeground(Color.BLACK);
level1.setContentAreaFilled(false);
level1.setFocusPainted(false);
level1.setBorderPainted(false);
level1.setFont(new Font("MV Boli",Font.PLAIN,20));

level1.setBounds(995, 150, 102, 40);

level2.setBackground(Color.WHITE);
level2.setForeground(Color.BLACK);
level2.setContentAreaFilled(false);
level2.setFocusPainted(false);
level2.setBorderPainted(false);
level2.setFont(new Font("MV Boli",Font.PLAIN,20));
level2.setBounds(995, 210, 102, 40);

level3.setBackground(Color.WHITE);
level3.setForeground(Color.BLACK);
level3.setContentAreaFilled(false);
level3.setFocusPainted(false);
level3.setBorderPainted(false);
level3.setFont(new Font("MV Boli",Font.PLAIN,20));
level3.setBounds(995, 270, 102, 40);

level4.setBackground(Color.WHITE);
level4.setForeground(Color.BLACK);
level4.setContentAreaFilled(false);
level4.setFocusPainted(false);
level4.setBorderPainted(false);
level4.setFont(new Font("MV Boli",Font.PLAIN,20));
level4.setBounds(995, 320, 102, 40);

random = new Random();
this.setPreferredSize(new Dimension(1100,688));
this.setBackground(Color.WHITE);
this.setFocusable(true);
this.addKeyListener(new MykeyAdapter());
this.add(replay);
this.add(exit2);
this.add(level1);
this.add(level2);
this.add(level3);
this.add(level4);
frame.add(this);
frame.pack();
frame.setLocationRelativeTo(null);

replay.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==replay){
frame.dispose();
NewFrame d = new NewFrame();
d.frame.setVisible(true);
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==replay){

replay.setForeground(Color.green);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==replay){

replay.setForeground(Color.BLACK);
}

}

});

exit2.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==exit2){
System.exit(0);
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==exit2){

exit2.setForeground(Color.red);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==exit2){

exit2.setForeground(Color.BLACK);
}

}

});

level1.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==level1){
frame.dispose();
GamePanel p = new GamePanel();
p.setFocusable(true);
p.frame.setVisible(true);

}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==level1){

level1.setForeground(Color.blue);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==level1){

level1.setForeground(Color.BLACK);
}

}

});

level2.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==level2){

frame.dispose();
GamePanel p1 = new GamePanel();
p1.setFocusable(true);
p1.frame.setVisible(true);
p1.DELAY = 60;
p1.startGame();
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==level2){

level2.setForeground(Color.blue);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==level2){

level2.setForeground(Color.BLACK);
}

}

});

level3.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==level3){
frame.dispose();
GamePanel p2 = new GamePanel();
p2.setFocusable(true);
p2.frame.setVisible(true);
p2.DELAY = 40;
p2.startGame();
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override

public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==level3){

level3.setForeground(Color.blue);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==level3){

level3.setForeground(Color.BLACK);
}

}

});

level4.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==level4){
frame.dispose();
GamePanel p3 = new GamePanel();
p3.setFocusable(true);
p3.frame.setVisible(true);
p3.DELAY = 20;
p3.startGame();
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e){

if(e.getSource()==level4){

level4.setForeground(Color.red);
}
}

@Override
public void mouseExited(MouseEvent e){

if(e.getSource()==level4){

level4.setForeground(Color.BLACK);
}

}

});

startGame();

}
public void startGame(){

newApple();
running = true;
timer = new Timer(DELAY,this);
timer.start();
}

public void paintComponent(Graphics g){

super.paintComponent(g);

draw(g);
}
public void draw(Graphics g){

if(running){
/* for(int i=0 ; i<(SCREEN_WIDTH*SCREEN_HEIGHT)/UNIT_SIZE ; i++){
g.drawLine(i*UNIT_SIZE, 0, i*UNIT_SIZE, SCREEN_HEIGHT);
g.drawLine(0, i*UNIT_SIZE, SCREEN_WIDTH, i*UNIT_SIZE);
}*/

g.setColor(new Color(150,150,60));
g.fillRect(0, 0, 992, 688);
g.setColor(Color.red);
g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);
if(bodyParts%5==0 && bodyParts!=5){

g.fillOval(appleX-2, appleY-2, 2*UNIT_SIZE, 2*UNIT_SIZE);
}

for(int i=0 ; i<bodyParts ; i++){

if(i==0){

g.setColor(Color.green);
g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
}
else{

// g.setColor(Color.green);
g.setColor(new
Color(random.nextInt(255),random.nextInt(255),random.nextInt(255)));
g.fillOval(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
}
}

g.setColor(Color.BLACK);
g.setFont(new Font("InkFree",Font.BOLD,20));
g.drawString("Score : "+applesEaten, 1003, 30);

}
else{

gameOver(g);
}

}
public void newApple(){

appleX = random.nextInt((int)(976/UNIT_SIZE))*UNIT_SIZE;
appleY = random.nextInt((int)(672/UNIT_SIZE))*UNIT_SIZE;

}
public void move(){

for(int i=bodyParts;i>0;i--){

x[i] = x[i-1];
y[i] = y[i-1];
}

switch(direction){

case 'U':
y[0] = y[0]-UNIT_SIZE;
break;
case 'D':
y[0] = y[0]+UNIT_SIZE;
break;
case 'L':
x[0] = x[0]-UNIT_SIZE;
break;
case 'R':
x[0] = x[0]+UNIT_SIZE;
break;

}

}
public void checkApple(){

if(x[0]==appleX && y[0]==appleY){

bodyParts++;
applesEaten++;
newApple();
}
if(bodyParts%5==0 && bodyParts!=5){

for(int i=appleX ; i<appleX+2*UNIT_SIZE ; i++){

if(x[0]==i && y[0]==appleY){

bodyParts++;
applesEaten+=5;
newApple();
}
}
for(int i=appleY ; i<appleY+2*UNIT_SIZE ; i++){

if(x[0]==i && y[0]==appleX){

bodyParts++;
applesEaten+=5;
newApple();
}
}
}

}
public void checkCollision(){

for(int i=bodyParts ; i>0 ; i--){

if((x[0]==x[i])&&(y[0]==y[i])){

running = false;
}
}
if(x[0]<0){

x[0]=976;
}
if(x[0]>976){

x[0]=0;
}
if(y[0]<0){

y[0]=672;
}
if(y[0]>672){

y[0]=0;
}

if(!running){

timer.stop();
}

}
public void gameOver(Graphics g){

g.setColor(Color.GRAY);
g.fillRect(0, 0, 992, 688);
g.setColor(Color.red);
g.setFont(new Font("InkFree",Font.BOLD,75));
FontMetrics metrics2 = getFontMetrics(g.getFont());
g.drawString("GAME OVER", (SCREEN_WIDTH-metrics2.stringWidth("GAMEOVER"))/2, SCREEN_HEIGHT/2);

g.setColor(Color.WHITE);
g.setFont(new Font("InkFree",Font.BOLD,40));
FontMetrics metrics1 = getFontMetrics(g.getFont());

g.drawString("SCORE :"+applesEaten,(SCREEN_WIDTH-
metrics1.stringWidth("SCORE :"+applesEaten))/2, g.getFont().getSize());

g.setColor(Color.BLACK);
g.setFont(new Font("InkFree",Font.BOLD,20));
g.drawString("Score :"+applesEaten, 1003, 30);

}

@Override
public void actionPerformed(ActionEvent e) {

if(running){

move();
checkApple();
checkCollision();
}

repaint();
}

public class MykeyAdapter extends KeyAdapter {

public void keyPressed(KeyEvent e) {
switch(e.getKeyCode()){

case KeyEvent.VK_LEFT:
if(direction !='R'){

direction = 'L';
}
break;
}
switch(e.getKeyCode()){

case KeyEvent.VK_RIGHT:
if(direction !='L'){

direction = 'R';
}
break;
}
switch(e.getKeyCode()){

case KeyEvent.VK_UP:
if(direction !='D'){

direction = 'U';
}
break;
}
switch(e.getKeyCode()){

case KeyEvent.VK_DOWN:
if(direction !='U'){

direction = 'D';
}
break;
}
}
}

}

class NewFrame implements MouseListener{
JFrame frame = new JFrame();
JPanel title_panel = new JPanel();
JPanel button_panel = new JPanel();
JLabel textField = new JLabel();
JButton play1 = new JButton("Play Now");
JButton exit1 = new JButton("Exit");
JButton maker = new JButton("Maker");

NewFrame(){

frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setSize(1000, 700);
frame.getContentPane().setBackground(new Color(50,50,50));
frame.setVisible(true);
frame.setResizable(false);
frame.setLocationRelativeTo(null);
frame.setLayout(new BorderLayout());

textField.setBackground(new Color(100,255,40));
textField.setForeground(new Color(255,25,5));
textField.setFont(new Font("Ink Free",Font.BOLD,75));
textField.setHorizontalAlignment(JLabel.CENTER);
textField.setText("Snack Game");
textField.setOpaque(true);

title_panel.setLayout(new BorderLayout());
title_panel.setBounds(0, 0, 1000, 300);

button_panel.setLayout(null);
button_panel.setBackground(new Color(100,255,40));

play1.setBackground(Color.WHITE);
play1.setForeground(Color.BLACK);
play1.setBorderPainted(false);
play1.setFocusPainted(false);
play1.setFont(new Font("MV Boli",Font.BOLD,50));

play1.setFocusable(false);
play1.addMouseListener(this);
play1.setBounds(300, 300, 400, 150);
button_panel.add(play1);

exit1.setBackground(Color.WHITE);
exit1.setForeground(Color.BLACK);
exit1.setBorderPainted(false);
exit1.setFocusPainted(true);
exit1.setFont(new Font("MV Boli",Font.BOLD,50));
exit1.setFocusable(false);
exit1.addMouseListener(this);
exit1.setBounds(300, 500, 400, 150);
button_panel.add(exit1);

maker.setBackground(Color.YELLOW);
maker.setForeground(Color.BLACK);
maker.setBorderPainted(false);
maker.setFocusPainted(false);
maker.setContentAreaFilled(false);
maker.setFont(new Font("MV Boli",Font.BOLD,18));
maker.setFocusable(false);
maker.setBounds(870, 640, 110, 30);
button_panel.add(maker);

title_panel.add(textField);

frame.add(title_panel,BorderLayout.CENTER);
frame.add(button_panel);

maker.addMouseListener(new MouseListener(){

public void mouseClicked(MouseEvent e){

if(e.getSource()==maker){
JOptionPane.showMessageDialog(null, "Name : Abo Al-SillProgrammer ", "help", JOptionPane.INFORMATION_MESSAGE);
}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e) {

if(e.getSource()==maker){

maker.setForeground(Color.WHITE);
}

}

@Override
public void mouseExited(MouseEvent e) {
if(e.getSource()==maker){

maker.setForeground(Color.BLACK);
}
}
});

}

@Override
public void mouseClicked(MouseEvent e){

if(e.getSource()== play1){
GamePanel s = new GamePanel();
s.setVisible(true);
frame.dispose();

}

if(e.getSource()== exit1){

if(JOptionPane.showConfirmDialog(null, "Are you want exit the game ",
"Exit", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION){

System.exit(0);
}

}
}

@Override
public void mousePressed(MouseEvent e) {}

@Override
public void mouseReleased(MouseEvent e) {}

@Override
public void mouseEntered(MouseEvent e) {

if(e.getSource()== play1){

if(play1.getText()=="Play Now"){

play1.setForeground(Color.GREEN);

play1.setBackground(Color.YELLOW);
}
}
if(e.getSource()== exit1){

if(exit1.getText()== "Exit"){

exit1.setForeground(Color.red);
exit1.setBackground(Color.YELLOW);
}
}

}

@Override
public void mouseExited(MouseEvent e) {

if(e.getSource()== play1){

if(play1.getText()=="Play Now"){

play1.setForeground(Color.BLACK);
play1.setBackground(Color.WHITE);
}
}
if(e.getSource()== exit1){

if(exit1.getText()== "Exit"){

exit1.setForeground(Color.BLACK);
exit1.setBackground(Color.WHITE);
}
}

}

}

public class Snake_Game {

public static void main(String[] args) {

NewFrame wind = new NewFrame();
}

}