//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 105 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 
// 👍 424 👎 0


package cn.db117.leetcode.solution5;

import java.util.HashMap;
import java.util.Map;

/**
 * 525.连续数组.contiguous-array
 *
 * @author db117
 * @since 2021-06-25 18:30:38
 **/

public class Solution_525 {
    public static void main(String[] args) {
        Solution solution = new Solution_525().new Solution();

        System.out.println(solution.findMaxLength(new int[]{
                0, 1, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxLength(int[] nums) {
            // 前缀和 -> 位置
            Map<Integer, Integer> map = new HashMap<>();
            // sum 刚好为 0 时
            map.put(0, 0);

            int sum = 0, max = 0;

            for (int i = 0; i < nums.length; i++) {
                // 把 0 当 -1 用, 则和为 0 时符合题意
                if (nums[i] == 1) {
                    sum++;
                } else {
                    sum--;
                }


                if (map.containsKey(sum)) {
                    // 如果 sum 已经存在 则 sum 的位置到当前位置符合题意
                    max = Math.max(max, i - map.get(sum) + 1);
                } else {
                    //  i + 1 为了配合 sum 为 0 的情况
                    map.put(sum, i + 1);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}