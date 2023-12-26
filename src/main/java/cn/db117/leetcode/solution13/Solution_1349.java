

//给你一个 m * n 的矩阵 seats 表示教室中的座位分布。如果座位是坏的（不可用），就用 '#' 表示；否则，用 '.' 表示。 
//
// 学生可以看到左侧、右侧、左上、右上这四个方向上紧邻他的学生的答卷，但是看不到直接坐在他前面或者后面的学生的答卷。请你计算并返回该考场可以容纳的同时参加考试
//且无法作弊的 最大 学生人数。 
//
// 学生必须坐在状况良好的座位上。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：seats = [["#",".","#","#",".","#"],
//              [".","#","#","#","#","."],
//              ["#",".","#","#",".","#"]]
//输出：4
//解释：教师可以让 4 个学生坐在可用的座位上，这样他们就无法在考试中作弊。 
// 
//
// 示例 2： 
//
// 
//输入：seats = [[".","#"],
//              ["#","#"],
//              ["#","."],
//              ["#","#"],
//              [".","#"]]
//输出：3
//解释：让所有学生坐在可用的座位上。
// 
//
// 示例 3： 
//
// 
//输入：seats = [["#",".",".",".","#"],
//              [".","#",".","#","."],
//              [".",".","#",".","."],
//              [".","#",".","#","."],
//              ["#",".",".",".","#"]]
//输出：10
//解释：让学生坐在第 1、3 和 5 列的可用座位上。
// 
//
// 
//
// 提示： 
//
// 
// seats 只包含字符 '.' 和'#' 
// m == seats.length 
// n == seats[i].length 
// 1 <= m <= 8 
// 1 <= n <= 8 
// 
//
// Related Topics 位运算 数组 动态规划 状态压缩 矩阵 👍 182 👎 0


package cn.db117.leetcode.solution13;

import java.util.Arrays;

/**
 * 1349.参加考试的最大学生数.maximum-students-taking-exam
 *
 * @author db117
 * @since 2023-12-26 09:56:50
 **/

public class Solution_1349 {
    public static void main(String[] args) {
        Solution solution = new Solution_1349().new Solution();
        // [["#",".","#","#",".","#"],[".","#","#","#","#","."],["#",".","#","#",".","#"]]
        System.out.println(solution.maxStudents(new char[][]{
                {'#', '.', '#', '#', '.', '#'},
                {'.', '#', '#', '#', '#', '.'},
                {'#', '.', '#', '#', '.', '#'}
        }));

        // [[".","#"],["#","#"],["#","."],["#","#"],[".","#"]]
//        System.out.println(solution.maxStudents(new char[][]{
//                {'.', '#'},
//                {'#', '#'},
//                {'#', '.'},
//                {'#', '#'},
//                {'.', '#'}
//        }));

        //[[".",".",".",".","#",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".",".",".","#","."],[".",".",".",".",".",".",".","."],[".",".","#",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","#",".",".","#","."]]
//        System.out.println(solution.maxStudents(new char[][]{
//                {'.', '.', '.', '.', '#', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '#', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '#', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '.', '.', '#', '.', '.', '#', '.'}
//        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int m, n;
        int[][] memo;
        int[] a;

        public int maxStudents(char[][] seats) {
            m = seats.length;
            n = seats[0].length;
            memo = new int[m][1 << n];
            a = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; ++j) {
                    a[i] |= (seats[i][j] == '.') ? (1 << j) : 0;
                }
            }
            for (int[] ints : memo) {
                Arrays.fill(ints, -1);
            }
            return dfs(m - 1, a[m - 1]);
        }

        /**
         * @param i    行数
         * @param flag 当前行可以坐的座位
         */
        private int dfs(int i, int flag) {
            if (i < 0) {
                // 没有座位了
                return 0;
            }
            if (memo[i][flag] != -1) {// 记忆化
                return memo[i][flag];
            }
            if (i == 0) {
                if (flag == 0) {
                    return 0;
                }
                // 算出第一排现在能做多少人
                int lowbit = flag & -flag;// 最右边能坐的人
                int d = lowbit << 1 | lowbit;// 选中的人和他的左边
                return memo[i][flag] = dfs(i, flag & ~d) + 1;
            }

            // 当前排不进行处理

            int ans = dfs(i - 1, a[i - 1]);
            // 遍历所有可能的位置
            for (int sub = flag; sub > 0; sub = (sub - 1) & flag) {// 枚举所有可能的位置
                if ((sub & (sub >> 1)) > 0) {// 有连续的座位不能坐
                    continue;
                }
                // 去掉由于当前位置影响的位置
                int next = a[i - 1] & ~(sub << 1 | sub >> 1);
                ans = Math.max(ans, Integer.bitCount(sub)/*现在选的*/ + dfs(i - 1, next)/*下一层基于当前位置继续*/);
            }

            return memo[i][flag] = ans;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}