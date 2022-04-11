/*



String Anagrams (hard) #
Given a string and a pattern, find all anagrams of the pattern in the given string.

Anagram is actually a Permutation of a string. For example, “abc” has the following six anagrams:

abc
acb
bac
bca
cab
cba
Write a function to return a list of starting indices of the anagrams of the pattern in the given string.

Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".
Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".



*/




import java.util.*;

public class Anagram
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(findPermutaion("abbcabc", "abc"));
        System.out.println(findPermutaion("ppqp", "pq"));
        System.out.println(findPermutaion("aaacbcba", "abc"));
        System.out.println(findPermutaion("oidbcaf", "abc"));
    }
    public static List<Integer> findPermutaion(String word,String pattern){
        int windowStart=0,matched=0;
        Map<Character,Integer> hm=new HashMap<>();
        List<Integer> l=new ArrayList<>();
        for(int i=0;i<pattern.length();i++){
            hm.put(pattern.charAt(i),hm.getOrDefault(pattern.charAt(i),0)+1);
        }
        for(int windowEnd=0;windowEnd<word.length();windowEnd++){
            char rightchar=word.charAt(windowEnd);
            if(hm.containsKey(rightchar)) {
                hm.put(rightchar, hm.get(rightchar) - 1);
                if (hm.get(rightchar) == 0)
                    matched++;
            }
            if(matched==pattern.length())
                l.add(windowStart);
            if(windowEnd>=pattern.length()-1){
                char leftchar=word.charAt(windowStart++);
                if(hm.containsKey(leftchar)){
                    if(hm.get(leftchar)==0)
                        matched--;
                    hm.put(leftchar,hm.get(leftchar)+1);
                }
            }
        }
        return l;
    }
}
