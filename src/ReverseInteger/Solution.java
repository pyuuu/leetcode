package ReverseInteger;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by xijueyp on 14-11-2.
 */
public class Solution {

    public int reverse(int x) {
        if (x<0)
            return reverse(-x)*(-1);

        StringBuilder s = new StringBuilder(x+"");
        s.reverse();

        return Integer.parseInt(s.toString());
    }


    public static void main(String a[]){
        int i= new Solution().reverse(-1122);
        System.out.println(i);
    }

    private int a;
}


