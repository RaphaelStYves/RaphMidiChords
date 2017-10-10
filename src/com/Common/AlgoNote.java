package com.Common;


import java.util.*;

public final class AlgoNote {

    public static int changenote(EChord origChord, EChord newChord, int note) {

        Map<EChord, List<Integer>> mapChord = compliteAllForceChords();
        int newNote = 0;
        int degre = 0;

        for (Map.Entry<EChord, List<Integer>> entry : mapChord.entrySet()) {

            if (origChord == entry.getKey()) {
                degre= entry.getValue().get(note % 12);
            }
        }

        for (Map.Entry<EChord, List<Integer>> entry : mapChord.entrySet()) {

            if (newChord == entry.getKey()) {

                for (int j = 0; j < entry.getValue().size(); ++j) {

                    if (degre == entry.getValue().get(j)) {

                        if (j < 6 ){
                            newNote = note + j;
                    }else {
                            newNote = note + j;
                        }
                    }
                }
            }
        }

        return newNote;
    }

    private static Map<EChord, List<Integer>> compliteAllForceChords() {


        Map<EChord, List<Integer>> mapforceChords = new HashMap<>();

        mapforceChords.put(EChord.I, Arrays.asList(0, 99, 1, 99, 2, 3, 99, 4, 99, 5, 99, 6));
        mapforceChords.put(EChord.i, Arrays.asList(0, 99, 1, 2, 99, 3, 99, 4, 99, 5, 99, 6));

        mapforceChords.put(EChord.II, Arrays.asList(6, 99, 0, 99, 1, 99, 2, 3, 99, 4, 99, 5));
        mapforceChords.put(EChord.ii, Arrays.asList(6, 99, 0, 99, 1, 2, 99, 3, 99, 4, 99, 5));

        mapforceChords.put(EChord.III, Arrays.asList(5, 99, 6, 99, 0, 1, 99, 99, 2, 3, 99, 4));
        mapforceChords.put(EChord.iii, Arrays.asList(5, 99, 6, 99, 0, 1, 99, 2, 99, 3, 99, 4));

        mapforceChords.put(EChord.IV, Arrays.asList(4, 99, 5, 99, 6, 0, 99, 1, 99, 2, 99, 3));
        mapforceChords.put(EChord.iv, Arrays.asList(4, 99, 5, 99, 6, 0, 99, 1, 2, 99, 99, 3));

        mapforceChords.put(EChord.V, Arrays.asList(3, 99, 4, 99, 5, 6, 99, 0, 99, 1, 99, 2));
        mapforceChords.put(EChord.v, Arrays.asList(3, 99, 4, 99, 5, 6, 99, 0, 99, 1, 2, 99));

        mapforceChords.put(EChord.VI, Arrays.asList(99, 2, 3, 99, 4, 5, 99, 6, 99, 0, 99, 1));
        mapforceChords.put(EChord.vi, Arrays.asList(2, 99, 3, 99, 4, 5, 99, 6, 99, 0, 99, 1));

        mapforceChords.put(EChord.VII, Arrays.asList(1, 99, 2, 99, 3, 4, 99, 5, 99, 6, 0, 99));
        mapforceChords.put(EChord.vii, Arrays.asList(1, 2, 99, 99, 3, 4, 99, 5, 99, 6, 0, 99));


        return mapforceChords;
    }


}




