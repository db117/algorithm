

//给你一个大小为 m x n 的矩阵 grid ，其中每个单元格都放置有一个字符： 
//
// 
// 'W' 表示一堵墙 
// 'E' 表示一个敌人 
// '0'（数字 0）表示一个空位 
// 
//
// 返回你使用 一颗炸弹 可以击杀的最大敌人数目。你只能把炸弹放在一个空位里。 
//
// 由于炸弹的威力不足以穿透墙体，炸弹只能击杀同一行和同一列没被墙体挡住的敌人。 
//
// 
//
// 示例 1： 
// 
// 
//输入：grid = [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
//输出：3
// 
//
// 示例 2： 
// 
// 
//输入：grid = [["W","W","W"],["0","0","0"],["E","E","E"]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// grid[i][j] 可以是 'W'、'E' 或 '0' 
// 
//
// Related Topics 数组 动态规划 矩阵 👍 116 👎 0


package cn.db117.leetcode.solution3;

/**
 * 361.轰炸敌人.bomb-enemy
 *
 * @author db117
 * @since 2025-04-21 19:53:31
 **/

public class Solution_361 {
    public static void main(String[] args) {
        Solution solution = new Solution_361().new Solution();
        // [["0","E","0","0"],["E","0","W","E"],["0","E","0","0"]]
        System.out.println(solution.maxKilledEnemies(new char[][]{
                {'0', 'E', '0', '0'},
                {'E', '0', 'W', 'E'},
                {'0', 'E', '0', '0'}
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxKilledEnemies(char[][] grid) {
            int ans = 0;
            int m= grid.length;
            int n = grid[0].length;
            int[][] boom = new int[m][n];


            // 从左往右走
            for (int i = 0; i < m; i++) {
                int count = 0;
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 'W') {
                        count = 0;
                    } else if (grid[i][j] == 'E') {
                        count++;
                    }
                    boom[i][j] += count;
                }
            }

            // 从右往左走
            for (int i = 0; i < m; i++) {
                int count = 0;
                for (int j = n - 1; j >= 0; j--) {
                    if (grid[i][j] == 'W') {
                        count = 0;
                    } else if (grid[i][j] == 'E') {
                        count++;
                    }
                    boom[i][j] += count;
                }
            }
            // 从上面往下面走
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    if (grid[j][i] == 'W') {
                        count = 0;
                    } else if (grid[j][i] == 'E') {
                        count++;
                    }
                    boom[j][i] += count;
                }
            }
            // 从下面往上走
            for (int i = 0; i < n; i++) {
                int count = 0;
                for (int j = m - 1; j >= 0; j--) {
                    if (grid[j][i] == 'W') {
                        count = 0;
                    } else if (grid[j][i] == 'E') {
                        count++;
                    }
                    boom[j][i] += count;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '0') {
                        ans = Math.max(ans, boom[i][j]);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}