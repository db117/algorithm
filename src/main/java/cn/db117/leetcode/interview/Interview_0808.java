


//有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。 
//
// 示例1: 
//
//  输入：S = "qqe"
// 输出：["eqq","qeq","qqe"]
// 
//
// 示例2: 
//
//  输入：S = "ab"
// 输出：["ab", "ba"]
// 
//
// 提示: 
//
// 
// 字符都是英文字母。 
// 字符串长度在[1, 9]之间。 
// 
// Related Topics 回溯算法 
// 👍 40 👎 0


package cn.db117.leetcode.interview;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.08.有重复字符串的排列组合.permutation-ii-lcci
 *
 * @author db117
 * @since 2021-05-28 16:27:09
 **/

public class Interview_0808 {
    public static void main(String[] args) {
        Solution solution = new Interview_0808().new Solution();

        System.out.println(Arrays.toString(solution.permutation("qqe")));
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