package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SavecObject implements Serializable {

    public static void writeToFile(Piece piece) throws IOException {


        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Piece.bin"));
        objectOutputStream.writeObject(piece);    }

    public static void readFile(){{}};
}