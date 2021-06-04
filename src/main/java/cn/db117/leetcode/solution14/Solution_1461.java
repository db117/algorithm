// 给你一个二进制字符串 s 和一个整数 k 。
//
// 如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "00110110", k = 2
//输出：true
//解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
// 
//
// 示例 2： 
//
// 
//输入：s = "00110", k = 2
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "0110", k = 1
//输出：true
//解释：长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
// 
//
// 示例 4： 
//
// 
//输入：s = "0110", k = 2
//输出：false
//解释：长度为 2 的二进制串 "00" 没有出现在 s 中。
// 
//
// 示例 5： 
//
// 
//输入：s = "0000000001011100", k = 4
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 105 
// s[i] 不是'0' 就是 '1' 
// 1 <= k <= 20 
// 
// Related Topics 位运算 字符串 
// 👍 25 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1461.检查一个字符串是否包含所有长度为 K 的二进制子串.check-if-a-string-contains-all-binary-codes-of-size-k
 *
 * @author db117
 * @since 2021-06-04 15:01:47
 **/

public class Solution_1461 {
    public static void main(String[] args) {
        Solution solution = new Solution_1461().new Solution();
        // "10010111100001110010"
        //5
        System.out.println(solution.hasAllCodes("10010111100001110010", 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean hasAllCodes(String s, int k) {
            if (s.length() < k) {
                return false;
            }
            // 全部可能的数字
            int total = 1 << k;
            int mask = total - 1;

            // 保存是否已经存在
            int[] flag = new int[total];

            // 初始数字
            int num = Integer.parseInt(s.substring(0, k), 2);
            flag[num]++;

            char[] chars = s.toCharArray();

            // 已经出现的数量
            int count = 1;
            for (int i = k; i < chars.length; i++) {
                num <<= 1;
                if (chars[i] == '1') {
                    num++;
                }
                // 消除高位
                num &= mask;

                // 标记
                if (flag[num] == 0) {
                    count++;
                }
                flag[num]++;
            }


            return count == total;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}