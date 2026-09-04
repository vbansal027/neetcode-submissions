class Solution {

    int moves[][] = {{0,1}, {0,-1}, {1, 0}, {-1, 0}};

    // this solution modifies the input grid to keep track of visited nodes
    // to not modify input array, we can use extra space O(m.n)
    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    // runBfs(grid, i, j);
                    runDfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    // start BFS from (i,j) and mark all possible nodes as visited
    private void runBfs(char[][] arr, int i, int j) {
        Queue<Pair> q = new ArrayDeque<Pair>();
        // to mark this as visited we gonna turn this into water (0)
        arr[i][j] = '0';
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            Pair p = q.remove();
            
            // add all possible neighbors
            for (int[] move : moves) {
                int r = p.f + move[0];
                int c = p.s + move[1];
                if (r>=0 && c>=0 && r<arr.length && c<arr[p.f].length && arr[r][c]=='1') {
                    arr[r][c] = '0';
                    q.add(new Pair(r, c));
                }
            }
        }

        return;
    }

    // start DFS from (i,j) and mark all possible nodes as visited
    private void runDfs(char[][] arr, int i, int j) {

        if (i<0 || j<0 || i>=arr.length || j>=arr[i].length || arr[i][j]!='1') {
            return;
        }

        // mark current node as visited
        arr[i][j] = '0';

        // now move in all possible directions from here
        for (int move[] : moves) {
            runDfs(arr, i+move[0], j+move[1]);
        }

        return;
    }

    private class Pair {
        int f;
        int s;

        Pair() {
            this.f = 0;
            this.s = 0;
        }
        
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}
