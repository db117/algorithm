

//给你一个非负整数 num ，返回它的「加密字符串」。 
//
// 加密的过程是把一个整数用某个未知函数进行转化，你需要从下表推测出该转化函数： 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：num = 23
//输出："1000"
// 
//
// 示例 2： 
//
// 输入：num = 107
//输出："101100"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= num <= 10^9 
// 
//
// Related Topics 位运算 数学 字符串 👍 19 👎 0


package cn.db117.leetcode.solution12;

/**
 * 1256.加密数字.encode-number
 *
 * @author db117
 * @since 2023-09-19 10:26:34
 **/

public class Solution_1256 {
    public static void main(String[] args) {
        Solution solution = new Solution_1256().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String encode(int num) {
            // n+1 的二进制 去掉第一位
            return Integer.toBinaryString(num + 1).substring(1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}