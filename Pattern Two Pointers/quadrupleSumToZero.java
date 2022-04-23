// Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the target number.

// Example 1:

// Input: [4, 1, 2, -1, 1, -3], target=1
// Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
// Explanation: Both the quadruplets add up to the target.
// Example 2:

// Input: [2, 0, -1, 1, -2, 2], target=2
// Output: [-2, 0, 2, 2], [-1, 0, 1, 2]
// Explanation: Both the quadruplets add up to the target.





import java.util.*;
public class Quadraplets {
    public static void main(String[] args) {
        System.out.println(searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int targetSum) {
        Arrays.sort(arr);
        List<List<Integer>> quadra = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i - 1] == arr[i])
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j - 1] == arr[j])
                    continue;
                searchPairs(arr, i, j, targetSum, quadra);
            }
        }
        return quadra;
    }

    public static void searchPairs(int[] arr, int first, int second, int targetSum, List<List<Integer>> quadra) {
        int left = second + 1;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right] + arr[first] + arr[second];
            if (sum == targetSum) {
                quadra.add(Arrays.asList(arr[first], arr[second], arr[left], arr[right]));
                right--;
                left++;
                while (left < right && arr[left - 1] == arr[left])
                    left++;
                while (left < right && arr[right + 1] == arr[right])
                    right--;
            } else if (sum < targetSum)
                left++;
            else
                right--;
        }
    }
}
