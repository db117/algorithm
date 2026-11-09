

//给你两个长度相同的字符串 s1 和 s2。 
//
// 不匹配片段 是一个 极大连续 下标区间，其中每个下标处 s1 和 s2 的字符都不相同。 
//
// 返回一个二维数组，其中包含每个不匹配片段对应的 [sub1, sub2]，sub1 和 sub2 分别是 s1 和 s2 中对应的 子字符串。请按片段起始
//下标的 递增 顺序返回。如果没有不匹配片段，则返回一个空数组。 
//
// 子字符串 是字符串中一个连续的 非空 字符序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s1 = "earth", s2 = "empty" 
// 
//
// 输出： [["ar","mp"],["h","y"]] 
//
// 解释： 
//
// 
// 下标 1 和 2 处的字符不同，形成不匹配片段 ["ar","mp"]。 
// 下标 4 处的字符不同，形成不匹配片段 ["h","y"]。 
// 
//
//
// 示例 2： 
//
// 
// 输入： s1 = "action", s2 = "nation" 
// 
//
// 输出： [["ac","na"]] 
//
// 解释： 
//
// 下标 0 和 1 处的字符不同，形成不匹配片段 ["ac","na"]。两个字符串中其余位置的字符均相同。 
//
//
// 示例 3： 
//
// 
// 输入： s1 = "hot", s2 = "hot" 
// 
//
// 输出： [] 
//
// 解释： 
//
// 两个字符串完全相同，因此没有不匹配片段。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length == s2.length <= 100 
// s1 和 s2 仅由小写英文字母组成。 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution41;

import java.util.ArrayList;
import java.util.List;

/**
 * 4106.找出两个字符串的不匹配片段.find-mismatched-segments-between-two-strings
 *
 * @author db117
 * @since 2026-11-09 22:18:15
 **/

public class Solution_4106 {
    public static void main(String[] args) {
        Solution solution = new Solution_4106().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findMismatchedSegments(String s1, String s2) {
            int n = s1.length();
            List<List<String>> ans = new ArrayList<>();
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    sb1.append(s1.charAt(i));
                    sb2.append(s2.charAt(i));
                } else {
                    if (!sb1.isEmpty()) {
                        ans.add(new ArrayList<>(List.of(sb1.toString(), sb2.toString())));
                        sb1.setLength(0);
                        sb2.setLength(0);
                    }
                }
            }

            if (!sb1.isEmpty()) {
                ans.add(new ArrayList<>(List.of(sb1.toString(), sb2.toString())));
                sb1.setLength(0);
                sb2.setLength(0);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}