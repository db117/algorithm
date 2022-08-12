

//给你一个下标从 0 开始的整数数组 nums 。如果 i < j 且 j - i != nums[j] - nums[i] ，那么我们称 (i, j) 是一
//个 坏数对 。 
//
// 请你返回 nums 中 坏数对 的总数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,3,3]
//输出：5
//解释：数对 (0, 1) 是坏数对，因为 1 - 0 != 1 - 4 。
//数对 (0, 2) 是坏数对，因为 2 - 0 != 3 - 4, 2 != -1 。
//数对 (0, 3) 是坏数对，因为 3 - 0 != 3 - 4, 3 != -1 。
//数对 (1, 2) 是坏数对，因为 2 - 1 != 3 - 1, 1 != 2 。
//数对 (2, 3) 是坏数对，因为 3 - 2 != 3 - 3, 1 != 0 。
//总共有 5 个坏数对，所以我们返回 5 。
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,3,4,5]
//输出：0
//解释：没有坏数对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 👍 7 👎 0


package cn.db117.leetcode.solution23;

import java.util.HashMap;
import java.util.Map;

/**
 * 2364.统计坏数对的数目.count-number-of-bad-pairs
 *
 * @author db117
 * @since 2022-08-12 17:20:26
 **/

public class Solution_2364 {
    public static void main(String[] args) {
        Solution solution = new Solution_2364().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long countBadPairs(int[] nums) {
            int len = nums.length;
            // 全部数对
            long ans = (long) len * (len - 1) / 2;
            // 找优质数对
            // 公式转换
            // j - i == nums[j] - nums[i]  --> nums[j] - j = nums[i] - i

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int key = nums[i] - i;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }

            for (Integer count : map.values()) {
                // 减去优质数对
                ans -= (long) count * (count - 1) / 2;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}