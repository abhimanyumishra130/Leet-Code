/*
An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

 

Example 1:

Input: changed = [1,3,4,2,6,8]
Output: [1,3,4]
Explanation: One possible original array could be [1,3,4]:
- Twice the value of 1 is 1 * 2 = 2.
- Twice the value of 3 is 3 * 2 = 6.
- Twice the value of 4 is 4 * 2 = 8.
Other original arrays could be [4,3,1] or [3,1,4].
Example 2:

Input: changed = [6,3,0,1]
Output: []
Explanation: changed is not a doubled array.
Example 3:

Input: changed = [1]
Output: []
Explanation: changed is not a doubled array.
 

Constraints:

1 <= changed.length <= 105
0 <= changed[i] <= 105
*/


class Solution {
    public int[] findOriginalArray(int[] arr) {
        int len = arr.length;
        if(len %2 == 1) return new int[0];
        Arrays.sort(arr);
        int[] res = new int[len/2];
        int ind= 0;
       for(int i=0, j=1; i<j && j<len && i<len;){
           if(arr[i]*2 == arr[j]){
               res[ind++] = arr[i];
               arr[i] = -1;
               arr[j] = -1;
               while(i<len && arr[i] == -1) i++;
               while(j<len && (arr[j] == -1 || j<=i)) j++;
           }else j++;
        }
        
        if(ind == 0 || ind<len/2) return new int[0];
        return res;
    }
    
}
