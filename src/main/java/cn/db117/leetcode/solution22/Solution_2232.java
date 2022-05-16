

//给你一个下标从 0 开始的字符串 expression ，格式为 "<num1>+<num2>" ，其中 <num1> 和 <num2> 表示正整数。 
//
// 请你向 expression 中添加一对括号，使得在添加之后， expression 仍然是一个有效的数学表达式，并且计算后可以得到 最小 可能值。左括号
// 必须 添加在 '+' 的左侧，而右括号必须添加在 '+' 的右侧。 
//
// 返回添加一对括号后形成的表达式 expression ，且满足 expression 计算得到 最小 可能值。如果存在多个答案都能产生相同结果，返回任意一
//个答案。 
//
// 生成的输入满足：expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围。 
//
// 
//
// 示例 1： 
//
// 输入：expression = "247+38"
//输出："2(47+38)"
//解释：表达式计算得到 2 * (47 + 38) = 2 * 85 = 170 。
//注意 "2(4)7+38" 不是有效的结果，因为右括号必须添加在 '+' 的右侧。
//可以证明 170 是最小可能值。
// 
//
// 示例 2： 
//
// 输入：expression = "12+34"
//输出："1(2+3)4"
//解释：表达式计算得到 1 * (2 + 3) * 4 = 1 * 5 * 4 = 20 。
// 
//
// 示例 3： 
//
// 输入：expression = "999+999"
//输出："(999+999)"
//解释：表达式计算得到 999 + 999 = 1998 。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= expression.length <= 10 
// expression 仅由数字 '1' 到 '9' 和 '+' 组成 
// expression 由数字开始和结束 
// expression 恰好仅含有一个 '+'. 
// expression 的原始值和添加满足要求的任一对括号之后 expression 的值，都符合 32-bit 带符号整数范围 
// 
// 👍 7 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2232.向表达式添加括号后的最小结果.minimize-result-by-adding-parentheses-to-expression
 *
 * @author db117
 * @since 2022-04-12 15:29:45
 **/

public class Solution_2232 {
    public static void main(String[] args) {
        Solution solution = new Solution_2232().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minimizeResult(String expression) {
            // 暴力枚举
            String[] split = expression.split("\\+");
            String ans = expression;
            int min = Integer.MAX_VALUE;
            String left = split[0];
            String right = split[1];
            for (int i = 0; i < left.length(); i++) {
                String left0 = left.substring(0, i);
                String left1 = left.substring(i);
                int l0 = left0.isBlank() ? 1 : Integer.parseInt(left0);
                int l1 = left1.isBlank() ? 1 : Integer.parseInt(left1);

                for (int j = 1; j <= right.length(); j++) {
                    String right0 = right.substring(0, j);
                    String right1 = right.substring(j);
                    int r0 = right0.isBlank() ? 1 : Integer.parseInt(right0);
                    int r1 = right1.isBlank() ? 1 : Integer.parseInt(right1);

                    int cur = (l1 + r0) * l0 * r1;
                    if (cur < min) {
                        ans = left0 + "(" + left1 + "+" + right0 + ")" + right1;
                        min = cur;
                    }

                }
            }

            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}