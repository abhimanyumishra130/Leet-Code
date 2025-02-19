/*
A happy string is a string that:

consists only of letters of the set ['a', 'b', 'c'].
s[i] != s[i + 1] for all values of i from 1 to s.length - 1 (string is 1-indexed).
For example, strings "abc", "ac", "b" and "abcbabcbcb" are all happy strings and strings "aa", "baa" and "ababbc" are not happy strings.

Given two integers n and k, consider a list of all happy strings of length n sorted in lexicographical order.

Return the kth string of this list or return an empty string if there are less than k happy strings of length n.

 

Example 1:

Input: n = 1, k = 3
Output: "c"
Explanation: The list ["a", "b", "c"] contains all happy strings of length 1. The third string is "c".
Example 2:

Input: n = 1, k = 4
Output: ""
Explanation: There are only 3 happy strings of length 1.
Example 3:

Input: n = 3, k = 9
Output: "cab"
Explanation: There are 12 different happy string of length 3 ["aba", "abc", "aca", "acb", "bab", "bac", "bca", "bcb", "cab", "cac", "cba", "cbc"]. You will find the 9th string = "cab"
 

Constraints:

1 <= n <= 10
1 <= k <= 100
*/

//

class Solution {
    char[] arr;
    boolean doesBreak = false;
    public String getHappyString(int n, int k) {
        arr = new char[n];
        Arrays.fill(arr,'a');
        doesBreak = false;
        String res = "";
        while(0<k--){
            while(!isValidString()){
                updateOne();
                if(doesBreak) break;
            }
            // print(arr);

            if(doesBreak) break;
            res = String.valueOf(arr);
            updateOne();
        }

        return k<0?res:"";
    }

    public void updateOne(){
        // print(arr);
        int rem = 0;
        int n = arr.length;
         if(arr[n-1] == 99){
            rem = 1;
            arr[n-1] = 97;
            if(n==1) doesBreak = true;
        }else arr[n-1]+=1;
        // System.out.println(arr[n-1]);
        for(int i=n-2; i>=0 && rem>0; i--){
            if(arr[i] == 99){
                rem = 1;
                arr[i] = 97;
                if(i==0) doesBreak = true;
            }else {
                arr[i]+=1;
                rem = 0;
            }
        }
    }

    public boolean isValidString(){
        for(int i=1; i<arr.length; i++){
            if(arr[i] == arr[i-1]) return false;
        }
        return true;
    }

    public void print(char[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
