/*



Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter, find the length of the longest substring having the same letters after replacement.

Example 1:

Input: String="aabccbb", k=2
Output: 5
Explanation: Replace the two 'c' with 'b' to have a longest repeating substring "bbbbb".
Example 2:

Input: String="abbcb", k=1
Output: 4
Explanation: Replace the 'c' with 'b' to have a longest repeating substring "bbbb".
Example 3:

Input: String="abccde", k=1
Output: 3
Explanation: Replace the 'b' or 'd' with 'c' to have the longest repeating substring "ccc".
*/





import java.util.HashMap;
import java.util.Map;

public class replaceKchars {
    public static void main(String[] args) {
        System.out.println(findLength("aabccbb",2));
        System.out.println(findLength("abbbb",1));
        System.out.println(findLength("abbcb",1));
        System.out.println(findLength("abccde",1));

    }
    public static int findLength(String s,int k){
        int windowstart=0,maxrepeating=0,maxlength=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(int windowend=0;windowend<s.length();windowend++){
            char ch=s.charAt(windowend);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            maxrepeating=Math.max(maxrepeating,hm.get(ch));
            if(windowend-windowstart+1-maxrepeating>k){
                char c=s.charAt(windowstart);
                hm.put(c,hm.get(c)-1);
                windowstart++;
            }
            maxlength=Math.max(maxlength,windowend-windowstart+1);
        }
        return maxlength;
    }
}
