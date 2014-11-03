package PalindromeNumber;

/**
 * Created by xijueyp on 14-11-2.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        String s = x+"";
        int size = s.length();
        for (int i=0;i!=size/2;i++){
            if (s.charAt(i)!=s.charAt(size-i-1))
                return false;
        }
        return true;
    }
}