package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Virtual memory size (number of pages): ");
        int virtualMemorySize = scanner.nextInt();

        System.out.println("Main memory size: ");
        int mainMemorySize = scanner.nextInt();

        System.out.println("Number of requests: ");
        int numberOfRequests = scanner.nextInt();

        ArrayList<Page> virtualMemory = Generator.generateVirtualMemory(virtualMemorySize);
        ArrayList<Request> requestQueue = Generator.generateRequestQueue(virtualMemory, numberOfRequests);
//        System.out.println(requestQueue.toString());
//        System.out.println(requestQueue.size());

        System.out.println("Initial conditions: ");
        System.out.println("\tNumber of pages: " + virtualMemorySize);
        System.out.println("\tNumber of frames: " + mainMemorySize);
        System.out.println("\tNumber of requests: " + numberOfRequests);


        System.out.println("Page faults: ");

        FIFO fifo = new FIFO(requestQueue, virtualMemory, mainMemorySize);
        fifo.handleQueue();
        System.out.println("FIFO: " + fifo.pageFaults);

        OPT opt = new OPT(requestQueue, virtualMemory, mainMemorySize);
        opt.handleQueue();
        System.out.println("OPT: " + opt.pageFaults);

        LRU lru = new LRU(requestQueue, virtualMemory, mainMemorySize);
        lru.handleQueue();
        System.out.println("LRU: " + lru.pageFaults);

        ApproxLRU approxLRU = new ApproxLRU(requestQueue, virtualMemory, mainMemorySize);
        approxLRU.handleQueue();
        System.out.println("Approximated LRU: " + approxLRU.pageFaults);

        RAND rand = new RAND(requestQueue, virtualMemory, mainMemorySize);
        rand.handleQueue();
        System.out.println("RAND: " + rand.pageFaults);
    }
}
