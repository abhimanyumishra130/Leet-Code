/*
Given an integer n, return true if it is a power of four. Otherwise, return false.

An integer n is a power of four, if there exists an integer x such that n == 4x.

 

Example 1:

Input: n = 16
Output: true
Example 2:

Input: n = 5
Output: false
Example 3:

Input: n = 1
Output: true
 

Constraints:

-231 <= n <= 231 - 1
 

Follow up: Could you solve it without loops/recursion?
*/

//
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        if(n == 1) return true;
       double num = (Math.log(n)/ Math.log(4));
        return Math.floor(num) == Math.ceil(num);
    }
}


//
class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        if(n == 1) return true;
        while(true){
            if(n % 4 != 0) break;;
            n /= 4;
        }
        return n == 1;
    }
}
