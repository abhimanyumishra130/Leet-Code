/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).

 

Example 1:


Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
Explanation: There are two falling paths with a minimum sum as shown.
Example 2:


Input: matrix = [[-19,57],[-40,-5]]
Output: -59
Explanation: The falling path with a minimum sum is shown.
 

Constraints:

n == matrix.length == matrix[i].length
1 <= n <= 100
-100 <= matrix[i][j] <= 100


*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] memo = new int[matrix.length][matrix.length];
        for(int i=0; i<matrix.length; i++) Arrays.fill(memo[i],10100);
        for(int i=0; i<matrix.length; i++){
            int sum = minSum(matrix,0,i,memo);
            if(sum < min) min = sum;
        }
        return min;
    }

    public int minSum(int[][] mat, int r, int c, int[][] memo){
        if(r >= mat.length || c<0 || c>=mat.length) return 10100;
        if(memo[r][c] != 10100) return memo[r][c];
        int dl =minSum(mat,r+1,c-1,memo);
        int dr =minSum(mat, r+1, c+1,memo);
        int dd =minSum(mat, r+1, c,memo);

        int min = 10100;
        if(dl != 10100) min = Math.min(min, dl+mat[r][c]);
        if(dd != 10100) min = Math.min(min, dd+mat[r][c]);
        if(dr != 10100) min = Math.min(min, dr+mat[r][c]);

        if(min != 10100) memo[r][c] = min;
        // System.out.println(dl+" "+dd+" "+dr+" "+mat[r][c]+" "+min);
        return min == 10100 ? mat[r][c] : min ;
    }
}
