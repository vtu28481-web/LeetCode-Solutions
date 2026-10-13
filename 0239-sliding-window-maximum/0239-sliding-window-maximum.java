import java.util.*;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> d = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int j = 0;

        for (int i = 0; i < n; i++) {

            while (!d.isEmpty() && d.peekFirst() <= i - k) {
                d.pollFirst();
            }

            while (!d.isEmpty() && nums[i] >= nums[d.peekLast()]) {
                d.pollLast();
            }

            d.offerLast(i);

            if (i >= k - 1) {
                ans[j++] = nums[d.peekFirst()];
            }
        }

        return ans;
    }
}