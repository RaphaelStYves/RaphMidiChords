package com;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class ViewChord  extends Rectangle{


    ViewChord(int i) {

        super(i , 0, ViewNote.NOTEWIDTH, ViewNote.NOTEHEIGHT);
        setStroke(Color.BLACK);
        setFill(Color.GRAY);

    }
 }

