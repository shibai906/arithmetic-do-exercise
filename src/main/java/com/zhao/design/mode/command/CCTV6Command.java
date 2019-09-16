package com.zhao.design.mode.command;

public class CCTV6Command extends Command {
    public CCTV6Command(Television television) {
        super(television);
    }

    @Override
    void execute() {
        television.playCctv6();
    }
}
