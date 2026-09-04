class Solution {

    private final int[][] moves = {
        {1,0},
        {0,1},
        {-1,0},
        {0,-1}
    };

    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> q = new ArrayDeque();

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int depth = 0;
        while (!q.isEmpty()) {
            int elementsAtCurrentDepth = q.size();
            for (int k = 0; k<elementsAtCurrentDepth; k++) {
                int[] p = q.poll();
                for (int[] move : moves) {
                    int r = p[0] + move[0];
                    int c = p[1] + move[1];
                    if (r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c] != Integer.MAX_VALUE) {
                        // this check skips the boudary breaching and non valid and visited cells
                        continue;
                    } else {
                        // mark the node as visited by updating the value of node to current depth+1
                        grid[r][c] = depth+1;
                        // and push it to the queue
                        q.offer(new int[]{r, c});
                    }
                }
            }
            depth++;
        }

        return;
    }

}
