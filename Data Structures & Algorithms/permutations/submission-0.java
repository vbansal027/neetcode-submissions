class Solution {

    private List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        this.res = new ArrayList();

        List<Integer> choices = Arrays.stream(nums)
                                      .boxed()
                                      .collect(Collectors.toCollection(ArrayList::new));
        getPermutations(choices, new ArrayList());
        return this.res;
    }

    private void getPermutations(List<Integer> choices, List<Integer> perm) {

        if (choices.isEmpty()) {
            this.res.add(new ArrayList(perm));
            return;
        }

        for (int i=0; i<choices.size(); i++) {
            perm.add(choices.get(i));
            List<Integer> remainingChoices = new ArrayList(choices);
            remainingChoices.remove(i);
            getPermutations(remainingChoices, perm);
            perm.remove(perm.size() - 1);
        }
    }
}
