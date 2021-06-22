


//给你一个整数数组 nums 和一个整数 k。 
//
// 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。 
//
// 请返回这个数组中「优美子数组」的数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,1,1], k = 3
//输出：2
//解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
// 
//
// 示例 2： 
//
// 输入：nums = [2,4,6], k = 1
//输出：0
//解释：数列中不包含任何奇数，所以不存在优美子数组。
// 
//
// 示例 3： 
//
// 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
//输出：16
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// 1 <= nums[i] <= 10^5 
// 1 <= k <= nums.length 
// 
// Related Topics 双指针 
// 👍 172 👎 0


package cn.db117.leetcode.solution12;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248.统计「优美子数组」.count-number-of-nice-subarrays
 *
 * @author db117
 * @since 2021-06-21 16:42:14
 **/

public class Solution_1248 {
    public static void main(String[] args) {
        Solution solution = new Solution_1248().new Solution();
        System.out.println(solution.numberOfSubarrays(new int[]{
                2, 4, 6
        }, 1));
        System.out.println(solution.numberOfSubarrays(new int[]{
                1, 1, 2, 1, 1
        }, 3));
        System.out.println(solution.numberOfSubarrays(new int[]{
                2, 2, 2, 1, 2, 2, 1, 2, 2, 2
        }, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int ans = 0;
            // 前缀和,差分
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (nums[i] & 1) == 1 ? 1 : 0;
            }

            int sum = 0;
            // 前缀和->出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 第一次出现时使用
            map.put(0, 1);

            for (int num : nums) {
                // 前缀和
                sum += num;

                int key = sum - k;
                if (map.containsKey(key)) {
                    // 差分
                    // 前面出现过和为 sum-k 的区间,减去那个区间即为和为k的区间
                    ans += map.get(key);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}