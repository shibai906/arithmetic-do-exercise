package com.zhao.multithreading.piped;

import java.io.IOException;
import java.io.PipedWriter;
import java.util.concurrent.ThreadFactory;

public class PipedWriterThread implements Runnable {

    PipedWriter writer;

    public PipedWriterThread(PipedWriter writer) {
        this.writer = writer;
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 26 ; i ++) {
            try {
                writer.write('a' + i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
