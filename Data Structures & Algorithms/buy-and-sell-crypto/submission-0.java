class Solution {
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int ans = 0;
        int i=0;
        int j=1;

        while (j<n) {

            while (j<n && prices[j] >= prices[j-1]) {
                j++;
            }

            ans = Math.max(ans, prices[j-1]-prices[i]);

            while (j<n && prices[i]>prices[j]) {
                i++;
            }
            j++;
        }

        return ans;

    }
}
