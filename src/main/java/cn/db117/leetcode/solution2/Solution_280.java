

//给你一个的整数数组 nums, 将该数组重新排序后使 nums[0] <= nums[1] >= nums[2] <= nums[3]... 
//
// 输入数组总是有一个有效的答案。 
//
// 
//
// 示例 1: 
//
// 
//输入：nums = [3,5,2,1,6,4]
//输出：[3,5,1,6,2,4]
//解释：[1,6,2,5,3,4]也是有效的答案 
//
// 示例 2: 
//
// 
//输入：nums = [6,6,5,6,3,8]
//输出：[6,6,5,6,3,8]
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 0 <= nums[i] <= 10⁴ 
// 输入的 nums 保证至少有一个答案。 
// 
//
// 
//
// 进阶：你能在 O(n) 时间复杂度下解决这个问题吗？ 
//
// Related Topics 贪心 数组 排序 👍 113 👎 0


package cn.db117.leetcode.solution2;

import java.util.Arrays;

/**
 * 280.摆动排序.wiggle-sort
 *
 * @author db117
 * @since 2023-05-17 15:17:19
 **/

public class Solution_280 {
    public static void main(String[] args) {
        Solution solution = new Solution_280().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public void wiggleSort(int[] nums) {
            Arrays.sort(nums);
            // 排序后，从第二个数字开始，每两个进行交换
            for (int i = 1; i < nums.length - 1; i += 2) {
                int temp = nums[i];
                nums[i] = nums[i + 1];
                nums[i + 1] = temp;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}