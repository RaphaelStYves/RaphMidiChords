package com.Common;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class  ViewNote extends Rectangle {

    public static final int NOTEWIDTH = 15;
    public static final int NOTEHEIGHT = 20;
    public static final int BEATHEIGHT = 30;

    private int pulse;
    private int cnote;
    private int lenght;
    private int height;

    public ViewNote(int pulse, int cnote, int lenght, int height){

        this.pulse = pulse;
        this.cnote = cnote;
        this.lenght = lenght;
        this.height = height;


                Rectangle rect1 = new Rectangle(pulse * NOTEWIDTH, (77 - cnote) * NOTEHEIGHT, NOTEWIDTH * lenght, height*NOTEHEIGHT);

                rect1.setFill(Color.GREEN);
                rect1.setStroke(Color.BLACK);
                rect1.setArcWidth(8);
                rect1.setArcHeight(8);

//                Text text = new Text(piece.notes.get(i).getPulse16() * NOTEWIDTH,(77 - piece.notes.get(i).getCNote()) * NOTEHEIGHT, Long.toString(piece.notes.get(i).getPulse16()));
//                Text text2 = new Text(piece.notes.get(i).getPulse16() * NOTEWIDTH,20+(77 - piece.notes.get(i).getCNote()) * NOTEHEIGHT, Long.toString(piece.notes.get(i).getPulse()));


            }

        }

