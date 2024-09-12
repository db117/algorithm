

//给你一个 50 x 50 的国际象棋棋盘，棋盘上有 一个 马和一些兵。给你两个整数 kx 和 ky ，其中 (kx, ky) 表示马所在的位置，同时还有一个
//二维数组 positions ，其中 positions[i] = [xi, yi] 表示第 i 个兵在棋盘上的位置。 
//
// Alice 和 Bob 玩一个回合制游戏，Alice 先手。玩家的一次操作中，可以执行以下操作： 
//
// 
// 玩家选择一个仍然在棋盘上的兵，然后移动马，通过 最少 的 步数 吃掉这个兵。注意 ，玩家可以选择 任意 一个兵，不一定 要选择从马的位置出发 最少 移动步
//数的兵。 
// 在马吃兵的过程中，马 可能 会经过一些其他兵的位置，但这些兵 不会 被吃掉。只有 选中的兵在这个回合中被吃掉。 
// 
//
// Alice 的目标是 最大化 两名玩家的 总 移动次数，直到棋盘上不再存在兵，而 Bob 的目标是 最小化 总移动次数。 
//
// 假设两名玩家都采用 最优 策略，请你返回可以达到的 最大 总移动次数。 
//
// 在一次 移动 中，如下图所示，马有 8 个可以移动到的位置，每个移动位置都是沿着坐标轴的一个方向前进 2 格，然后沿着垂直的方向前进 1 格。 
//
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：kx = 1, ky = 1, positions = [[0,0]] 
// 
//
// 输出：4 
//
// 解释： 
//
// 
//
// 马需要移动 4 步吃掉 (0, 0) 处的兵。 
//
// 示例 2： 
//
// 
// 输入：kx = 0, ky = 2, positions = [[1,1],[2,2],[3,3]] 
// 
//
// 输出：8 
//
// 解释： 
//
// 
//
// 
// Alice 选择 (2, 2) 处的兵，移动马吃掉它需要 2 步：(0, 2) -> (1, 4) -> (2, 2) 。 
// Bob 选择 (3, 3) 处的兵，移动马吃掉它需要 2 步：(2, 2) -> (4, 1) -> (3, 3) 。 
// Alice 选择 (1, 1) 处的兵，移动马吃掉它需要 4 步：(3, 3) -> (4, 1) -> (2, 2) -> (0, 3) -> (1, 
//1) 。 
// 
//
// 示例 3： 
//
// 
// 输入：kx = 0, ky = 0, positions = [[1,2],[2,4]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// Alice 选择 (2, 4) 处的兵，移动马吃掉它需要 2 步：(0, 0) -> (1, 2) -> (2, 4) 。注意，(1, 2) 处的兵不会被
//吃掉。 
// Bob 选择 (1, 2) 处的兵，移动马吃掉它需要 1 步：(2, 4) -> (1, 2) 。 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= kx, ky <= 49 
// 1 <= positions.length <= 15 
// positions[i].length == 2 
// 0 <= positions[i][0], positions[i][1] <= 49 
// positions[i] 两两互不相同。 
// 输入保证对于所有 0 <= i < positions.length ，都有 positions[i] != [kx, ky] 。 
// 
//
// Related Topics 位运算 广度优先搜索 数组 数学 状态压缩 博弈 👍 10 👎 0


package cn.db117.leetcode.solution32;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 3283.吃掉所有兵需要的最多移动次数.maximum-number-of-moves-to-kill-all-pawns
 *
 * @author db117
 * @since 2024-09-12 11:28:28
 **/

public class Solution_3283 {
    public static void main(String[] args) {
        Solution solution = new Solution_3283().new Solution();
        // 1
        //			1
        //			[[0,0]]
//        System.out.println(solution.maxMoves(1, 1, new int[][]{{0, 0}}));

        // 0
        //			2
        //			[[1,1],[2,2],[3,3]]
        System.out.println(solution.maxMoves(0, 2, new int[][]{{1, 1}, {2, 2}, {3, 3}}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][][] minSteps;
        // 定义马的移动方向
        private static final int[][] DIRECTIONS = {
                {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
                {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
        };

        int[][] positions;
        int kx, ky;
        int n;
        int[][] memo;

        public int maxMoves(int kx, int ky, int[][] positions) {
            n = positions.length;
            this.positions = positions;
            this.kx = kx;
            this.ky = ky;
            memo = new int[n + 1][(1 << n) + 1];
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            // 初始化每个兵到不同位置的最小步数
            initMinStep();

            return dfsAlice(n, (1 << n) - 1);
        }

        int dfsAlice(int i, int mask) {
            if (mask == 0) {
                return 0;
            }
            int x, y;
            if (i == n) {
                x = kx;
                y = ky;
            } else {
                x = positions[i][0];
                y = positions[i][1];
            }
            if (memo[i][mask] != -1) {
                return memo[i][mask];
            }

            int ans = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    // 从当前位置到所有位置的最大步数
                    ans = Math.max(ans, dfsBob(j, mask ^ (1 << j)) + minSteps[j][x][y]);
                }
            }
            return memo[i][mask] = ans;
        }

        int dfsBob(int i, int mask) {
            if (mask == 0) {
                return 0;
            }

            int x = positions[i][0];
            int y = positions[i][1];

            if (memo[i][mask] != -1) {
                return memo[i][mask];
            }

            int ans = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) != 0) {
                    // 从当前位置到所有位置的最小步数
                    ans = Math.min(ans, dfsAlice(j, mask ^ (1 << j)) + minSteps[j][x][y]);
                }
            }
            return memo[i][mask] = ans;
        }

        private void initMinStep() {

            minSteps = new int[n][50][50];// 每个兵到不同的位置的最小步数
            Queue<int[]> queue = new ArrayDeque<>(n);

            // 初始化每个兵到不同位置的最小步数
            for (int i = 0; i < n; i++) {
                int[][] minStep = minSteps[i];
                for (int j = 0; j < 50; j++) {
                    Arrays.fill(minStep[j], -1);
                }
                queue.offer(positions[i]);
                int step = 0;
                minStep[positions[i][0]][positions[i][1]] = step;

                while (!queue.isEmpty()) {
                    step++;
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        int[] poll = queue.poll();
                        int x = poll[0], y = poll[1];
                        for (int[] direction : DIRECTIONS) {
                            int nx = x + direction[0];
                            int ny = y + direction[1];
                            if (nx < 0 || nx >= 50 || ny < 0 || ny >= 50) {
                                continue;
                            }
                            if (minStep[nx][ny] < 0) {
                                minStep[nx][ny] = step;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}