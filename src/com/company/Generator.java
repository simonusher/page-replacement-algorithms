package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Igor on 03.05.2017.
 */
public class Generator {
    public static Random generator = new Random();
    public static ArrayList<Page> generateVirtualMemory(int numberOfPages){
        ArrayList<Page> virtualMemory = new ArrayList<>();
        for (int i = 0; i < numberOfPages; i++) {
            virtualMemory.add(new Page(i));
        }
        return virtualMemory;
    }

    public static ArrayList<Request> generateRequestQueue(ArrayList<Page> virtualMemory, int numberOfRequests){
        ArrayList<Request> requestQueue = new ArrayList<>();
        int size = virtualMemory.size();
        Request lastGenerated;
        for (int i = 0; requestQueue.size() < numberOfRequests;) {
            lastGenerated = new Request(i++, virtualMemory.get(generator.nextInt(size)));
            if(requestQueue.size() < numberOfRequests) requestQueue.add(lastGenerated);
            int x;
            for (int j = 0; j < (numberOfRequests * 0.007) && requestQueue.size() < numberOfRequests; j++) {
                x = generator.nextInt(10);
                if(x < 9){
                    lastGenerated = new Request(i++, requestQueue.get(requestQueue.size() - 1).page);
                    requestQueue.add(lastGenerated);
                }
                else{
                    lastGenerated = new Request(i++, virtualMemory.get(generator.nextInt(size)));
                    requestQueue.add(lastGenerated);
                    break;
                }
            }
        }
        return requestQueue;
    }
}
