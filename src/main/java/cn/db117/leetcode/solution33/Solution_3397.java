

//给你一个整数数组 nums 和一个整数 k。 
//
// 你可以对数组中的每个元素 最多 执行 一次 以下操作： 
//
// 
// 将一个在范围 [-k, k] 内的整数加到该元素上。 
// 
//
// 返回执行这些操作后，nums 中可能拥有的不同元素的 最大 数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,2,3,3,4], k = 2 
// 
//
// 输出： 6 
//
// 解释： 
//
// 对前四个元素执行操作，nums 变为 [-1, 0, 1, 2, 3, 4]，可以获得 6 个不同的元素。 
//
// 示例 2： 
//
// 
// 输入： nums = [4,4,4,4], k = 1 
// 
//
// 输出： 3 
//
// 解释： 
//
// 对 nums[0] 加 -1，以及对 nums[1] 加 1，nums 变为 [3, 5, 4, 4]，可以获得 3 个不同的元素。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁹ 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution33;

import java.util.Arrays;

/**
 * 3397.执行操作后不同元素的最大数量.maximum-number-of-distinct-elements-after-operations
 *
 * @author db117
 * @since 2024-12-24 15:03:07
 **/

public class Solution_3397 {
    public static void main(String[] args) {
        Solution solution = new Solution_3397().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistinctElements(int[] nums, int k) {
            // 尽可能的往左边站
            Arrays.sort(nums);
            int pre = Integer.MIN_VALUE;// 记录上一个实际站的位置
            int ans = 0;
            for (int num : nums) {
                int x = Math.max(num - k, pre + 1);
                x = Math.min(x, num + k);
                if (x > pre) {
                    // 有地方可以站
                    pre = x;
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}