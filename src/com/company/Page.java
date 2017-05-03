package com.company;

/**
 * Created by Szymon on 23.04.2017.
 */
public class Page {
    int ID;
    int placedInMemory = 0;
    int lastRequested = 0;
    boolean wasRequested = false;

    public Page(int ID) {
        this.ID = ID;
    }

    public String toString(){
        return "" + ID;
    }
}
