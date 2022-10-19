

//给你一个整数数组 nums ，如果 nums 是一个 连贯数组 ，则返回 true ，否则返回 false 。 
//
// 如果数组包含 [x, x + n - 1] 范围内的所有数字（包括 x 和 x + n - 1 ），则该数组为连贯数组；其中 x 是数组中最小的数，n 是
//数组的长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,4,2]
//输出：true
//解释：
//最小值是 1 ，数组长度为 4 。
//范围 [x, x + n - 1] 中的所有值都出现在 nums 中：[1, 1 + 4 - 1] = [1, 4] = (1, 2, 3, 4) 。
//因此，nums 是一个连贯数组。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,3]
//输出：false
//解释：
//最小值是 1 ，数组长度为 2 。 
//范围 [x, x + n - 1] 中的所有值没有都出现在 nums 中：[1, 1 + 2 - 1] = [1, 2] = (1, 2) 。 
//因此，nums 不是一个连贯数组。 
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,5,4]
//输出：true
//解释：
//最小值是 3 ，数组长度为 3 。
//范围 [x, x + n - 1] 中的所有值都出现在 nums 中：[3, 3 + 3 - 1] = [3, 5] = (3，4，5) 。
//因此，nums 是一个连贯数组。
// 
//
// 
//提示：
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 👍 0 👎 0


package cn.db117.leetcode.solution22;

import java.util.TreeSet;

/**
 * 2229.检查数组是否连贯.check-if-an-array-is-consecutive
 *
 * @author db117
 * @since 2022-10-19 18:48:05
 **/

public class Solution_2229 {
    public static void main(String[] args) {
        Solution solution = new Solution_2229().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isConsecutive(int[] nums) {
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int num : nums) {
                treeSet.add(num);
            }

            int tmp = treeSet.last() - treeSet.first() + 1;
            return tmp == nums.length && tmp == treeSet.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}