class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;

        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        int pivot = left;
        // the two segments are this point are [0, pivot), [pivot, n)
        if (target <= nums[n-1]) {
            left = pivot;
            right = n-1;
        } else {
            left = 0;
            right = pivot-1;
        }

        while (left < right) {
            int mid = left + (right-left)/2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (left < 0 || left >= n) return -1;
        return (nums[left] == target) ? (left) : -1;
    }
}