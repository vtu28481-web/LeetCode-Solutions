class Solution {
public:
    vector<int> getSumAbsoluteDifferences(vector<int>& nums) {
        int n = nums.size();
        vector<int> result(n);

        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            int left = nums[i] * i - leftSum;
            int right = rightSum - nums[i] * (n - i - 1);

            result[i] = left + right;

            leftSum += nums[i];
        }

        return result;
    }
};