package com.Common;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class  ViewNote extends Rectangle {

    public static final int NOTEWIDTH = 15;
    public static final int NOTEHEIGHT = 20;
    public static final int BEATHEIGHT = 30;


    public ViewNote(int pulse, int cnote, int lenght, int height, Color color, double opacity ){

        super(pulse * NOTEWIDTH, (77 - cnote) * NOTEHEIGHT, NOTEWIDTH * lenght, height+NOTEHEIGHT);

        setFill(color);
        setStroke(Color.BLACK);
        setArcWidth(8);
        setArcHeight(8);
        setOpacity(opacity);


    }


}

