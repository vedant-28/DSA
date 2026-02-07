package Arrays_strings;

import java.util.*;

/*
Sliding window technique: https://www.techinterviewhandbook.org/algorithms/array/#sliding-window
Problem: https://leetcode.com/problems/first-unique-character-in-a-string/
*/

public class FirstUniqueCharOfString {
    public int firstUniqChar(String s) {
        int left = 0, result = 0;
        Set<Character> set = new HashSet<>();

        for(int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
        }


        return 0;
    }
} // loveleetcode