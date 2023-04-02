

//给你一个 正 整数 n 。 
//
// 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。 
//
// 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。 
//
// 返回整数数组 answer ，其中 answer = [even, odd] 。 
//
// 
//
// 示例 1： 
//
// 输入：n = 17
//输出：[2,0]
//解释：17 的二进制形式是 10001 。 
//下标 0 和 下标 4 对应的值为 1 。 
//共有 2 个偶数下标，0 个奇数下标。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：[0,1]
//解释：2 的二进制形式是 10 。 
//下标 1 对应的值为 1 。 
//共有 0 个偶数下标，1 个奇数下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1000 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2595.奇偶位数.number-of-even-and-odd-bits
 *
 * @author db117
 * @since 2023-03-20 11:08:27
 **/

public class Solution_2595 {
    public static void main(String[] args) {
        Solution solution = new Solution_2595().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] evenOddBit(int n) {
            String s = Integer.toBinaryString(n);
            int[] ans = new int[2];
            int count = s.length();
            for (int i = 0; i < count; i++) {
                if (s.charAt(count - 1 - i) == '1') {
                    ans[(i) % 2]++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}