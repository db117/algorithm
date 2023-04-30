

//给你一个下标从 0 开始的 正 整数数组 nums 。你可以对数组执行以下操作 任意 次： 
//
// 
// 选择一个满足 0 <= i < n - 1 的下标 i ，将 nums[i] 或者 nums[i+1] 两者之一替换成它们的最大公约数。 
// 
//
// 请你返回使数组 nums 中所有元素都等于 1 的 最少 操作次数。如果无法让数组全部变成 1 ，请你返回 -1 。 
//
// 两个正整数的最大公约数指的是能整除这两个数的最大正整数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,6,3,4]
//输出：4
//解释：我们可以执行以下操作：
//- 选择下标 i = 2 ，将 nums[2] 替换为 gcd(3,4) = 1 ，得到 nums = [2,6,1,4] 。
//- 选择下标 i = 1 ，将 nums[1] 替换为 gcd(6,1) = 1 ，得到 nums = [2,1,1,4] 。
//- 选择下标 i = 0 ，将 nums[0] 替换为 gcd(2,1) = 1 ，得到 nums = [1,1,1,4] 。
//- 选择下标 i = 2 ，将 nums[3] 替换为 gcd(1,4) = 1 ，得到 nums = [1,1,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,10,6,14]
//输出：-1
//解释：无法将所有元素都变成 1 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 50 
// 1 <= nums[i] <= 10⁶ 
// 
//
// 👍 11 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2654.使数组所有元素变成 1 的最少操作次数.minimum-number-of-operations-to-make-all-array-elements-equal-to-1
 *
 * @author db117
 * @since 2023-04-25 10:36:28
 **/

public class Solution_2654 {
    public static void main(String[] args) {
        Solution solution = new Solution_2654().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int n = nums.length;
            int allGcd = 0, cnt1 = 0;
            for (int num : nums) {
                allGcd = gcd(num, allGcd);
                if (num == 1) {
                    cnt1++;
                }
            }
            if (allGcd != 1) {
                // 只有能搞出 1 才能完成
                return -1;
            }
            if (cnt1 > 0) {
                // 如果有 1 ，则把 1 扩散到全部就行。即 n - （1 的数量）
                return n - cnt1;
            }

            int ans = Integer.MAX_VALUE;

            // 如果没有 1 ，则需要找到生成 1  的最短子数组
            for (int i = 0; i < n; i++) {
                int g = 0;
                for (int j = i; j < n; j++) {
                    g = gcd(nums[j], g);
                    if (g == 1) {
                        // 当前区间数量
                        int range = j - i + 1;
                        ans = Math.min(ans, n + range - 2);
                        break;
                    }
                }
            }
            return ans;
        }

        private int gcd(int a, int b) {
            if (a == 0) {
                return b;
            }
            return gcd(b % a, a);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}