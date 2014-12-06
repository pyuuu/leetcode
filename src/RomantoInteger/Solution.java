package RomantoInteger;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.Key;
import java.util.Arrays;

/**
 * Created by xijueyp on 14-11-2.
 */
// 罗马字符太多了，，，，先跳过
public class Solution {
    public static void main(String s[]) throws IOException {
        String a = "asdasd+1111=";
        a = URLEncoder.encode("asdasd+1111=");
        System.out.println(a);
        a="AmDXSnlCIVQsk8cH9Gx3yHjPVBlv%2bwSYNLIaWXajt1oQ%2bTifX%2bH%2fk%2fhM62DNiT%2bEh52oUV5i7pSrlmT3fOHPgKQJtbFcXY1F6SmpUngaBf9S1D%2bwLT0azIxbOM2Ww6S8x%2f0eTOscMlULQDkhuNTr6%2fVLX5lhiWU3iQ9vIkNehbM%3d";
        a = URLDecoder.decode(a);
        System.out.println(a);

        URL url;
        int responsecode;
        HttpURLConnection urlConnection;
        BufferedReader reader;
        String line;
        url=new URL("http://latour.daily.taobao.net:8388/lottery/delayLottery.do?tbpm=3&lotteryID=D9FD70E53239E0FB2928B3E81181D925&_tb_token_=EiDvSHHLztyZ5&deviceId=device_20141023_7421&encodeData=AmDXSnlCIVQsk8cH9Gx3yHjPVBlv%2bwSYNLIaWXajt1oQ%2bTifX%2bH%2fk%2fhM62DNiT%2bEh52oUV5i7pSrlmT3fOHPgKQJtbFcXY1F6SmpUngaBf9S1D%2bwLT0azIxbOM2Ww6S8x%2f0eTOscMlULQDkhuNTr6%2fVLX5lhiWU3iQ9vIkNehbM%3d");
        //打开URL
        urlConnection = (HttpURLConnection)url.openConnection();
        //获取服务器响应代码
        responsecode=urlConnection.getResponseCode();
        if(responsecode==200){
            //得到输入流，即获得了网页的内容
            reader=new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"GBK"));
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }
        else{
            System.out.println("获取不到网页的源码，服务器响应代码为："+responsecode);
        }

    }

    public static byte[] getKetByte(String name) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(name);
            ois = new ObjectInputStream(fis);
            Key key = (Key) ois.readObject();
            return key.getEncoded();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace
                        ();
            }
        }
        return null;
    }
}
