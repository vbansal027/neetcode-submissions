class Solution {

    private List<List<Integer>> res;
    private int[][] elements;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.res = new ArrayList();

        Map<Integer, Integer> fmap = new HashMap();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0) + 1);
        }

        this.elements = fmap.entrySet().stream()
                            .map((entry) -> new int[]{entry.getKey(), entry.getValue()})
                            .toArray(int[][]::new);

        recurse(0);
        return this.res;
    }

    private void recurse(int i) {
        if (i == this.elements.length) {    // this is beyond the last element of the array, add empty set
            this.res.add(new ArrayList());
            // System.out.println("In base case: " + this.res)
            return;
        }

        // fill all sets without current element
        recurse(i+1);

        // now we append element 'i' strategically
        List<List<Integer>> prevSets = this.res.stream().map(innerList -> new ArrayList<Integer>(innerList)).collect(Collectors.toList());
        for (int k=0; k<this.elements[i][1]; k++) {
            // for each set added last, append nums[i] and add to result set
            for (List<Integer> set : prevSets) {
                set.add(elements[i][0]);
            }
            // add this set to result
            this.res.addAll(prevSets);
            // now update the reference of prevSets to a new copy
            prevSets = prevSets.stream().map(innerList -> new ArrayList<Integer>(innerList)).collect(Collectors.toList());
        }

        return;
    }
}
