

//给你一个正整数 n ，你可以执行下述操作 任意 次： 
//
// 
// n 加上或减去 2 的某个 幂 
// 
//
// 返回使 n 等于 0 需要执行的 最少 操作数。 
//
// 如果 x == 2ⁱ 且其中 i >= 0 ，则数字 x 是 2 的幂。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 39
//输出：3
//解释：我们可以执行下述操作：
//- n 加上 2⁰ = 1 ，得到 n = 40 。
//- n 减去 2³ = 8 ，得到 n = 32 。
//- n 减去 2⁵ = 32 ，得到 n = 0 。
//可以证明使 n 等于 0 需要执行的最少操作数是 3 。
// 
//
// 示例 2： 
//
// 
//输入：n = 54
//输出：3
//解释：我们可以执行下述操作：
//- n 加上 2¹ = 2 ，得到 n = 56 。
//- n 加上 2³ = 8 ，得到 n = 64 。
//- n 减去 2⁶ = 64 ，得到 n = 0 。
//使 n 等于 0 需要执行的最少操作数是 3 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 
//
// 👍 18 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2571.将整数减少到零需要的最少操作数.minimum-operations-to-reduce-an-integer-to-0
 *
 * @author db117
 * @since 2023-02-21 14:43:14
 **/

public class Solution_2571 {
    public static void main(String[] args) {
        Solution solution = new Solution_2571().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int n) {
            // 连续多个 1 可以加上 lowBit 变成一个 1

            int ans = 1;
            while (Integer.bitCount(n) > 1) {// bit 数量大于 1
                int lowbit = n & -n;// 最后一个 bit
                if ((n & (lowbit << 1)) > 0) {// lowbit 左边一位也是 1
                    n += lowbit; // 合并多个 1
                } else {
                    n -= lowbit;// 只有一个 1 ,直接去掉
                }
                ans++;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}