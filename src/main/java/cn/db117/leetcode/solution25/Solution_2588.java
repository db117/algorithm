

//给你一个下标从 0 开始的整数数组nums 。每次操作中，你可以： 
//
// 
// 选择两个满足 0 <= i, j < nums.length 的不同下标 i 和 j 。 
// 选择一个非负整数 k ，满足 nums[i] 和 nums[j] 在二进制下的第 k 位（下标编号从 0 开始）是 1 。 
// 将 nums[i] 和 nums[j] 都减去 2ᵏ 。 
// 
//
// 如果一个子数组内执行上述操作若干次后，该子数组可以变成一个全为 0 的数组，那么我们称它是一个 美丽 的子数组。 
//
// 请你返回数组 nums 中 美丽子数组 的数目。 
//
// 子数组是一个数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,1,2,4]
//输出：2
//解释：nums 中有 2 个美丽子数组：[4,3,1,2,4] 和 [4,3,1,2,4] 。
//- 按照下述步骤，我们可以将子数组 [3,1,2] 中所有元素变成 0 ：
//  - 选择 [3, 1, 2] 和 k = 1 。将 2 个数字都减去 2¹ ，子数组变成 [1, 1, 0] 。
//  - 选择 [1, 1, 0] 和 k = 0 。将 2 个数字都减去 2⁰ ，子数组变成 [0, 0, 0] 。
//- 按照下述步骤，我们可以将子数组 [4,3,1,2,4] 中所有元素变成 0 ：
//  - 选择 [4, 3, 1, 2, 4] 和 k = 2 。将 2 个数字都减去 2² ，子数组变成 [0, 3, 1, 2, 0] 。
//  - 选择 [0, 3, 1, 2, 0] 和 k = 0 。将 2 个数字都减去 2⁰ ，子数组变成 [0, 2, 0, 2, 0] 。
//  - 选择 [0, 2, 0, 2, 0] 和 k = 1 。将 2 个数字都减去 2¹ ，子数组变成 [0, 0, 0, 0, 0] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,4]
//输出：0
//解释：nums 中没有任何美丽子数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 哈希表 前缀和 👍 20 👎 0


package cn.db117.leetcode.solution25;

import java.util.HashMap;
import java.util.Map;

/**
 * 2588.统计美丽子数组数目.count-the-number-of-beautiful-subarrays
 *
 * @author db117
 * @since 2023-03-14 15:00:54
 **/

public class Solution_2588 {
    public static void main(String[] args) {
        Solution solution = new Solution_2588().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long beautifulSubarrays(int[] nums) {
            long ans = 0;
            int n = nums.length;
            // 一个子数组是美丽数组，则每一个 bit 位的和肯定是偶数，那么直接用前缀异或和记录当前位置出现的 bit 数量奇偶性
            // 前缀异或和
            int[] xor = new int[n + 1];
            for (int i = 0; i < n; i++) {
                xor[i + 1] = xor[i] ^ nums[i];
            }
            // 前面当前数字出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : xor) {
                // 前面有多少个异或和 和当前形同，则可以组成多少个美丽数组
                ans += map.getOrDefault(i, 0);
                map.merge(i, 1, Integer::sum);// 累加
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}