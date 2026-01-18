package Arrays;
import java.util.*;

/*
Sliding window technique: https://www.techinterviewhandbook.org/algorithms/array/#sliding-window
Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */

public class LongestSubstringWoRepeat {
    public int lengthOfLongestString(String s) {
        int left = 0, maxLen = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestSubstringWoRepeat str = new LongestSubstringWoRepeat();
        int len = str.lengthOfLongestString("abcabcbb");
        System.out.println(len);
    }
}


