/*



In many problems dealing with an array (or a LinkedList), we are asked to find or calculate something among all the contiguous 
subarrays (or sublists) of a given size. For example, take a look at this problem:

Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

Let’s understand this problem with a real input:

Array: [1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
Here, we are asked to find the average of all contiguous subarrays of size ‘5’ in the given array. Let’s solve this:

For the first 5 numbers (subarray from index 0-4), the average is: (1+3+2+6-1)/5 => 2.2(1+3+2+6−1)/5=>2.2
The average of next 5 numbers (subarray from index 1-5) is: (3+2+6-1+4)/5 => 2.8(3+2+6−1+4)/5=>2.8
For the next 5 numbers (subarray from index 2-6), the average is: (2+6-1+4+1)/5 => 2.4(2+6−1+4+1)/5=>2.4
…
Here is the final output containing the averages of all contiguous subarrays of size 5:

Output: [2.2, 2.8, 2.4, 3.6, 2.8]
A brute-force algorithm will be to calculate the sum of every 5-element contiguous subarray of the given array and divide the sum by ‘5’ to find the average. 
This is what the algorithm will look like:



*/





import java.util.Arrays;
import java.util.Scanner;

public class subarrayaverage {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double[] arr= find_Average(5,new int[]{1,3,2,6,-1,4,1,8,2});
        System.out.println(Arrays.toString(arr));
    }
    public static double[] find_Average(int k,int[] arr){
        double[] d=new double[arr.length-k+1];
        int windowstart=0;
        double windowsum=0;
        for(int windowend=0;windowend< arr.length;windowend++){
            windowsum+=arr[windowend];
            if(windowend>=k-1){
                d[windowstart]=windowsum/k;
                windowsum-=arr[windowstart];
                windowstart++;
            }
        }
        return d;
    }
}
