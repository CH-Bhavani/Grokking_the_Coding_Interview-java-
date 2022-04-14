/*

Given a string and a pattern, find the smallest substring in the given string which has all the characters of the given pattern.

Example 1:

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"
Example 2:

Input: String="abdabca", Pattern="abc"
Output: "abc"
Explanation: The smallest substring having all characters of the pattern is "abc".
Example 3:

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.




*/



import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        System.out.println(find("aabdec","abc"));
        System.out.println(find("abdabca","abc"));
        System.out.println(find("adcad","abc"));
    }
    public static String find(String word,String pattern){
        Map<Character,Integer> hm=new HashMap<>();
        int sub=0;
        int matched=0,windowstart=0,min=word.length()+1;
        for(char c:pattern.toCharArray())
            hm.put(c,hm.getOrDefault(c,0)+1);
        for(int windowend=0;windowend<word.length();windowend++){
            char rightchar=word.charAt(windowend);
            if(hm.containsKey(rightchar)) {
                hm.put(rightchar, hm.get(rightchar) - 1);
                if (hm.get(rightchar) >= 0)
                    matched++;
            }
            while(matched==pattern.length()){
                if(min>windowend-windowstart+1){
                    min=windowend-windowstart+1;
                    sub=windowstart;
                }
                char leftchar=word.charAt(windowstart++);
                if(hm.containsKey(leftchar)) {
                    if (hm.get(leftchar) == 0)
                        matched--;
                    hm.put(leftchar, hm.get(leftchar) + 1);
                }
            }
        }
        return min>word.length() ?"":word.substring(sub,sub+min);

    }
}
