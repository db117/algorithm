

//给你一种规律 pattern 和一个字符串 s，请你判断 s 是否和 pattern 的规律相匹配。 
//
// 如果存在单个字符到字符串的 双射映射 ，那么字符串
// s 匹配
// pattern ，即：如果
// pattern 中的每个字符都被它映射到的字符串替换，那么最终的字符串则为 s 。双射 意味着映射双方一一对应，不会存在两个字符映射到同一个字符串，也不会
//存在一个字符分别映射到两个不同的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：pattern = "abab", s = "redblueredblue"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "red"
//'b' -> "blue" 
//
// 示例 2： 
//
// 
//输入：pattern = "aaaa", s = "asdasdasdasd"
//输出：true
//解释：一种可能的映射如下：
//'a' -> "asd"
// 
//
// 示例 3： 
//
// 
//输入：pattern = "aabb", s = "xyzabcxzyabc"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pattern.length, s.length <= 20 
// pattern 和 s 由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 92 👎 0


package cn.db117.leetcode.solution2;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 291.单词规律 II.word-pattern-ii
 *
 * @author db117
 * @since 2022-12-21 14:03:42
 **/

public class Solution_291 {
    public static void main(String[] args) {
        Solution solution = new Solution_291().new Solution();
        // "abab"
        //			"redblueredblue"

//        System.out.println(solution.wordPatternMatch("abab", "redblueredblue"));

        // "aba"
        //"aaaa"
        System.out.println(solution.wordPatternMatch("aba", "aaaa"));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[] chars;
        String s;

        public boolean wordPatternMatch(String pattern, String s) {
            chars = pattern.toCharArray();
            this.s = s;
            return dfs(0, 0, new TreeMap<>(), new HashSet<>());
        }

        private boolean dfs(int pi, int si, Map<Character, String> map, Set<String> set) {
            if (pi == chars.length) {
                return si == s.length();
            }

            // 第一次匹配
            if (!map.containsKey(chars[pi])) {
                for (int i = si + 1; i <= s.length(); i++) {
                    String cur = s.substring(si, i);
                    if (!set.add(cur)) {
                        // 当前字符串已经匹配过
                        continue;
                    }
                    map.put(chars[pi], cur);
                    if (dfs(pi + 1, i, map, set)) {
                        return true;
                    }
                    // 回朔
                    map.remove(chars[pi]);
                    set.remove(cur);
                }
            } else {
                // 不是第一次匹配
                String cur = map.get(chars[pi]);
                if (si + cur.length() > s.length()) {
                    return false;
                }
                // 当前子字符串匹配
                if (s.startsWith(cur, si)) {
                    return dfs(pi + 1, si + cur.length(), map, set);
                }
                return false;
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}