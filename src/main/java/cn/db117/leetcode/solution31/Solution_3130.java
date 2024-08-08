

//给你 3 个正整数 zero ，one 和 limit 。 
//
// 一个 二进制数组 arr 如果满足以下条件，那么我们称它是 稳定的 ： 
//
// 
// 0 在 arr 中出现次数 恰好 为 zero 。 
// 1 在 arr 中出现次数 恰好 为 one 。 
// arr 中每个长度超过 limit 的 子数组 都 同时 包含 0 和 1 。 
// 
//
// 请你返回 稳定 二进制数组的 总 数目。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
// 输入：zero = 1, one = 1, limit = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 两个稳定的二进制数组为 [1,0] 和 [0,1] ，两个数组都有一个 0 和一个 1 ，且没有子数组长度大于 2 。 
//
// 示例 2： 
//
// 
// 输入：zero = 1, one = 2, limit = 1 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一稳定的二进制数组是 [1,0,1] 。 
//
// 二进制数组 [1,1,0] 和 [0,1,1] 都有长度为 2 且元素全都相同的子数组，所以它们不稳定。 
//
// 示例 3： 
//
// 
// 输入：zero = 3, one = 3, limit = 2 
// 
//
// 输出：14 
//
// 解释： 
//
// 所有稳定的二进制数组包括 [0,0,1,0,1,1] ，[0,0,1,1,0,1] ，[0,1,0,0,1,1] ，[0,1,0,1,0,1] ，[0,1
//,0,1,1,0] ，[0,1,1,0,0,1] ，[0,1,1,0,1,0] ，[1,0,0,1,0,1] ，[1,0,0,1,1,0] ，[1,0,1,0,
//0,1] ，[1,0,1,0,1,0] ，[1,0,1,1,0,0] ，[1,1,0,0,1,0] 和 [1,1,0,1,0,0] 。 
//
// 
//
// 提示： 
//
// 
// 1 <= zero, one, limit <= 1000 
// 
//
// Related Topics 动态规划 前缀和 👍 28 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3130.找出所有稳定的二进制数组 II.find-all-possible-stable-binary-arrays-ii
 *
 * @author db117
 * @since 2024-08-07 19:37:56
 **/

public class Solution_3130 {
    public static void main(String[] args) {
        Solution solution = new Solution_3130().new Solution();
        // 1
        //			2
        //			1
        System.out.println(new Solution_3130().new Solution().numberOfStableArrays(1, 2, 1));

        // 71
        //			12
        //			26
        System.out.println(new Solution_3130().new Solution().numberOfStableArrays(71, 12, 26));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int MOD = 1_000_000_007;
        int[][][] memo;
        int limit;

        public int numberOfStableArrays(int zero, int one, int limit) {
            // 不能出现连续 limit 个 1 或 0
            this.limit = limit;
            memo = new int[zero + 1][one + 1][2];
            for (int i = 0; i < zero + 1; i++) {
                for (int j = 0; j < one + 1; j++) {
                    for (int k = 0; k < 2; k++) {
                        memo[i][j][k] = -1;
                    }
                }
            }
            return (dfs(zero, one, 0) % MOD + dfs(zero, one, 1) % MOD) % MOD;
        }

        private int dfs(int zero, int one, int cur) {
            if (zero < 0 || one < 0) {
                return 0;
            }
            if (zero == 0) {
                // 当前选的是 1 ，而且剩下的 1 不超过 limit
                return cur == 1 && one <= limit ? 1 : 0;
            }
            if (one == 0) {
                // 当前选的是 0 ，而且剩下的 0 不超过 limit
                return cur == 0 && zero <= limit ? 1 : 0;
            }
            if (memo[zero][one][cur] != -1) {
                return memo[zero][one][cur];
            }
            long ans = 0;
            if (cur == 0) {
                ans = dfs(zero - 1, one, 1);
                ans += dfs(zero - 1, one, 0);
                // 去掉不合法的，去掉 1 后面连续 limit 个 0
                ans -= dfs(zero - limit - 1, one, 1);
            } else {
                ans = dfs(zero, one - 1, 1);
                ans += dfs(zero, one - 1, 0);
                // 去掉不合法的，去掉 0 后面连续 limit 个 1
                ans -= dfs(zero, one - limit - 1, 0);
            }
            return memo[zero][one][cur] = (int) ((ans+MOD) % MOD);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}