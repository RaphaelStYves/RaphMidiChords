package com;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.ViewBackGround.NBNOTE;

public class Main extends Application {

    private List<Rectangle> rects = new ArrayList<>();
    private Piece piece;
    private Pane root;
    private Rectangle rect2;

    private  boolean clicked = false;

    private Color choice =Color. BLUE;
    private int choice2 = 99;




    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(createContents(primaryStage));

        scene.addEventFilter(MouseEvent.DRAG_DETECTED, event -> scene.startFullDrag());


        primaryStage.setScene(scene);
        primaryStage.setTitle("10 000 objects");
        primaryStage.setWidth(1600);
        primaryStage.setHeight(900);
        primaryStage.show();


        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.NUMPAD1) {
                SoundMidi soundMidi = new SoundMidi(piece, rect2);
                try {
                    soundMidi.play();
                } catch (MidiUnavailableException e1) {
                    e1.printStackTrace();
                } catch (InvalidMidiDataException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    private Parent createContents(Stage primaryStage) {

        BorderPane masterPane = new BorderPane();
        BorderPane borderPane = new BorderPane();


        MenuBar menuBar = new MenuBar();
        menuBar.setPrefWidth(1000);
        Menu menuFile = new Menu("File");
        menuBar.getMenus().add(menuFile);
        MenuItem importFile = new MenuItem("Import");
        menuFile.getItems().add(importFile);
        masterPane.setTop(menuBar);


        VBox vbox = new VBox();
        int BTNWIDTH = 50;
        int BTNHEIGHT = 50;

        Button btnSave = new Button("SAVE");
        btnSave.setPrefSize(BTNWIDTH,BTNHEIGHT);

        btnSave.setOnMouseClicked(event -> {
            try {
                SavecObject.writeToFile(piece);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



        Button btnI = new Button("I");
        btnI.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnI.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnI.setOnMouseClicked(event ->  {
            choice = Color.DODGERBLUE;
            choice2 = 0;
        });

        Button btni = new Button("i");
        btni.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btni.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btni.setOnMouseClicked(event ->{
            choice = Color.CORNFLOWERBLUE;
            choice2 = 1;
        });

        Button btnII = new Button("II");
        btnII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnII.setOnMouseClicked(event -> {
            choice = Color.CORAL;
            choice2 = 2;
        });


        Button btnii = new Button("ii");
        btnii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnii.setOnMouseClicked(event -> {
            choice = Color.DARKSALMON;
            choice2 = 3;
        });

        Button btnIII = new Button("III");
        btnIII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnIII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnIII.setOnMouseClicked(event -> {
                choice = Color.HOTPINK;
                choice2 = 4;
    });

        Button btniii = new Button("iii");
        btniii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btniii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btniii.setOnMouseClicked(event -> {
                choice = Color.VIOLET;
                choice2 = 5;
    });

        Button btnIV = new Button("IV");
        btnIV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnIV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnIV.setOnMouseClicked(event -> {
            choice = Color.YELLOWGREEN;
            choice2 = 6;
        });

        Button btniv = new Button("iv");
        btniv.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btniv.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btniv.setOnMouseClicked(event ->  {
            choice =Color.PALEGREEN;
            choice2 = 7;
        });

        Button btnV = new Button("V");
        btnV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnV.setOnMouseClicked(event -> {
            choice = Color.FIREBRICK;
            choice2 = 8;
        });

        Button btnv = new Button("v");
        btnv.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnv.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnv.setOnMouseClicked(event -> {
            choice = Color.PALEVIOLETRED;
            choice2 = 9;

        });

        Button btnVI = new Button("VI");
        btnVI.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnVI.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnVI.setOnMouseClicked(event -> {
            choice = Color.AQUA;
            choice2 = 10;
        });

        Button btnvi = new Button("vi");
        btnvi.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnvi.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnvi.setOnMouseClicked(event -> {
            choice = Color.AQUAMARINE;
            choice2 = 11;
        });

        Button btnVII = new Button("VII");
        btnVII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnVII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnVII.setOnMouseClicked(event -> {
            choice = Color.TAN;
            choice2 = 12;
        });

        Button btnvii = new Button("vii");
        btnvii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnvii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnvii.setOnMouseClicked(event -> {
            choice = Color.BEIGE;
            choice2 = 13;
        });

        Button btnv99 = new Button("00");
        btnv99.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnv99.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnv99.setOnMouseClicked(event -> {
            choice = Color.BEIGE;
            choice2 = 99;
        });


        vbox.getChildren().addAll(btnSave,btnI,btni,btnII, btnii, btnIII, btniii, btnIV, btniv, btnV, btnv, btnVI, btnvi, btnVII, btnvii,btnv99);
        masterPane.setLeft(vbox);



        final FileChooser fileChooser = new FileChooser();
        importFile.setOnAction(event -> {

            File midiFile = fileChooser.showOpenDialog(primaryStage);
            if (midiFile != null) {

                try {
                    piece = new Piece(midiFile);


                    root.getChildren().addAll(new ViewBackGround(piece),new ViewNote(piece));


                    for (int i = 0; i < piece.getPieceLenght16(); i++) {

                        ViewChord viewChord = new ViewChord(i * ViewNote.NOTEWIDTH);


                        viewChord.setOnMouseDragEntered((event1 -> {

                                viewChord.setFill(choice);
                                piece.chords.get((int) (viewChord.getX()/ ViewNote.NOTEWIDTH)).setChord(choice2);

                          }));

                        ViewNewChord viewNewChord = new ViewNewChord(i * ViewNote.NOTEWIDTH);
                        viewNewChord.setOnMouseDragEntered((event1 -> {

                                viewNewChord.setFill(choice);
                                piece.chords.get((int) (viewNewChord.getX()/ ViewNote.NOTEWIDTH)).setChord(choice2);

                        }));


                        root.getChildren().addAll(viewChord,viewNewChord);

                    }

                } catch (IOException e) {
                    e.printStackTrace();
                } catch (InvalidMidiDataException e) {
                    e.printStackTrace();
                } catch (MidiUnavailableException e) {
                    e.printStackTrace();
                }

            }


        });

        root = new Pane();
        borderPane.setCenter(root);

        rect2 =new Rectangle(0,0,5,ViewNote.BEATHEIGHT + (NBNOTE  * ViewNote.NOTEHEIGHT));
        rect2.setFill(Color.RED);
        root.getChildren().add(rect2);

       ScrollPane scrollPane = new ScrollPane(borderPane);

        masterPane.setCenter(scrollPane);



        return masterPane;
    }


    public void update(Rectangle rect2, int count) {

        rect2.setTranslateX(rect2.getX() + count);

    }
}
