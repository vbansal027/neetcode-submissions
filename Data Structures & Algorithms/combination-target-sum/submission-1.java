class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList();
        computeCombinations(res, new ArrayList(), nums, 0, target);
        return res;
    }

    private void computeCombinations(List<List<Integer>> res, List<Integer> comb, int[] nums, int i, int t) {
        
        if (t == 0) {
            // target sum has been reached, add this combination to res
            res.add(new ArrayList(comb));
            return;
        } else if (t < 0 || i == nums.length){
            // if sum has exceeded target or if we have run out of options, exit recursion becasue all int are positive
            return;
        }

        
        // compute combinations without nums[i]
        computeCombinations(res, comb, nums, i+1, t);

        // compute combinations with atleast 1 nums[i]
        comb.add(nums[i]);
        computeCombinations(res, comb, nums, i, t-nums[i]);
        comb.remove(comb.size()-1);
    }
}
