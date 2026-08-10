class KthLargest {

    private int k;
    private PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // create min_heap and return the top element
        pq = new PriorityQueue<>(this.k);

        for (int val : nums) {
            this.add(val);
        }
    }
    
    public int add(int val) {

        /// in min_heap when a new element add takes the total 
        /// above k , then the 1st element is the k+1 largest element
        /// it is safe to remove that
        if (pq.offer(val) && pq.size() > this.k) {
            pq.poll();
        }

        return pq.peek();
    }
}
