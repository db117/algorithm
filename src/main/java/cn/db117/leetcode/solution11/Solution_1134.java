

//给你一个整数 n ，让你来判定他是否是 阿姆斯特朗数，是则返回 true，不是则返回 false。 
//
// 假设存在一个 k 位数 n ，其每一位上的数字的 k 次幂的总和也是 n ，那么这个数是阿姆斯特朗数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 153
//输出：true
//示例： 
//153 是一个 3 位数，且 153 = 1³ + 5³ + 3³。
// 
//
// 示例 2： 
//
// 
//输入：n = 123
//输出：false
//解释：123 是一个 3 位数，且 123 != 1³ + 2³ + 3³ = 36。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁸ 
// 
// Related Topics 数学 👍 9 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1134.阿姆斯特朗数.armstrong-number
 *
 * @author db117
 * @since 2022-05-20 11:05:02
 **/

public class Solution_1134 {
    public static void main(String[] args) {
        Solution solution = new Solution_1134().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isArmstrong(int n) {
            String s = Integer.toString(n);
            int len = s.length();
            int sum = 0;
            for (char c : s.toCharArray()) {
                int num = c - '0';
                sum += Math.pow(num, len);
            }

            return sum == n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}