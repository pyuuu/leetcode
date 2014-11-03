package ReverseWordsinaString;

import com.sun.xml.internal.ws.util.StringUtils;

/**
 * Created by xijueyp on 14-11-1.
 */
// 考察边界问题
public class Solution {
    public String reverseWords(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        int size = cs.length;
        String result = new String();
        for (int i=size - 1; i > -1 ;){

            String index = new String();
            while (i!=-1 && cs[i]!=' ') index = cs[i--] + index;
            while (i!=-1 && cs[i] == ' ') i--;
            if (i!=-1 && !index.equals(""))
                index+=" ";
            result+=(index);
        }
        return result;
    }

    public static void main(String a[]){
        System.out.println(new Solution().reverseWords(new String("asd")));
    }
}
