class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        for (int i=0; i<nums.length; i++) {
            int v = target - nums[i];

            if (
                (v != nums[i] && map.containsKey(v)) || 
                (v == nums[i] && map.get(v).size() > 1)
            ) {
                return new int[]{i, map.get(v).get(map.get(v).size()-1)};
            }
        }

        return new int[2];
    }
}
