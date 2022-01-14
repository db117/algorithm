

//给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。 
//
// 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。 
//
// 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。 
//
// 回文串 指的是从前往后和从后往前读一样的字符串。 
//
// 
//
// 示例 1： 
//
// 输入：words = ["lc","cl","gg"]
//输出：6
//解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
//"clgglc" 是另一个可以得到的最长回文串。
// 
//
// 示例 2： 
//
// 输入：words = ["ab","ty","yt","lc","cl","ab"]
//输出：8
//解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
//"lcyttycl" 是另一个可以得到的最长回文串。
// 
//
// 示例 3： 
//
// 输入：words = ["cc","ll","xx"]
//输出：2
//解释：最长回文串是 "cc" ，长度为 2 。
//"ll" 是另一个可以得到的最长回文串。"xx" 也是。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁵ 
// words[i].length == 2 
// words[i] 仅包含小写英文字母。 
// 
// Related Topics 贪心 数组 哈希表 字符串 计数 👍 7 👎 0


package cn.db117.leetcode.solution21;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131.连接两字母单词得到的最长回文串.longest-palindrome-by-concatenating-two-letter-words
 *
 * @author db117
 * @since 2022-01-14 11:47:14
 **/

public class Solution_2131 {
    public static void main(String[] args) {
        Solution solution = new Solution_2131().new Solution();

//        System.out.println(solution.longestPalindrome(new String[]{"lc","cl","gg"}));
//        System.out.println(solution.longestPalindrome(new String[]{"ab","ty","yt","lc","cl","ab"}));
//        System.out.println(solution.longestPalindrome(new String[]{"cc","ll","xx"}));
        System.out.println(solution.longestPalindrome(new String[]{"ll", "lb", "bb", "bx", "xx", "lx", "xx", "lx", "ll", "xb", "bx", "lb", "bb", "lb", "bl", "bb", "bx", "xl", "lb", "xx"}));

        // 26
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestPalindrome(String[] words) {
            int ans = 0;
            Map<String, Integer> map = new HashMap<>();
            for (String word : words) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }

            // 是否有相同字符的字符串
            boolean flag = false;

            for (String word : words) {
                if (!map.containsKey(word)) {
                    continue;
                }

                // 翻转字符串
                String r = new String(new char[]{word.charAt(1), word.charAt(0)});
                Integer count = map.remove(word);

                if (r.equals(word)) {
                    if (count % 2 == 1) {
                        flag = true;
                        // 减去多余的,剩下的都可以凑一对
                        count--;
                    }
                    // 相同字符可相互抵消
                    ans += count * 2;
                    continue;
                }


                Integer rCount = map.remove(r);
                if (rCount != null) {
                    // 可以凑一对
                    ans += Math.min(count, rCount) * 4;
                }

            }

            if (flag) {
                // 可以放在中间,但只能放一个
                ans += 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}