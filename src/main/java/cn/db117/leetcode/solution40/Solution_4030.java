

//给你一个由小写英文字母组成的字符串 s。 
//
// 将 s 中的每个字符替换为其 ASCII 值对应的 8 位二进制表示，包括前导零，并保持字符原有顺序，从而构造一个二进制字符串。 
//
// 如果得到的二进制字符串是一个 回文串 ，则返回 true；否则返回 false。 
//
// 二进制字符串 是指仅由字符 '0' 和 '1' 组成的字符串。 
//
// 回文串 是指正着读和反着读都相同的字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "ff" 
// 
//
// 输出： true 
//
// 解释： 
//
// 
// 字符 f 的 ASCII 值为 102，其 8 位二进制表示为 01100110。 
// 因此，得到的二进制字符串为 0110011001100110。 
// 由于该二进制字符串是一个 回文串 ，因此输出为 true。 
// 
//
//
// 示例 2： 
//
// 
// 输入： s = "leet" 
// 
//
// 输出： false 
//
// 解释： 
//
// 
// 字符 l、e、e 和 t 的 ASCII 值分别为 108、101、101 和 116 。 
// 它们对应的 8 位二进制表示分别为 01101100、01100101、01100101 和 01110100。 
// 因此，得到的二进制字符串为 01101100011001010110010101110100。 
// 由于该二进制字符串不是一个 回文串 ，因此输出为 false。 
// 
//
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 100 
// s 仅由小写英文字母组成。 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution40;

/**
 * 4030.判断 ASCII 值回文.check-ascii-palindromic
 *
 * @author db117
 * @since 2026-08-23 16:59:27
 **/

public class Solution_4030 {
    public static void main(String[] args) {
        Solution solution = new Solution_4030().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindromic(String s) {
            StringBuilder sb = new StringBuilder();
            for (byte b : s.getBytes()) {
                String binaryString = Integer.toBinaryString(b);
                int ramains = 8 - binaryString.length();
                sb.append("0".repeat(Math.max(0, ramains)));
                sb.append(binaryString);
            }
            return check(sb);
        }

        boolean check(StringBuilder sb) {
            int length = sb.length();
            for (int i = 0; i < length / 2; i++) {
                if (sb.charAt(i) != sb.charAt(length - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}