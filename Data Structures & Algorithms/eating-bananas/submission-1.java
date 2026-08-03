class Solution {

    private boolean canEatWithinLimit(int[] piles, int speed, int limit) {
        int h = 0;
        for (int pile : piles) {
            h += (int) Math.ceil((double) pile/speed);
        }
        return h <= limit;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 1;
        for (int p : piles) {
            r = Math.max(p, r);
        };

        while (l < r) {
            int mid = l + (r-l)/2;

            if (canEatWithinLimit(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
