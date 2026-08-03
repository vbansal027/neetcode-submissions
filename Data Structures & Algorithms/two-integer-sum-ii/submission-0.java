class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int i, j;
        int n = numbers.length;
        for (i=0, j=n-1; i<j; ) {
            int x = numbers[i];
            int y = numbers[j];

            if (x + y < target) {
                i++;
            } else if (x + y > target) {
                j--;
            } else {
                return new int[]{i+1, j+1};
            }
        }

        return new int[2];
    }
}
