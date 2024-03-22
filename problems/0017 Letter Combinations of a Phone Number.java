/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/


class Solution {
    private static HashMap<Integer, String> map = new HashMap<>();
    private static List<String> list = new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        putValues(map);
        list.clear();
        addCombinations(digits, "", 0);
        return list;
    }
    public static void putValues(HashMap<Integer, String> map){
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
    }

    public static void addCombinations(String digits, String result, int ind){
        if(ind >= digits.length()){
            if(result.length() != 0) list.add(result);
            return;
        }
        int num = digits.charAt(ind)-'0';
        ind++;
        String str = map.get(num);
        for(int i = 0; i<str.length(); i++){
            addCombinations(digits, result+str.charAt(i), ind);
        }
    }
}
