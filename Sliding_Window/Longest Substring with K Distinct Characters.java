/*



Given a string, find the length of the longest substring in it with no more than K distinct characters.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".



*/



import java.util.HashMap;

public class longestSubSringWithKdistinctChars{
     public static void main(String[] args) {
         System.out.println(find("araaci", 2));
         System.out.println(find("araaci", 1));
         System.out.println(find("cbbebi", 3));


     }
     public  static int find(String s,int k){
         if(s==null || s.length()==0 ||s.length()<k)
             return -1;
         int windowstart=0,max=Integer.MIN_VALUE;
         HashMap<Character,Integer> hs=new HashMap<>();
         for(int i=0;i<s.length();i++){
             char c=s.charAt(i);
             hs.put(c,hs.getOrDefault(c,0)+1);
             while(hs.size()>k){
                 char ch=s.charAt(windowstart);
                 hs.put(ch,hs.get(ch)-1);
                 if(hs.get(ch)==0)
                     hs.remove(ch);
                 windowstart++;
             }
             max=Math.max(max,i-windowstart+1);
         }
         return max;
     }
}
