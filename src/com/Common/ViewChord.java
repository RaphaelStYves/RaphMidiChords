package com.Common;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ViewChord  extends Rectangle  {


    public ViewChord(int Xplace, int Yplace, List<Piece.Chord> chords) {

        super(Xplace , Yplace*ViewNote.NOTEWIDTH, ViewNote.NOTEWIDTH, ViewNote.NOTEHEIGHT);
        setStroke(Color.BLACK);
        setFill(Color.GRAY);



    }


}
