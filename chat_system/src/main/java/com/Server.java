package com;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket()){
            //bind the port
            serverSocket.bind(new InetSocketAddress(8888));
            System.out.println("Server launched at 8888");
            while (true){
                Socket socket =serverSocket.accept();
                new ServerThread(socket).start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
