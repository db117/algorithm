// 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
//
// 示例1: 
//
// 
// 输入：S = "qwe"
// 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
// 
//
// 示例2: 
//
// 
// 输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// wwy
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 47 👎 0


package cn.db117.leetcode.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.07.无重复字符串的排列组合.permutation-i-lcci
 *
 * @author db117
 * @since 2021-05-28 14:57:33
 **/

public class Interview_0807 {
    public static void main(String[] args) {
        Solution solution = new Interview_0807().new Solution();

        System.out.println(Arrays.toString(solution.permutation("qweabcdm")));
        System.out.println(Arrays.toString(solution.permutation("ab")));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String[] permutation(String S) {
            List<String> ans = new LinkedList<>();
            char[] chars = S.toCharArray();

            dfs(ans, chars, new char[chars.length], new boolean[chars.length], 0);

            return ans.toArray(new String[0]);
        }

        /**
         * dfs
         *
         * @param ans   结果集
         * @param chars 源字符串
         * @param cur   当前字符串
         * @param flag  标记是否使用过
         * @param index 当前字符串的位置
         */
        private void dfs(List<String> ans, char[] chars, char[] cur, boolean[] flag, int index) {
            if (index >= chars.length) {
                ans.add(new String(cur));
                return;
            }

            for (int i = 0; i < flag.length; i++) {
                if (flag[i]) {
                    continue;
                }

                cur[index] = chars[i];
                flag[i] = true;

                dfs(ans, chars, cur, flag, index + 1);

                // 回溯
                cur[index] = 0;
                flag[i] = false;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}