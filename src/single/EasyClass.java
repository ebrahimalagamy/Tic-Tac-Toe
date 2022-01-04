package single;

import java.awt.Color;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EasyClass {
    JLabel[] arrayOfLabals;
     JPanel parentPanal;
     JLabel firstPlayerScore, secondPlayerScore;
     JLabel pressedLabel;
     int XOCounter ;

    public EasyClass(JLabel[] arrayOfLabals, JPanel parentPanal, JLabel firstPlayerScore, JLabel secondPlayerScore, JLabel pressedLabel, int XOCounter) {
        this.arrayOfLabals = arrayOfLabals;
        this.parentPanal = parentPanal;
        this.firstPlayerScore = firstPlayerScore;
        this.secondPlayerScore = secondPlayerScore;
        this.pressedLabel = pressedLabel;
        this.XOCounter = XOCounter;
    }

    boolean isFirstPlayerTurn = true;
    boolean isGameEnds = false;
    int randomNumber;
    Random random = new Random();
    
     private void colorBackgroundWinnerLabels(JLabel l1, JLabel l2, JLabel l3) {
        l1.setOpaque(true);
        l2.setOpaque(true);
        l3.setOpaque(true);
        isGameEnds = true;
    }
     
     private void checkIfThereIsAWinner() {

        String c0 = arrayOfLabals[0].getText();
        String c1 = arrayOfLabals[1].getText();
        String c2 = arrayOfLabals[2].getText();
        String c3 = arrayOfLabals[3].getText();
        String c4 = arrayOfLabals[4].getText();
        String c5 = arrayOfLabals[5].getText();
        String c6 = arrayOfLabals[6].getText();
        String c7 = arrayOfLabals[7].getText();
        String c8 = arrayOfLabals[8].getText();

        int firstPlayerScore = Integer.valueOf(this.firstPlayerScore.getText());
        int secondPlayerScore = Integer.valueOf(this.secondPlayerScore.getText());

        if (c0.equals(c1) && c0.equals(c2) && !c0.equals("")) {
            if (c0.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[0], arrayOfLabals[1], arrayOfLabals[2]);
        }

        if (c3.equals(c4) && c3.equals(c5) && !c3.equals("")) {
            if (c3.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[3], arrayOfLabals[4], arrayOfLabals[5]);
        }

        if (c6.equals(c7) && c6.equals(c8) && !c6.equals("")) {
            if (c6.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[6], arrayOfLabals[7], arrayOfLabals[8]);
        }

        if (c0.equals(c3) && c0.equals(c6) && !c0.equals("")) {
            if (c0.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[0], arrayOfLabals[3], arrayOfLabals[6]);
        }

        if (c1.equals(c4) && c1.equals(c7) && !c1.equals("")) {
            if (c1.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[1], arrayOfLabals[4], arrayOfLabals[7]);
        }

        if (c2.equals(c5) && c2.equals(c8) && !c2.equals("")) {
            if (c2.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[2], arrayOfLabals[5], arrayOfLabals[8]);
        }

        if (c0.equals(c4) && c0.equals(c8) && !c0.equals("")) {
            if (c0.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[0], arrayOfLabals[4], arrayOfLabals[8]);
        }

        if (c2.equals(c4) && c2.equals(c6) && !c2.equals("")) {
            if (c2.equals("X")) {
                this.firstPlayerScore.setText((firstPlayerScore + 1) + "");
            } else {
                this.secondPlayerScore.setText((secondPlayerScore + 1) + "");
            }
            colorBackgroundWinnerLabels(arrayOfLabals[2], arrayOfLabals[4], arrayOfLabals[6]);
        }

    }
     
     public boolean isOnePlayerGameEnds() {

        if (XOCounter < 9 && pressedLabel.getText().equals("")) {

            pressedLabel.setText("X");
            pressedLabel.setForeground(Color.blue);
            
            XOCounter++;
            System.out.println(XOCounter);
            checkIfThereIsAWinner();

            if (XOCounter < 9 && isGameEnds == false) {
                for (;;) {
                    randomNumber = random.nextInt(9);
                    if (arrayOfLabals[randomNumber].getText().equals("")) {

                        arrayOfLabals[randomNumber].setText("O");
                        arrayOfLabals[randomNumber].setForeground(Color.red);
                        parentPanal.repaint();

                        XOCounter++;
                        checkIfThereIsAWinner();
                        break;
                    }
                }
            }

        }

       if (XOCounter >= 9 || isGameEnds == true) {
           
            return true;
        }

        return false;

    }

}