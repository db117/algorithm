

//给定一个整数数组 nums，你可以在这个数组上进行 任意 次操作。 
//
// 在每次 操作 中，你可以： 
//
// 
// 选择这个数组的一个 前缀。 
// 选择一个整数 k（可以为负）并且对选中前缀的每一个元素加 k。 
// 
//
// 数组的 前缀 是一个子数组，从数组的开头开始并延伸到数组内的任何位置。 
//
// 返回使 arr 中的所有元素都相等的 最小 操作数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,4,2] 
// 
//
// 输出：2 
//
// 解释： 
//
// 
// 操作 1：选择长度为 2 的前缀 [1, 4] 并且对其中的所有元素加 -2。数组变为 [-1, 2, 2]。 
// 操作 2：选择长度为 1 的前缀 [-1] 并且对其中的所有元素加 3。数组变为 [2, 2, 2]。 
// 因此，所需的最小操作数为 2。 
// 
//
// 示例 2： 
//
// 
// 输入：nums = [10,10,10] 
// 
//
// 输出：0 
//
// 解释： 
//
// 
// 所有元素已经相等，所以不需要操作。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 👍 2 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3353.最小总操作数.minimum-total-operations
 *
 * @author db117
 * @since 2025-04-18 11:02:00
 **/

public class Solution_3353 {
    public static void main(String[] args) {
        Solution solution = new Solution_3353().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length-1; i++) {
                if (nums[i] != nums[i + 1]) {
                    // 不一样就要操作
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}