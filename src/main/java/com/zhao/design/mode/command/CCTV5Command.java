package com.zhao.design.mode.command;

public class CCTV5Command extends Command {
    public CCTV5Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv5();
    }
}
