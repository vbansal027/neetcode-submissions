class Solution {
    private final int[][] moves = {
        {1, 0},
        {0, 1},
        {-1, 0},
        {0, -1}
    };

    public int orangesRotting(int[][] grid) {
        int minutesForSpread = runMultiSourceBfs(grid, 2);
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minutesForSpread;
    }

    private int runMultiSourceBfs(int[][] grid, int source) {
        Queue<int[]> q = new ArrayDeque();
        // int current timestamp
        int timeElapsed = 0;
        // init queue with source elements
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == source) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        // now start processing all nodes in queue together at a given timestamp
        while (!q.isEmpty()) {
            System.out.println("timeElapsed: " + timeElapsed);
            int limit = q.size();
            for (int k = 0; k<limit; k++) {
                int[] curr = q.poll();
                System.out.println(curr[0] + ", " + curr[1]);
                for (int[] move: moves) {
                    int r = curr[0] + move[0];
                    int c = curr[1] + move[1];
                    if (r<0 || c<0 || r>=grid.length || c>=grid[r].length || grid[r][c]!=1) {
                        continue;
                    } else {
                        grid[r][c] = source;
                        q.offer(new int[] {r, c});
                    }
                }
            }

            if (!q.isEmpty()) {
                timeElapsed++;
            }
        }

        return timeElapsed;
    }
}
