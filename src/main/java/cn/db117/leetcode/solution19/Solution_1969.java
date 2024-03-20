

//给你一个正整数 p 。你有一个下标从 1 开始的数组 nums ，这个数组包含范围 [1, 2ᵖ - 1] 内所有整数的二进制形式（两端都 包含）。你可以进
//行以下操作 任意 次： 
//
// 
// 从 nums 中选择两个元素 x 和 y 。 
// 选择 x 中的一位与 y 对应位置的位交换。对应位置指的是两个整数 相同位置 的二进制位。 
// 
//
// 比方说，如果 x = 1101 且 y = 0011 ，交换右边数起第 2 位后，我们得到 x = 1111 和 y = 0001 。 
//
// 请你算出进行以上操作 任意次 以后，nums 能得到的 最小非零 乘积。将乘积对 10⁹ + 7 取余 后返回。 
//
// 注意：答案应为取余 之前 的最小值。 
//
// 
//
// 示例 1： 
//
// 
//输入：p = 1
//输出：1
//解释：nums = [1] 。
//只有一个元素，所以乘积为该元素。
// 
//
// 示例 2： 
//
// 
//输入：p = 2
//输出：6
//解释：nums = [01, 10, 11] 。
//所有交换要么使乘积变为 0 ，要么乘积与初始乘积相同。
//所以，数组乘积 1 * 2 * 3 = 6 已经是最小值。
// 
//
// 示例 3： 
//
// 
//输入：p = 3
//输出：1512
//解释：nums = [001, 010, 011, 100, 101, 110, 111]
//- 第一次操作中，我们交换第二个和第五个元素最左边的数位。
//    - 结果数组为 [001, 110, 011, 100, 001, 110, 111] 。
//- 第二次操作中，我们交换第三个和第四个元素中间的数位。
//    - 结果数组为 [001, 110, 001, 110, 001, 110, 111] 。
//数组乘积 1 * 6 * 1 * 6 * 1 * 6 * 7 = 1512 是最小乘积。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= p <= 60 
// 
//
// Related Topics 贪心 递归 数学 👍 53 👎 0


package cn.db117.leetcode.solution19;

/**
 * 1969.数组元素的最小非零乘积.minimum-non-zero-product-of-the-array-elements
 *
 * @author db117
 * @since 2024-03-20 11:11:41
 **/

public class Solution_1969 {
    public static void main(String[] args) {
        Solution solution = new Solution_1969().new Solution();
        // 5 202795991
        System.out.println(solution.minNonZeroProduct(5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int MOD = (int) (1e9 + 7);

        public int minNonZeroProduct(int p) {
            if (p == 1) {
                return 1;
            }
            int ans = 0;
            // 把某些数字搞成1
            // 那么就会分成两部分,一部分是1,一部分是2^p-1-1(111110)
            // 1的个数为2^(p-1)-1
            // 2^p-1-1的个数为2^(p-1)
            // 在加上一个 2^p-1

            // 2^p-1
            // 最大的数字,不为 1 的数字的数量
            long n = (1L << p) - 1;
            // 2^p-1-1  不为 1 的值
            long midValue = n - 1;
            // 2^(p-1)-1 不为 1 的值的数量
            long midCount = (1L << (p - 1)) - 1;
            return (int) (n % MOD * quickPow(midValue, midCount) % MOD);
        }

        public long quickPow(long x, long n) {
            x %= MOD;
            long res = 1L;
            while (n > 0) {
                if ((n & 1) != 0) {
                    // 如果为奇数
                    res = (res * x) % MOD;
                }
                x = (x * x) % MOD;
                n >>= 1;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}