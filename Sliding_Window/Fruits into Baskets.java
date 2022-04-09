/*



Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.

You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.

Write a function to return the maximum number of fruits in both the baskets.

Example 1:

Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
Example 2:

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. 
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']


*/


import java.util.HashMap;

public class longestSubSringWith2distinctChars {
     public static void main(String[] args) {
         System.out.println(find(new char[]{'A','B','C','A','C'}));
         System.out.println(find(new char[] {'A','B','C','B','B','C'}));
         System.out.println(find(new char[] {'B'}));


     }
     public  static int find(char[]   s ){
         if(s==null || s.length==0 ||s.length<2)
             return -1;
         int windowstart=0,max=Integer.MIN_VALUE;
         HashMap<Character,Integer> hs=new HashMap<>();
         for(int i=0;i<s.length;i++){
             char c=s[i];
             hs.put(c,hs.getOrDefault(c,0)+1);
             while(hs.size()>2){
                 char ch=s[windowstart];
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
