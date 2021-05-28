


// 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
//
// 说明：解集不能包含重复的子集。 
//
// 例如，给出 n = 3，生成结果为： 
//
// 
//[
//  "((()))",
//  "(()())",
//  "(())()",
//  "()(())",
//  "()()()"
//]
// 
// Related Topics 字符串 回溯算法 
// 👍 67 👎 0


package cn.db117.leetcode.interview;

import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.09.括号.bracket-lcci
 *
 * @author db117
 * @since 2021-05-28 14:47:13
 **/

public class Interview_0809 {
    public static void main(String[] args) {
        Solution solution = new Interview_0809().new Solution();
        System.out.println(solution.generateParenthesis(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> generateParenthesis(int n) {

            List<String> ans = new LinkedList<>();

            dfs(new StringBuilder(2 * n), ans, n, n);

            return ans;
        }

        public void dfs(StringBuilder cur, List<String> ans, int left, int right) {
            if (left == 0 && right == 0) {
                ans.add(cur.toString());
                return;
            }

            // 分别选左右
            if (left > 0) {
                cur.append('(');

                dfs(cur, ans, left - 1, right);

                // 回溯
                cur.deleteCharAt(cur.length() - 1);
            }

            if (right > left) {
                // 有括号需要合法
                cur.append(')');

                dfs(cur, ans, left, right - 1);

                // 回溯
                cur.deleteCharAt(cur.length() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}