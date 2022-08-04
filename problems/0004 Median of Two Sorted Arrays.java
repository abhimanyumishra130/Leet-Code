/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

 

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 

Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/

//
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int k = 0;
        ArrayList<Integer> arr = new ArrayList();
        int limit = (m+n)/2+1;
        while(i<n && j<m && k++<limit) {
            if(nums1[i]<nums2[j]) {
                arr.add(nums1[i++]);
            } else {
                arr.add(nums2[j++]);
            }
        }
        if(i<n) {
            while(k++<limit) {
                arr.add(nums1[i++]);
            }
        } else if(j<m) {
            while(k++<limit) {
                arr.add(nums2[j++]);
            }
        }
        if((n+m)%2==0) {
            return (arr.get(limit-2)+arr.get(limit-1))/2.0;
        }
        return (double)arr.get(limit-1);
    }
}



//
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums2.length>nums1.length?nums2.length:nums1.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(i<nums1.length) {
                arr.add(nums1[i]);
            }
            if(i<nums2.length) {
                arr.add(nums2[i]);
            }
        }
        
        Collections.sort(arr);
        int mid = (arr.size())/2;
        if(arr.size()%2 == 1) return (double) arr.get(mid);
        return  (arr.get(mid)+arr.get(mid-1))/2.0;
    }
}
