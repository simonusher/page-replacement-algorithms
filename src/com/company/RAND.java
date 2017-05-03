package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Igor on 02.05.2017.
 */
public class RAND extends PageReplacementAlgorithm {
    Random random = new Random();

    public RAND(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        super(requestQueue, virtualMemory, virtualMemorySize);
    }

    @Override
    public int findPageToRemove() {
        return random.nextInt(mainMemory.length);
    }
}
