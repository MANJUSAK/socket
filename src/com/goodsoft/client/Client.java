package com.goodsoft.client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by 严彬荣 on 2017/7/12.
 */
public class Client {
    public static void main(String[] arg) {
        try {
            Socket socket = new Socket("localhost", 8888);

            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream);
            Scanner scanner = new Scanner(System.in);
            boolean tip = true;
            String msg = "";
            while (tip) {
                msg = scanner.nextLine();
                tip = false;
                printWriter.print(msg);
                printWriter.flush();
            }
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String temp = null;
            String info = "";
            while ((temp = bufferedReader.readLine()) != null) {
                info += temp;
                System.out.println("客户端收到服务端发送的信息：" + info);
            }


            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
