package com.zhao.design.mode.command;

public class CCTV4Command extends Command {
    public CCTV4Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv4();
    }
}
