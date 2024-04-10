

//给你一个二进制字符串 binary ，它仅有 0 或者 1 组成。你可以使用下面的操作任意次对它进行修改： 
//
// 
// 操作 1 ：如果二进制串包含子字符串 "00" ，你可以用 "10" 将其替换。 
// 
//
// 
// 比方说， "00010" -> "10010" 
// 
// 
// 操作 2 ：如果二进制串包含子字符串 "10" ，你可以用 "01" 将其替换。
// 
// 比方说， "00010" -> "00001" 
// 
// 
//
//
// 请你返回执行上述操作任意次以后能得到的 最大二进制字符串 。如果二进制字符串 x 对应的十进制数字大于二进制字符串 y 对应的十进制数字，那么我们称二进制
//字符串 x 大于二进制字符串 y 。 
//
// 
//
// 示例 1： 
//
// 
//输入：binary = "000110"
//输出："111011"
//解释：一个可行的转换为：
//"000110" -> "000101" 
//"000101" -> "100101" 
//"100101" -> "110101" 
//"110101" -> "110011" 
//"110011" -> "111011"
// 
//
// 示例 2： 
//
// 
//输入：binary = "01"
//输出："01"
//解释："01" 没办法进行任何转换。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= binary.length <= 10⁵ 
// binary 仅包含 '0' 和 '1' 。 
// 
//
// Related Topics 贪心 字符串 👍 67 👎 0


package cn.db117.leetcode.solution17;

/**
 * 1702.修改后的最大二进制字符串.maximum-binary-string-after-change
 *
 * @author db117
 * @since 2024-04-10 15:32:25
 **/

public class Solution_1702 {
    public static void main(String[] args) {
        Solution solution = new Solution_1702().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String maximumBinaryString(String binary) {
            char[] chars = binary.toCharArray();
            int n = chars.length;

            int count1 = 0;
            int count0 = 0;
            int countFirst1 = 0;
            for (char aChar : chars) {
                if (count0 == 0 && aChar == '1') {
                    countFirst1++;
                    continue;
                }
                if (aChar == '0') {
                    count0++;
                } else {
                    count1++;
                }
            }
            // 原来就在最左边的 1 不动
            // 原来的 1 全放到最右边
            // 原来的 0 全放到最右边，但是要留一个 0
            if (count0 == 0) {
                return binary;
            }

            return "1".repeat(countFirst1) +
                    "1".repeat(Math.max(0, count0 - 1)) +
                    "0" +
                    "1".repeat(count1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}