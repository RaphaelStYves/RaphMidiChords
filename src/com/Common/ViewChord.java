package com.Common;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class ViewChord  extends Rectangle  {


    public ViewChord(int i, int Yplace, List<Piece.Chord> chords) {

        super(i , Yplace*ViewNote.NOTEWIDTH, ViewNote.NOTEWIDTH, ViewNote.NOTEHEIGHT);
        setStroke(Color.BLACK);
        setFill(Color.GRAY);


//        this.setOnMouseDragEntered((event1 -> {
//            this.setFill(new ViewButton().getColor());
//            chords.get((int) (this.getX()/ ViewNote.NOTEWIDTH)).setChord(new ViewButton().getChord());
//        }));

    }


}
