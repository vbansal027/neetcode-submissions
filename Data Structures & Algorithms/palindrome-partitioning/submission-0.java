class Solution {

    List<List<String>> res;
    boolean[][] dp;

    public List<List<String>> partition(String s) {

        preCompute(s);

        this.res = new ArrayList();

        recurse(s, 0, new ArrayList());
        
        return this.res;
    }

    private void recurse(String s, int i, List<String> split) {
        if (i == s.length()) {
            this.res.add(new ArrayList(split));
            return;
        }

        for (int l = 1; l < dp[i].length; l++) {
            if (dp[i][l]) {
                split.add(s.substring(i, i+l));
                recurse(s, i+l, split);
                split.remove(split.size()-1);
            }
        }
        return;
    }

    private void preCompute(String s) {
        int n = s.length();

        dp = new boolean[n][];

        for (int i=n-1; i>=0; i--) {
            dp[i] = new boolean[n-i+1];
            dp[i][0] = dp[i][1] = true;
            for (int l=2; l<=(n-i); l++) {
                dp[i][l] = (s.charAt(i) == s.charAt(i+l-1)) && (dp[i+1][l-2]);
            }
        }

        return;
    }
}
