/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
 

Follow up: Could you use search pruning to make your solution faster with a larger board?
*/

//
class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] vis;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                    vis = new boolean[board.length][board[i].length];
                    if(isExist(board, i, j, word, 0, vis)) return true;
                }
            }
        }

        return false;
    }

    public boolean isExist(char[][] arr, int i, int j, String str, int ind, boolean[][] vis){
        if(ind>=str.length()) return true;
        if(i<0 || i>=arr.length ||
        j<0 || j>=arr[0].length ||
        vis[i][j] || arr[i][j] != str.charAt(ind)) return false;
        vis[i][j] = true;
        boolean top = isExist(arr, i-1,j, str, ind+1, vis);
        boolean down = isExist(arr, i+1,j, str, ind+1, vis);
        boolean left = isExist(arr, i,j-1, str, ind+1, vis);
        boolean right = isExist(arr, i,j+1, str, ind+1, vis);
        vis[i][j] = false;
        return top || down || left || right;
    }
}
