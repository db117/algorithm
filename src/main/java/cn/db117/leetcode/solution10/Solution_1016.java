

//给定一个二进制字符串 s 和一个正整数 n，如果对于 [1, n] 范围内的每个整数，其二进制表示都是 s 的 子字符串 ，就返回 true，否则返回 
//false 。 
//
// 子字符串 是字符串中连续的字符序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "0110", n = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "0110", n = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 不是 '0' 就是 '1' 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 字符串 👍 46 👎 0


package cn.db117.leetcode.solution10;

/**
 * 1016.子串能表示从 1 到 N 数字的二进制串.binary-string-with-substrings-representing-1-to-n
 *
 * @author db117
 * @since 2023-05-10 17:44:06
 **/

public class Solution_1016 {
    public static void main(String[] args) {
        Solution solution = new Solution_1016().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean queryString(String s, int n) {
            // 如果二进制比较长的存在，那么短的肯定存在
            // 如果 [100000 , 111111] 存在，那么[0,100000] 也肯定存在
            int end = n >> 2;
            for (int i = n; i > end; i--) {
                String bs = Integer.toBinaryString(i);
                if (!s.contains(bs)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}