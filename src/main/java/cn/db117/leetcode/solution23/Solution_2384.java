

//给你一个仅由数字（0 - 9）组成的字符串 num 。 
//
// 请你找出能够使用 num 中数字形成的 最大回文 整数，并以字符串形式返回。该整数不含 前导零 。 
//
// 注意： 
//
// 
// 你 无需 使用 num 中的所有数字，但你必须使用 至少 一个数字。 
// 数字可以重新排序。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "444947137"
//输出："7449447"
//解释：
//从 "444947137" 中选用数字 "4449477"，可以形成回文整数 "7449447" 。
//可以证明 "7449447" 是能够形成的最大回文整数。
// 
//
// 示例 2： 
//
// 
//输入：num = "00009"
//输出："9"
//解释：
//可以证明 "9" 能够形成的最大回文整数。
//注意返回的整数不应含前导零。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num.length <= 10⁵ 
// num 由数字（0 - 9）组成 
// 
//
// Related Topics 贪心 哈希表 字符串 👍 8 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2384.最大回文数字.largest-palindromic-number
 *
 * @author db117
 * @since 2022-08-26 18:21:54
 **/

public class Solution_2384 {
    public static void main(String[] args) {
        Solution solution = new Solution_2384().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String largestPalindromic(String num) {
            int[] count = new int[10];
            for (char c : num.toCharArray()) {
                count[c - '0']++;
            }

            int max = -1;
            // 分层两半
            StringBuilder ans = new StringBuilder();
            for (int i = count.length - 1; i >= 0; i--) {
                int size = count[i];
                if ((count[i] & 1) == 1) {
                    max = Math.max(max, i);
                }

                if (size < 2) {
                    continue;
                }
                size /= 2;
                ans.append(String.valueOf((char) ('0' + i)).repeat(size));
            }
            // 去掉前缀 0
            while (ans.length() > 0 && ans.charAt(0) == '0') {
                ans.deleteCharAt(0);
            }
            String pre = ans.toString();
            if (max != -1) {
                ans.append((char) ('0' + max));
            }
            if (ans.length() == 0 && count[0] > 0) {
                // 特殊处理
                return "0";
            }
            return ans.append(new StringBuilder(pre).reverse()).toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}