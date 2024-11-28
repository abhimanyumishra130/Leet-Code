/*


*/

// Time limit exceeded

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i], -1);
        }
        int[][] vis = new int[m][n];
        // vis[0][0] = 1;
        return getMinimumRemoval(grid, 0, 0, memo, vis, 0, m, n);
    }
    
    public int getMinimumRemoval(int[][] arr, int i, int j, int[][] memo, int[][] vis, int remCount, int m, int n){
        if(i==m-1 && j==n-1) return remCount;
        if(vis[i][j] == 1) return -1;
        if(memo[i][j]!=-1) return memo[i][j];
        vis[i][j] = 1;
        int topCount = 0;
        int leftCount = 0;
        int downCount = 0;
        int rightCount = 0;
        int smallestCount = -1;
        if(i>0){
            // if(vis[i-1][j] == 1) topCount = -1;
            // else {
                 // vis[i-1][j] = 1;
                topCount = getMinimumRemoval(arr, i-1, j, memo, vis, 0, m, n);
                // vis[i-1][j] = 0;
            // }
            
            if(topCount!=-1) smallestCount = topCount;
        }
        
        if(j>0){
            // if(vis[i][j-1] == 1) leftCount = -1;
            // else {
                // vis[i][j-1] = 1;
                leftCount = getMinimumRemoval(arr, i, j-1, memo, vis, 0, m, n);
                // vis[i][j-1] = 0;
            // }
            if(leftCount!=-1 && (smallestCount==-1||leftCount<smallestCount)) 
                smallestCount = leftCount;
        }
        
        if(i<m-1){
            // if(vis[i+1][j] == 1) downCount = -1;
            // else {
                // vis[i+1][j] = 1;
                downCount = getMinimumRemoval(arr, i+1, j,memo, vis, 0, m, n);
                // vis[i+1][j] = 0;
            // }
            if(downCount!=-1 && (smallestCount==-1||downCount<smallestCount)) 
                smallestCount = downCount;
        }
        
        if(j<n-1){
            // if(vis[i][j+1] == 1) rightCount = -1;
            // else {
                // vis[i][j+1] = 1;
                rightCount = getMinimumRemoval(arr, i, j+1, memo, vis, 0, m, n);
                // vis[i][j+1] = 0;
            // }
            // System.out.println(i+" "+j+" right:"+rightCount);
            if(rightCount!=-1 && (smallestCount==-1||rightCount<smallestCount)) 
                smallestCount = rightCount;
        }
        // System.out.println(i+" "+j+" top:"+topCount+" down:"+downCount+" left:"+leftCount+" right:"+rightCount+" smallestCount");
        vis[i][j] = 0;
        if(arr[i][j] == 1) ++smallestCount;
        if(smallestCount<memo[i][j]) memo[i][j]= smallestCount;
        return smallestCount;
    }
}


//accepted

class Solution {
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distance = new int[m][n];
        for (int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        Deque<int[]> dq = new ArrayDeque<>();

        distance[0][0] = 0;
        dq.offerFirst(new int[] {0, 0});
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!dq.isEmpty()) {
            int[] cell = dq.pollFirst();
            int x = cell[0], y = cell[1];
            for (int[] dir : directions) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newDist = distance[x][y] + grid[nx][ny];
                    if (newDist < distance[nx][ny]) {
                        distance[nx][ny] = newDist;
                        if (grid[nx][ny] == 0) {
                            dq.offerFirst(new int[] {nx, ny});
                        } else {
                            dq.offerLast(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        return distance[m-1][n-1];
    }
}

