package com.Common;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ViewChord  extends Rectangle {


    public ViewChord(int i, int Yplace) {

        super(i , Yplace*ViewNote.NOTEWIDTH, ViewNote.NOTEWIDTH, ViewNote.NOTEHEIGHT);
        setStroke(Color.BLACK);
        setFill(Color.GRAY);

    }
}
