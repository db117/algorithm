

//如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。 
//
// 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。 
//
// 
//
// 示例 1： 
//
// 输入：text = "ababa"
//输出：3
// 
//
// 示例 2： 
//
// 输入：text = "aaabaaa"
//输出：6
// 
//
// 示例 3： 
//
// 输入：text = "aaabbaaa"
//输出：4
// 
//
// 示例 4： 
//
// 输入：text = "aaaaa"
//输出：5
// 
//
// 示例 5： 
//
// 输入：text = "abcdef"
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= text.length <= 20000 
// text 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 158 👎 0


package cn.db117.leetcode.solution11;

import java.util.HashMap;
import java.util.Map;

/**
 * 1156.单字符重复子串的最大长度.swap-for-longest-repeated-character-substring
 *
 * @author db117
 * @since 2023-06-03 16:53:11
 **/

public class Solution_1156 {
    public static void main(String[] args) {
        Solution solution = new Solution_1156().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxRepOpt1(String text) {
            char[] chars = text.toCharArray();
            int n = chars.length;

            Map<Character, Integer> count = new HashMap<>();
            for (char c : chars) {
                count.merge(c, 1, Integer::sum);
            }

            int ans = 0;

            for (int left = 0; left < n; ) {
                int right = left;
                // 连续一样的
                while (right < n && chars[right] == chars[left]) {
                    right++;
                }


                if (right - left == count.get(chars[left])) {
                    ans = Math.max(ans, right - left);
                    left = right;
                    continue;
                } else {
                    // 有多余的就可以最少加 1
                    ans = Math.max(ans, right - left + 1);
                }

                int k = right + 1;
                // 跳过一个不一样的，继续找一样的
                while (k < n &&
                        chars[k] == chars[left]) {
                    k++;
                }
                ans = Math.max(ans, Math.min(k - left, count.get(chars[left])));

                left = right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}