package com.zhao.io.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-08-03 17:22
 * @description
 **/
public class NIOClient {

    private final int PORT = 8080; //服务器端口
    private Selector selector;
    private SocketChannel socketChannel;
    private String username;

    public NIOClient() throws IOException {
        selector = Selector.open();
        socketChannel = socketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
        //设置非阻塞
        socketChannel.configureBlocking(false);
        //将channel注册到selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        username = socketChannel.getLocalAddress().toString().substring(1);
        System.out.println(username + " is ok...");
    }

    //向服务器发送消息
    public void sendInfo(String info) {
        info = username + " 说：" + info;
        try {
            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
        } catch (IOException e) {
            System.out.println("sendInfo error:" + e.getMessage());
        }
    }

    //读取从服务器端回复的消息
    public void readInfo() {
        try {
            int readChannels = selector.select();
            if (readChannels > 0) {
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if (key.isReadable()) {
                        //得到相关的通道
                        SocketChannel sc = (SocketChannel) key.channel();
                        //得到一个Buffer
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取
                        sc.read(buffer);
                        //把读到的缓冲区的数据转成字符串
                        String msg = new String(buffer.array());
                        System.out.println(msg.trim());
                    }
                }
                iterator.remove(); //删除当前的selectionKey, 防止重复操作
            } else {
                System.out.println("没有可以用的通道...");
            }
        } catch (Exception e) {
            System.out.println("readInfo error:" + e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
        NIOClient nioClient = new NIOClient();
        new Thread() {
            public void run() {
                while (true) {
                    nioClient.readInfo();
                    try {
                        Thread.currentThread().sleep(2000);
                    } catch (InterruptedException e) {
                        System.out.println("sleep error:" + e.getMessage());
                    }
                }
            }
        }.start();

        //发送数据给服务器端
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            nioClient.sendInfo(scanner.nextLine());
        }
    }
}

