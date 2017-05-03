package com.company;

import java.util.ArrayList;

/**
 * Created by Szymon on 23.04.2017.
 */
public class FIFO extends PageReplacementAlgorithm{

    public FIFO(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        super(requestQueue, virtualMemory, virtualMemorySize);
    }

    public int findPageToRemove(){
        Page p = mainMemory[0];
        Page q;
        int x = 0;
        for (int i = 1; i < mainMemory.length ; i++) {
            q = mainMemory[i];
            if(q.placedInMemory < p.placedInMemory){
                x = i;
                p = q;
            }
        }
        return x;
    }




}
