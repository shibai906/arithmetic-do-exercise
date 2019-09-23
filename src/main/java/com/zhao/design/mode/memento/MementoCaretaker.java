package com.zhao.design.mode.memento;

import java.util.ArrayList;

public class MementoCaretaker {

    private ArrayList<ChessmanMemento> mementoArrayList = new ArrayList<>();

    public ChessmanMemento getMemento(int i) {
        return mementoArrayList.get(i);
    }

    public void addMemento(ChessmanMemento memento) {
        mementoArrayList.add(memento);
    }

}
