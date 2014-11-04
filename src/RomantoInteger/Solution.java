package RomantoInteger;

import java.io.*;
import java.security.Key;
import java.util.Arrays;

/**
 * Created by xijueyp on 14-11-2.
 */
// 罗马字符太多了，，，，先跳过
public class Solution {
    public static void main(String s[]) throws IOException {
        byte[] file = getKetByte("/Users/xijueyp/Downloads/tmall.public");

        System.out.println(new String(file));
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
