package br.mattsousa.base.manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProbabilityManager {

    public boolean[] getChance(String hitChance) {
        double chance = Double.parseDouble(hitChance);
        int sampleSize = 100;

        int hits = (int) Math.round(sampleSize * chance);
        int gdc = calculateGCD(hits, sampleSize);

        hits = Math.divideExact(hits, gdc);
        sampleSize = Math.divideExact(sampleSize, gdc);

        List<Boolean> sampleList = new ArrayList<>(Collections.nCopies(hits, true));
        sampleList.addAll(Collections.nCopies(sampleSize - hits, false));

        Collections.shuffle(sampleList);

        boolean[] sampleArray = new boolean[sampleSize];
        for (int i = 0; i < sampleSize; i++) {
            sampleArray[i] = sampleList.get(i);
        }

        return sampleArray;
    }

    private int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
