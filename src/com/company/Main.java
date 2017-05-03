package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Page> virtualMemory= new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            virtualMemory.add(new Page(i));
        }
        ArrayList<Request> requestQueue = new ArrayList();
        requestQueue.add(new Request(0, virtualMemory.get(0)));
        requestQueue.add(new Request(1, virtualMemory.get(1)));
        requestQueue.add(new Request(2, virtualMemory.get(2)));
        requestQueue.add(new Request(3, virtualMemory.get(3)));
        requestQueue.add(new Request(4, virtualMemory.get(0)));
        requestQueue.add(new Request(5, virtualMemory.get(1)));
        requestQueue.add(new Request(6, virtualMemory.get(4)));
        requestQueue.add(new Request(7, virtualMemory.get(0)));
        requestQueue.add(new Request(8, virtualMemory.get(1)));
        requestQueue.add(new Request(9, virtualMemory.get(2)));
        requestQueue.add(new Request(10, virtualMemory.get(3)));
        requestQueue.add(new Request(11, virtualMemory.get(4)));
//        FIFO f = new FIFO(requestQueue, virtualMemory, 3);
//        f.handleQueue();
//        System.out.println(f.pageFaults);

//        RAND rand = new RAND(requestQueue, virtualMemory, 3);
//        rand.handleQueue();
//        System.out.println(rand.pageFaults);

//        OPT o = new OPT (requestQueue, virtualMemory, 3);
//        o.handleQueue();
//        System.out.println(o.pageFaults);
        LRU lru = new LRU(requestQueue, virtualMemory, 3);
        lru.handleQueue();
        System.out.println(lru.pageFaults);
    }
}
