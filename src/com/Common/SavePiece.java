package com.Common;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SavePiece implements Serializable {

    public static void writeToFile(Piece piece, Piece newPiece) throws IOException {

        List<Piece> pieces = new ArrayList<>();
        pieces.add(piece);
        pieces.add(newPiece);


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Piece.bin"));
        objectOutputStream.writeObject(piece);    }


}
