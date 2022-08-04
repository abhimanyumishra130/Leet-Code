/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
 

Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:
P     I    N
A   L S  I G
Y A   H R
P     I
Example 3:

Input: s = "A", numRows = 1
Output: "A"
 

Constraints:

1 <= s.length <= 1000
s consists of English letters (lower-case and upper-case), ',' and '.'.
1 <= numRows <= 1000
*/


class Solution {
    public String convert(String s, int numRows) {
        String res = "";
        if(s.length() == 1 ||s.length() == 2 || numRows == 1) return s;
        int add = numRows+numRows-2;
        int sum = add;
        int min = 0;
        for(int i=0; i<s.length() && i<numRows; i++){
            if(i==0 || i == numRows-1){
                for(int k=i; k<s.length(); k+=sum){
                    res += s.charAt(k);
                }
            }else{
                int j=i;
                boolean flag = true;
                while(j<s.length() && j>=0){
                    if(flag){
                        res += s.charAt(j);
                        j += add;
                        flag = false;
                    }else{
                        res += s.charAt(j);
                        j += min;
                        flag = true;
                    }
                }
            }
            
            add -= 2;
            min += 2;
        }
        
        return res;
    }
}
