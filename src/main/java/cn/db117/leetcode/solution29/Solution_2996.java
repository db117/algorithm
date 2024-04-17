

//给你一个下标从 0 开始的整数数组 nums 。 
//
// 如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，那么我们称这个
//前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。 
//
// 请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,2,5]
//输出：6
//解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,5,1,12,14,13]
//输出：15
//解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最
//小整数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50 
// 1 <= nums[i] <= 50 
// 
//
// Related Topics 数组 哈希表 排序 👍 4 👎 0


package cn.db117.leetcode.solution29;

/**
 * 2996.大于等于顺序前缀和的最小缺失整数.smallest-missing-integer-greater-than-sequential-prefix-sum
 *
 * @author db117
 * @since 2024-04-17 11:38:57
 **/

public class Solution_2996 {
    public static void main(String[] args) {
        Solution solution = new Solution_2996().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingInteger(int[] nums) {
            int sum = nums[0];
            int n = nums.length;
            // 找到最长的
            for (int i = 1; i < n; i++) {
                if (nums[i] == nums[i - 1] + 1) {
                    sum += nums[i];
                } else {
                    break;
                }
            }

            // 记录出现的
            int[] hash = new int[57];
            for (int num : nums) {
                hash[num]++;
            }
            if (sum > 50) {
                return sum;
            }
            // 找到第一个没有的
            for (int i = sum; i <= 51; i++) {
                if (hash[i] == 0) {
                    return i;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}