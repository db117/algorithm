//给你一个整数数组 nums ，你可以对它进行一些操作。
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i]
// + 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 数组 哈希表 动态规划 
// 👍 355 👎 0


package cn.db117.leetcode.solution7;

/**
 * 740.删除并获得点数.delete-and-earn
 *
 * @author db117
 * @since 2021-07-01 17:01:04
 **/

public class Solution_740 {
    public static void main(String[] args) {
        Solution solution = new Solution_740().new Solution();
        System.out.println(solution.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int deleteAndEarn(int[] nums) {
            // 打家劫舍
            int[] count = new int[10001];
            for (int num : nums) {
                count[num] += num;
            }

            for (int i = 2; i < count.length; i++) {
                // 简单说就是不能连续取两个数字
                count[i] = Math.max(count[i - 1], count[i - 2] + count[i]);
            }

            return count[10000];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}