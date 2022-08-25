/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
*/


class Solution {
    public boolean canConstruct(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<a.length(); i++){
            map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0)+1);
        }
        
        for(int i=0; i<b.length(); i++){
            if(map.containsKey(b.charAt(i))){
                map.put(b.charAt(i),map.get(b.charAt(i))-1);
            }
        }
        
        for(Map.Entry<Character, Integer> m:map.entrySet()){
            if(m.getValue()>0) return false;
        }
        return true;
    }
}
