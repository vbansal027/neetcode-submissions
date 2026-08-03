class Solution {
    public int maxArea(int[] heights) {
        
        int n = heights.length;
        int ans = 0;
        for (int i=0, j=n-1; i<j; ) {
            int curr = (j-i) * (Math.min(heights[i], heights[j]));
            ans = Math.max(ans, curr);
            
            if (heights[i] < heights[j]) {
                i++;
            } else {
                j--;
            }
        }

        return ans;
    }
}
