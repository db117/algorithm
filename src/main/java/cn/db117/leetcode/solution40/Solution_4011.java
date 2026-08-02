package cn.db117.leetcode.solution40;

/**
 *4011. 按奇偶比统计子数组 I
 *@since 2026/8/2
 *@author zhangdabing
 */
public class Solution_4011 {

    class Solution {
        public int countRatioSubarrays(int[] nums, int a, int b) {
            int n = nums.length;
            int[] pre = new int[n + 1];
            for (int i = 0; i < n; i++) {
                pre[i + 1] = pre[i];
                if (nums[i] % 2 == 1) {
                    pre[i + 1]++;
                }
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    int all = j - i + 1;
                    int odd = pre[j + 1] - pre[i];
                    int even = all - odd;
                    // x / y <= a / b
                    if (odd > 0 && even * b <= odd * a) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
