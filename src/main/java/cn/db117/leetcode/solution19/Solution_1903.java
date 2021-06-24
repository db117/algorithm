//给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个
//空字符串 "" 。 
//
// 子字符串 是字符串中的一个连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "52"
//输出："5"
//解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
// 
//
// 示例 2： 
//
// 
//输入：num = "4206"
//输出：""
//解释：在 "4206" 中不存在奇数。
// 
//
// 示例 3： 
//
// 
//输入：num = "35427"
//输出："35427"
//解释："35427" 本身就是一个奇数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 105 
// num 仅由数字组成且不含前导零 
// 
// Related Topics 贪心算法 数学 字符串 
// 👍 9 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1903.字符串中的最大奇数.largest-odd-number-in-string
 *
 * @author db117
 * @since 2021-06-24 18:26:10
 **/

public class Solution_1903 {
    public static void main(String[] args) {
        Solution solution = new Solution_1903().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestOddNumber(String num) {
            // 脑筋急转弯
            // 找最右边的奇数
            char[] chars = num.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                if ((chars[i] - '0' & 1) == 0) {
                    // 偶数
                    continue;
                }
                // 第一个奇数
                return num.substring(0, i + 1);
            }

            return "";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}