package com.company;

import java.util.ArrayList;

/**
 * Created by Szymon on 23.04.2017.
 */
public class FIFO extends PageReplacementAlgorithm{

    public FIFO(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        super(requestQueue, virtualMemory, virtualMemorySize);
    }

    @Override
    public void handleRequest() {
        if(!isInMainMemory(activeRequest.page)){
            pageFaults++;
            place = findEmpty();
            if(place == -1){
                place = findPageToRemove();
            }
            mainMemory[place] = activeRequest.page;
        }
        requestQueue.remove(0);
        if(!isDone()) activeRequest = requestQueue.get(0);
    }

    public int findPageToRemove(){
        Page p = mainMemory[0];
        Page q;
        int x = 0;
        for (int i = 1; i < mainMemory.length ; i++) {
            q = mainMemory[i];
            if(q.placedInMemory < p.placedInMemory) x = i;
        }
        return x;
    }




}
