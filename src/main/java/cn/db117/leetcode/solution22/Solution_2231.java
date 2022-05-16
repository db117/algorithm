

//给你一个正整数 num 。你可以交换 num 中 奇偶性 相同的任意两位数字（即，都是奇数或者偶数）。 
//
// 返回交换 任意 次之后 num 的 最大 可能值。 
//
// 
//
// 示例 1： 
//
// 输入：num = 1234
//输出：3412
//解释：交换数字 3 和数字 1 ，结果得到 3214 。
//交换数字 2 和数字 4 ，结果得到 3412 。
//注意，可能存在其他交换序列，但是可以证明 3412 是最大可能值。
//注意，不能交换数字 4 和数字 1 ，因为它们奇偶性不同。
// 
//
// 示例 2： 
//
// 输入：num = 65875
//输出：87655
//解释：交换数字 8 和数字 6 ，结果得到 85675 。
//交换数字 5 和数字 7 ，结果得到 87655 。
//注意，可能存在其他交换序列，但是可以证明 87655 是最大可能值。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 10⁹ 
// 
// 👍 8 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2231.按奇偶性交换后的最大数字.largest-number-after-digit-swaps-by-parity
 *
 * @author db117
 * @since 2022-04-12 15:31:50
 **/

public class Solution_2231 {
    public static void main(String[] args) {
        Solution solution = new Solution_2231().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestInteger(int num) {
            // 冒泡
            char[] chars = Integer.toString(num).toCharArray();
            int len = chars.length;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    // 找后面奇偶性相同的数字,把小的放前面
                    if (Math.abs(chars[i] - chars[j]) % 2 == 0 && chars[i] < chars[j]) {
                        char tmp = chars[i];
                        chars[i] = chars[j];
                        chars[j] = tmp;
                    }
                }
            }
            return Integer.parseInt(new String(chars));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}