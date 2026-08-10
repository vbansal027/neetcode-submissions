class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (int w : stones) {
            pq.add(w);
        }

        while (pq.size() > 1) {
            int w1 = pq.remove();
            int w2 = pq.remove();

            if (w1 != w2) {
                pq.add(Math.abs(w1-w2));
            }
        }

        return pq.isEmpty() ? 0 : pq.remove();
    }
}
