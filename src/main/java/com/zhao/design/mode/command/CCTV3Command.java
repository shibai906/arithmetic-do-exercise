package com.zhao.design.mode.command;

public class CCTV3Command extends Command {
    public CCTV3Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv3();
    }
}
