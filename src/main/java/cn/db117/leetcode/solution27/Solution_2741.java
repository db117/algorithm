

//给你一个下标从 0 开始的整数数组 nums ，它包含 n 个 互不相同 的正整数。如果 nums 的一个排列满足以下条件，我们称它是一个特别的排列： 
//
// 
// 对于 0 <= i < n - 1 的下标 i ，要么 nums[i] % nums[i+1] == 0 ，要么 nums[i+1] % nums[i] 
//== 0 。 
// 
//
// 请你返回特别排列的总数目，由于答案可能很大，请将它对 109 + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,3,6]
//输出：2
//解释：[3,6,2] 和 [2,6,3] 是 nums 两个特别的排列。
// 
//
// 示例 2： 
//
// 输入：nums = [1,4,3]
//输出：2
//解释：[3,1,4] 和 [4,1,3] 是 nums 两个特别的排列。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 14 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 位运算 数组 状态压缩 👍 30 👎 0


package cn.db117.leetcode.solution27;

import java.util.Arrays;

/**
 * 2741.特别的排列.special-permutations
 *
 * @author db117
 * @since 2023-07-04 16:24:49
 **/

public class Solution_2741 {
    public static void main(String[] args) {
        Solution solution = new Solution_2741().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialPerm(int[] nums) {
            // 状态压缩
            int n = nums.length;
            g = new int[n];
            f = new int[n][1 << (n + 1)];
            for (int[] ints : f) {
                Arrays.fill(ints, -1);
            }
            this.nums = nums;
            // 计算每个数可以放在哪些数字后面
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (j == i) {
                        continue;
                    }
                    if (nums[i] % nums[j] == 0 || nums[j] % nums[i] == 0) {
                        g[i] |= 1 << j;
                        g[j] |= 1 << i;
                    }
                }
            }
            int flag = (1 << (n)) - 1;// 全不选的状态
            long ans = 0;
            for (int i = 0; i < n; i++) {
                // 从每个数字开始,进行状态压缩记忆化搜索
                ans += dfs(flag ^ (1 << i), i);
            }
            return (int) (ans % mod);
        }

        private final int mod = (int) (1e9 + 7);

        private int[][] f;
        private int[] g;

        int[] nums;

        private int dfs(int flag, int pre) {
            if (f[pre][flag] != -1) {
                return f[pre][flag];
            }
            if (flag == 0) {
                // 全选完了
                return 1;
            }
            long ans = 0;

            int m = g[pre];
            for (int i = 0; i < nums.length; i++) {
                if ((m & (1 << i)) == 0) {
                    // 不能放在这个数字后面
                    continue;
                }
                if ((flag & (1 << i)) == 0) {
                    // 已经选过了
                    continue;
                }
                // 选择这个数字,并且从这个数字开始
                ans += dfs(flag ^ (1 << i), i);
            }

            return f[pre][flag] = (int) (ans % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}