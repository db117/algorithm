

//给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。 
//
// 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。 
//
// 
//
// 示例 1： 
//
// 输入：a = 12, b = 6
//输出：4
//解释：12 和 6 的公因子是 1、2、3、6 。
// 
//
// 示例 2： 
//
// 输入：a = 25, b = 30
//输出：2
//解释：25 和 30 的公因子是 1、5 。 
//
// 
//
// 提示： 
//
// 
// 1 <= a, b <= 1000 
// 
//
// Related Topics 数学 枚举 数论 👍 4 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2427.公因子的数目.number-of-common-factors
 *
 * @author db117
 * @since 2022-10-11 14:49:54
 **/

public class Solution_2427 {
    public static void main(String[] args) {
        Solution solution = new Solution_2427().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int commonFactors(int a, int b) {
            int min = Math.min(a, b);

            int ans = 0;
            for (int i = 1; i <= min; i++) {
                if (a % i == 0 && b % i == 0) {
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}