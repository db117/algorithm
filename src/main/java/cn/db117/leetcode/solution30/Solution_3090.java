

//给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "bcbbbcba" 
// 
//
// 输出： 4 
//
// 解释： 
//
// 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。 
//
// 示例 2： 
//
// 
// 输入： s = "aaaa" 
// 
//
// 输出： 2 
//
// 解释： 
//
// 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。 
//
// 
//
// 提示： 
//
// 
// 
// 2 <= s.length <= 100 
// 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3090.每个字符最多出现两次的最长子字符串.maximum-length-substring-with-two-occurrences
 *
 * @author db117
 * @since 2024-03-26 23:29:47
 **/

public class Solution_3090 {
    public static void main(String[] args) {
        Solution solution = new Solution_3090().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLengthSubstring(String s) {
            // 暴力
            char[] chars = s.toCharArray();
            int n = chars.length;
            int ans = 1;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (check(chars, i, j)) {
                        ans = Math.max(ans, j - i + 1);
                    }
                }
            }

            return ans;
        }

        private boolean check(char[] chars, int i, int j) {
            int[] count = new int[26];
            for (int k = i; k <= j; k++) {
                count[chars[k] - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                if (count[k] > 2) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}