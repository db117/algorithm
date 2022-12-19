

//请在 n × n 的棋盘上，实现一个判定井字棋（Tic-Tac-Toe）胜负的神器，判断每一次玩家落子后，是否有胜出的玩家。 
//
// 在这个井字棋游戏中，会有 2 名玩家，他们将轮流在棋盘上放置自己的棋子。 
//
// 在实现这个判定器的过程中，你可以假设以下这些规则一定成立： 
//
// 1. 每一步棋都是在棋盘内的，并且只能被放置在一个空的格子里； 
//
// 2. 一旦游戏中有一名玩家胜出的话，游戏将不能再继续； 
//
// 3. 一个玩家如果在同一行、同一列或者同一斜对角线上都放置了自己的棋子，那么他便获得胜利。 
//
// 示例: 
//
// 给定棋盘边长 n = 3, 玩家 1 的棋子符号是 "X"，玩家 2 的棋子符号是 "O"。
//
//TicTacToe toe = new TicTacToe(3);
//
//toe.move(0, 0, 1); -> 函数返回 0 (此时，暂时没有玩家赢得这场对决)
//|X| | |
//| | | |    // 玩家 1 在 (0, 0) 落子。
//| | | |
//
//toe.move(0, 2, 2); -> 函数返回 0 (暂时没有玩家赢得本场比赛)
//|X| |O|
//| | | |    // 玩家 2 在 (0, 2) 落子。
//| | | |
//
//toe.move(2, 2, 1); -> 函数返回 0 (暂时没有玩家赢得比赛)
//|X| |O|
//| | | |    // 玩家 1 在 (2, 2) 落子。
//| | |X|
//
//toe.move(1, 1, 2); -> 函数返回 0 (暂没有玩家赢得比赛)
//|X| |O|
//| |O| |    // 玩家 2 在 (1, 1) 落子。
//| | |X|
//
//toe.move(2, 0, 1); -> 函数返回 0 (暂无玩家赢得比赛)
//|X| |O|
//| |O| |    // 玩家 1 在 (2, 0) 落子。
//|X| |X|
//
//toe.move(1, 0, 2); -> 函数返回 0 (没有玩家赢得比赛)
//|X| |O|
//|O|O| |    // 玩家 2 在 (1, 0) 落子.
//|X| |X|
//
//toe.move(2, 1, 1); -> 函数返回 1 (此时，玩家 1 赢得了该场比赛)
//|X| |O|
//|O|O| |    // 玩家 1 在 (2, 1) 落子。
//|X|X|X|
// 
//
// 
//
// 进阶: 您有没有可能将每一步的 move() 操作优化到比 O(n²) 更快吗? 
//
// Related Topics 设计 数组 哈希表 矩阵 👍 124 👎 0


package cn.db117.leetcode.solution3;

/**
 * 348.设计井字棋.design-tic-tac-toe
 *
 * @author db117
 * @since 2022-12-19 14:15:34
 **/

public class Solution_348 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TicTacToe {
        // 横竖
        int[] r, c;
        // 两个对角线
        int ld, rd;
        int n;

        public TicTacToe(int n) {
            r = new int[n];
            c = new int[n];
            this.n = n;
        }

        public int move(int row, int col, int player) {
            // 玩家 1 标记 -1
            // 玩家 2 标记 1

            int flag = player == 1 ? -1 : 1;
            r[row] += flag;
            c[col] += flag;

            if (row == col) {
                ld += flag;
            }
            if (row + col == n - 1) {
                rd += flag;
            }
            if (r[row] == n || c[col] == n || ld == n || rd == n) {
                return 2;
            }
            if (r[row] == -n || c[col] == -n || ld == -n || rd == -n) {
                return 1;
            }
            return 0;
        }
    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
//leetcode submit region end(Prohibit modification and deletion)

}