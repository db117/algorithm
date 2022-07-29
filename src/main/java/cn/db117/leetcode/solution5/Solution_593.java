

//给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。 
//
// 点的坐标 pi 表示为 [xi, yi] 。输入 不是 按任何顺序给出的。 
//
// 一个 有效的正方形 有四条等边和四个等角(90度角)。 
//
// 
//
// 示例 1: 
//
// 
//输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
//输出: True
// 
//
// 示例 2: 
//
// 
//输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
//输出：false
// 
//
// 示例 3: 
//
// 
//输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
//输出：true
// 
//
// 
//
// 提示: 
//
// 
// p1.length == p2.length == p3.length == p4.length == 2 
// -10⁴ <= xi, yi <= 10⁴ 
// 
//
// Related Topics 几何 数学 👍 140 👎 0


package cn.db117.leetcode.solution5;

/**
 * 593.有效的正方形.valid-square
 *
 * @author db117
 * @since 2022-07-29 15:29:27
 **/

public class Solution_593 {
    public static void main(String[] args) {
        Solution solution = new Solution_593().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
            return helper(p1, p2, p3) && helper(p1, p2, p4) && helper(p1, p3, p4) && helper(p4, p2, p3);
        }

        /**
         * 判断是否是直角三角形
         */
        private boolean helper(int[] p1, int[] p2, int[] p3) {
            // 三条边的平方
            int ab = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
            int bc = (p3[0] - p2[0]) * (p3[0] - p2[0]) + (p3[1] - p2[1]) * (p3[1] - p2[1]);
            int ac = (p1[0] - p3[0]) * (p1[0] - p3[0]) + (p1[1] - p3[1]) * (p1[1] - p3[1]);

            // 找斜边,判断是否是等边三角形且边长不为 0
            if (ab == bc + ac) {
                return bc == ac && ac != 0;
            } else if (bc == ac + ab) {
                return ac == ab && ac != 0;
            } else if (ac == ab + bc) {
                return ab == bc && ab != 0;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}