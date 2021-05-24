//给你一个字符串 s ，请你拆分该字符串，并返回拆分后唯一子字符串的最大数目。
//
// 字符串 s 拆分后可以得到若干 非空子字符串 ，这些子字符串连接后应当能够还原为原字符串。但是拆分出来的每个子字符串都必须是 唯一的 。 
//
// 注意：子字符串 是字符串中的一个连续字符序列。 
//
// 
//
// 示例 1： 
//
// 输入：s = "ababccc"
//输出：5
//解释：一种最大拆分方法为 ['a', 'b', 'ab', 'c', 'cc'] 。像 ['a', 'b', 'a', 'b', 'c', 'cc'] 这样
//拆分不满足题目要求，因为其中的 'a' 和 'b' 都出现了不止一次。
// 
//
// 示例 2： 
//
// 输入：s = "aba"
//输出：2
//解释：一种最大拆分方法为 ['a', 'ba'] 。
// 
//
// 示例 3： 
//
// 输入：s = "aa"
//输出：1
//解释：无法进一步拆分字符串。
// 
//
// 
//
// 提示： 
//
// 
// 
// 1 <= s.length <= 16 
// 
// 
// s 仅包含小写英文字母 
// 
// 
// Related Topics 回溯算法 
// 👍 26 👎 0


package cn.db117.leetcode.solution15;

import java.util.HashSet;
import java.util.Set;

/**
 * 1593.拆分字符串使唯一子字符串的数目最大.split-a-string-into-the-max-number-of-unique-substrings
 *
 * @author db117
 * @since 2021-05-24 15:22:25
 **/

public class Solution_1593 {
    public static void main(String[] args) {
        Solution solution = new Solution_1593().new Solution();
        System.out.println(solution.maxUniqueSplit("ababccc"));
        System.out.println(solution.maxUniqueSplit("aba"));
        System.out.println(solution.maxUniqueSplit("aa"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maxUniqueSplit(String s) {
            int[] max = new int[1];
            dfs(new HashSet<>(), s.toCharArray(), 0, max);
            return max[0];
        }

        private void dfs(Set<String> set, char[] chars, int index, int[] max) {
            if (index >= chars.length) {
                // 字符都分完了
                max[0] = Math.max(max[0], set.size());
                return;
            }
            if (chars.length - index + set.size() <= max[0]) {
                // 当后面全部都拆除一个字符还比当前最大值小,就没有必要继续了
                return;
            }

            StringBuilder b = new StringBuilder();
            for (int i = index; i < chars.length; i++) {
                b.append(chars[i]);

                String s = b.toString();
                if (set.contains(s)) {
                    continue;
                }

                set.add(s);

                dfs(set, chars, i + 1, max);

                // 回溯
                set.remove(s);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}