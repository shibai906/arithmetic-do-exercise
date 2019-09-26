package com.zhao.multithreading.piped;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {

    public static void main(String[] args) throws IOException {
        PipedWriter pipedWriter = new PipedWriter();
        PipedReader pipedReader = new PipedReader();
        pipedReader.connect(pipedWriter);
        ExecutorService es = Executors.newCachedThreadPool(new PipedThreadFactory());
        es.execute(new PipedWriterThread(pipedWriter));
        es.execute(new PipedReaderThread(pipedReader));
        es.shutdown();



    }

}
