/*




Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.

Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3 
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2 
Output: 7
Explanation: Subarray with maximum sum is [3, 4].



*/





import java.util.Arrays;
import java.util.Scanner;

public class sumsubarrayMax {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int maxsum= find_sum(5,new int[]{1,3,2,6,-1,4,1,8,2});
        System.out.println(maxsum);
    }
    public static int  find_sum(int k,int[] arr){
        double[] d=new double[arr.length-k+1];
        int windowstart=0;
        int  windowsum=0,max=Integer.MIN_VALUE;
        for(int windowend=0;windowend< arr.length;windowend++){
            windowsum+=arr[windowend];
            if(windowend>=k-1){
                max=Math.max(max,windowsum);
                windowsum-=arr[windowstart];
                windowstart++;
            }
        }
        return max;
    }
}
