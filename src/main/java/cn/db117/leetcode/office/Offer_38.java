// 输入一个字符串，打印出该字符串中字符的所有排列。
//
// 
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。 
//
// 
//
// 示例: 
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
// 
//
// 
//
// 限制： 
//
// 1 <= s 的长度 <= 8 
// Related Topics 回溯算法 
// 👍 279 👎 0


package cn.db117.leetcode.office;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 38.字符串的排列.zi-fu-chuan-de-pai-lie-lcof
 *
 * @author db117
 * @since 2021-05-28 17:09:32
 **/

public class Offer_38 {
    public static void main(String[] args) {
        Solution solution = new Offer_38().new Solution();
        System.out.println(Arrays.toString(solution.permutation("abc")));
        System.out.println(Arrays.toString(solution.permutation("abcaa")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String S) {
            List<String> ans = new LinkedList<>();
            char[] chars = S.toCharArray();

            dfs(ans, chars, new char[chars.length], new boolean[chars.length], 0);

            return ans.toArray(new String[0]);
        }

        private void dfs(List<String> ans, char[] chars, char[] cur, boolean[] flag, int index) {
            if (index == chars.length) {
                ans.add(new String(cur));
                return;
            }
            // 标记当前位置使用的字符
            boolean[] cFlag = new boolean[64];
            for (int i = 0; i < chars.length; i++) {
                if (flag[i]) {
                    continue;
                }

                int cIndex = chars[i] - 64;
                if (cFlag[cIndex]) {
                    // 当前位置已经使用过该字符,则跳过
                    continue;
                }
                cFlag[cIndex] = true;// 不需要重置

                flag[i] = true;
                cur[index] = chars[i];

                dfs(ans, chars, cur, flag, index + 1);

                // 重置
                flag[i] = false;
                cur[index] = 0;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}