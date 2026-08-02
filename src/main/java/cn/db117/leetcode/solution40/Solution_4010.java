package cn.db117.leetcode.solution40;

/**
 *4010. 数对的最大强度
 *@since 2026/8/2
 *@author zhangdabing
 */
public class Solution_4010 {

    class Solution {
        public long maxPairStrength(int[] nums) {
            int n = nums.length;
            long max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {

                    long gcd = gcd(nums[i], nums[j]);
                    long cur = ((long) nums[i] * nums[j]) / (gcd * gcd);
                    max = Math.max(max, cur);
                }
            }

            return max;
        }


        public static long gcd(long a, long b) {
            if (b == 0) {
                return a;
            }

            return gcd(b, a % b);
        }
    }
}
