class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        
        int m = matrix.length;
        int n = matrix[m-1].length;

        int l = 0;
        int r = (m*n)-1;

        while (l < r) {
            int mid = l + (r-l)/2;
            if (matrix[mid/n][mid%n] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        // at this point "l" points to min element that is greater than or equal to target
        
        return matrix[l/n][l%n] == target;
    }
}
