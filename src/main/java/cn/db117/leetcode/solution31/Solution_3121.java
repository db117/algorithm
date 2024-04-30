

//给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称
//字母 c 是一个 特殊字母 。 
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
// 特殊字母是 'a'、'b' 和 'c'。 
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
// word 中不存在特殊字母。 
//
// 示例 3: 
//
// 
// 输入：word = "AbBCab" 
// 
//
// 输出：0 
//
// 解释： 
//
// word 中不存在特殊字母。 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 2 * 10⁵ 
// word 仅由小写和大写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 👍 5 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;

/**
 * 3121.统计特殊字母的数量 II.count-the-number-of-special-characters-ii
 *
 * @author db117
 * @since 2024-04-30 11:24:28
 **/

public class Solution_3121 {
    public static void main(String[] args) {
        Solution solution = new Solution_3121().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSpecialChars(String word) {
            char[] chars = word.toCharArray();
            boolean[] flag = new boolean[26];
            // 记录大写字母第一次出现的位置
            int[] firstBig = new int[26];
            Arrays.fill(firstBig, -1);

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c <= 'Z') {
                    if (firstBig[c - 'A'] == -1) {
                        firstBig[c - 'A'] = i;
                    }
                }
            }

            int ans = 0;

            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c <= 'Z') {
                    continue;
                }
                // 小写字母在大写字母之前
                flag[c - 'a'] = firstBig[c - 'a'] > i;
            }

            for (int i = 0; i < 26; i++) {
                if (flag[i]) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}