

//在由 2D 网格表示的校园里有 n 位工人（worker）和 m 辆自行车（bike），n <= m。所有工人和自行车的位置都用网格上的 2D 坐标表示。 
//
//
// 我们为每一位工人分配一辆专属自行车，使每个工人与其分配到的自行车之间的 曼哈顿距离 最小化。 
//
// 返回 每个工人与分配到的自行车之间的曼哈顿距离的最小可能总和 。 
//
// p1 和 p2 之间的 曼哈顿距离 为 Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//输出：6
//解释：
//自行车 0 分配给工人 0，自行车 1 分配给工人 1 。分配得到的曼哈顿距离都是 3, 所以输出为 6 。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//输出：4
//解释：
//先将自行车 0 分配给工人 0，再将自行车 1 分配给工人 1（或工人 2），自行车 2 给工人 2（或工人 1）。如此分配使得曼哈顿距离的总和为 4。
// 
//
// 示例 3: 
//
// 
//输入：workers = [[0,0],[1,0],[2,0],[3,0],[4,0]], bikes = [[0,999],[1,999],[2,999]
//,[3,999],[4,999]]
//输出：4995
// 
//
// 
//
// 提示： 
//
// 
// n == workers.length 
// m == bikes.length 
// 1 <= n <= m <= 10 
// workers[i].length == 2 
// bikes[i].length == 2 
// 0 <= workers[i][0], workers[i][1], bikes[i][0], bikes[i][1] < 1000 
// 所有的工人和自行车的位置都是 不同 的。 
// 
//
// Related Topics 位运算 数组 动态规划 回溯 状态压缩 👍 96 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1066.校园自行车分配 II.campus-bikes-ii
 *
 * @author db117
 * @since 2023-10-30 11:29:42
 **/

public class Solution_1066 {
    public static void main(String[] args) {
        Solution solution = new Solution_1066().new Solution();
        // [[0,0],[2,1]]
        //			[[1,2],[3,3]]
        System.out.println(solution.assignBikes(new int[][]{
                {0, 0}, {2, 1}
        }, new int[][]{
                {1, 2}, {3, 3}
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int n, m;
        int[][] memo;
        int[][] workers, bikes;

        public int assignBikes(int[][] workers, int[][] bikes) {
            // 动态规划 状态压缩
            n = workers.length;
            m = bikes.length;
            this.workers = workers;
            this.bikes = bikes;
            memo = new int[1 << n][1 << m];

            return dfs((1 << n) - 1, (1 << m) - 1);
        }

        private int dfs(int workerFlag, int bikeFlag) {
            if (workerFlag == 0) {
                // 所有工人都分配了
                return 0;
            }
            if (memo[workerFlag][bikeFlag] != 0) {
                return memo[workerFlag][bikeFlag];
            }

            int ans = Integer.MAX_VALUE / 2;
            for (int i = 0; i < n; i++) {
                // 工人已经分配了
                if ((workerFlag & (1 << i)) == 0) {
                    continue;
                }
                for (int j = 0; j < m; j++) {
                    // 自行车已经分配了
                    if ((bikeFlag & (1 << j)) == 0) {
                        continue;
                    }
                    // 分配 移除标记
                    ans = Math.min(ans, dfs(workerFlag ^ (1 << i), bikeFlag ^ (1 << j)) + getDistance(workers[i], bikes[j]));
                }
            }
            memo[workerFlag][bikeFlag] = ans;
            return ans;
        }

        private int getDistance(int[] worker, int[] bike) {
            // 曼哈顿距离
            return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}