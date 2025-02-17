/*
You have n  tiles, where each tile has one letter tiles[i] printed on it.

Return the number of possible non-empty sequences of letters you can make using the letters printed on those tiles.

 

Example 1:

Input: tiles = "AAB"
Output: 8
Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".
Example 2:

Input: tiles = "AAABBC"
Output: 188
Example 3:

Input: tiles = "V"
Output: 1
 

Constraints:

1 <= tiles.length <= 7
tiles consists of uppercase English letters.
*/

//
class Solution {
    public int count = 0;
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> counter = new HashMap<>();
        for (char ch : tiles.toCharArray()) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        return backtrack(counter);
    }

    private int backtrack(Map<Character, Integer> counter) {
        int total = 0;
        for (char ch : counter.keySet()) {
            int count = counter.get(ch);
            if (count > 0) {
                counter.put(ch, count - 1);
                total += 1 + backtrack(counter);
                counter.put(ch, count);
            }
        }
        return total;
    }
}
