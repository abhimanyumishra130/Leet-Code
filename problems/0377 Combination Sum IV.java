/*
Given an array of distinct integers nums and a target integer target, return the number of possible combinations that add up to target.

The test cases are generated so that the answer can fit in a 32-bit integer.

 

Example 1:

Input: nums = [1,2,3], target = 4
Output: 7
Explanation:
The possible combination ways are:
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)
Note that different sequences are counted as different combinations.
Example 2:

Input: nums = [9], target = 3
Output: 0
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 1000
All the elements of nums are unique.
1 <= target <= 1000
 

Follow up: What if negative numbers are allowed in the given array? How does it change the problem? What limitation we need to add to the question to allow negative numbers?
*/

//
class Solution {
    public int combinationSum4(int[] nums, int target) {
     return resultCount(nums, target, new Integer[target+1]);  
    }
    
    public static int resultCount(int[] arr, int sum,Integer[] memo){
        if(sum == 0)  return 1;
        if(sum < 0) return 0;
        if(memo[sum] != null){
            System.out.println(sum);
            return memo[sum];
        }
        int count =0;
       for(int i=0; i<arr.length; i++){
           count += resultCount(arr, sum-arr[i], memo);
       }
        return memo[sum] = count;
    }
}
