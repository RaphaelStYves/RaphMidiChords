package com.Common;


import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ViewBackGround extends Group {

    public static final int NBNOTE =125;
    private int TXTAJUTY = 15;
    private int TXTAJUTX = 10;
    private int pieceLenght16;

    ViewBackGround(int pieceLenght16){

        this.pieceLenght16 = pieceLenght16;

     for (int i = 0; i <= NBNOTE; i++) {

            Rectangle rect1 = new Rectangle(0 , (NBNOTE - i) * ViewNote.NOTEHEIGHT, ViewNote.NOTEWIDTH * pieceLenght16, ViewNote.NOTEHEIGHT);
            Text text = new Text(TXTAJUTX,(NBNOTE - i) * ViewNote.NOTEHEIGHT + TXTAJUTY, null);


            switch (i%12) {
                case 0:  rect1.setFill(Color.GRAY);
                    text.setText("C");
                    break;
                case 1:  rect1.setFill(Color.BLACK);
                    text.setText("C#");
                    break;
                case 2:  rect1.setFill(Color.GRAY);
                    text.setText("D");
                    break;
                case 3:  rect1.setFill(Color.BLACK);
                    text.setText("D#");
                    break;
                case 4:  rect1.setFill(Color.GRAY);
                    text.setText("E");
                    break;
                case 5:  rect1.setFill(Color.GRAY);
                    text.setText("F");
                    break;
                case 6:  rect1.setFill(Color.BLACK);
                    text.setText("F#");
                    break;
                case 7:  rect1.setFill(Color.GRAY);
                    text.setText("G");
                    break;
                case 8:  rect1.setFill(Color.BLACK);
                    text.setText("G#");
                    break;
                case 9:  rect1.setFill(Color.GRAY);
                    text.setText("A");
                    break;
                case 10:  rect1.setFill(Color.BLACK);
                    text.setText("A#");
                    break;
                case 11:  rect1.setFill(Color.GRAY);
                    text.setText("B");
                    break;



            }
                    rect1.setOpacity(.20);
                    text.setFont(new Font("Helvetica", 9));

                    getChildren().addAll(rect1,text);

            }

            createMesure();

        }

    private void createMesure() {

        for (int i = 0; i < pieceLenght16; i++) {

            if (i%1 ==0){

                Rectangle line1 = new Rectangle(i* ViewNote.NOTEWIDTH, 0, 3, (NBNOTE  * ViewNote.NOTEHEIGHT));
                line1.setFill(Color.BLUE);
                line1.setOpacity(.20);

                getChildren().add(line1);

            }

            if (i%16 ==0){

                Rectangle line16 = new Rectangle(i* ViewNote.NOTEWIDTH, 0, 3, (NBNOTE  * ViewNote.NOTEHEIGHT));
                line16.setOpacity(.20);

                getChildren().add(line16);

            }

        }
    }


}

