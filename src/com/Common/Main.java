package com.Common;


import com.analysePiece.chordFinder.ChordFinder;

import com.analysePiece.voiceFinder.VoiceFinder;
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

import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;



import static com.Common.ViewBackGround.NBNOTE;
import static com.Common.ViewNote.NOTEHEIGHT;
import static com.Common.ViewNote.NOTEWIDTH;

public class Main extends Application {


    private Piece piece;
    private Piece newPiece;

    private Pane root;
    private Rectangle rect2;

    private Group newGroup;
    private ViewNote viewNewNote = null;
    private Group orgiGroup;
    private ViewNote viewOrigNote = null;

    private Color color =Color.BLUE;
    private EChord chord = EChord.nothing;

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
                SoundMidi soundMidi = new SoundMidi(newPiece, rect2);
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
                SavePiece.writeToFile(piece, newPiece);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        VBox vbox = new VBox();
        int BTNWIDTH = 50;
        int BTNHEIGHT = 50;

        Button btnUpdate = new Button("Update");
        btnUpdate.setPrefSize(BTNWIDTH,BTNHEIGHT);
        btnUpdate.setStyle("-fx-font: 10 arial; -fx-base: #ff8c00;");
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

        int FAC = 15;

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

            vbox.getChildren().addAll(btnUpdate);
            vbox.getChildren().addAll(btnI,btni,btnII, btnii, btnIII, btniii, btnIV, btniv, btnV, btnv, btnVI, btnvi, btnVII, btnvii,btnv99);


        masterPane.setLeft(vbox);


        AlgoNote algoNote = new AlgoNote();



        final FileChooser fileChooser = new FileChooser();
        importFile.setOnAction(event -> {

            File midiFile = fileChooser.showOpenDialog(primaryStage);
            if (midiFile != null) {

                try {
                    piece = new Piece(midiFile);
                    newPiece = new Piece(midiFile);

                    //chords finder

                    ChordFinder chordFinder = new ChordFinder(piece);
                    chordFinder.findChord();

                    //Make the backGround
                    root.getChildren().addAll(new ViewBackGround((int)piece.getPieceLenght16()));

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

                            Text text = new Text();
                            text.setText(Integer.toString(newPiece.notes.get(i).getCNote()));
                            text.setX(newPiece.notes.get(i).getPulse16()* NOTEWIDTH);
                            text.setY((125 - newPiece.notes.get(i).getCNote()) * NOTEHEIGHT);


                            newGroup.getChildren().addAll(viewNewNote,text);
                            }
                    }
                    root.getChildren().add(newGroup);


                    ///create Algo


                    Group chordGroupe = new Group();
                    for (int i = 0; i < (((piece.getPieceLenght16()/32))*32); i++) {

                            Text text = new Text();
                            text.setText(chordFinder.getChordsResults().get(i));
                            text.setX(i * NOTEWIDTH);
                            text.setY(55);

                        chordGroupe.getChildren().addAll(text);
                        }
                    root.getChildren().add(chordGroupe);





                    for (int i = 0; i < piece.getPieceLenght16(); i++) {

                        //Make visual for CHORD DATA
                        ViewChord viewOldChord = new ViewChord(i * NOTEWIDTH,0,piece.chords);


                        viewOldChord.setOnMouseDragEntered((event1 -> {
                            viewOldChord.setFill(color);
                            piece.chords.get((int) (viewOldChord.getX()/ NOTEWIDTH)).setChord(chord);
                        }));



                        //Make visual for CHORD DATA
                        ViewChord viewNewChord = new ViewChord(i * NOTEWIDTH,1,newPiece.chords);
                        viewNewChord.setOnMouseDragEntered((event1 -> {
                            viewNewChord.setFill(color);
                            newPiece.chords.get((int) (viewNewChord.getX()/ NOTEWIDTH)).setChord(chord);


                                int pulse16 =(int) (viewNewChord.getX()/ NOTEWIDTH);

                                Piece.Chord origChord = piece.chords.get(pulse16);
                                origChord.getChord();

                                //New Chord
                                Piece.Chord newChord =newPiece.chords.get(pulse16);
                                newChord.setChord(chord);

                            if(piece.chords.get(pulse16).getChord() != EChord.nothing && piece.pulses.containsKey(pulse16)){

                                for (Piece.Note note : newPiece.pulses.get(pulse16).getNotes()) {
                                    note.setChordAjuste(algoNote.changenote(origChord.getChord(),newChord.getChord(),note.getCNote()));
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

        rect2 =new Rectangle(0,0,5, ViewNote.BEATHEIGHT + (NBNOTE  * NOTEHEIGHT));
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
