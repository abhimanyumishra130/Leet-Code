/*
You are given an integer n. We reorder the digits in any order (including the original order) such that the leading digit is not zero.

Return true if and only if we can do this so that the resulting number is a power of two.

 

Example 1:

Input: n = 1
Output: true
Example 2:

Input: n = 10
Output: false
 

Constraints:

1 <= n <= 10^9
*/

//
class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) return true;
        var numArr = (n+"").toCharArray();
        Arrays.sort(numArr);
        int mul = 1;
        for(int i=1; i<=30; i++){
            mul *= 2;
            if(isEqual(numArr,mul)) return true;
        }
        
        return false;
        
    }
    
    public static boolean isEqual(char[] numArr, int power) {
        var powerArr = (power+"").toCharArray();
        Arrays.sort(powerArr);
        return Arrays.equals(numArr, powerArr);
    }
}

//avg
class Solution {
    public boolean reorderedPowerOf2(int n) {
        if(n==1) return true;
        var numArr = String.valueOf(n).toCharArray();
        Arrays.sort(numArr);
        int mul = 1;
        for(int i=1; i<=30; i++){
            mul *= 2;
            if(isEqual(numArr,mul)) return true;
        }
        
        return false;
        
    }
    
    public static boolean isEqual(char[] numArr, int power) {
        var powerArr = String.valueOf(power).toCharArray();
        Arrays.sort(powerArr);
        return Arrays.equals(numArr, powerArr);
    }
}

// faster
class Solution {
    public boolean reorderedPowerOf2(int n) {
        var numArr = String.valueOf(n).toCharArray();
        Arrays.sort(numArr);
        for(int i=0; i<=30; i++){
            int mul = 1<<i;
            if(isEqual(numArr,mul)) return true;
        }
        
        return false;
        
    }
    
    public static boolean isEqual(char[] numArr, int power) {
        var powerArr = String.valueOf(power).toCharArray();
        Arrays.sort(powerArr);
        return Arrays.equals(numArr, powerArr);
    }
}

