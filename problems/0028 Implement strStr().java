/*
Implement strStr().

Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

 

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
Accepted

*/

class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
     if( n> h) return -1;
        for(int i=0; i<h; i++){
            boolean b = false;
            if(h-i < n) return -1;
            if(haystack.charAt(i) == needle.charAt(0) && !b){
                for(int j=0, k =i; j<n && k<h; j++,k++){
                    if(haystack.charAt(k) == needle.charAt(j) && j == n-1){
                        b = true;
                    }else if(haystack.charAt(k) != needle.charAt(j)) break;
                }
            }
            
            if(b) return i;
        }
        
        return -1;
    }
}
