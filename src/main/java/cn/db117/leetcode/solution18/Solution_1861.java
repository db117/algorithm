//给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
//
// 
// '#' 表示石头 
// '*' 表示固定的障碍物 
// '.' 表示空位置 
// 
//
// 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影
//响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。 
//
// 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。 
//
// 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：box = [["#",".","#"]]
//输出：[["."],
//      ["#"],
//      ["#"]]
// 
//
// 示例 2： 
//
// 
//
// 输入：box = [["#",".","*","."],
//            ["#","#","*","."]]
//输出：[["#","."],
//      ["#","#"],
//      ["*","*"],
//      [".","."]]
// 
//
// 示例 3： 
//
// 
//
// 输入：box = [["#","#","*",".","*","."],
//            ["#","#","#","*",".","."],
//            ["#","#","#",".","#","."]]
//输出：[[".","#","#"],
//      [".","#","#"],
//      ["#","#","*"],
//      ["#","*","."],
//      ["#",".","*"],
//      ["#",".","."]]
// 
//
// 
//
// 提示： 
//
// 
// m == box.length 
// n == box[i].length 
// 1 <= m, n <= 500 
// box[i][j] 只可能是 '#' ，'*' 或者 '.' 。 
// 
// Related Topics 数组 双指针 
// 👍 3 👎 0


package cn.db117.leetcode.solution18;

import java.util.Arrays;

/**
 * 1861.旋转盒子.rotating-the-box
 *
 * @author db117
 * @since 2021-06-23 15:54:03
 **/

public class Solution_1861 {
    public static void main(String[] args) {
        Solution solution = new Solution_1861().new Solution();

        System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][]
                {{'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}, {'.', '.', '.', '.', '.'}}
        )));
        System.out.println(Arrays.deepToString(solution.rotateTheBox(new char[][]
                {{'#', '#', '*', '.', '*', '.'},
                        {'#', '#', '#', '*', '.', '.'},
                        {'#', '#', '#', '.', '#', '.'}}
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char[][] rotateTheBox(char[][] box) {
            int m = box.length;
            int n = box[0].length;


            for (char[] chars : box) {
                // 双指针
                int left = n - 1, right = n - 1;
                while (left > 0) {
                    // 保证右指针指向 .
                    while (right > 0 && chars[right] != '.') {
                        right--;
                    }
                    if (right == 0) {
                        // 不需要移动
                        break;
                    }
                    left = right;

                    // 左指针往左边走
                    // 碰见空继续
                    while (left > 0 && chars[left] == '.') {
                        left--;
                    }


                    // 碰见障碍物,右指针指向左指针左边
                    if (chars[left] == '*') {
                        left--;
                        right = left;
                        continue;
                    }

                    if (chars[left] == '#') {
                        // 碰见石头放到右边
                        chars[right] = '#';
                        chars[left] = '.';
                    }
                }
            }
            // 翻转数组
            char[][] ans = new char[n][m];
            for (int i = 0; i < m; i++) {
                char[] chars = box[i];
                // 第一行变成最后一列
                for (int j = 0; j < chars.length; j++) {
                    ans[j][m - 1 - i] = chars[j];
                }

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}