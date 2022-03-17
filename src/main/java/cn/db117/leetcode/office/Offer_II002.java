


//给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。 
//
// 输入为 非空 字符串且只包含数字 1 和 0。 
//
// 
//
// 示例 1: 
//
// 
//输入: a = "11", b = "10"
//输出: "101" 
//
// 示例 2: 
//
// 
//输入: a = "1010", b = "1011"
//输出: "10101" 
//
// 
//
// 提示： 
//
// 
// 每个字符串仅由字符 '0' 或 '1' 组成。 
// 1 <= a.length, b.length <= 10^4 
// 字符串如果不是 "0" ，就都不含前导零。 
// 
//
// 
//
// 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/ 
// Related Topics 位运算 数学 字符串 模拟 👍 23 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer II 002.二进制加法.JFETK5
 *
 * @author db117
 * @since 2022-03-17 10:24:19
 **/

public class Offer_II002 {
    public static void main(String[] args) {
        Solution solution = new Offer_II002().new Solution();

        System.out.println(solution.addBinary("11", "10"));
        System.out.println(solution.addBinary("1010", "1011"));
        System.out.println(solution.addBinary("", ""));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String addBinary(String a, String b) {
            char[] charsA = a.toCharArray();
            char[] charsB = b.toCharArray();
            int lenA = charsA.length;
            int lenB = charsB.length;

            StringBuilder sb = new StringBuilder();
            int index = 0;
            int up = 0;// 进位
            while (index < lenA || index < lenB || up > 0) {
                int cur = up;
                if (index < lenA) {
                    cur += charsA[lenA - 1 - index] - '0';
                }
                if (index < lenB) {
                    cur += charsB[lenB - 1 - index] - '0';
                }

                index++;
                if (cur < 2) {
                    sb.append(cur);
                    up = 0;
                    continue;
                }

                // 进位
                up = 1;
                if (cur == 2) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
            }

            return sb.reverse().toString();
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}