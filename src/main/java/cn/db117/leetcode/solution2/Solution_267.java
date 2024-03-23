

//给定一个字符串 s ，返回 其重新排列组合后可能构成的所有回文字符串，并去除重复的组合 。 
//
// 你可以按 任意顺序 返回答案。如果 s 不能形成任何回文排列时，则返回一个空列表。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "aabb"
//输出: ["abba", "baab"] 
//
// 示例 2： 
//
// 
//输入: s = "abc"
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 👍 120 👎 0


package cn.db117.leetcode.solution2;

import java.util.ArrayList;
import java.util.List;


/**
 * 267.回文排列 II.palindrome-permutation-ii
 *
 * @author db117
 * @since 2024-03-22 17:00:36
 **/

public class Solution_267 {
    public static void main(String[] args) {
        Solution solution = new Solution_267().new Solution();

        // aabb
        System.out.println(solution.generatePalindromes("aabb"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generatePalindromes(String s) {
            List<String> ans = new ArrayList<>();
            int[] count = new int[26];
            s.chars().forEach(c -> count[c - 'a']++);
            // 最多一个奇数的字符
            char oddChar = 0;
            for (int i = 0; i < 26; i++) {
                if (count[i] % 2 == 1) {
                    if (oddChar != 0) {
                        return ans;
                    }
                    oddChar = (char) (i + 'a');
                }
            }

            int n = s.length();
            // 回文的前半段
            char[] cur = new char[n / 2];
            int curIndex = 0;
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < count[i] / 2; j++) {
                    cur[curIndex++] = (char) (i + 'a');
                }
            }
            boolean[] visited = new boolean[n / 2];
            dfs(ans, cur, visited, new StringBuilder(), oddChar);
            return ans;
        }

        // 回溯
        private void dfs(List<String> ans, char[] cur, boolean[] visited, StringBuilder stringBuilder, char oddChar) {
            if (stringBuilder.length() == cur.length) {
                StringBuilder sb = new StringBuilder(stringBuilder);
                if (oddChar != 0) {
                    sb.append(oddChar);
                }
                // reverse
                for (int i = cur.length - 1; i >= 0; i--) {
                    sb.append(sb.charAt(i));
                }
                ans.add(sb.toString());
                return;
            }
            for (int i = 0; i < cur.length; i++) {
                // avoid duplicate
                if (visited[i] || (i > 0 && cur[i] == cur[i - 1] && !visited[i - 1])) {
                    continue;
                }
                visited[i] = true;
                stringBuilder.append(cur[i]);
                dfs(ans, cur, visited, stringBuilder, oddChar);
                visited[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}