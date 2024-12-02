/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.

 

Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 

Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/

// 1425 ms

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int[] min = new int[2];
        min[1] = -1;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                for(int k=j+1; k<nums.length; k++){
                    int sum = nums[i]+nums[j]+nums[k];
                    int near = 0;
                    if((target<0 && sum>0) || (target>0 && sum<0) ){
                        near = Math.abs(Math.abs(sum) + Math.abs(target));
                    }else{
                        near = Math.abs(Math.abs(sum) - Math.abs(target));
                    }
                    // System.out.println(sum+" "+min[1]+" "+near);
                    if(min[1] == -1 || near<min[1]){
                        min[0] = sum;
                        min[1] = near;
                    }
                }
            }
        }

        return min[0];
    }
}


//Optimized with two pointer

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int[] min = new int[2];
        min[1] = -1;
        for(int i=0; i<nums.length; i++){
            int j=i+1;
            int k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==target) return sum;
                else if(sum<target) j++;
                else k--;

                int diff = Math.abs(sum-target);
                if(min[1] == -1 || diff<min[1]){
                    min[0] = sum;
                    min[1] = diff;
                }
            }
        }

        return min[0];
    }
}
