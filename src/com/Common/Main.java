package com.Common;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;


import static com.Common.ViewBackGround.NBNOTE;

public class Main extends Application {


    private Piece piece;
    private Piece newPiece;

    private Pane root;
    private Rectangle rect2;


    private Color choice =Color. BLUE;
    private EChord choice2 = EChord.nothing;


    private Group newGroup;
    private ViewNote viewNewNote = null;
    private Group orgiGroup;
    private ViewNote viewOrigNote = null;

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
        MenuItem saveFile = new MenuItem("Save");
        menuFile.getItems().addAll(importFile,saveFile);
        masterPane.setTop(menuBar);

        saveFile.setOnAction(event -> {
            try {
                SaveObject.writeToFile(piece);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        VBox vbox = new VBox();
        int BTNWIDTH = 50;
        int BTNHEIGHT = 50;

        Button btnUpdate = new Button("Update");
        btnUpdate.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnUpdate.setStyle("-fx-font: 10 arial; -fx-base: #0000ff;");
        btnUpdate.setOnMouseClicked(event ->  {
            newGroup.getChildren().clear();
            newGroup = new Group();

            for (int i = 0; i < newPiece.notes.size(); i++) {

                newPiece.notes.get(i).getCNote();
                if (newPiece.notes.get(i).getOn()) {
                    viewNewNote = new ViewNote(newPiece.notes.get(i).getPulse16(),newPiece.notes.get(i).getCNote(),newPiece.notes.get(i).getLenght16(), 1, Color.GREEN,1);
                    newGroup.getChildren().add(viewNewNote);
                }
            }
            root.getChildren().add(newGroup);

        });



        Button btnI = new Button("I");
        btnI.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnI.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnI.setOnMouseClicked(event ->  {
            choice = Color.DODGERBLUE;
            choice2 = EChord.I;
        });

        Button btni = new Button("i");
        btni.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btni.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btni.setOnMouseClicked(event ->{
            choice = Color.CORNFLOWERBLUE;
            choice2 = EChord.i;
        });

        Button btnII = new Button("II");
        btnII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnII.setOnMouseClicked(event -> {
            choice = Color.CORAL;
            choice2 = EChord.II;
        });


        Button btnii = new Button("ii");
        btnii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnii.setOnMouseClicked(event -> {
            choice = Color.DARKSALMON;
            choice2 = EChord.ii;
        });

        Button btnIII = new Button("III");
        btnIII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnIII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnIII.setOnMouseClicked(event -> {
                choice = Color.HOTPINK;
                choice2 = EChord.III;
    });

        Button btniii = new Button("iii");
        btniii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btniii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btniii.setOnMouseClicked(event -> {
                choice = Color.VIOLET;
                choice2 = EChord.iii;
    });

        Button btnIV = new Button("IV");
        btnIV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnIV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnIV.setOnMouseClicked(event -> {
            choice = Color.YELLOWGREEN;
            choice2 = EChord.IV;
        });

        Button btniv = new Button("iv");
        btniv.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btniv.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btniv.setOnMouseClicked(event ->  {
            choice =Color.PALEGREEN;
            choice2 = EChord.iv;
        });

        Button btnV = new Button("V");
        btnV.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnV.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnV.setOnMouseClicked(event -> {
            choice = Color.FIREBRICK;
            choice2 = EChord.V;
        });

        Button btnv = new Button("v");
        btnv.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnv.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnv.setOnMouseClicked(event -> {
            choice = Color.PALEVIOLETRED;
            choice2 = EChord.v;

        });

        Button btnVI = new Button("VI");
        btnVI.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnVI.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnVI.setOnMouseClicked(event -> {
            choice = Color.AQUA;
            choice2 = EChord.VI;
        });

        Button btnvi = new Button("vi");
        btnvi.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnvi.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnvi.setOnMouseClicked(event -> {
            choice = Color.AQUAMARINE;
            choice2 = EChord.vi;
        });

        Button btnVII = new Button("VII");
        btnVII.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnVII.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnVII.setOnMouseClicked(event -> {
            choice = Color.TAN;
            choice2 = EChord.VII;
        });

        Button btnvii = new Button("vii");
        btnvii.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnvii.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnvii.setOnMouseClicked(event -> {
            choice = Color.BEIGE;
            choice2 = EChord.vii;
        });

        Button btnv99 = new Button("00");
        btnv99.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnv99.setStyle("-fx-font: 15 arial; -fx-base: #0000ff;");
        btnv99.setOnMouseClicked(event -> {
            choice = Color.GRAY;
            choice2 = EChord.nothing;
        });


        vbox.getChildren().addAll(btnUpdate,btnI,btni,btnII, btnii, btnIII, btniii, btnIV, btniv, btnV, btnv, btnVI, btnvi, btnVII, btnvii,btnv99);
        masterPane.setLeft(vbox);



        final FileChooser fileChooser = new FileChooser();
        importFile.setOnAction(event -> {

            File midiFile = fileChooser.showOpenDialog(primaryStage);
            if (midiFile != null) {

                try {
                    piece = new Piece(midiFile);
                    newPiece = new Piece(midiFile);

                    //Make the backGround
                    root.getChildren().addAll(new ViewBackGround(piece));

                    //Make visual for original piece.
                    orgiGroup = new Group();
                    for (int i = 0; i < piece.notes.size(); i++) {
                        piece.notes.get(i).getCNote();
                        if (piece.notes.get(i).getOn()) {
                            viewOrigNote = new ViewNote(piece.notes.get(i).getPulse16(),piece.notes.get(i).getCNote(),piece.notes.get(i).getLenght16(), 5, Color.RED,0.3);
                            orgiGroup.getChildren().add(viewOrigNote);
                            }
                    }
                    root.getChildren().add(orgiGroup);



                    //Make visual for new piece.
                    newGroup = new Group();
                    for (int i = 0; i < newPiece.notes.size(); i++) {
                        newPiece.notes.get(i).getCNote();
                        if (newPiece.notes.get(i).getOn()) {
                            viewNewNote = new ViewNote(newPiece.notes.get(i).getPulse16(),newPiece.notes.get(i).getCNote(),newPiece.notes.get(i).getLenght16(), 1, Color.GREEN, 1);
                            newGroup.getChildren().add(viewNewNote);
                            }
                    }
                    root.getChildren().add(newGroup);




                    //Make original and new chord piece.
                    for (int i = 0; i < piece.getPieceLenght16(); i++) {

                        ViewChord viewOldChord = new ViewChord(i * ViewNote.NOTEWIDTH,0);
                        viewOldChord.setOnMouseDragEntered((event1 -> {
                            viewOldChord.setFill(choice);
                                Piece.Chord origChord = piece.chords.get((int) (viewOldChord.getX()/ ViewNote.NOTEWIDTH));
                                origChord.setChord(choice2);
                          }));
                        ViewChord viewNewChord = new ViewChord(i * ViewNote.NOTEWIDTH ,1);
                        viewNewChord.setOnMouseDragEntered((event1 -> {
                                viewNewChord.setFill(choice);
                                int pulse16 =(int) (viewNewChord.getX()/ ViewNote.NOTEWIDTH);

                                Piece.Chord origChord = piece.chords.get((int) (viewOldChord.getX()/ ViewNote.NOTEWIDTH));
                                origChord.getChord();

                                //New Chord
                                Piece.Chord newChord =newPiece.chords.get(pulse16);
                                newChord.setChord(choice2);

                                //change data in object data
                            /////////UPDATE DE TOUT LA TUNE C'EST TROP . JE DOIT ETRE CAPABLE de savoir rapide qu'elle oject j'ai en pulse 10 par exemple.
                                for (int j = 0; j < piece.getPieceLenght16(); j++) {

                                if((newPiece.notes.get(j).getPulse16() == pulse16 )&&(piece.chords.get(pulse16).getChord() != EChord.nothing)){
                                    newPiece.notes.get(j).setNote(AlgoNote.changenote(origChord.getChord(),newChord.getChord(),piece.notes.get(pulse16).getCNote()));

                                    }
                               }
                          }));
                        root.getChildren().addAll(viewOldChord,viewNewChord);
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

        rect2 =new Rectangle(0,0,5, ViewNote.BEATHEIGHT + (NBNOTE  * ViewNote.NOTEHEIGHT));
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
