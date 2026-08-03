class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numsSoFar = new HashSet();
        for (int i=0; i<nums.length; i++) {
            if (numsSoFar.contains(nums[i])) {
                return true;
            } else {
                numsSoFar.add(nums[i]);
            }
        }
        return false;
    }
}