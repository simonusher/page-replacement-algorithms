package com.company;

import java.util.ArrayList;

/**
 * Created by Igor on 03.05.2017.
 * LRU algorithm approximated using second chance algorithm.
 */
public class ApproxLRU extends PageReplacementAlgorithm {
    public ApproxLRU(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        super(requestQueue, virtualMemory, virtualMemorySize);
    }

    @Override
    public int findPageToRemove() {
        boolean found = false;
        while(!found){
            for (int i = 0; i < mainMemory.length; i++) {
                if(!mainMemory[i].wasRequested){
                    found = true;
                    return i;
                }
                else mainMemory[i].wasRequested = false;
            }
        }
        return 0;
    }
}
