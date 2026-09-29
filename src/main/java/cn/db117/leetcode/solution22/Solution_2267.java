

//一个括号字符串是一个 非空 且只包含 '(' 和 ')' 的字符串。如果下面 任意 条件为 真 ，那么这个括号字符串就是 合法的 。 
//
// 
// 字符串是 () 。 
// 字符串可以表示为 AB（A 连接 B），A 和 B 都是合法括号序列。 
// 字符串可以表示为 (A) ，其中 A 是合法括号序列。 
// 
//
// 给你一个 m x n 的括号网格图矩阵 grid 。网格图中一个 合法括号路径 是满足以下所有条件的一条路径： 
//
// 
// 路径开始于左上角格子 (0, 0) 。 
// 路径结束于右下角格子 (m - 1, n - 1) 。 
// 路径每次只会向 下 或者向 右 移动。 
// 路径经过的格子组成的括号字符串是 合法 的。 
// 
//
// 如果网格图中存在一条 合法括号路径 ，请返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [["(","(","("],[")","(",")"],["(","(",")"],["(","(",")"]]
//输出：true
//解释：上图展示了两条路径，它们都是合法括号字符串路径。
//第一条路径得到的合法字符串是 "()(())" 。
//第二条路径得到的合法字符串是 "((()))" 。
//注意可能有其他的合法括号字符串路径。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[")",")"],["(","("]]
//输出：false
//解释：两条可行路径分别得到 "))(" 和 ")((" 。由于它们都不是合法括号字符串，我们返回 false 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// grid[i][j] 要么是 '(' ，要么是 ')' 。 
// 
//
// Related Topics 数组 动态规划 矩阵 括号序列 👍 73 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2267.检查是否有合法括号字符串路径.check-if-there-is-a-valid-parentheses-string-path
 *
 * @author db117
 * @since 2026-09-29 18:40:54
 **/

public class Solution_2267 {
    public static void main(String[] args) {
        Solution solution = new Solution_2267().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] grid;
        boolean[][][] vis;

        public boolean hasValidPath(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            this.grid = grid;
            this.vis = new boolean[m][n][(m + n + 1) / 2];
            if ((m + n) % 2 == 0 || grid[0][0] == ')' || grid[m - 1][n - 1] == '(') {
                // 一定不存在
                return false;
            }
            return dfs(0, 0, 0);
        }

        boolean dfs(int x, int y, int c) {
            int m = grid.length;
            int n = grid[0].length;
            if (x < 0 || y < 0 || x >= m || y >= n) {
                return false;
            }
            if (c > m - x + n - y - 1) { // 剪枝：即使后面都是 ')' 也不能把 c 减为 0
                return false;
            }

            if (x == m - 1 && y == n - 1) {
                // c 最后必须等于 1
                return c == 1;
            }
            if (vis[x][y][c]) {
                // 访问过了，那就说明之前的不行
                return false;
            }
            vis[x][y][c] = true;
            // 记录还需要多少个右括号
            if (grid[x][y] == '(') {
                c++;
            } else {
                c--;
            }
            if (c < 0) {
                // c 不能小于 0
                return false;
            }

            return dfs(x + 1, y, c) || dfs(x, y + 1, c);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}