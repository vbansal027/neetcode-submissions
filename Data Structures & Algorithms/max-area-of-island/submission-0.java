class Solution {

    int moves[][] = {{0,1}, {1,0}, {-1,0}, {0,-1}};
    // dfs solution
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                int area = getAreaDfs(grid, i, j);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int getAreaDfs(int[][] arr, int i, int j) {
        if (i<0 || j<0 || i>=arr.length || j>=arr[i].length || arr[i][j]!=1) {
            return 0;
        }

        arr[i][j] = 0;
        int area = 1;
        for (int[] move: moves) {
            int r = i + move[0];
            int c = j + move[1];
            area += getAreaDfs(arr, r, c);
        }

        return area;
    }
}
