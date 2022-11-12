package com.zhao.io.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @program: arithmetic-do-exercise
 * @author: zhaohuan
 * @create: 2022-08-03 17:18
 * @description
 **/
public class NIOServer {

    private Selector selector;
    private ServerSocketChannel serverSocketChannel;
    private static final int PORT = 8080;

    public NIOServer() {
        try {
            //获得选择器
            selector = Selector.open();
            serverSocketChannel = ServerSocketChannel.open();
            //绑定端口
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            //设置非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //将该ServerSocketChannel 注册到selector
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            System.out.println("NioServer error:" + e.getMessage());
        }
    }

    public void listen() {
        System.out.println("监听线程启动: " + Thread.currentThread().getName());
        try {
            while (true) {
                int count = selector.select();
                if (count > 0) {
                    //遍历得到selectionKey集合
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {
                        SelectionKey key = iterator.next();

                        if (key.isAcceptable()) {
                            SocketChannel sc = serverSocketChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " 上线 ");
                        }
                        //通道发送read事件，即通道是可读的状态
                        if (key.isReadable()) {
                            getDataFromChannel(key);
                        }
                        //当前的key 删除，防止重复处理
                        iterator.remove();
                    }
                } else {
                    System.out.println("等待中");
                }
            }
        } catch (Exception e) {
            System.out.println("listen error:" + e.getMessage());
        }
    }

    private void getDataFromChannel(SelectionKey key) {
        SocketChannel channel = null;
        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            //根据count的值做处理
            if (count > 0) {
                String msg = new String(buffer.array());
                System.out.println("来自客户端: " + msg);

                //向其它的客户端转发消息(排除自己)
                sendInfoToOtherClients(msg, channel);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " 离线了");
                //取消注册
                key.cancel();
            } catch (IOException ex) {
                System.out.println("getDataFromChannel error:" + ex.getMessage());
            }
        } finally {
            try {
                channel.close();
            } catch (IOException ex) {
                System.out.println("channel.close() error:" + ex.getMessage());
            }
        }
    }

    //转发消息给其它客户(通道)
    private void sendInfoToOtherClients(String msg, SocketChannel self) throws IOException {
        System.out.println("服务器转发消息中...");
        System.out.println("服务器转发数据给客户端线程: " + Thread.currentThread().getName());
        //遍历 所有注册到selector 上的 SocketChannel,并排除 self
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();

            //排除自己
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                //将信息存储到buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //将buffer数据写入通道
                dest.write(buffer);
            }
        }
    }

    public static void main(String[] args) {
        //创建服务器对象
        NIOServer nioServer = new NIOServer();
        nioServer.listen();
    }
}

