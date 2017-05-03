package com.company;

import java.util.ArrayList;

/**
 * Created by Igor on 03.05.2017.
 */
public class OPT extends PageReplacementAlgorithm {
    int[] helper;
    public OPT(ArrayList<Request> requestQueue, ArrayList<Page> virtualMemory, int virtualMemorySize) {
        super(requestQueue, virtualMemory, virtualMemorySize);
//        helper = new int[virtualMemorySize];
    }

    @Override
    public int findPageToRemove() {
        helper = new int[mainMemory.length];
        for (int i = 0; i < mainMemory.length; i++) {
            helper[i] = indexOf(mainMemory[i]);
        }
        return findIndex(helper);
    }

    public int findIndex(int[] t){
        int x = t[0];
        int index = 0;
        if(x == -1) return 0;
        for (int i = 1; i < t.length; i++) {
            if(t[i] == -1) return i;
            if(t[i] > x){
                x = t[i];
                index = i;
            }
        }
        return index;
    }

    public int indexOf(Page p) {
        for (int i = 0; i < requestQueue.size(); i++){
            if (p.equals(requestQueue.get(i).page)){
                return i;
            }
        }
        return -1;
    }
}
