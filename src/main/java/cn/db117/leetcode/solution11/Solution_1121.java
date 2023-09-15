

//给你一个 非递减 的正整数数组 nums 和整数 K，判断该数组是否可以被分成一个或几个 长度至少 为 K 的 不相交的递增子序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,2,2,3,3,4,4], K = 3
//输出：true
//解释：
//该数组可以分成两个子序列 [1,2,3,4] 和 [2,3,4]，每个子序列的长度都至少是 3。
// 
//
// 示例 2： 
//
// 输入：nums = [5,6,6,7,8], K = 3
//输出：false
//解释：
//没有办法根据条件来划分数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10^5 
// 1 <= K <= nums.length 
// 1 <= nums[i] <= 10^5 
// 
//
// Related Topics 贪心 数组 👍 29 👎 0


package cn.db117.leetcode.solution11;

import java.util.HashMap;
import java.util.Map;

/**
 * 1121.将数组分成几个递增序列.divide-array-into-increasing-sequences
 *
 * @author db117
 * @since 2023-09-15 16:09:43
 **/

public class Solution_1121 {
    public static void main(String[] args) {
        Solution solution = new Solution_1121().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canDivideIntoSubsequences(int[] nums, int k) {
            Map<Integer, Integer> counter = new HashMap<>();
            for (int num : nums) {
                counter.put(num, counter.getOrDefault(num, 0) + 1);
            }

            // 只要有一个数字的数量大于总数/k,则不行
            // 因为每个子序列的长度都至少是 k
            for (Integer value : counter.values()) {
                if (value * k > nums.length) {
                    return false;
                }
            }

            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}