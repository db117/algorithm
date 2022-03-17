


//给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。 
//
// 正数的平方根有两个，只输出其中的正数平方根。 
//
// 如果平方根不是整数，输出只保留整数的部分，小数部分将被舍去。 
//
// 
//
// 示例 1: 
//
// 
//输入: x = 4
//输出: 2
// 
//
// 示例 2: 
//
// 
//输入: x = 8
//输出: 2
//解释: 8 的平方根是 2.82842...，由于小数部分将被舍去，所以返回 2
// 
//
// 
//
// 提示: 
//
// 
// 0 <= x <= 2³¹ - 1 
// 
//
// 
//
// 注意：本题与主站 69 题相同： https://leetcode-cn.com/problems/sqrtx/ 
// Related Topics 数学 二分查找 👍 15 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer II 072.求平方根.jJ0w9p
 *
 * @author db117
 * @since 2022-03-17 14:15:31
 **/

public class Offer_II072 {
    public static void main(String[] args) {
        Solution solution = new Offer_II072().new Solution();
        System.out.println(solution.mySqrt(8));
        System.out.println(solution.mySqrt(Integer.MAX_VALUE));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int mySqrt(int x) {
            int pre = 0;
            // int 最大值的平方根为 46340
            for (int i = 0; i < 46341; i++) {
                int cur = i * i;
                if (cur == x) {
                    return i;
                }
                if (cur > x) {
                    return pre;
                }
                pre = i;
            }
            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}