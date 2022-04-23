/*


Given an array, find the length of the smallest subarray in it which when sorted will sort the whole array.

Example 1:

Input: [1, 2, 5, 3, 7, 10, 9, 12]
Output: 5
Explanation: We need to sort only the subarray [5, 3, 7, 10, 9] to make the whole array sorted
Example 2:

Input: [1, 3, 2, 0, -1, 7, 10]
Output: 5
Explanation: We need to sort only the subarray [1, 3, 2, 0, -1] to make the whole array sorted
Example 3:

Input: [1, 2, 3]
Output: 0
Explanation: The array is already sorted
Example 4:

Input: [3, 2, 1]
Output: 3
Explanation: The whole array needs to be sorted.

*/




class test{
    public static void main(String[] args) {
        System.out.println(sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(sort(new int[] { 1, 2, 3 }));
        System.out.println(sort(new int[] { 3, 2, 1 }));

    }
    public static int sort(int[] arr){
        int left=0,right=arr.length-1,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
        while(left<arr.length-1 && arr[left]<=arr[left+1])
            left++;
        if(left==arr.length-1)
            return 0;
        while(right>0 && arr[right]>=arr[right-1])
            right--;
        for(int i=left;i<=right;i++){
            min=Math.min(min,arr[i]);
            max=Math.max(max,arr[i]);
        }
        while(left>0 && arr[left-1]>min)
            left--;
        while(right<arr.length-1 && arr[right+1]<max)
            right++;
        return right-left+1;
    }
}
