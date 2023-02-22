

//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 187 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1140.石子游戏 II.stone-game-ii
 *
 * @author db117
 * @since 2023-02-22 10:41:28
 **/

public class Solution_1140 {
    public static void main(String[] args) {
        Solution solution = new Solution_1140().new Solution();

        System.out.println(solution.stoneGameII(new int[]{2, 7, 9, 4, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][] cache;// 记忆化搜索
        private int[] sufSum;// 后缀和

        public int stoneGameII(int[] piles) {
            int n = piles.length;
            // m 的最大值 (n + 1) / 4 每次都拿最大值的情况下也不会超过
            cache = new int[n][(n + 1) / 4 + 1];
            sufSum = new int[n + 1];
            for (int i = n - 1; i >= 0; i--) {
                sufSum[i] = piles[i] + sufSum[i + 1];
            }

            // 从第 0 堆石子开始拿，最多能拿多少
            return dfs(0, 1);
        }

        private int dfs(int x, int m) {
            if (x + m * 2 >= sufSum.length - 1) {
                // 能够一次性全部拿完
                return sufSum[x];
            }
            if (cache[x][m] != 0) {
                return cache[x][m];
            }
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= m * 2; i++) {// 枚举所有可能选择的数量
                // 选择下一次获得最少的选择
                min = Math.min(min, dfs(i + x, Math.max(i, m)));
            }
            // 下次拿最少，则是最优的
            cache[x][m] = sufSum[x] - min;
            return cache[x][m];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}