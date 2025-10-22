

//给你一个整数数组 nums 和两个整数 k 和 numOperations 。 
//
// 你必须对 nums 执行 操作 numOperations 次。每次操作中，你可以： 
//
// 
// 选择一个下标 i ，它在之前的操作中 没有 被选择过。 
// 将 nums[i] 增加范围 [-k, k] 中的一个整数。 
// 
//
// 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。 
//
// 一个元素 x 的 频率 指的是它在数组中出现的次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,4,5], k = 1, numOperations = 2 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。 
// 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [5,11,20,20], k = 5, numOperations = 1 
// 
//
// 输出：2 
//
// 解释： 
//
// 通过以下操作得到最高频率 2 ： 
//
// 
// 将 nums[1] 增加 0 。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// 0 <= numOperations <= nums.length 
// 
//
// Related Topics 数组 二分查找 前缀和 排序 滑动窗口 👍 21 👎 0


package cn.db117.leetcode.solution33;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 3347.执行操作后元素的最高频率 II.maximum-frequency-of-an-element-after-performing-operations-ii
 *
 * @author db117
 * @since 2025-10-22 17:36:54
 **/

public class Solution_3347 {
    public static void main(String[] args) {
        Solution solution = new Solution_3347().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxFrequency(int[] nums, int k, int numOperations) {
            int res = 0;
            Map<Integer, Integer> cut = new HashMap<>();
            Map<Integer, Integer> diff = new TreeMap<>();
            for (int num : nums) {
                cut.merge(num, 1, Integer::sum);
                diff.putIfAbsent(num, 0);// 保证后面遍历能遍历到当前数字
                // 差分数组
                diff.merge(num - k, 1, Integer::sum);
                diff.merge(num + k + 1, -1, Integer::sum);
            }

            int sum = 0;
            for (Map.Entry<Integer, Integer> entry : diff.entrySet()) {
                Integer num = entry.getKey();
                sum += entry.getValue();
                Integer count = cut.getOrDefault(num, 0);

                res = Math.max(res, Math.min(numOperations + count/*当前数字数量+可以改变的数字数量*/, sum));
            }
            return res;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}