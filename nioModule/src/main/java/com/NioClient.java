package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class NioClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(6666));
        if(socketChannel.finishConnect()){
            while (true){
                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();
                socketChannel.write(ByteBuffer.wrap(next.getBytes()));
            }
        }
    }
}
