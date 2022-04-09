/*
Given a string, find the length of the longest substring which has no repeating characters.

Example 1:

Input: String="aabccbb"
Output: 3
Explanation: The longest substring without any repeating characters is "abc".
Example 2:

Input: String="abbbb"
Output: 2
Explanation: The longest substring without any repeating characters is "ab".
Example 3:

Input: String="abccde"
Output: 3
Explanation: Longest substrings without any repeating characters are "abc" & "cde".


*/










import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NoRepeatSubstring {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb"));
        System.out.println(findLength("abbbb"));
        System.out.println(findLength("abccde"));

    }

    public static int findLength(String s) {
        int max = Integer.MIN_VALUE, windowStart = 0;
        Map<Character, Integer> hm = new HashMap<>();
        for (int windowend = 0; windowend < s.length(); windowend++) {
            char rightchar = s.charAt(windowend);
            if (hm.containsKey(rightchar)) {
                windowStart = Math.max(windowStart, hm.get(rightchar) + 1);
            }
            hm.put(rightchar, windowend);
            max = Math.max(max, windowend - windowStart + 1);
        }
        return max;
    }
}
