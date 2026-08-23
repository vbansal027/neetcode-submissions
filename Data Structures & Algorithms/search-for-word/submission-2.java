class Solution {

    private char[][] arr;

    public boolean exist(char[][] board, String word) {
        this.arr = board;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[i].length; j++) {
                if (recurse(i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean recurse(int r, int c, String word, int i) {
        if (i == word.length()) {
            return true;
        }

        // visiting an already visited or out of range node
        if (
            (r < 0) || (c < 0) ||
            (r >= this.arr.length) ||
            (c >= this.arr[r].length) ||
            (this.arr[r][c] == 0)
        ) {
            return false;
        }

        boolean isFound = false;

        if (word.charAt(i) == this.arr[r][c]) {

            // mark this char as visited 
            char letter = this.arr[r][c];
            this.arr[r][c] = 0;

            isFound = (
                recurse(r-1, c, word, i+1) ||
                recurse(r, c-1, word, i+1) ||
                recurse(r+1, c, word, i+1) ||
                recurse(r, c+1, word, i+1)
            );

            // restore original arr value
            this.arr[r][c] = letter;
        }

        return isFound;
    }
}
