/*
Given a 0-indexed integer array nums of size n and two integers lower and upper, return the number of fair pairs.

A pair (i, j) is fair if:

0 <= i < j < n, and
lower <= nums[i] + nums[j] <= upper
 

Example 1:

Input: nums = [0,1,7,4,4,5], lower = 3, upper = 6
Output: 6
Explanation: There are 6 fair pairs: (0,3), (0,4), (0,5), (1,3), (1,4), and (1,5).
Example 2:

Input: nums = [1,7,9,2,5], lower = 11, upper = 11
Output: 1
Explanation: There is a single fair pair: (2,3).
 

Constraints:

1 <= nums.length <= 105
nums.length == n
-109 <= nums[i] <= 109
-109 <= lower <= upper <= 109
*/

//

class Solution {
    fun countFairPairs(arr: IntArray, lower: Int, upper: Int): Long {
        var count: Long = 0
        val nums = arr.sortedArray();
        for(i in 0 until nums.size){
            val rightInd =searchRightUpperInd(nums, upper, nums[i], i+1)
            val leftInd = searchLeftLowerInd(nums, lower, nums[i], i+1)
            if(rightInd == -1 || leftInd == -1) continue

            count += rightInd - leftInd +1
        }
        return count
    }

    fun searchLeftLowerInd(nums:IntArray, lower: Int, num: Int, start: Int): Int{
        
        var right = nums.size-1
        var left = start
        var ans = -1;

        while(left<=right){
            val mid: Int = left+(right-left)/2
            // println("$mid $left $right")
            if(nums[mid]+num >= lower){
                ans = mid
                right = mid-1
            }
            else left = mid+1;
        }
        return ans;
    }

    fun searchRightUpperInd(nums:IntArray, upper: Int, num: Int, start: Int): Int{
        
        var right = nums.size-1
        var left = start
        var ans = -1;

        while(left<=right){
            val mid: Int = left+(right-left)/2
            // println("$mid $left $right")
            if(nums[mid]+num <= upper){
                ans = mid
                left = mid+1
            }
            else right = mid-1;
        }
        return ans;
    }
}
