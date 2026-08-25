class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {

            // Current index is unreachable
            if (i > maxReach) {
                return false;
            }

            // Update the farthest position we can reach
            maxReach = Math.max(maxReach, i + nums[i]);

            // Last index is reachable
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}