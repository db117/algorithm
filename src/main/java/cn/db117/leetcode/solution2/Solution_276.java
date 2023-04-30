

//有 k 种颜色的涂料和一个包含 n 个栅栏柱的栅栏，请你按下述规则为栅栏设计涂色方案： 
//
// 
// 每个栅栏柱可以用其中 一种 颜色进行上色。 
// 相邻的栅栏柱 最多连续两个 颜色相同。 
// 
//
// 给你两个整数 k 和 n ，返回所有有效的涂色 方案数 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3, k = 2
//输出：6
//解释：所有的可能涂色方案如上图所示。注意，全涂红或者全涂绿的方案属于无效方案，因为相邻的栅栏柱 最多连续两个 颜色相同。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：n = 7, k = 2
//输出：42
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 50 
// 1 <= k <= 10⁵ 
// 题目数据保证：对于输入的 n 和 k ，其答案在范围 [0, 2³¹ - 1] 内 
// 
//
// Related Topics 动态规划 👍 180 👎 0


package cn.db117.leetcode.solution2;

/**
 * 276.栅栏涂色.paint-fence
 *
 * @author db117
 * @since 2023-04-27 10:00:01
 **/

public class Solution_276 {
    public static void main(String[] args) {
        Solution solution = new Solution_276().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWays(int n, int k) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return k;
            }
            if (n == 2) {
                return k * k;
            }
            // 以 i-1 结尾的方案数
            int[] f = new int[n + 1];
            f[1] = k;// 第一个可以涂所有颜色
            f[2] = k * k;// 第二个也可以涂任意颜色

            for (int i = 3; i <= n; i++) {
                // 和上一个涂一样的颜色，那么需要和上上个不一样，那么上一个就必须和当前颜色一样
                f[i] = f[i - 2] * (k - 1);
                // 颜色不一样则可以涂 k-1 种
                f[i] += f[i - 1] * (k - 1);
            }

            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}