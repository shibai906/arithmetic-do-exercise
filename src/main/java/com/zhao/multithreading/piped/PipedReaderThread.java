package com.zhao.multithreading.piped;

import java.io.IOException;
import java.io.PipedReader;

public class PipedReaderThread implements Runnable {

    PipedReader reader ;

    public PipedReaderThread(PipedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        try {
            for(int i = 0 ; i < 26 ; i++)
                System.out.println((char) reader.read());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
