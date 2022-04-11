/*



Permutation in a String (hard) #
Given a string and a pattern, find out if the string contains any permutation of the pattern.

Permutation is defined as the re-arranging of the characters of the string. For example, “abc” has the following six permutations:

abc
acb
bac
bca
cab
cba
If a string has ‘n’ distinct characters it will have n!n! permutations.

Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.
Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.
Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.
Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.\




*/




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PatternMatching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(findPermutaion("oidbcaf", "abc"));
        System.out.println(findPermutaion("odicf", "dc"));
        System.out.println(findPermutaion("bcdxabcdy", "bcdyabcdx"));
        System.out.println(findPermutaion("aaacb", "abc"));
        System.out.println(findPermutaion("abbcdui","udc"));

    }

    public static boolean findPermutaion(String word, String pattern) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            hm.put(pattern.charAt(i), hm.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int matched = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < word.length(); windowEnd++) {
            char rightchar = word.charAt(windowEnd);
            if (hm.containsKey(rightchar)) {
                hm.put(rightchar, hm.get(rightchar) - 1);
                if (hm.get(rightchar) == 0)
                    matched++;
            }
            if (matched == hm.size())
                return true;
            if (windowEnd >= pattern.length() - 1) {
                char leftchar = word.charAt(windowStart++);
                if (hm.containsKey(leftchar)) {
                    if (hm.get(leftchar) == 0)
                        matched--;
                    hm.put(leftchar, hm.get(leftchar) - 1);
                }
            }
        }
        return false;
    }
}
