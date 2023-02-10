

//有一个骰子模拟器会每次投掷的时候生成一个 1 到 6 的随机数。 
//
// 不过我们在使用它时有个约束，就是使得投掷骰子时，连续 掷出数字 i 的次数不能超过 rollMax[i]（i 从 1 开始编号）。 
//
// 现在，给你一个整数数组 rollMax 和一个整数 n，请你来计算掷 n 次骰子可得到的不同点数序列的数量。 
//
// 假如两个序列中至少存在一个元素不同，就认为这两个序列是不同的。由于答案可能很大，所以请返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 2, rollMax = [1,1,2,2,2,3]
//输出：34
//解释：我们掷 2 次骰子，如果没有约束的话，共有 6 * 6 = 36 种可能的组合。但是根据 rollMax 数组，数字 1 和 2 最多连续出现一次，所
//以不会出现序列 (1,1) 和 (2,2)。因此，最终答案是 36-2 = 34。
// 
//
// 示例 2： 
//
// 输入：n = 2, rollMax = [1,1,1,1,1,1]
//输出：30
// 
//
// 示例 3： 
//
// 输入：n = 3, rollMax = [1,1,1,2,2,3]
//输出：181
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5000 
// rollMax.length == 6 
// 1 <= rollMax[i] <= 15 
// 
//
// Related Topics 数组 动态规划 👍 136 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;

/**
 * 1223.掷骰子模拟.dice-roll-simulation
 *
 * @author db117
 * @since 2023-02-10 10:33:35
 **/

public class Solution_1223 {
    public static void main(String[] args) {
        Solution solution = new Solution_1223().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] rollMax;
        int n;
        int mod = (int) (1e9 + 7);
        int[][][] cache;

        public int dieSimulator(int n, int[] rollMax) {
            this.rollMax = rollMax;
            this.n = n;

            // 记忆化搜索
            cache = new int[n][6][15];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 6; j++) {
                    Arrays.fill(cache[i][j], -1);
                }
            }

            long ans = 0;
            for (int i = 0; i < 6; i++) {
                ans += dfs(n - 1, i, rollMax[i] - 1);
            }
            return (int) (ans % mod);
        }

        /**
         * dfs
         *
         * @param i         扔色子的次数
         * @param last      下一次扔的数字
         * @param remaining 前面还能扔几次
         * @return long
         */
        private long dfs(int i, int last, int remaining) {
            if (i == 0) {
                return 1;
            }
            if (cache[i][last][remaining] != -1) {
                return cache[i][last][remaining];
            }

            long ans = 0;
            for (int j = 0; j < 6; j++) { // 当前选择的数字
                if (last == j) {
                    if (remaining > 0) {
                        // 连续数字相等,且还有剩余连续次数可以用
                        ans += dfs(i - 1, j, remaining - 1);
                    }
                } else {
                    // 不相同直接继续
                    ans += dfs(i - 1, j, rollMax[j] - 1);
                }
            }

            cache[i][last][remaining] = (int) (ans % mod);
            return cache[i][last][remaining];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}