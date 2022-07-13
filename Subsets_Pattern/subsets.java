/*
Given a set with distinct elements, find all of its distinct subsets.
Example 1:
Input: [1, 3]
Output: [], [1], [3], [1,3]
Example 2:
Input: [1, 5, 3]
Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
*/


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> fin=new ArrayList<>();
        fin.add(new ArrayList<>());
        for(int num:nums){
            int s=fin.size();
            for(int i=0;i<s;i++){
                List<Integer> set=new ArrayList<>(fin.get(i));
                set.add(num);
                fin.add(set);
            }
        }
        return fin;
    }
}
