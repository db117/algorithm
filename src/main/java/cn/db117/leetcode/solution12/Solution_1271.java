

//你有一个十进制数字，请按照此规则将它变成「十六进制魔术数字」：首先将它变成字母大写的十六进制字符串，然后将所有的数字 0 变成字母 O ，将数字 1 变成字
//母 I 。 
//
// 如果一个数字在转换后只包含 {"A", "B", "C", "D", "E", "F", "I", "O"} ，那么我们就认为这个转换是有效的。 
//
// 给你一个字符串 num ，它表示一个十进制数 N，如果它的十六进制魔术数字转换是有效的，请返回转换后的结果，否则返回 "ERROR" 。 
//
// 
//
// 示例 1： 
//
// 输入：num = "257"
//输出："IOI"
//解释：257 的十六进制表示是 101 。
// 
//
// 示例 2： 
//
// 输入：num = "3"
//输出："ERROR"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^12 
// 给定字符串不会有前导 0 。 
// 结果中的所有字母都应该是大写字母。 
// 
// Related Topics 数学 字符串 👍 10 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1271.十六进制魔术数字.hexspeak
 *
 * @author db117
 * @since 2022-05-27 17:28:45
 **/

public class Solution_1271 {
    public static void main(String[] args) {
        Solution solution = new Solution_1271().new Solution();
        System.out.println(solution.toHexspeak("257"));
        System.out.println(solution.toHexspeak("6"));
        System.out.println(solution.toHexspeak("619879596177"));
        System.out.println(solution.toHexspeak("747823223228"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String toHexspeak(String num) {
            char[] chars = Long.toHexString(Long.parseLong(num)).toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                if (c > '1' && c <= '9') {
                    return "ERROR";
                }
                if (c == '1') {
                    chars[i] = 'I';
                } else if (c == '0') {
                    chars[i] = 'O';
                } else {
                    // 小写字母转大写
                    chars[i] = (char) (c ^ 32);
                }
            }
            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}