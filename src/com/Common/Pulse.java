package com.Common;

import java.util.ArrayList;
import java.util.HashMap;

public class Pulse {

    private  ArrayList<Piece.Note> notes = new ArrayList<>();

    public void addNote(Piece.Note note){
     this.notes.add(note);
    }

    public ArrayList<Piece.Note> getNotes() {
        return notes;
    }
}
