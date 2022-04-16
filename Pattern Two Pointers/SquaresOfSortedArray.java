/*







Given a sorted array, create a new array containing squares of all the number of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0 1 1 4 9]



*/





import java.util.Scanner;

class squares{
    public static void main(String[] args) {
        find(new int[]{-2,-1,0,2,3});
        find(new int[] {-3,-1,0,1,2,6});
    }
    public static void find(int[] arr){
        int left=0,right=arr.length-1,high=arr.length-1;
        int[] a=new int[arr.length];
        while(left<=right){
            int leftsquare=arr[left]*arr[left];
            int rightsquare=arr[right]*arr[right];
            if(leftsquare>rightsquare){
                a[high--]=leftsquare;
                left++;
            }
            else {
                a[high--] = rightsquare;
                right--;
            }
        }
        for(int i:a)
            System.out.print(i+" ");
        System.out.println();
    }
}
