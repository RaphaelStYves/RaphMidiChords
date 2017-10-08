package com;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ViewNewChord  extends Rectangle {


    ViewNewChord(int i) {

        super(i , ViewNote.NOTEHEIGHT, ViewNote.NOTEWIDTH, ViewNote.NOTEHEIGHT);
        setStroke(Color.BLACK);
        setFill(Color.GRAY);

    }
}