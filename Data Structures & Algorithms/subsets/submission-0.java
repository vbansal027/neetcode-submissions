class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> collection = new ArrayList<>();
        fillSubsets(collection, new ArrayList<>(), nums, 0);
        return collection;
    }

    private void fillSubsets(List<List<Integer>> collection, List<Integer> set, int[] nums, int i) {
        
        if (i == nums.length) { // you have exhausted all choices, one set is complete
            collection.add(new ArrayList(set));
            return;
        }

        /**
            we make two choices here
                1) get all subsets that have nums[i]
                2) get all subsests without nums[i]
        **/
        
        // not selecting nums[i]
        fillSubsets(collection, set, nums, i+1);

        // selecting nums[i]
        set.add(nums[i]);
        fillSubsets(collection, set, nums, i+1);
        set.remove(set.size() - 1); 
    }
}
