

//有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。 
//
// 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。 
//
// 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：stones = [3,2,4,1], K = 2
//输出：20
//解释：
//从 [3, 2, 4, 1] 开始。
//合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
//合并 [4, 1]，成本为 5，剩下 [5, 5]。
//合并 [5, 5]，成本为 10，剩下 [10]。
//总成本 20，这是可能的最小值。
// 
//
// 示例 2： 
//
// 输入：stones = [3,2,4,1], K = 3
//输出：-1
//解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
// 
//
// 示例 3： 
//
// 输入：stones = [3,5,1,2,6], K = 3
//输出：25
//解释：
//从 [3, 5, 1, 2, 6] 开始。
//合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
//合并 [3, 8, 6]，成本为 17，剩下 [17]。
//总成本 25，这是可能的最小值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stones.length <= 30 
// 2 <= K <= 30 
// 1 <= stones[i] <= 100 
// 
//
// Related Topics 数组 动态规划 👍 299 👎 0


package cn.db117.leetcode.solution10;

import java.util.Arrays;

/**
 * 1000.合并石头的最低成本.minimum-cost-to-merge-stones
 *
 * @author db117
 * @since 2023-04-04 17:22:53
 **/

public class Solution_1000 {
    public static void main(String[] args) {
        Solution solution = new Solution_1000().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][][] cache;
        int[] ps;
        int k;

        public int mergeStones(int[] stones, int k) {
            int n = stones.length;
            if ((n - 1) % (k - 1) != 0) {
                // 不可能搞成
                return -1;
            }
            // 把 i-j 合并成 k 堆的成本
            cache = new int[n + 1][n + 1][k + 1];
            this.k = k;
            // 前缀和
            ps = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ps[i + 1] = ps[i] + stones[i];
            }
            for (int[][] ints : cache) {
                for (int[] anInt : ints) {
                    Arrays.fill(anInt, -1);
                }
            }


            return dfs(0, n - 1, 1);
        }

        public int dfs(int i, int j, int p) {
            if (cache[i][j][p] != -1) {
                return cache[i][j][p];
            }
            if (i == j) {
                return 0;
            }
            if (p == 1) {
                // 合成一个 = 把所有的都合成 k 堆，然后加上当前区间的和（当前区间的成本）
                cache[i][j][p] = dfs(i, j, k) + ps[j + 1] - ps[i];
                return cache[i][j][p];
            }
            int res = Integer.MAX_VALUE;

            for (int l = i; l < j; l += k - 1) {
                // 把左边的分在一堆，剩下都分成 p - 1 堆（子问题）
                res = Math.min(res, dfs(i, l, 1) + dfs(l + 1, j, p - 1));
            }

            cache[i][j][p] = res;
            return cache[i][j][p];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}