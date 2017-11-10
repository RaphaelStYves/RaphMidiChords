package com.analysePiece.chordFinder;

import com.Common.Piece;
import com.analysePiece.chordFinder.Section;
import com.analysePiece.voiceFinder.VoiceFinder;

import java.io.*;
import java.util.*;
import java.util.stream.DoubleStream;

/**
 Definition : in a Beats we have 5 things.
 Structure ex: 16,16
 32
 8,8,8,8,8
 /////////////////////////////
 beat and beats ex:
 D **8**( D 8,Cm 16,Dm 4,Am 4)
 G **4**( G 4,G 16,Am 8,Am 4)
 A **16**( D 16,Cm 16)
 beat properties :
 core;
 bestIndex;
 startPulse;
 numberOfPulse;
 ///////////////////////////////
 **seq** and seqs :
 D **8**( D 8,Cm 16,Dm 4,Am 4)
 (only the best Seq is in seq)**seq** and seqs ex:
 seq properties :
 score;
 bestIndex;
 startPulse;
 numberOfPulse;
 ///////////////////////////////
 **pulse** and pulses :
 C **1**(1,1,1,1,1,1,1)
 Cm**1**(1,1,1,1,1,1,1)
 D **1**(1,1,1,1,1,1,1)
 pulse properties :
 score;
 bestIndex;
 */

public class ChordFinder {

    private Piece piece;

    private List<Section> pulses;
    private Section structure;
    private List<Section> structures;

    private int trackvoice;

    private  List<String> nameChords;
    private List<List<Double>> forceChords;

    private List<List<Integer>> chordBeats;

    private  List<String> chordsResults;


    private int[][] pieceMOD12;

    public  ChordFinder(Piece piece) {
        this.piece = piece;
    }

    public void findChord() throws IOException {

        //find voice track.
        VoiceFinder voiceFinder = new VoiceFinder(piece);
       trackvoice = voiceFinder.findVoice();

        pieceMOD12 = new int[(int) piece.getPieceLenght16()][12];
        pieceMOD12 = changePieceInOnes();
        getMapofChordsForce("C:\\Users\\Raphael\\IdeaProjects\\ViewMidiChords\\ChordForce.csv");
        getMapofChordBeat("C:\\Users\\Raphael\\IdeaProjects\\ViewMidiChords\\ChordBeat.csv");

        findEachScorePulse();

        //find the last full 32 pulse for analyse


        structures= new ArrayList<>();

        int blockOf32 = (((piece.getPieceLenght16()/32))*32);

           for (int i = 0; i <blockOf32; i += 32) {
            forEach32(i);
        }

        for (int i = 0; i < blockOf32; i += 32) {
            foh32();
        }
    }


    private void forEach32(int startPulse)  {

        Section beat;
        List<Section> beats = new ArrayList<>();
        int nbBeat = chordBeats.size();
        int pulseDone =0;
        for (int i = 0; i < nbBeat ; i++) {//for each beats

            List<Section> seqs = new ArrayList<>();
            pulseDone =0;
            int nbSeq = chordBeats.get(i).size();
            for (int j = 0; j <nbSeq ; j++) { //for each seq of beat

                int numberOfPulse = chordBeats.get(i).get(j);
                seqs.add(OneSeq(startPulse + pulseDone, numberOfPulse));
                pulseDone += numberOfPulse;
            }

            beat = new Section();
            beat.setSeqs(seqs);
            beat.setScore(seqs);
            beat.setNumberOfPulse(pulseDone);

            beats.add(beat);
        }

        structure = new Section();
        structure.setBeats(beats);
        structure.setNumberOfPulse(pulseDone);
        structure.setBestScoreAndSetTheBestIndex(beats);
        structure.setStartPulse(startPulse);

        structures.add(structure);

       }

    private void foh32()  {

        chordsResults = new ArrayList<>();

        for (Section structure : structures) {
            int indexBestBeat = structure.getBestIndex();
            List<Section> bestSeqs = structure.getBeats().get(indexBestBeat).getSeqs();

            for (Section bestSeq : bestSeqs) {



                for (int i = 0; i < bestSeq.getNumberOfPulse(); i++) {

                    chordsResults.add(nameChords.get(bestSeq.getBestIndex()));
                }

            }
        }
    }

