

//给你一个下标从 0 开始的字符串 num ，表示一个非负整数。 
//
// 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。 
//
// 返回最少需要多少次操作可以使 num 变成特殊数字。 
//
// 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：num = "2245047"
//输出：2
//解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 2 位数字。 
//
// 示例 2： 
//
// 
//输入：num = "2908305"
//输出：3
//解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 3 位数字。 
//
// 示例 3： 
//
// 
//输入：num = "10"
//输出：1
//解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
// 
//
// 
//
// 提示 
//
// 
// 1 <= num.length <= 100 
// num 仅由数字 '0' 到 '9' 组成 
// num 不含任何前导零 
// 
//
// 👍 10 👎 0


package cn.db117.leetcode.solution28;

/**
 * 2844.生成特殊数字的最少操作.minimum-operations-to-make-a-special-number
 *
 * @author db117
 * @since 2023-09-04 17:09:26
 **/

public class Solution_2844 {
    public static void main(String[] args) {
        Solution solution = new Solution_2844().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumOperations(String num) {
            int ans = num.length();
            // 00 25 50 75
            char[] chars = num.toCharArray();
            ans = Math.min(ans, help(chars, new char[]{'0', '0'}));
            ans = Math.min(ans, help(chars, new char[]{'2', '5'}));
            ans = Math.min(ans, help(chars, new char[]{'5', '0'}));
            ans = Math.min(ans, help(chars, new char[]{'7', '5'}));

            // 只剩0
            long count = num.chars().filter(i -> i != '0').count();
            ans = Math.min(ans, (int) (count));
            return ans;
        }

        // 从后往前匹配,返回需要删除的数量
        public int help(char[] chars, char[] chars1) {
            int ans = 0;
            int i1 = chars.length - 1;
            int i2 = chars1.length - 1;
            while (i1 >= 0 && i2 >= 0) {
                if (chars[i1] == chars1[i2]) {
                    i1--;
                    i2--;
                } else {
                    i1--;
                    ans++;
                }
            }
            if (i2 >= 0) {
                // 没有匹配完
                return chars.length;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}