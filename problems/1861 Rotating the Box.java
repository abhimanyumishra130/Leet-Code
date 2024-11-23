/*
You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:

A stone '#'
A stationary obstacle '*'
Empty '.'
The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.

It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.

Return an n x m matrix representing the box after the rotation described above.

 

Example 1:



Input: box = [["#",".","#"]]
Output: [["."],
         ["#"],
         ["#"]]
Example 2:



Input: box = [["#",".","*","."],
              ["#","#","*","."]]
Output: [["#","."],
         ["#","#"],
         ["*","*"],
         [".","."]]
Example 3:



Input: box = [["#","#","*",".","*","."],
              ["#","#","#","*",".","."],
              ["#","#","#",".","#","."]]
Output: [[".","#","#"],
         [".","#","#"],
         ["#","#","*"],
         ["#","*","."],
         ["#",".","*"],
         ["#",".","."]]
 

Constraints:

m == box.length
n == box[i].length
1 <= m, n <= 500
box[i][j] is either '#', '*', or '.'.
*/


class Solution {
    public char[][] rotateTheBox(char[][] box) {
        if(box.length<1) return box;
        for(int i=0; i<box.length; i++){
            int end = box[i].length;
            int emp = 0;
            for(int j=end-1; j>=0; j--){
                // System.out.println(box[i][j]+" "+emp+" "+i+" "+j);
                if(box[i][j] == '#'){
                    // System.out.println(box[i][j]+" "+emp+" "+i+" "+j);
                    if(emp>0){
                        box[i][end-1] = '#';
                        box[i][j] = '.';
                    }
                    end--;
                }else if(box[i][j] == '*'){
                    end = j;
                    emp = 0;
                }else emp++;
            }
        }
        
        return rotate90(box);
    }
    
    public char[][] rotate90(char[][] arr){
        if(arr.length<1) return arr;
        char[][] res = new char[arr[0].length][arr.length];
        for(int i=arr.length-1; i>=0; i--){
            int n = arr.length;
            for(int j=0; j<arr[i].length; j++){
                res[j][n-1-i] = arr[i][j];
            }
        }
        
        return res;
    }
}
