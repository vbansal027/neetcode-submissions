class Solution {

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;

        int[] seenRow = new int[n];
        int[] seenCol = new int[n];
        int[] seenBox = new int[n];

        for (int x=0; x<n; x++) {
            for (int y=0; y<n; y++) {
                
                if (board[x][y] == '.') continue;

                int val = Character.getNumericValue(board[x][y]);

                int setBit = (1 << (val-1));

                int b = ((x/3)*3)+(y/3);

                if (
                    (setBit & seenRow[x]) > 0 ||
                    (setBit & seenCol[y]) > 0 ||
                    (setBit & seenBox[b]) > 0
                ) 
                {
                    return false;
                }

                seenRow[x] = seenRow[x]|setBit;
                seenCol[y] = seenCol[y]|setBit;
                seenBox[b] = seenBox[b]|setBit;
            }
        }

        return true;
    }
}
