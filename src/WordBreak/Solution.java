package WordBreak;

import java.util.HashSet;
import java.util.Set;

/**
 * todo
 * Created by xijueyp on 14-12-10.
 */
public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        return true;
    }

    public static void main(String ap[]){
        Set<String> strings = new HashSet<String>();

        strings.add("a");
        strings.add("s");

        System.out.println(new Solution().wordBreak("ass", strings));
    }
}