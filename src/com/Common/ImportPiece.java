package com.Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class ImportPiece {

    public static void readMidiFile(String Piece) throws IOException {

        List<Piece> pieces;

        try {
            FileInputStream fileIn = new FileInputStream(Piece);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            pieces = (List<Piece>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Piece class not found");
            c.printStackTrace();
            return;
        }
    }

}
