/*



Given a string s, find the length of the longest substring without repeating characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

his difficulty in this question is finding out where to pick our next substring once we've spotted a duplicate character. Using two pointers and a sliding window, we can quite easily choose what substring we want to look at. In fact, finding the longest substring without repeating characters becomes even easier once you realise the following observation.

Key Observation:

Once we've landed on a character we've seen before, we want to move the left pointer of our window to the index after the last occurrence of that character.    



visit :   https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/2132830/Visual-Explanation-or-Sliding-Window-JAVA
*/



class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr=new int[128];
        int l=0,r=0,longest=0;
        for(r=0;r<s.length();r++){
            l=Math.max(l,arr[s.charAt(r)]);
            longest=Math.max(longest,r-l+1);
            arr[s.charAt(r)]=r+1;
        }
        return longest;
    }
}
