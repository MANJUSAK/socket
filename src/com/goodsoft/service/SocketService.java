package com.goodsoft.service;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ASUS on 2017/7/12.
 */
public class SocketService {
    public static void main(String[] arg) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println("开启服务端，等待客户连接...");
            Socket socket = serverSocket.accept();
            System.out.println("客户端已连接");
            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println("服务端收到客户端信息：" + info + "，当前客户端ip为：" + socket.getInetAddress().getCanonicalHostName());
            }

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            printWriter.print("您好，服务端已接收到您的消息");
            printWriter.flush();
            socket.shutdownOutput();

            printWriter.close();
            outputStream.close();
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
