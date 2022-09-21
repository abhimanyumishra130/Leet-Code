/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

 

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
Explanation: The repeated subarray with maximum length is [3,2,1].
Example 2:

Input: nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
Output: 5
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 100
*/

class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int max = 0;
        int count = 0;
        for(int i=0; i<nums1.length; i++){
            
            for(int j=0,k = i; j<nums2.length && k<nums1.length; j++){
                if(nums1[k] == nums2[j]){
                    count++;
                    k++;
                }else{
                    if(count > max) max = count;
                    count = 0;
                    
                    k=i;
                     if(nums1[k] == nums2[j]){
                        count++;
                        k++;
                     } 
                }
            }
            if(count>max) max = count;
            count = 0;
        }
        
        for(int i=0; i<nums2.length; i++){
            
            for(int j=0,k = i; j<nums1.length && k<nums2.length; j++){
                if(nums2[k] == nums1[j]){
                    count++;
                    k++;
                }else{
                    if(count > max) max = count;
                    count = 0;
                    
                    k=i;
                     if(nums2[k] == nums1[j]){
                        count++;
                        k++;
                     } 
                }
            }
            if(count>max) max = count;
            count = 0;
        }
        // if(count>max) max = count;
        return max;
    }
}
