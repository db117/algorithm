

//给你一个下标从 0 开始的二维数组 grid ，数组大小为 2 x n ，其中 grid[r][c] 表示矩阵中 (r, c) 位置上的点数。现在有两个机器
//人正在矩阵上参与一场游戏。 
//
// 两个机器人初始位置都是 (0, 0) ，目标位置是 (1, n-1) 。每个机器人只会 向右 ((r, c) 到 (r, c + 1)) 或 向下 ((
//r, c) 到 (r + 1, c)) 。 
//
// 游戏开始，第一个 机器人从 (0, 0) 移动到 (1, n-1) ，并收集路径上单元格的全部点数。对于路径上所有单元格 (r, c) ，途经后 
//grid[r][c] 会重置为 0 。然后，第二个 机器人从 (0, 0) 移动到 (1, n-1) ，同样收集路径上单元的全部点数。注意，它们的路径可能会存在相交的部
//分。 
//
// 第一个 机器人想要打击竞争对手，使 第二个 机器人收集到的点数 最小化 。与此相对，第二个 机器人想要 最大化 自己收集到的点数。两个机器人都发挥出自己的
// 最佳水平 的前提下，返回 第二个 机器人收集到的 点数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,5,4],[1,5,1]]
//输出：4
//解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
//第一个机器人访问过的单元格将会重置为 0 。
//第二个机器人将会收集到 0 + 0 + 4 + 0 = 4 个点。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,3,1],[8,5,2]]
//输出：4
//解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。 
//第一个机器人访问过的单元格将会重置为 0 。
//第二个机器人将会收集到 0 + 3 + 1 + 0 = 4 个点。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,3,1,15],[1,3,3,1]]
//输出：7
//解释：第一个机器人的最佳路径如红色所示，第二个机器人的最佳路径如蓝色所示。
//第一个机器人访问过的单元格将会重置为 0 。
//第二个机器人将会收集到 0 + 1 + 3 + 3 + 0 = 7 个点。
// 
//
// 
//
// 提示： 
//
// 
// grid.length == 2 
// n == grid[r].length 
// 1 <= n <= 5 * 10⁴ 
// 1 <= grid[r][c] <= 10⁵ 
// 
// 👍 7 👎 0


package cn.db117.leetcode.solution20;

/**
 * 2017.网格游戏.grid-game
 *
 * @author db117
 * @since 2021-09-28 17:37:14
 **/

public class Solution_2017 {
    public static void main(String[] args) {
        Solution solution = new Solution_2017().new Solution();
        System.out.println(solution.gridGame(new int[][]
                {{1, 3, 1, 15}, {1, 3, 3, 1}}
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long gridGame(int[][] grid) {
            int n = grid[0].length;
            // 上面一排前缀和
            long[] topSum = new long[n + 1];
            // 下面一排后缀和
            long[] downSum = new long[n + 1];

            for (int i = 0; i < n; i++) {
                topSum[i + 1] = topSum[i] + grid[0][i];
                downSum[i + 1] = downSum[i] + grid[1][i];
            }

            // 第一个机器人只能往下走一次，会把走过的路清空
            // 则第二个机器人只能选择 第一行拐点后 或 者第二行拐点钱的路
            long ans = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // 找到第二次最小的和
                long top = topSum[n] - topSum[i + 1];
                ans = Math.min(ans, Math.max(top, downSum[i]));
            }
            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}