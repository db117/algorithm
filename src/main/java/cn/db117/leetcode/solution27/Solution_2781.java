

//给你一个字符串 word 和一个字符串数组 forbidden 。 
//
// 如果一个字符串不包含 forbidden 中的任何字符串，我们称这个字符串是 合法 的。 
//
// 请你返回字符串 word 的一个 最长合法子字符串 的长度。 
//
// 子字符串 指的是一个字符串中一段连续的字符，它可以为空。 
//
// 
//
// 示例 1： 
//
// 输入：word = "cbaaaabc", forbidden = ["aaa","cb"]
//输出：4
//解释：总共有 9 个合法子字符串："c" ，"b" ，"a" ，"ba" ，"aa" ，"bc" ，"baa" ，"aab" 和 "aabc" 。最长合法子
//字符串的长度为 4 。
//其他子字符串都要么包含 "aaa" ，要么包含 "cb" 。 
//
// 示例 2： 
//
// 输入：word = "leetcode", forbidden = ["de","le","e"]
//输出：4
//解释：总共有 11 个合法子字符串："l" ，"t" ，"c" ，"o" ，"d" ，"tc" ，"co" ，"od" ，"tco" ，"cod" 和 
//"tcod" 。最长合法子字符串的长度为 4 。
//所有其他子字符串都至少包含 "de" ，"le" 和 "e" 之一。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 10⁵ 
// word 只包含小写英文字母。 
// 1 <= forbidden.length <= 10⁵ 
// 1 <= forbidden[i].length <= 10 
// forbidden[i] 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 滑动窗口 👍 15 👎 0


package cn.db117.leetcode.solution27;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2781.最长合法子字符串的长度.length-of-the-longest-valid-substring
 *
 * @author db117
 * @since 2023-07-19 10:27:41
 **/

public class Solution_2781 {
    public static void main(String[] args) {
        Solution solution = new Solution_2781().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestValidSubstring(String word, List<String> forbidden) {
            int ans = 0;
            Set<String> set = new HashSet<>(forbidden);
            int n = word.length();
            int left = 0;// 左边界,如果右边界开始往左边有非法字符,则左边界移动到非法字符的下一个位置
            for (int right = 0; right < n; right++) {
                // 从后往前找,最多找10个字符
                for (int i = right; i >= right - 10 && i >= left; i--) {
                    if (set.contains(word.substring(i, right + 1))) {
                        // 有非法字符
                        left = i + 1;// 左边界移动到非法字符的下一个位置
                        break;
                    }
                }
                ans = Math.max(ans, right - left + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}