/*
Given a string s, return the longest palindromic substring in s.

 

Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 

Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int max = 0;
        String palindrome = "";
        for(int i=1; i<s.length(); i++) {
            String current = getPalindrome(i, s);
            if(max < current.length()) {
                max = current.length();
                palindrome = current;
            }
        }
        return palindrome;
    }
    public String getPalindrome(int i, String s) {
        String res ="";
         if(s.charAt(i-1) == s.charAt(i)) res =  getEvenPalindrome(i-1, i, s);
        String oddStr = getOddPalindrome(i, s);
         return res.length()>oddStr.length()?res:oddStr;
    }
    public String getEvenPalindrome(int i, int j, String s) {
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        return s.substring(i, j);
    }
    public String getOddPalindrome(int idx, String s) {
        int i = idx;
        int j = idx;
        while(i>=0 && j<s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        i++;
        return s.substring(i, j);
    }
}
