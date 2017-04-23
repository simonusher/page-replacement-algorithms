package com.company;

import java.util.ArrayList;

/**
 * Created by Szymon on 23.04.2017.
 */
public abstract class PageReplacementAlgorithm {
    int pageFaults = 0;
    int timePassed = 0;
    ArrayList<Request> requestQueue;
    ArrayList<Page> virtualMemory;
    Page[] mainMemory;
    Request activeRequest;
    int place;

    public PageReplacementAlgorithm() {
    }

    public PageReplacementAlgorithm(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        this.requestQueue = requestQueue;
        this.virtualMemory = virtualMemory;
        this.mainMemory = new Page[virtualMemorySize];
    }

    public void handleQueue(){
        activeRequest = requestQueue.get(0);
        while (!isDone()){
            if(activeRequest.timeOfRequest <= timePassed){
                handleRequest();
            }
            timePassed++;
        }
    }

    public abstract int findPageToRemove();
    public abstract void handleRequest();

    public int findEmpty(){
        for (int i = 0; i < mainMemory.length; i++) {
            if(mainMemory[i] == null) return i;
        }
        return -1;
    }

    public boolean isInMainMemory(Page p){
        for (int i = 0; i < mainMemory.length; i++) {
            if(p.equals(mainMemory[i])) return true;
        }
        return false;
    }

    public boolean isDone() {
        return requestQueue.size() == 0;
    }
}
