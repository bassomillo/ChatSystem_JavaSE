package com;

import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.*;
import java.util.Arrays;

public class NetTest {

    @Test
    public void InetTest() throws UnknownHostException {
        InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
        System.out.println("loopbackAddress = " + loopbackAddress);
        InetAddress[] allByName = InetAddress.getAllByName("www.pornhub.com");
        System.out.println(Arrays.toString(allByName));
        InetAddress[] localhosts = InetAddress.getAllByName("localhost");
        System.out.println(Arrays.toString(localhosts));
        byte[] bytes = {127,0,0,1};
        InetAddress byAddress = InetAddress.getByAddress(bytes);
        System.out.println("byAddress = " + byAddress);
        InetAddress[] allByName1 = InetAddress.getAllByName("LAPTOP-094GAFOA");
        System.out.println("Arrays.toString(allByName1) = " + Arrays.toString(allByName1));
    }

    @Test
    public void UrlTest() throws IOException {
        URL url = new URL("https://down.qq.com/qqweb/PCQQ/PCQQ_EXE/PCQQ2021.exe");
        System.out.println("url.getProtocol() = " + url.getProtocol());
        System.out.println("url.getHost() = " + url.getHost());
        System.out.println("url.getPath() = " + url.getPath());
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\QQ.exe");
        byte[] buf = new byte[1024 * 1024];
        long l = System.currentTimeMillis();
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            fileOutputStream.write(buf, 0, len);
        }
    }

    @Test
    public void ServerTest() throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8888));
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        byte[] buf = new byte[1024 * 1024];
        int len;
        while ((len = inputStream.read(buf)) != -1) {
            System.out.println(new String(buf,0,len));
        }
        inputStream.close();
        serverSocket.close();
    }

    @Test
    public void ClientTest() throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(InetAddress.getLoopbackAddress(),8888));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());
        outputStream.close();
        socket.close();
    }

}
