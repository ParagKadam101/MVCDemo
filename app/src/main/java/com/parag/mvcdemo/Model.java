package com.parag.mvcdemo;


import java.util.ArrayList;
import java.util.Observable;

class Model extends Observable {
    private ArrayList<Integer> countList;
    Model()
    {
        countList = new ArrayList<>(3);
        countList.add(0);
        countList.add(0);
        countList.add(0);
    }

    void setCountAtPosition(int position)
    {
        countList.set(position, countList.get(position)+1);
        setChanged();
        notifyObservers();
    }

    int getCountAtPosition(int position)
    {
        return countList.get(position);
    }

}
