/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

 

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/


//brute force
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for(int j=0; j<nums.length; j++){
            for(int i=j+1; i<nums.length; i++){
                if(i-j > k) break;
                
                if(nums[i] == nums[j]) return true;
            }
        }
        return false;
    }
}


//O(n) approach
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<nums.length; j++){
            if(map.containsKey(nums[j])){
                if(j-map.get(nums[j]) <= k) return true;
            }
            
            map.put(nums[j],j);
        }
        return false;
    }
}

//More efficient
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j=0; j<nums.length; j++){
            Integer ind = map.put(nums[j],j);
            if(ind != null && j-ind <= k) return true;
        }
        return false;
    }
}
