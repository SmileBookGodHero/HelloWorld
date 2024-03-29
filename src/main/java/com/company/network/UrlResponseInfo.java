package com.company.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Set;

/**
 * Created by lilei on 2017/7/14.
 * 获取URL响应头信息
 */
public class UrlResponseInfo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://baidu.com");
        URLConnection connection = url.openConnection();

        Map headers = connection.getHeaderFields();
        Set<String> keys = headers.keySet();
        for (String key : keys) {
            String value = connection.getHeaderField(key);
            System.out.println(key + ": " + value);
        }
        long timestamp = connection.getLastModified();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println(sdf.format(timestamp));
    }
}
