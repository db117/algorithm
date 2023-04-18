

//给你一个仅由 0 和 1 组成的二进制字符串 s 。 
//
// 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字
//符串。 
//
// 返回 s 中最长的平衡子字符串长度。 
//
// 子字符串是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "01000111"
//输出：6
//解释：最长的平衡子字符串是 "000111" ，长度为 6 。
// 
//
// 示例 2： 
//
// 
//输入：s = "00111"
//输出：4
//解释：最长的平衡子字符串是 "0011" ，长度为  4 。
// 
//
// 示例 3： 
//
// 
//输入：s = "111"
//输出：0
//解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 50 
// '0' <= s[i] <= '1' 
// 
//
// Related Topics 字符串 👍 9 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2609.最长平衡子字符串.find-the-longest-balanced-substring-of-a-binary-string
 *
 * @author db117
 * @since 2023-04-10 10:45:38
 **/

public class Solution_2609 {
    public static void main(String[] args) {
        Solution solution = new Solution_2609().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            // 双指针
            int n = s.length();
            char[] chars = s.toCharArray();
            int max = 0;
            int left = 0, right = 0;
            while (right < n) {
                // 先找 0
                while (right < n && chars[right] == '0') {
                    right++;
                }
                int z = right - left;
                // 在找 1
                int one = right;
                while (right < n && chars[right] == '1') {
                    right++;
                }
                // 记录最大值
                max = Math.max(max, Math.min(z, right - one) * 2);

                left = right;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}