package com.Common;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ViewButton extends VBox {

    private Color color =Color.BLUE;
    private EChord chord = EChord.nothing;
    int BTNWIDTH = 50;
    int BTNHEIGHT = 50;

    int FAC = 15;

    ViewButton(){


        Button btnI = new Button("I");
        btnI.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnI.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnI.setOnMouseClicked(event ->  {
            color = Color.DODGERBLUE;
            chord = EChord.I;

        });

        Button btni = new Button("i");
        btni.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btni.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btni.setOnMouseClicked(event ->{
            color = Color.CORNFLOWERBLUE;
            chord = EChord.i;
        });

        Button btnII = new Button("II");
        btnII.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnII.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnII.setOnMouseClicked(event -> {
            color = Color.CORAL;
            chord = EChord.II;
        });


        Button btnii = new Button("ii");
        btnii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnii.setOnMouseClicked(event -> {
            color = Color.DARKSALMON;
            chord = EChord.ii;
        });

        Button btnIII = new Button("III");
        btnIII.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnIII.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnIII.setOnMouseClicked(event -> {
            color = Color.HOTPINK;
            chord = EChord.III;
        });

        Button btniii = new Button("iii");
        btniii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btniii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btniii.setOnMouseClicked(event -> {
            color = Color.VIOLET;
            chord = EChord.iii;
        });

        Button btnIV = new Button("IV");
        btnIV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnIV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnIV.setOnMouseClicked(event -> {
            color = Color.YELLOWGREEN;
            chord = EChord.IV;
        });

        Button btniv = new Button("iv");
        btniv.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btniv.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btniv.setOnMouseClicked(event ->  {
            color =Color.PALEGREEN;
            chord = EChord.iv;
        });

        Button btnV = new Button("V");
        btnV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnV.setOnMouseClicked(event -> {
            color = Color.FIREBRICK;
            chord = EChord.V;
        });

        Button btnv = new Button("v");
        btnv.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnv.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnv.setOnMouseClicked(event -> {
            color = Color.PALEVIOLETRED;
            chord = EChord.v;

        });

        Button btnVI = new Button("VI");
        btnVI.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnVI.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnVI.setOnMouseClicked(event -> {
            color = Color.AQUA;
            chord = EChord.VI;
        });

        Button btnvi = new Button("vi");
        btnvi.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnvi.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnvi.setOnMouseClicked(event -> {
            color = Color.AQUAMARINE;
            chord = EChord.vi;
        });

        Button btnVII = new Button("VII");
        btnVII.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnVII.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnVII.setOnMouseClicked(event -> {
            color = Color.TAN;
            chord = EChord.VII;
        });

        Button btnvii = new Button("vii");
        btnvii.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnvii.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnvii.setOnMouseClicked(event -> {
            color = Color.BEIGE;
            chord = EChord.vii;
        });

        Button btnv99 = new Button("00");
        btnv99.setPrefSize(BTNWIDTH,BTNHEIGHT/FAC);
        btnv99.setStyle("-fx-font: 10 arial; -fx-base: #778899;");
        btnv99.setOnMouseClicked(event -> {
            color = Color.GRAY;
            chord = EChord.nothing;
        });

        getChildren().addAll(btnI,btni,btnII, btnii, btnIII, btniii, btnIV, btniv, btnV, btnv, btnVI, btnvi, btnVII, btnvii,btnv99);


    }



    public Color getColor() {
        return this.color;
    }

    public void setColor(Color choice) {
        this.color = choice;
    }

    public EChord getChord() {
        return chord;
    }

    public void setChord(EChord chord) {
        this.chord = chord;
    }
}
