/*

Given an array of unsorted numbers and a target number, find a triplet in the array whose sum is as close to the target number as possible, return the sum of the triplet. If there are more than one such triplet, return the sum of the triplet with the smallest sum.

Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.

*/



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class TripleSumtozero{
    public static void main(String[] args) {
        System.out.println(searchTriplets(new int[]{-2,0,1,2},2));
        System.out.println(searchTriplets(new int[] {-3,-1,1,2},1));
        System.out.println(searchTriplets(new int[]{1,0,1,1},100));
    }
    public static int searchTriplets(int[] arr,int target){
        Arrays.sort(arr);
        int smallestDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-2;i++) {
            int right = arr.length - 1,left=i+1;
            while (left < right) {
                int currentdiff=target-arr[i]-arr[left]-arr[right];
                if(currentdiff==0)
                    return target-currentdiff;
                if(Math.abs(smallestDiff)>Math.abs(currentdiff))
                    smallestDiff=currentdiff;
                if(currentdiff>0)
                    left++;
                else
                    right--;

            }
        }
        return target-smallestDiff;
    }
}
