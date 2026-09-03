class Solution {
    public int removeDuplicates(int[] nums) {

        int k = 0;

        for (int num : nums) {

            // Allow the first two elements,
            // or allow num if it differs from nums[k - 2]
            if (k < 2 || num != nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }

        return k;
    }
}