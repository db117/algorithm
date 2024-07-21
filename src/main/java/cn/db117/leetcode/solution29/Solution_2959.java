

//一个公司在全国有 n 个分部，它们之间有的有道路连接。一开始，所有分部通过这些道路两两之间互相可以到达。 
//
// 公司意识到在分部之间旅行花费了太多时间，所以它们决定关闭一些分部（也可能不关闭任何分部），同时保证剩下的分部之间两两互相可以到达且最远距离不超过 
//maxDistance 。 
//
// 两个分部之间的 距离 是通过道路长度之和的 最小值 。 
//
// 给你整数 n ，maxDistance 和下标从 0 开始的二维整数数组 roads ，其中 roads[i] = [ui, vi, wi] 表示一条从 
//ui 到 vi 长度为 wi的 无向 道路。 
//
// 请你返回关闭分部的可行方案数目，满足每个方案里剩余分部之间的最远距离不超过 maxDistance。 
//
// 注意，关闭一个分部后，与之相连的所有道路不可通行。 
//
// 注意，两个分部之间可能会有多条道路。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]
//输出：5
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [2] ，剩余分部为 [0,1] ，它们之间的距离为 2 。
//- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
//- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
//- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
//- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
//总共有 5 种可行的关闭方案。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]
//输出：7
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [] ，剩余分部为 [0,1,2] ，它们之间的最远距离为 4 。
//- 关闭分部集合 [0] ，剩余分部为 [1,2] ，它们之间的距离为 2 。
//- 关闭分部集合 [1] ，剩余分部为 [0,2] ，它们之间的距离为 2 。
//- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
//- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
//- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
//- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
//总共有 7 种可行的关闭方案。
// 
//
// 示例 3： 
//
// 
//输入：n = 1, maxDistance = 10, roads = []
//输出：2
//解释：可行的关闭分部方案有：
//- 关闭分部集合 [] ，剩余分部为 [0] 。
//- 关闭分部集合 [0] ，关闭后没有剩余分部。
//总共有 2 种可行的关闭方案。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10 
// 1 <= maxDistance <= 10⁵ 
// 0 <= roads.length <= 1000 
// roads[i].length == 3 
// 0 <= ui, vi <= n - 1 
// ui != vi 
// 1 <= wi <= 1000 
// 一开始所有分部之间通过道路互相可以到达。 
// 
//
// Related Topics 位运算 图 枚举 最短路 堆（优先队列） 👍 16 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2959.关闭分部的可行集合数目.number-of-possible-sets-of-closing-branches
 *
 * @author db117
 * @since 2024-07-17 10:41:17
 **/

public class Solution_2959 {
    public static void main(String[] args) {
        Solution solution = new Solution_2959().new Solution();
        // 3
        //			5
        //			[[0,1,2],[1,2,10],[0,2,10]]
        System.out.println(new Solution_2959().new Solution().numberOfSets(3, 5, new int[][]{
                {0, 1, 2},
                {1, 2, 10},
                {0, 2, 10}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n;
        int maxDistance;
        int mask;
        int[][] roads;

        public int numberOfSets(int n, int maxDistance, int[][] roads) {
            this.n = n;
            this.maxDistance = maxDistance;
            this.roads = roads;
            mask = (1 << n) - 1;
            // 二进制枚举所有的可能性
            int ans = 0;
            for (int i = 0; i < 1 << n; i++) {
                ans += helper(i);
            }
            return ans;
        }

        int helper(int cur) {
            // 建图
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    f[i][j] = Integer.MAX_VALUE / 2;
                }
                f[i][i] = 0;
            }
            for (int[] road : roads) {
                int x = road[0];
                int y = road[1];
                int w = road[2];
                if ((cur & (1 << x)) == 0 || (cur & (1 << y)) == 0) {
                    // 有关闭的
                    continue;
                }
                // 有重复的
                f[x][y] = Math.min(f[x][y], w);
                f[y][x] = Math.min(f[y][x], w);
            }

            // floyd
            for (int k = 0; k < n; k++) {
                if ((cur >> k & 1) == 0) {
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    if ((cur >> i & 1) == 0) {
                        continue;
                    }
                    for (int j = 0; j < n; j++) {
                        if ((cur >> j & 1) == 0) {
                            continue;
                        }
                        f[i][j] = Math.min(f[i][j], f[i][k] + f[k][j]);
                    }
                }
            }

            // 枚举所有点，判断是否满足条件
            for (int i = 0; i < n; i++) {
                if ((cur >> i & 1) == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if ((cur >> j & 1) == 0) {
                        continue;
                    }
                    if (f[i][j] > maxDistance) {
                        // 不满足条件
                        return 0;
                    }
                }
            }
            return 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}