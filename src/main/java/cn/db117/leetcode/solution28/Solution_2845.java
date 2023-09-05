

//给你一个下标从 0 开始的整数数组 nums ，以及整数 modulo 和整数 k 。 
//
// 请你找出并统计数组中 趣味子数组 的数目。 
//
// 如果 子数组 nums[l..r] 满足下述条件，则称其为 趣味子数组 ： 
//
// 
// 在范围 [l, r] 内，设 cnt 为满足 nums[i] % modulo == k 的索引 i 的数量。并且 cnt % modulo == k 。
// 
// 
//
// 以整数形式表示并返回趣味子数组的数目。 
//
// 注意：子数组是数组中的一个连续非空的元素序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,4], modulo = 2, k = 1
//输出：3
//解释：在这个示例中，趣味子数组分别是： 
//子数组 nums[0..0] ，也就是 [3] 。 
//- 在范围 [0, 0] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//子数组 nums[0..1] ，也就是 [3,2] 。
//- 在范围 [0, 1] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//子数组 nums[0..2] ，也就是 [3,2,4] 。
//- 在范围 [0, 2] 内，只存在 1 个下标 i = 0 满足 nums[i] % modulo == k 。
//- 因此 cnt = 1 ，且 cnt % modulo == k 。
//可以证明不存在其他趣味子数组。因此，答案为 3 。 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,9,6], modulo = 3, k = 0
//输出：2
//解释：在这个示例中，趣味子数组分别是： 
//子数组 nums[0..3] ，也就是 [3,1,9,6] 。
//- 在范围 [0, 3] 内，只存在 3 个下标 i = 0, 2, 3 满足 nums[i] % modulo == k 。
//- 因此 cnt = 3 ，且 cnt % modulo == k 。
//子数组 nums[1..1] ，也就是 [1] 。
//- 在范围 [1, 1] 内，不存在下标满足 nums[i] % modulo == k 。
//- 因此 cnt = 0 ，且 cnt % modulo == k 。
//可以证明不存在其他趣味子数组，因此答案为 2 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// 1 <= nums[i] <= 10⁹ 
// 1 <= modulo <= 10⁹ 
// 0 <= k < modulo 
// 
//
// 👍 16 👎 0


package cn.db117.leetcode.solution28;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 2845.统计趣味子数组的数目.count-of-interesting-subarrays
 *
 * @author db117
 * @since 2023-09-05 10:44:30
 **/

public class Solution_2845 {
    public static void main(String[] args) {
        Solution solution = new Solution_2845().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
            long ans = 0;
            int n = nums.size();
            int[] arr = new int[n];
            // 处理所有的符合条件
            for (int i = 0; i < n; i++) {
                if (nums.get(i) % modulo == k) {
                    arr[i] = 1;
                }
            }

            // 前缀和
            int[] pre = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                pre[i] = pre[i - 1] + arr[i - 1];
            }

            // 统计
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : pre) {
                int key = i % modulo;
                ans += map.getOrDefault((key - k + modulo) % modulo, 0);// 配对的数量
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}