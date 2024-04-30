

//给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums ，对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 
//大于 nums[i] ，并且数组 nums 中所有元素的按位 AND 运算结果为 x 。 
//
// 返回 nums[n - 1] 可能的 最小 值。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 3, x = 4 
// 
//
// 输出：6 
//
// 解释： 
//
// 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。 
//
// 示例 2： 
//
// 
// 输入：n = 2, x = 7 
// 
//
// 输出：15 
//
// 解释： 
//
// 数组 nums 可以是 [7,15] ，最后一个元素为 15 。 
//
// 
//
// 提示： 
//
// 
// 1 <= n, x <= 10⁸ 
// 
//
// 👍 6 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3133.数组最后一个元素的最小值.minimum-array-end
 *
 * @author db117
 * @since 2024-04-30 11:04:57
 **/

public class Solution_3133 {
    public static void main(String[] args) {
        Solution solution = new Solution_3133().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minEnd(int n, int x) {
            // 把 n 的二进制插入到 x 的二进制（0）中
            char[] charsN = Integer.toBinaryString(n - 1).toCharArray();
            char[] charsX = Integer.toBinaryString(x).toCharArray();
            char[] ans = new char[64];
            for (int i = 0; i < charsX.length; i++) {
                ans[63 - i] = charsX[charsX.length - 1 - i];
            }

            int ni = charsN.length - 1;
            for (int i = 63; i >= 0; i--) {
                if (ans[i] == '1') {
                    continue;
                }
                ans[i] = charsN[ni];
                ni--;
                if (ni < 0) {
                    break;
                }
            }

            long res = 0;
            for (int i = 0; i < ans.length; i++) {
                if (ans[i] == '1') {
                    res |= 1L << (63 - i);
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}