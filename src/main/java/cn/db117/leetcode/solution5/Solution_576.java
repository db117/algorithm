

//给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以
//穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。 
//
// 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 
//10⁹ + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
// 
// 
//输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//输出：6
// 
//
// 示例 2： 
// 
// 
//输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 50 
// 0 <= maxMove <= 50 
// 0 <= startRow < m 
// 0 <= startColumn < n 
// 
//
// Related Topics 动态规划 👍 269 👎 0


package cn.db117.leetcode.solution5;

/**
 * 576.出界的路径数.out-of-boundary-paths
 *
 * @author db117
 * @since 2022-12-27 11:19:06
 **/

public class Solution_576 {
    public static void main(String[] args) {
        Solution solution = new Solution_576().new Solution();
        // m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
//        System.out.println(solution.findPaths(2, 2, 2, 0, 0));

        // 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
        //输出：12
        System.out.println(solution.findPaths(1, 3, 3, 0, 1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] f;
        int mod = (int) (1e9 + 7);

        public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
            // 状态定义
            // 在某个位置剩余可移动步数 有多少种路径出轨
            f = new int[m * n][maxMove + 1];

            // 定义初始数据
            // 在边缘的可以确定出轨的数量,角上有 2 个,边上有 1 个
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        add(i, j, n, maxMove);
                    }
                    if (j == 0) {
                        add(i, j, n, maxMove);
                    }
                    if (i == m - 1) {
                        add(i, j, n, maxMove);
                    }
                    if (j == n - 1) {
                        add(i, j, n, maxMove);
                    }
                }
            }

            // 需要先把剩余步数小的算出来 从剩余步数开始遍历
            for (int v = 1; v <= maxMove; v++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        int index = getIndex(i, j, n);
                        for (int[] dir : dirs) {
                            int ni = i + dir[0];
                            int nj = j + dir[1];
                            if (ni < 0 || nj < 0 || ni >= m || nj >= n) {
                                continue;
                            }
                            // 从 4 个方向获取数据
                            int preIndex = getIndex(ni, nj, n);
                            f[index][v] += f[preIndex][v - 1];
                            f[index][v] %= mod;
                        }
                    }
                }
            }

            return f[getIndex(startRow, startColumn, n)][maxMove];
        }

        void add(int i, int j, int n, int maxMove) {
            int index = getIndex(i, j, n);
            // 剩余步数大于 1 即可出轨
            for (int k = 1; k <= maxMove; k++) {
                f[index][k]++;
            }
        }

        /**
         * 获取索引
         * 将 (x, y) 转换为 index
         *
         * @param n 每行的数量
         */
        int getIndex(int x, int y, int n) {
            return x * n + y;
        }

        /**
         * 解析索引
         * 将 index 解析回 (x, y)
         *
         * @param idx 索引
         * @param n   每行的数量
         * @return {@link int[]}
         */
        int[] parseIdx(int idx, int n) {
            return new int[]{idx / n, idx % n};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}