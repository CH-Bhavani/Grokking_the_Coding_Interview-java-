/*



Given an array containing 0s and 1s, if you are allowed to replace no more than ‘k’ 0s with 1s, find the length of the longest contiguous subarray having all 1s.

Example 1:

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
Example 2:

Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.


*/




public class LongestSubarraywithOnesafterReplacement {
    public static void main(String[] args) {
        System.out.println(find(new int[]{0,1,1,0,0,0,1,1,0,1,1},2));
        System.out.println(find(new int[]{0,1,0,0,1,1,0,1,1,0,0,1,1},3));
    }
    public static int find(int[] arr,int k){
        int windowstart=0,max=Integer.MIN_VALUE,count1=0;
        for(int windowend=0;windowend<arr.length;windowend++){
            if(arr[windowend]==1)
                count1++;
            if(windowend-windowstart+1-count1>k){
                if(arr[windowstart]==1)
                    count1--;
                windowstart++;
            }
            max=Math.max(max,windowend-windowstart+1);
        }
        return max;
    }
}