    private Section OneSeq(int startPulse, int numberOfPulse)  {


        Section seq = new Section();
        for (int indexChord = 0; indexChord < nameChords.size() ; indexChord++) {//each force
            //addOfXPulsesForOneChord and add to the forceSeqs
            seq.add(sumOfOneSeqForOneChord(startPulse,numberOfPulse, indexChord));
        }


        seq.setMaxScoreAndSetTheIndex();
        seq.setStartPulse(startPulse);
        seq.setNumberOfPulse(numberOfPulse);

        return seq;
    }

    private double sumOfOneSeqForOneChord(int startPulse,int numberOfPulse, int indexChord)  {
        double scoreSeqOneChord =0;
        for (int k = 0; k < numberOfPulse ; k++) {
            scoreSeqOneChord += pulses.get(startPulse + k).getScores().get(indexChord);
        }
        return scoreSeqOneChord;
    }

    private List<Section> findEachScorePulse()  {

        pulses = new ArrayList<>();

          for (int pulse = 0; pulse < pieceMOD12.length ; pulse++) {

           pulses.add(scoreForOneChordOnePulse(pulse));
        }
        return pulses;
    }

    private Section scoreForOneChordOnePulse(int indexPulse)  {

        Section pulse = new Section();
        for (int indexChord = 0; indexChord < forceChords.size() ; indexChord++) {
            pulse.add(multiplyForceByNote(indexPulse,indexChord));
        }
        return pulse;
    }

    private double multiplyForceByNote(int indexPulse,int indexChord)  {
        double[] colonne16 =   new double [12];
        for (int k = 0; k < pieceMOD12[0].length; k++) {
            colonne16[k]=(pieceMOD12[indexPulse][k] * forceChords.get(indexChord).get(k));
        }
        return DoubleStream.of(colonne16).sum();

    }

    private int[][] changePieceInOnes() {

        //mettre le song sous forme de MOD12 pour en faire l'analyse'
        // ne pas prendre en compte les channels  9  le drum ne doit pas considéré dans l'analyse des accords
        for (Piece.Note note : piece.notes) {
            if (note.getChannel() != 9 ) {
                for (int j = 0; j < note.getLenght16(); j++) {
                    pieceMOD12[note.getPulse16() + j][note.getCNote() % 12] = 1;
                }
            }
        }
        fillHoles();
        return pieceMOD12;
    }

    private void fillHoles() {
        //Remplir les trous d'accords du type aucune note dans 1/16 de temps. Dans ce cas repété les 1 du dernier 1/16.
        // //Ceci permettra de mettre de l,avant une meilleur logique d'évalution des accords.
        if (!hasfirstColonneEmpty(pieceMOD12)) {
            pieceMOD12[0][0] = 1;
        }

        for (int i = 0; i < piece.getPieceLenght16(); i++) {
            int tempo = 0;
            for (int j = 0; j < 12; j++) {
                tempo = +pieceMOD12[i][j];
                if (tempo != 0) {
                    break;
                }
            }
            if (tempo == 0) {
                for (int n = 0; n < 12; n++) {
                    pieceMOD12[i][n] = pieceMOD12[i - 1][n];
                }
            }
        }
    }

    private boolean hasfirstColonneEmpty(int[][] arraymod12notes) {

        int tempo;
        for (int i = 0; i < 12; i++) {
            tempo = arraymod12notes[0][i];
            if (tempo != 0) {
                return true;
            }
        }
        return false;
    }

    public void getMapofChordsForce(String filePath) throws IOException {
        BufferedReader br;
        String line;

        nameChords = new ArrayList<>();
        forceChords = new ArrayList<>();

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            String[] chord = line.split(";");
            nameChords.add(chord[0]);

            List<Double> forceChord = new ArrayList<>();
            for (int i = 1; i < chord.length; i++) {
                forceChord.add(Double.parseDouble(chord[i]));
              }

            forceChords.add(forceChord);
        }
    }

    public void getMapofChordBeat(String filePath) throws IOException {
        BufferedReader br;
        String line;

        chordBeats = new ArrayList<>();
        List<Integer> beats;

        br = new BufferedReader(new FileReader(filePath));
        while ((line = br.readLine()) != null) {
            // use comma as separator
            String[] beat = line.split(";");


            beats = new ArrayList<>();
            for (int i = 0; i < beat.length ; i++) {
                if (Integer.parseInt(beat[i]) > 0) {

                    beats.add(Integer.parseInt(beat[i]));
                }
                          
            }
            chordBeats.add(beats);
        }
    }

    public List<String> getChordsResults() {
        return chordsResults;
    }


}



