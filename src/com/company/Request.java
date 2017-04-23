package com.company;

/**
 * Created by Szymon on 23.04.2017.
 */
public class Request {
    int timeOfRequest;
    Page page;

    public Request(int timeOfRequest, Page page) {
        this.timeOfRequest = timeOfRequest;
        this.page = page;
    }
}
