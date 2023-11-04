

//给你一个下标从 0 开始的整数数组 nums 和一个 正 整数 k 。 
//
// 你可以对数组执行以下操作 任意次 ： 
//
// 
// 选择两个互不相同的下标 i 和 j ，同时 将 nums[i] 更新为 (nums[i] AND nums[j]) 且将 nums[j] 更新为 (
//nums[i] OR nums[j]) ，OR 表示按位 或 运算，AND 表示按位 与 运算。 
// 
//
// 你需要从最终的数组里选择 k 个元素，并计算它们的 平方 之和。 
//
// 请你返回你可以得到的 最大 平方和。 
//
// 由于答案可能会很大，将答案对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,6,5,8], k = 2
//输出：261
//解释：我们可以对数组执行以下操作：
//- 选择 i = 0 和 j = 3 ，同时将 nums[0] 变为 (2 AND 8) = 0 且 nums[3] 变为 (2 OR 8) = 10 ，结
//果数组为 nums = [0,6,5,10] 。
//- 选择 i = 2 和 j = 3 ，同时将 nums[2] 变为 (5 AND 10) = 0 且 nums[3] 变为 (5 OR 10) = 15 
//，结果数组为 nums = [0,6,0,15] 。
//从最终数组里选择元素 15 和 6 ，平方和为 15² + 6² = 261 。
//261 是可以得到的最大结果。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,4,7], k = 3
//输出：90
//解释：不需要执行任何操作。
//选择元素 7 ，5 和 4 ，平方和为 7² + 5² + 4² = 90 。
//90 是可以得到的最大结果。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 位运算 数组 哈希表 👍 10 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2897.对数组执行操作使平方和最大.apply-operations-on-array-to-maximize-sum-of-squares
 *
 * @author db117
 * @since 2023-10-19 16:24:51
 **/

public class Solution_2897 {
    public static void main(String[] args) {
        Solution solution = new Solution_2897().new Solution();
        // [2,6,5,8]
        //			2
        System.out.println(solution.maxSum(List.of(2, 6, 5, 8), 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int maxSum(List<Integer> nums, int k) {
            long ans = 0;
            //  nums[i] 更新为 (nums[i] AND nums[j]) 且将 nums[j] 更新为 (nums[i] OR nums[j])
            // 操作相当于将一个nums[i] 的 bit 尽量转到 nums[j] 上
            // 即在相同bit位上,如果有 1 个 1,那么会在 nums[j] 上,只有有 2 个 1 的时候 nums[i] 才为 1
            int[] count = new int[32];
            for (Integer num : nums) {
                for (int i = 0; i < 32; i++) {
                    if ((num & (1 << i)) != 0) {
                        count[i]++;
                    }
                }
            }

            // 组装 k 个数字,每个数字的 bit 位尽量多
            for (int i = 0; i < k; i++) {
                long cur = 0;
                for (int j = 0; j < 32; j++) {
                    if (count[j] > 0) {
                        cur |= 1 << j;
                        count[j]--;
                    }
                }
                ans += cur * cur;
                ans %= mod;
            }
            return (int) ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}