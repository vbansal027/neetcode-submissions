class Solution {

    private int getHours(int[] piles, int speed) {
        int h = 0;
        for (int pile : piles) {
            h += (int) Math.ceil((double) pile/speed);
        }
        return h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1;
        int r = 1;
        for (int p : piles) {
            r = Math.max(p, r);
        };

        while (l < r) {
            int mid = l + (r-l)/2;

            if (getHours(piles, mid) <= h) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
