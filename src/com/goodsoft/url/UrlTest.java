package com.goodsoft.url;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by ASUS on 2017/7/12.
 */
public class UrlTest {
    public static void main(String[] arg) {
        long start = System.currentTimeMillis();
        try {
            for (int i = 0; i < 1000000; ++i) {
                URL url = new URL("http://localhost:8080/device/queryMechanicalEQ?page=0&num=200");
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();
                System.out.println(i);
            }
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String temp = null;
//            String data = "";
//            while ((temp = bufferedReader.readLine()) != null) {
//                data += temp;
//            }
//            File file = new File("D:/test.txt");
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileWriter fileWriter = new FileWriter(file);
//            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write(data);
            long end = System.currentTimeMillis();
            System.out.println("写入成功,用时 " + (end - start) + " ms");
//            bufferedWriter.close();
//            bufferedReader.close();
//            inputStreamReader.close();
//            inputStream.close();
        } catch (MalformedURLException e) {
//            e.printStackTrace();
        } catch (IOException e) {
//            e.printStackTrace();
        }
    }
}
