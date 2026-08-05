package cn.db117.leetcode.solution40;

/**
 *4012. 统计每个班次结束后的未完成任务数
 *@since 2026/8/5
 *@author zhangdabing
 */
public class Solution_4012 {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int m = tasks.length;
        int n = shifts.length;

        long[] prefix = new long[m];
        long sum = 0;

        for (int i = 0; i < m; i++) {
            sum += tasks[i];
            prefix[i] = sum;
        }

        int[] ans = new int[n];
        long current = 0;

        for (int i = 0; i < n; i++) {
            current += shifts[i];

            // 查找第一个 prefix[index] > current
            int index = upperBound(prefix, current);

            ans[i] = m - index;


            if (index == m) {
                current = 0;
            }
        }

        return ans;
    }


    private int upperBound(long[] nums, long target) {
        int left = 0;
        int right = nums.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
