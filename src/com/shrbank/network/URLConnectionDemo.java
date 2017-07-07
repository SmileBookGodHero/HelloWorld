package com.shrbank.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by lilei on 2017/7/7.
 */
public class URLConnectionDemo {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://www.lilei1998.com");
            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = null;
            if (urlConnection instanceof HttpURLConnection) {
                connection = (HttpURLConnection) urlConnection;
            } else {
                System.out.println("请输入URL地址：");
                return;
            }

            BufferedReader in =  new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String urlString = "";
            String current;
            while ((current = in.readLine()) != null) {
                urlString += current;
            }
            System.out.println(urlString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
