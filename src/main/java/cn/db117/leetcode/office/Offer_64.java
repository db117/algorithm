


//求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。 
//
// 
//
// 示例 1： 
//
// 输入: n = 3
//输出: 6
// 
//
// 示例 2： 
//
// 输入: n = 9
//输出: 45
// 
//
// 
//
// 限制： 
//
// 
// 1 <= n <= 10000 
// 
// Related Topics 位运算 递归 脑筋急转弯 👍 451 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer 64.求1+2+…+n.qiu-12n-lcof
 *
 * @author db117
 * @since 2022-03-14 14:46:19
 **/

public class Offer_64 {
    public static void main(String[] args) {
        Solution solution = new Offer_64().new Solution();
        System.out.println(solution.sumNums(10000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumNums(int n) {
            // 递归替换 for
            // 短路替换 if
            boolean flag = (n > 0) && (n += sumNums(n - 1)) > 0;
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}