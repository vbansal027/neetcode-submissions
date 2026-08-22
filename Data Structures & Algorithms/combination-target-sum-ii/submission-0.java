class Solution {

    Map<Integer, Integer> nums;
    List<Integer> keyList;
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList();
        this.nums = new HashMap();

        for (int i : candidates) {
            this.nums.put(i, nums.getOrDefault(i, 0) + 1);
        }

        this.keyList = new ArrayList(this.nums.keySet());
        System.out.println(this.keyList);

        compute(new ArrayList(), 0, target);

        return this.res;
    }

    private void compute(List<Integer> set, int i, int t) {

        if (t == 0) {
            this.res.add(new ArrayList(set));
            return;
        }

        if (i == this.keyList.size()) {
            return;
        }

        for (int c=1; c<=nums.get(this.keyList.get(i)); c++) {
            if (t - (c*this.keyList.get(i)) >= 0) {
                for (int k=0; k<c; k++) {
                    set.add(this.keyList.get(i));
                }
                System.out.println(set);
                compute(set, i+1, t - (c*this.keyList.get(i)));
                for (int k=0; k<c; k++) {
                    set.remove(set.size()-1);
                }
            } else {
                break;
            }
        }

        compute(set, i+1, t);
    }
}
