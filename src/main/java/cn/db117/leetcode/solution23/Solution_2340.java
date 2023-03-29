

//给定一个 下标从 0 开始 的整数数组 nums。 
//
// nums 上的 相邻 元素可以进行 交换。 
//
// 一个 有效 的数组必须满足以下条件: 
//
// 
// 最大的元素 (如果有多个，则为最大元素中的任何一个) 位于数组中最右边的位置。 
// 最小的元素 (如果有多个，则为最小的任何一个元素) 位于数组的最左侧。 
// 
//
// 返回使 nums 成为有效数组所需的最少交换次数。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [3,4,5,5,3,1]
//输出: 6
//解释: 进行以下交换:
//- 交换 1:交换第 3 和第 4 个元素，然后 nums 是 [3,4,5,3,5,1].
//- 交换 2:交换第 4 和第 5 个元素，然后 nums 是 [3,4,5,3,1,5].
//- 交换 3:交换第 3 和第 4 个元素，然后 nums 是  [3,4,5,1,3,5].
//- 交换 4:交换第 2 和第 3 个元素，然后 nums 是  [3,4,1,5,3,5].
//- 交换 5:交换第 1 和第 2 个元素，然后 nums 是  [3,1,4,5,3,5].
//- 交换 6:交换第 0 和第 1 个元素，然后 nums 是  [1,3,4,5,3,5].
//可以证明，6 次交换是组成一个有效数组所需的最少交换次数。
// 
//
//示例 2:
//
// 
//输入: nums = [9]
//输出: 0
//解释: 该数组已经有效，因此返回 0。 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 👍 3 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2340.生成有效数组的最少交换次数.minimum-adjacent-swaps-to-make-a-valid-array
 *
 * @author db117
 * @since 2023-03-29 10:41:27
 **/

public class Solution_2340 {
    public static void main(String[] args) {
        Solution solution = new Solution_2340().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSwaps(int[] nums) {
            int n = nums.length;
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            // 找到要换的数字位置
            int minI = 0, maxI = 0;
            for (int i = 0; i < n; i++) {
                int num = nums[i];
                if (num >= max) {
                    maxI = i;
                    max = num;
                }
                if (num < min) {
                    minI = i;
                    min = num;
                }
            }
            if (minI == maxI) {
                // 只有一个数字
                return 0;
            }

            if (minI < maxI) {
                // 两个数字不会换位
                return minI + (n - maxI - 1);
            }
            // 换了一次位置
            return minI + (n - maxI - 1) - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}