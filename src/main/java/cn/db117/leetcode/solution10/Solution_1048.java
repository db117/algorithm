

//给出一个单词数组 words ，其中每个单词都由小写英文字母组成。 
//
// 如果我们可以 不改变其他字符的顺序 ，在 wordA 的任何地方添加 恰好一个 字母使其变成 wordB ，那么我们认为 wordA 是 wordB 的 
//前身 。 
//
// 
// 例如，"abc" 是 "abac" 的 前身 ，而 "cba" 不是 "bcad" 的 前身 
// 
//
// 词链是单词 [word_1, word_2, ..., word_k] 组成的序列，k >= 1，其中 word1 是 word2 的前身，word2 是
// word3 的前身，依此类推。一个单词通常是 k == 1 的 单词链 。 
//
// 从给定单词列表 words 中选择单词组成词链，返回 词链的 最长可能长度 。 
//
// 示例 1： 
//
// 
//输入：words = ["a","b","ba","bca","bda","bdca"]
//输出：4
//解释：最长单词链之一为 ["a","ba","bda","bdca"]
// 
//
// 示例 2: 
//
// 
//输入：words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//输出：5
//解释：所有的单词都可以放入单词链 ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
// 
//
// 示例 3: 
//
// 
//输入：words = ["abcd","dbqca"]
//输出：1
//解释：字链["abcd"]是最长的字链之一。
//["abcd"，"dbqca"]不是一个有效的单词链，因为字母的顺序被改变了。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 1000 
// 1 <= words[i].length <= 16 
// words[i] 仅由小写英文字母组成。 
// 
//
// Related Topics 数组 哈希表 双指针 字符串 动态规划 👍 213 👎 0


package cn.db117.leetcode.solution10;

import java.util.*;

/**
 * 1048.最长字符串链.longest-string-chain
 *
 * @author db117
 * @since 2023-04-26 14:29:16
 **/

public class Solution_1048 {
    public static void main(String[] args) {
        Solution solution = new Solution_1048().new Solution();

//        System.out.println(solution.longestStrChain(new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp",
//                "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda",
//                "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya",
//                "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"}));

        System.out.println(solution.longestStrChain(new String[]{"a", "ab", "ac", "bd", "abc", "abd", "abdd"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        @SuppressWarnings({"unchecked", "rawtypes"})
        public int longestStrChain(String[] words) {
            int n = words.length;
            // 字符串 -> 以这个字符串结尾的最大长度
            Map<String, Integer> max = new HashMap<>();
            // 每个长度的分一块
            ArrayList<String>[] arr = new ArrayList[17];
            Arrays.setAll(arr, value -> new ArrayList());

            for (String word : words) {
                arr[word.length()].add(word);
            }

            for (int i = 1; i <= 16; i++) {

                for (String s : arr[i]) {
                    max.put(s, 1);
                }

                // 把两组长度差 1 的字符串进行对比
                for (String cur : arr[i]) {
                    for (String pre : arr[i - 1]) {
                        if (check(pre, cur)) {
                            // 刚好差 1 个字符,找最长的
                            max.put(cur, Math.max(max.get(cur), max.getOrDefault(pre, 1) + 1));
                        }
                    }
                }
            }
            // 找最大的
            return max.values()
                    .stream()
                    .max(Comparator.comparingInt(o -> o))
                    .orElse(1);
        }

        private boolean check(String pre, String last) {
            if (pre.length() + 1 != last.length()) {
                return false;
            }
            // 双指针比较
            int l = 0, r = 0;
            while (l < pre.length() && r < last.length()) {
                if (pre.charAt(l) == last.charAt(r)) {
                    l++;
                    r++;
                } else {
                    r++;
                }
                if (l + 1 < r) {
                    return false;
                }
            }
            return l == r || l + 1 == r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}