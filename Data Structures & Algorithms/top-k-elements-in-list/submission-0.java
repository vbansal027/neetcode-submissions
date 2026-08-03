class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            fmap.put(num, fmap.getOrDefault(num, 0)+1);
        }

        // now we have fmap.entrySet() as a set of almost pairs
        // instead of creating pair from it we can use the
        // entry set to prepare the prirority q

        PriorityQueue<Map.Entry<Integer, Integer>> pq = 
            new PriorityQueue<>(Map.Entry.comparingByValue());
        
        for (Map.Entry entry : fmap.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream().mapToInt(e -> e.getKey()).toArray();
    }
}
