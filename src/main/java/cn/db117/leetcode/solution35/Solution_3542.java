

//给你一个大小为 n 的 非负 整数数组 nums 。你的任务是对该数组执行若干次（可能为 0 次）操作，使得 所有 元素都变为 0。 
//
// 在一次操作中，你可以选择一个子数组 [i, j]（其中 0 <= i <= j < n），将该子数组中所有 最小的非负整数 的设为 0。 
//
// 返回使整个数组变为 0 所需的最少操作次数。 一个 
//子数组 是数组中的一段连续元素。
//
// 
//
// 示例 1： 
//
// 
// 输入: nums = [0,2] 
// 
//
// 输出: 1 
//
// 解释: 
//
// 
// 选择子数组 [1,1]（即 [2]），其中最小的非负整数是 2。将所有 2 设为 0，结果为 [0,0]。 
// 因此，所需的最少操作次数为 1。 
// 
//
// 示例 2： 
//
// 
// 输入: nums = [3,1,2,1] 
// 
//
// 输出: 3 
//
// 解释: 
//
// 
// 选择子数组 [1,3]（即 [1,2,1]），最小非负整数是 1。将所有 1 设为 0，结果为 [3,0,2,0]。 
// 选择子数组 [2,2]（即 [2]），将 2 设为 0，结果为 [3,0,0,0]。 
// 选择子数组 [0,0]（即 [3]），将 3 设为 0，结果为 [0,0,0,0]。 
// 因此，最少操作次数为 3。 
// 
//
// 示例 3： 
//
// 
// 输入: nums = [1,2,1,2,1,2] 
// 
//
// 输出: 4 
//
// 解释: 
//
// 
// 选择子数组 [0,5]（即 [1,2,1,2,1,2]），最小非负整数是 1。将所有 1 设为 0，结果为 [0,2,0,2,0,2]。 
// 选择子数组 [1,1]（即 [2]），将 2 设为 0，结果为 [0,0,0,2,0,2]。 
// 选择子数组 [3,3]（即 [2]），将 2 设为 0，结果为 [0,0,0,0,0,2]。 
// 选择子数组 [5,5]（即 [2]），将 2 设为 0，结果为 [0,0,0,0,0,0]。 
// 因此，最少操作次数为 4。 
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n == nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 栈 贪心 数组 哈希表 单调栈 👍 53 👎 0


package cn.db117.leetcode.solution35;

import java.util.ArrayDeque;

/**
 * 3542.将所有元素变为 0 的最少操作次数.minimum-operations-to-convert-all-elements-to-zero
 *
 * @author db117
 * @since 2025-11-10 19:55:48
 **/

public class Solution_3542 {
    public static void main(String[] args) {
        Solution solution = new Solution_3542().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minOperations(int[] nums) {
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int ans = 0;
            for (int num : nums) {
                while (!stack.isEmpty() && stack.peek() > num) {
                    stack.pop();
                    ans++;// 栈顶的元素必须自己单独减
                }
                if (!stack.isEmpty() && stack.peek() == num) {
                    // 栈顶元素相等，可以在一次中减
                    continue;
                }
                stack.push(num);
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                if (pop > 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}