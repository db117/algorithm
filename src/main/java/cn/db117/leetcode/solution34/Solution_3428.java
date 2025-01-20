

//给你一个整数数组 nums 和一个正整数 k，返回所有长度最多为 k 的 子序列 中 最大值 与 最小值 之和的总和。 
//
// 非空子序列 是指从另一个数组中删除一些或不删除任何元素（且不改变剩余元素的顺序）得到的数组。 
//
// 由于答案可能非常大，请返回对 10⁹ + 7 取余数的结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3], k = 2 
// 
//
// 输出： 24 
//
// 解释： 
//
// 数组 nums 中所有长度最多为 2 的子序列如下： 
//
// 
// 
// 
// 子序列 
// 最小值 
// 最大值 
// 和 
// 
// 
// 
// 
// [1] 
// 1 
// 1 
// 2 
// 
// 
// [2] 
// 2 
// 2 
// 4 
// 
// 
// [3] 
// 3 
// 3 
// 6 
// 
// 
// [1, 2] 
// 1 
// 2 
// 3 
// 
// 
// [1, 3] 
// 1 
// 3 
// 4 
// 
// 
// [2, 3] 
// 2 
// 3 
// 5 
// 
// 
// 总和 
// 
// 
// 24 
// 
// 
// 
//
// 因此，输出为 24。 
//
// 示例 2： 
//
// 
// 输入： nums = [5,0,6], k = 1 
// 
//
// 输出： 22 
//
// 解释： 
//
// 对于长度恰好为 1 的子序列，最小值和最大值均为元素本身。因此，总和为 5 + 5 + 0 + 0 + 6 + 6 = 22。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,1,1], k = 2 
// 
//
// 输出： 12 
//
// 解释： 
//
// 子序列 [1, 1] 和 [1] 各出现 3 次。对于所有这些子序列，最小值和最大值均为 1。因此，总和为 12。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 1 <= k <= min(100, nums.length) 
// 
//
// Related Topics 数组 数学 动态规划 组合数学 排序 👍 2 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;

/**
 * 3428.最多 K 个元素的子序列的最值之和.maximum-and-minimum-sums-of-at-most-size-k-subsequences
 *
 * @author db117
 * @since 2025-01-20 16:34:33
 **/

public class Solution_3428 {
    public static void main(String[] args) {
        Solution solution = new Solution_3428().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1_000_000_007;

        public int minMaxSums(int[] nums, int k) {
            int n = nums.length;
            Arrays.sort(nums);
            long res = 0;
            for (int i = 0; i < n; i++) {
                // 当前数字为最小值，计算后面有多少个数字可以选
                res += nums[i] * helper(n - i - 1, k);
                res %= MOD;
                // 当前数字为最大值，计算前面有多少个数字可以选
                res += nums[i] * helper(i, k);
                res %= MOD;
            }

            return (int) (res % MOD);
        }

        private long helper(int m, int k) {
            if (m == 0) {
                return 1;
            }
            long ans = 0;
            // 枚举 C（m，1）-> C（m，k）
            for (int i = 0; i < k && i <= m; i++) {
                ans += comb(m, i);
                ans %= MOD;
            }
            return ans;
        }


        private static final int MX = 200002;

        // 组合数模板
        private static final long[] FAC = new long[MX];
        private static final long[] INV_FAC = new long[MX];

        static {
            FAC[0] = 1;
            for (int i = 1; i < MX; i++) {
                FAC[i] = FAC[i - 1] * i % MOD;
            }
            INV_FAC[MX - 1] = pow(FAC[MX - 1], MOD - 2);
            for (int i = MX - 1; i > 0; i--) {
                INV_FAC[i - 1] = INV_FAC[i] * i % MOD;
            }
        }

        private static long comb(int n, int k) {
            return FAC[n] * INV_FAC[k] % MOD * INV_FAC[n - k] % MOD;
        }

        private static long pow(long x, int n) {
            long res = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 > 0) {
                    res = res * x % MOD;
                }
                x = x * x % MOD;
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}