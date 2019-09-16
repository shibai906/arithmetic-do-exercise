package com.zhao.design.mode.command;

public class CCTV2Command extends Command {
    public CCTV2Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv2();
    }
}
