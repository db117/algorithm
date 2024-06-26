

//给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的
// 战舰 的数量。 
//
// 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，其中 k 可以
//是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：board = [["."]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 200 
// board[i][j] 是 '.' 或 'X' 
// 
//
// 
//
// 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？ 
//
// Related Topics 深度优先搜索 数组 矩阵 👍 282 👎 0


package cn.db117.leetcode.solution4;

/**
 * 419.甲板上的战舰.battleships-in-a-board
 *
 * @author db117
 * @since 2024-06-11 10:40:36
 **/

public class Solution_419 {
    public static void main(String[] args) {
        Solution solution = new Solution_419().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countBattleships(char[][] board) {
            int ans = 0;
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        if (i > 0 && board[i - 1][j] == 'X') {
                            // 上面有
                            continue;
                        }
                        if (j > 0 && board[i][j - 1] == 'X') {
                            // 左边有
                            continue;
                        }
                        // 第一次访问这个
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}