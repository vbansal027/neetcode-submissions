class Solution {
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a, b) -> ((b.distance - a.distance) > 0 ? 1 : ((b.distance - a.distance) < 0 ? -1 : 0)));

        for (int i=0; i<points.length; i++) {
            // Point p = new Point(points[i][0], points[i][1]);
            // System.out.printf("Adding (%d,%d) with distance %f\n", p.x, p.y, p.distance);
            pq.add(new Point(points[i][0], points[i][1]));
            if (pq.size() > k) {
                // Point r = pq.remove();
                pq.remove();
                // System.out.printf("Removed (%d,%d) with distance %f\n", r.x, r.y, r.distance);
            }
        }

        // System.out.printf("pq size: %d\n", pq.size());
        int[][] ans = new int[k][2];
        while ((k--) > 0) {
            Point p = pq.remove();
            ans[k] = new int[]{p.x, p.y};
        }

        return ans;

    }

    private class Point {
        int x;
        int y;
        Double distance;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        }
    }
}
