/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral.

 

Example 1:

Input: num = 3
Output: "III"
Explanation: 3 is represented as 3 ones.
Example 2:

Input: num = 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 3:

Input: num = 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 

Constraints:

1 <= num <= 3999
*/

class Solution {
    public String intToRoman(int num) {
        StringBuilder str = new StringBuilder();
        while(num>0){
            if(num>=1000){
                num -= 1000;
                str.append("M");
            }else if(num>=900){
                num -= 900;
                str.append("CM");
            }else if(num>=500){
                num -= 500;
                str.append("D");
            }else if(num>=400){
                num -= 400;
                str.append("CD");
            }else if(num>=100){
                num -= 100;
                str.append("C");
            }else if(num>=90){
                num -= 90;
                str.append("XC");
            }else if(num>=50){
                num -= 50;
                str.append("L");
            }else if(num>=40){
                num -= 40;
                str.append("XL");
            }else if(num>=10){
                num -= 10;
                str.append("X");
            }else if(num>=9){
                num -= 9;
                str.append("IX");
            }else if(num>=5){
                num -= 5;
                str.append("V");
            }else if(num>=4){
                num -= 4;
                str.append("IV");
            }else if(num>=1){
                num -= 1;
                str.append("I");
            }
        }
        return str.toString();
    }
}
