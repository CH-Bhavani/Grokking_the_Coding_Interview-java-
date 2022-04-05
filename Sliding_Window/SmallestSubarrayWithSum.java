/*


Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.

Example 1:

Input: [2, 1, 5, 2, 3, 2], S=7 
Output: 2
Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
Example 2:

Input: [2, 1, 5, 2, 8], S=7 
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
Example 3:

Input: [3, 4, 1, 1, 6], S=8 
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].




*/





import java.util.Scanner;

public class findMinsubarray {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int maxsum= find_sum(8,new int[]{3,4,1,1,6,1,2,4,4,});
        System.out.println(maxsum);
    }
    public static int  find_sum(int sum,int[] arr){
        int windowstart=0,windowsum=0,minwindow=Integer.MAX_VALUE;
        for(int windowend=0;windowend<arr.length;windowend++){
            windowsum+=arr[windowend];
            while(windowsum>=sum){
                minwindow=Math.min(minwindow,windowend-windowstart+1);
                windowsum-=arr[windowstart];
                windowstart++;
            }
        }
        return minwindow==Integer.MAX_VALUE?0:minwindow;

    }
}
