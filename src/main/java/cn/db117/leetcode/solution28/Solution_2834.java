

//给你两个正整数：n 和 target 。 
//
// 如果数组 nums 满足下述条件，则称其为 美丽数组 。 
//
// 
// nums.length == n. 
// nums 由两两互不相同的正整数组成。 
// 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。 
// 
//
// 返回符合条件的美丽数组所可能具备的 最小 和。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 2, target = 3
//输出：4
//解释：nums = [1,3] 是美丽数组。
//- nums 的长度为 n = 2 。
//- nums 由两两互不相同的正整数组成。
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 4 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 2： 
//
// 
//输入：n = 3, target = 3
//输出：8
//解释：
//nums = [1,3,4] 是美丽数组。 
//- nums 的长度为 n = 3 。 
//- nums 由两两互不相同的正整数组成。 
//- 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
//可以证明 8 是符合条件的美丽数组所可能具备的最小和。 
//
// 示例 3： 
//
// 
//输入：n = 1, target = 1
//输出：1
//解释：nums = [1] 是美丽数组。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= target <= 10⁵ 
// 
//
// 👍 7 👎 0


package cn.db117.leetcode.solution28;

/**
 * 2834.找出美丽数组的最小和.find-the-minimum-possible-sum-of-a-beautiful-array
 *
 * @author db117
 * @since 2023-08-30 10:28:18
 **/

public class Solution_2834 {
    public static void main(String[] args) {
        Solution solution = new Solution_2834().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumPossibleSum(int n, int target) {
            int max = target + n;
            long ans = 0;
            // 把一个数字分成了三段 中间一段不能用
            for (int i = 1; i < target; i++) {
                if (i <= target / 2) {
                    ans += i;
                    n--;
                }
                if (n == 0) {
                    break;
                }
            }

            for (int i = target; i < max && n > 0; i++, n--) {
                ans += i;
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}