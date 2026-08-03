class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int v = target-nums[i];
            if (seen.containsKey(v)) {
                return new int[]{seen.get(v), i};
            } else {
                seen.put(nums[i], i);
            }
        }

        return new int[2];
    }
}
