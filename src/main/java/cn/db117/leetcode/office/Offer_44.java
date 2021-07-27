// 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
//
// 请写一个函数，求任意第n位对应的数字。 
//
// 
//
// 示例 1： 
//
// 输入：n = 3
//输出：3
// 
//
// 示例 2： 
//
// 输入：n = 11
//输出：0 
//
// 
//
// 限制： 
//
// 
// 0 <= n < 2^31 
// 
//
// 注意：本题与主站 400 题相同：https://leetcode-cn.com/problems/nth-digit/ 
// Related Topics 数学 二分查找 
// 👍 151 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer 44.数字序列中某一位的数字.shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 *
 * @author db117
 * @since 2021-07-27 14:46:10
 **/

public class Offer_44 {
    public static void main(String[] args) {
        Solution solution = new Offer_44().new Solution();
        System.out.println(solution.findNthDigit(6));
        System.out.println(solution.findNthDigit(11));
        System.out.println(solution.findNthDigit(Integer.MAX_VALUE));
        System.out.println(solution.findNthDigit(1000000000));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNthDigit(int n) {
            if (n < 10) {
                return n;
            }
            int ans = 9;
            // 上一个位数的最大值
            int preMax = 9;
            // 当前位数数字个数
            long count = 90;
            // 当前数字位数
            int i;
            for (i = 2; i < 13; i++) {
                if (ans + count * i > n) {
                    break;
                }
                ans += count * i;
                preMax *= 10;
                preMax += 9;

                count *= 10;
            }

            // 所在数字
            int num = (n - ans + i - 1) / i + preMax;

            // 所在数字的位置
            int index = (n - ans - 1) % i;

            return Integer.toString(num).toCharArray()[index] - '0';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}