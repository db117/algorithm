

//给你两个正整数 left 和 right ，请你找到两个整数 num1 和 num2 ，它们满足： 
//
// 
// left <= nums1 < nums2 <= right 。 
// nums1 和 nums2 都是 质数 。 
// nums2 - nums1 是满足上述条件的质数对中的 最小值 。 
// 
//
// 请你返回正整数数组 ans = [nums1, nums2] 。如果有多个整数对满足上述条件，请你返回 nums1 最小的质数对。如果不存在符合题意的质数
//对，请你返回 [-1, -1] 。 
//
// 如果一个整数大于 1 ，且只能被 1 和它自己整除，那么它是一个质数。 
//
// 
//
// 示例 1： 
//
// 
//输入：left = 10, right = 19
//输出：[11,13]
//解释：10 到 19 之间的质数为 11 ，13 ，17 和 19 。
//质数对的最小差值是 2 ，[11,13] 和 [17,19] 都可以得到最小差值。
//由于 11 比 17 小，我们返回第一个质数对。
// 
//
// 示例 2： 
//
// 
//输入：left = 4, right = 6
//输出：[-1,-1]
//解释：给定范围内只有一个质数，所以题目条件无法被满足。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= left <= right <= 10⁶ 
// 
//
// 👍 8 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2523.范围内最接近的两个质数.closest-prime-numbers-in-range
 *
 * @author db117
 * @date 2023-01-03 10:22:09
 **/

public class Solution_2523 {
    public static void main(String[] args) {
        Solution solution = new Solution_2523().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int mix = (int) 1e6;
        private final static int[] primes = new int[78500];

        // 线性筛（欧拉筛）
        static {
            // 标记是否是质数
            boolean[] np = new boolean[mix + 1];
            int pi = 0;
            for (int i = 2; i <= mix; ++i) {
                if (!np[i]) {
                    // 走到这还没有标记为合数,这为质数
                    primes[pi++] = i;
                }
                // 乘以比当前小的质数
                for (int j = 0; j < pi; ++j) {
                    int p = primes[j];
                    if (i * p > mix) {
                        break;
                    }
                    // 标记为质数
                    np[i * p] = true;
                    // 如果当前质数是当前数字的约数则后面的数字会重复
                    if (i % p == 0) {
                        break;
                    }
                }
            }
            primes[pi++] = mix + 1;
            primes[pi++] = mix + 1;
        }

        public int[] closestPrimes(int left, int right) {

            int[] ans = new int[]{Integer.MAX_VALUE / 2, Integer.MAX_VALUE};

            // 开始的位置
            int start = bsRightMin(primes, left);
            if (primes[start + 1] > right) {
                return new int[]{-1, -1};
            }
            // 找最小差
            for (int i = start; primes[i + 1] <= right; i++) {
                Integer i1 = primes[i];
                Integer i2 = primes[i + 1];
                if (i2 - i1 < ans[1] - ans[0]) {
                    ans = new int[]{i1, i2};
                }
            }
            return ans;
        }

        public int bsRightMin(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                // 左边中位数
                int mid = left + ((right - left) >> 1);
                if (nums[mid] < target) {
                    // 移动左边界
                    // 上面选择左边中位数,所有加一
                    left = mid + 1;
                } else {
                    // 大于等于则保持右边界
                    // 等于则继续往左边查找
                    right = mid;
                }
            }

            // 需要判断是否找到
            return nums[right] >= target ? right : -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}