

//给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。 
//
// 返回 word 中 特殊字母 的数量。 
//
// 
//
// 示例 1: 
//
// 
// 输入：word = "aaAbcBC" 
// 
//
// 输出：3 
//
// 解释： 
//
// word 中的特殊字母是 'a'、'b' 和 'c'。 
//
// 示例 2: 
//
// 
// 输入：word = "abc" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在大小写形式同时出现的字母。 
//
// 示例 3: 
//
// 
// 输入：word = "abBCab" 
// 
//
// 输出：1 
//
// 解释： 
//
// word 中唯一的特殊字母是 'b'。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 50 
// word 仅由小写和大写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 1 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3120.统计特殊字母的数量 I.count-the-number-of-special-characters-i
 *
 * @author db117
 * @since 2024-04-30 11:23:43
 **/

public class Solution_3120 {
    public static void main(String[] args) {
        Solution solution = new Solution_3120().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSpecialChars(String word) {
            boolean[] flag = new boolean[26];
            boolean[] flag1 = new boolean[26];

            for (char c : word.toCharArray()) {
                if (c >= 'a' && c <= 'z') {
                    flag[c - 'a'] = true;
                } else if (c >= 'A' && c <= 'Z') {
                    flag1[c - 'A'] = true;
                }
            }

            int ans = 0;
            for (int i = 0; i < 26; i++) {
                if (flag[i] && flag1[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}