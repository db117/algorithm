


//设计一种算法，打印 N 皇后在 N × N 棋盘上的各种摆法，其中每个皇后都不同行、不同列，也不在对角线上。这里的“对角线”指的是所有的对角线，不只是平分整
//个棋盘的那两条对角线。 
//
// 注意：本题相对原题做了扩展 
//
// 示例: 
//
//  输入：4
// 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
// 解释: 4 皇后问题存在如下两个不同的解法。
//[
// [".Q..",  // 解法 1
//  "...Q",
//  "Q...",
//  "..Q."],
//
// ["..Q.",  // 解法 2
//  "Q...",
//  "...Q",
//  ".Q.."]
//]
// 
// Related Topics 数组 回溯 👍 128 👎 0


package cn.db117.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题 08.12.八皇后.eight-queens-lcci
 *
 * @author db117
 * @since 2022-03-22 15:31:23
 **/

public class Interview_0812 {
    public static void main(String[] args) {
        Solution solution = new Interview_0812().new Solution();
        System.out.println(solution.solveNQueens(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> solveNQueens(int n) {
            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = '.';
                }
            }

            // 标记列是否存在
            boolean[] col = new boolean[n];
            // 左斜是否包含 row-col
            boolean[] left = new boolean[2 * n];
            // 右斜是否包含 row+col
            boolean[] right = new boolean[2 * n];

            dfs(n, 0, col, left, right, grid);


            return ans;
        }

        private void dfs(int n, int row, boolean[] col, boolean[] left, boolean[] right, char[][] grid) {
            if (n == row) {
                List<String> cur = new ArrayList<>();
                for (char[] chars : grid) {
                    cur.add(new String(chars));
                }
                ans.add(cur);
                return;
            }
            // 在第 row 行放入一个皇后
            // 遍历每一列
            for (int i = 0; i < n; i++) {
                if (!col[i] && !left[n + row - i] && !right[row + i]) {
                    // 回溯
                    grid[row][i] = 'Q';
                    right[row + i] = left[n + row - i] = col[i] = true;

                    dfs(n, row + 1, col, left, right, grid);

                    right[row + i] = left[n + row - i] = col[i] = false;
                    grid[row][i] = '.';
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}