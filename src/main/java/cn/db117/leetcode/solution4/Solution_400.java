//在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 位数字。
//
// 
//
// 注意：n 是正数且在 32 位整数范围内（n < 231）。 
//
// 
//
// 示例 1： 
//
// 
//输入：3
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：11
//输出：0
//解释：第 11 位数字在序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... 里是 0 ，它是 10 的一部分。
// 
// Related Topics 数学 二分查找 
// 👍 161 👎 0


package cn.db117.leetcode.solution4;

/**
 * 400.第 N 位数字.nth-digit
 *
 * @author db117
 * @since 2021-07-05 11:27:23
 **/

public class Solution_400 {
    public static void main(String[] args) {
        Solution solution = new Solution_400().new Solution();
        System.out.println(solution.findNthDigit(1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n < 10) {
                return n;
            }
            // 1-9
            // 10-99
            // 100-999

            // 当前区间 [left,right]
            int left = 1;
            int right = 9;
            // 当区间数字长度
            long curLen = 1;
            // 当前区间左边字符长度
            long len = 0;

            while (n > (right - left + 1) * curLen) {
                len += (right - left + 1) * curLen;
                left *= 10;
                right = left * 10 - 1;
                curLen++;
            }

            // 循环结束可以得到 当前区间
            // 找到目标数字
            int num = (int) ((n - len - 1) / curLen + left);
            // 目标数字的位置
            int index = (int) ((n - len - 1) % curLen);

            return Integer.toString(num).charAt(index) - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}