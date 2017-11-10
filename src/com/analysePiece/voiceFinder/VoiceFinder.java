package com.analysePiece.voiceFinder;

import com.Common.Piece;
import com.Common.Tracknumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**Find what kind of track is it.
 * voice, drum, chords, bass, solo.
 *
 * comme les pulses il faudrait créer une liste de note par channel.
 *
 */

public class VoiceFinder {

    private Piece piece;

    private Track track;

    private List<Track> tracks;

    public VoiceFinder(Piece piece) {
        this.piece = piece;

    }

    public int findVoice(){

        changeInAArrayPulse();
        compareEach32Pulse();
        return minimumscore();

    }

    private int minimumscore() {
        double score =9999999;
        int tracknumber = 99;
        for (int i = 0; i <tracks.size() ; i++) {
            if (score > tracks.get(i).getScore()){
               tracknumber = tracks.get(i).getTrackNumber();


            }

        }

        for (int i = 0; i <tracks.size() ; i++) {
            System.out.println(i + "score   " + tracks.get(i).getScore()); tracks.get(i).getScore();
            System.out.println(i +"track   " + tracks.get(i).getTrackNumber());
            System.out.println(i +"channel   " + tracks.get(i).getChannel());
            System.out.println(i +"nomber of note   " + tracks.get(i).getNumberOfNotes());
            System.out.println(i +"sum of 32   " + tracks.get(i).getSumOfpulses32());
               System.out.println("   ");

        }
        return tracknumber;

    }

    public void changeInAArrayPulse() {


        tracks = new ArrayList<>();

        for (Map.Entry<Integer, Tracknumber> entry : piece.trackNumbers.entrySet()) {
            int[] pulses = new int[piece.getPieceLenght16()];

            for (int j = 0; j < entry.getValue().getNotes().size(); j++) {
                pulses[entry.getValue().getNotes().get(j).getPulse16()] += 1;
            }
            track = new Track();
            track.setPulses(pulses);
            track.setNumberOfNotes(entry.getValue().getNotes().size());
            track.setChannel(entry.getValue().getNotes().get(0).getChannel()); //car tout les notes de la meme track auront le même channel.
            track.setTrackNumber(entry.getKey());

            tracks.add(track);

        }
    }

    public void compareEach32Pulse()  {

        for ( Track track : tracks) {

            int sumOfpulses32 =0;
            for (int i = 0; i <track.getPulses().length ; i += 32) {

                if(i+64<piece.getPieceLenght16()){


                    for (int j = 0; j < 32 ; j++) {
                        sumOfpulses32 += track.getPulses()[i+j]*track.getPulses()[i+j+32];


                    }

                }
            }
            track.setSumOfpulses32(sumOfpulses32);
            track.setScore((double)sumOfpulses32/track.getNumberOfNotes());
        }
    }
}


    


