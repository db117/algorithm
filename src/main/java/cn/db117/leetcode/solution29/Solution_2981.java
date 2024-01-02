

//给你一个仅由小写英文字母组成的字符串 s 。 
//
// 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
//符串。 
//
// 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。 
//
// 子字符串 是字符串中的一个连续 非空 字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aaaa"
//输出：2
//解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
//可以证明最大长度是 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "abcdef"
//输出：-1
//解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
// 
//
// 示例 3： 
//
// 
//输入：s = "abcaba"
//输出：1
//解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
//可以证明最大长度是 1 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 50 
// s 仅由小写英文字母组成。 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution29;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 2981.找出出现至少三次的最长特殊子字符串 I.find-longest-special-substring-that-occurs-thrice-i
 *
 * @author db117
 * @since 2024-01-02 10:59:45
 **/

public class Solution_2981 {
    public static void main(String[] args) {
        Solution solution = new Solution_2981().new Solution();
        // eccdnmcnkl
        System.out.println(solution.maximumLength("eccdnmcnkl"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(String s) {
            int ans = 0;

            // 每个字符串连续出现的长度
            ArrayList<Integer>[] list = new ArrayList[26];
            Arrays.setAll(list, i -> new ArrayList<>());
            int n = s.length();
            int count = 0;
            for (int i = 0; i < n; i++) {
                count++;
                if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                    list[s.charAt(i) - 'a'].add(count);
                    count = 0;
                }
            }

            for (ArrayList<Integer> a : list) {
                if (a.isEmpty()) {
                    continue;
                }
                a.sort(Collections.reverseOrder());// 只需要前三个
                a.add(0);// 保底,防止少于 3
                a.add(0);

                // 一个字符串拆成 3 个
                ans = Math.max(ans, a.get(0) - 2);
                // 最长的可以拆成两个第二长的 + 第二长的
                // 如果最大,次大相等,则拆成 3个 max-1
                ans = Math.max(ans, Math.min(a.get(0) - 1, a.get(1)));
                // 都拆成第三长的
                ans = Math.max(ans, a.get(2));
            }
            return ans > 0 ? ans : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}