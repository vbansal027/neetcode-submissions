public class Pair<F, S> {
    private final F first;
    private final S second;

    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    public F getFirst() { return first; }
    public S getSecond() { return second; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pair<?, ?> pair)) return false;
        return java.util.Objects.equals(first, pair.first) && 
               java.util.Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(first, second);
    }
}

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        int[] ans = new int[n];

        Stack<Pair<Integer, Integer>> stack = new Stack();

        for (int i=0; i<n; i++) {
            while (!stack.empty() && stack.peek().getFirst() < temperatures[i]) {
                Pair<Integer, Integer> top = stack.pop();
                ans[top.getSecond()] = i - top.getSecond();
            }
            stack.push(new Pair(temperatures[i], i));
        }

        return ans;
    }
}
