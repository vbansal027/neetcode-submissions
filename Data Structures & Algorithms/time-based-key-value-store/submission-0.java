class TimeMap {

    Map<String, List<Object[]>> map;

    private int getLocAt(String key, int target) {
        List<Object[]> list = this.map.get(key);

        int left = 0;
        int right = list.size(); // initialising it as n and not n-1 becasue we return left-1

        while (left < right) {
            int mid = left + (right - left)/2;
            if ((int) list.get(mid)[0] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return (left < list.size() && (int) list.get(left)[0] == target) ? left : (left-1);
    }

    public TimeMap() {
        this.map = new HashMap();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, v -> new ArrayList<Object[]>()).add(new Object[]{timestamp, value});
    }
    
    public String get(String key, int timestamp) {
        int loc = (map.get(key) != null) ? getLocAt(key, timestamp) : -1;
        return (loc == -1) ? "" : String.valueOf(map.get(key).get(loc)[1]);
    }
}
