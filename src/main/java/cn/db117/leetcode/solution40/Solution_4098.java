

//给你三个整数 n、index 和 value。 
//
// 如果长度为 n 的整数数组 nums 满足以下条件，则称其为 GCD 连通数组： 
//
// 
// 对于 0 <= i <= n - 1，有 nums[i] > 0。 
// 对于 0 <= i <= n - 2，有 nums[i] < nums[i + 1]。 
// nums[index] = value。 
// 对于 0 <= i <= n - 2，有 gcd(nums[i], nums[i + 1]) > 1。 
// 
//
// 在所有 GCD 连通数组 nums 中，返回最大元素 nums[n - 1] 可能的最小值。如果不存在这样的数组，返回 -1。 
//其中，gcd(a, b) 表示 a 和 b 的最大公约数。
//
// 
//
// 示例 1： 
//
// 
// 输入： n = 4, index = 2, value = 8 
// 
//
// 输出： 10 
//
// 解释： 
//
// 
// 由于 nums[2] = 8，GCD 连通数组的形式为：nums = [?, ?, 8, ?]。 
// 由于 nums[3] > 8 且 gcd(8, 9) = 1，所有合法的 GCD 连通数组都必须满足 nums[3] >= 10。 
// 一个满足所有条件的最优数组是 [2, 4, 8, 10]。 
// 因此，nums[3] 可能的最小值为 10。 
// 
//
//
// 示例 2： 
//
// 
// 输入： n = 2, index = 1, value = 3 
// 
//
// 输出： -1 
//
// 解释： 
//
// 
// 由于 nums[1] = 3，GCD 连通数组的形式为：nums = [?, 3]。 
// 由于需要满足 0 < nums[0] < nums[1] = 3，只有两个可能的数组：[1, 3] 和 [2, 3]。它们都不满足 gcd(nums[0]
//, nums[1]) > 1。 
// 因此，不存在合法的 GCD 连通数组，答案为 -1。 
// 
//
//
// 示例 3： 
//
// 
// 输入： n = 2, index = 0, value = 3 
// 
//
// 输出： 6 
//
// 解释： 
//
// 
// 由于 nums[0] = 3，GCD 连通数组的形式为：nums = [3, ?]。 
// 由于 nums[1] > 3 且 gcd(3, 4) = gcd(3, 5) = 1，所有合法的 GCD 连通数组都必须满足 nums[1] >= 6。 
//
// 一个最优数组是 [3, 6]。 
// 因此，nums[1] 可能的最小值为 6。 
// 
//
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 10⁹ 
// 1 <= value <= 10⁹ 
// 0 <= index <= n - 1 
// 
//
// 👍 1 👎 0


package cn.db117.leetcode.solution40;

/**
 * 4098.最小化 GCD 连通数组的最大值.minimize-the-maximum-value-of-gcd-connected-array
 *
 * @author db117
 * @since 2026-11-09 22:35:03
 **/

public class Solution_4098 {
    public static void main(String[] args) {
        Solution solution = new Solution_4098().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumMaxValue(int n, int index, int value) {
            if (value == 1) {
                return -1;
            }
            // 前面位置要够
            long downCount = downCount(value);
            if (downCount <= index) {
                return -1;
            }
            long ans = value;
            long minGcd = minGcd(value);
            while (index < n - 1/*后面位置要够*/ && minGcd != 2) {
                ans += minGcd;
                minGcd = minGcd(ans);
                index++;
            }

            return ans + (n - index - 1) * 2L;
        }

        // 最小公约数
        long minGcd(long n) {
            for (long i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return i;
                }
            }
            return n;
        }

        long downCount(long n) {
            if (n == 0) {
                return 0;
            }
            long minGcd = minGcd(n);
            // 偶数就直接都减2
            if (minGcd == 2) {
                return n / 2;
            }
            // 奇数处理完就变偶数了，然后+1
            return downCount(n - minGcd) + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}