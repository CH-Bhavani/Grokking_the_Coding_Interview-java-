/*

Given an integer array nums, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order.

Return the shortest such subarray and output its length.

 

Example 1:

Input: nums = [2,6,4,8,10,9,15]
Output: 5
Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
Example 2:

Input: nums = [1,2,3,4]
Output: 0
Example 3:

Input: nums = [1]
Output: 0
 

Constraints:

1 <= nums.length <= 104
-105 <= nums[i] <= 105


*/



class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length==1)
            return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        boolean flag = false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1])
                flag=true;
            if(flag)
                min=Math.min(min,nums[i]);
        }
        flag=false;
        for(int j=nums.length-2;j>=0;j--){
            if(nums[j]>nums[j+1])
                flag=true;
            if(flag)
                max=Math.max(max,nums[j]);
        }
        int l,r;
        for(l=0;l<nums.length;l++){
            if(min<nums[l])
                break;
        }
        for(r=nums.length-1;r>=0;r--){
            if(max>nums[r])
                break;
        }
        return r-l<0?0:r-l+1;
    }
}
