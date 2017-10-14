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
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiUnavailableException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import static com.Common.ViewBackGround.NBNOTE;
import static java.awt.SystemColor.text;

public class Main extends Application {


    private Piece piece;
    private Piece newPiece;

    private Pane root;
    private Rectangle rect2;

    ViewButton btnChord;

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
                SaveObject.writeToFile(piece);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });


        VBox vbox = new VBox();
        int BTNWIDTH = 50;
        int BTNHEIGHT = 50;

        Button btnUpdate = new Button("Update");
        btnUpdate.setPrefSize(BTNWIDTH,BTNHEIGHT-15);
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

        btnChord = new ViewButton();

       vbox.getChildren().addAll(btnUpdate,new ViewButton());

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
                            newGroup.getChildren().addAll(viewNewNote);
                            }
                    }
                    root.getChildren().add(newGroup);



                    for (int i = 0; i < piece.getPieceLenght16(); i++) {

                        //Make visual for CHORD DATA
                        ViewChord viewOldChord = new ViewChord(i * ViewNote.NOTEWIDTH,0,btnChord.getChord(),btnChord.getColor(),piece.chords);


                        //Make visual for CHORD DATA
                        //////////////////////ici piece.chords devrait être soit la nouvelle tune ou la vieille pas seulement la  nouvelle....
                        ViewChord viewNewChord = new ViewChord(i * ViewNote.NOTEWIDTH,1,btnChord.getChord(),btnChord.getColor(),newPiece.chords);

                        viewNewChord.setOnMouseDragEntered((event1 -> {


                                int pulse16 =(int) (viewNewChord.getX()/ ViewNote.NOTEWIDTH);

                                Piece.Chord origChord = piece.chords.get(pulse16);
                                origChord.getChord();

                                //New Chord
                                Piece.Chord newChord =newPiece.chords.get(pulse16);
                                newChord.setChord(btnChord.getChord());

                            if(piece.chords.get(pulse16).getChord() != EChord.nothing && piece.pulses.containsKey(pulse16)){

                                for (Piece.Note note : newPiece.pulses.get(pulse16).getNotes()) {
                                    note.setNote(AlgoNote.changenote(origChord.getChord(),newChord.getChord(),note.getCNote()));
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
