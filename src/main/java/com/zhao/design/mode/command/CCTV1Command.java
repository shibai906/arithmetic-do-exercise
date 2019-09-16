package com.zhao.design.mode.command;

public class CCTV1Command extends Command {
    public CCTV1Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv1();
    }
}
