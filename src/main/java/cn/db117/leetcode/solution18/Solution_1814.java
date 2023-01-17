

//给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， 
//rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ： 
//
// 
// 0 <= i < j < nums.length 
// nums[i] + rev(nums[j]) == nums[j] + rev(nums[i]) 
// 
//
// 请你返回好下标对的数目。由于结果可能会很大，请将结果对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [42,11,1,97]
//输出：2
//解释：两个坐标对为：
// - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
// - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
// 
//
// 示例 2： 
//
// 输入：nums = [13,10,35,24,76]
//输出：4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 计数 👍 58 👎 0


package cn.db117.leetcode.solution18;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814.统计一个数组中好对子的数目.count-nice-pairs-in-an-array
 *
 * @author db117
 * @since 2023-01-17 11:31:38
 **/

public class Solution_1814 {
    public static void main(String[] args) {
        Solution solution = new Solution_1814().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static final int mod = (int) (1e9 + 7);

        public int countNicePairs(int[] nums) {
            // nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])      两边减 nums[j] + rev(nums[i])
            // nums[i] + rev(nums[j]) - nums[j] - rev(nums[i]) = 0   两边加 nums[j] - rev(nums[j])
            // nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
            Map<Integer, Integer> count = new HashMap<>();

            // 统计每一个数字出现的次数
            for (int num : nums) {
                int k = num - rev(num);
                count.put(k, count.getOrDefault(k, 0) + 1);
            }

            long ans = 0;

            for (Integer value : count.values()) {
                // C(n,2)
                ans += (long) value * (value - 1) / 2;
                ans %= mod;
            }
            return (int) ans;
        }

        private int rev(int num) {
            int ans = 0;
            while (num > 0) {
                ans *= 10;
                ans += num % 10;
                num /= 10;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}