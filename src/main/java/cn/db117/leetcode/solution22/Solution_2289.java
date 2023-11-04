

//给你一个下标从 0 开始的整数数组 nums 。在一步操作中，移除所有满足 nums[i - 1] > nums[i] 的 nums[i] ，其中 0 < 
//i < nums.length 。 
//
// 重复执行步骤，直到 nums 变为 非递减 数组，返回所需执行的操作数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,3,4,4,7,3,6,11,8,5,11]
//输出：3
//解释：执行下述几个步骤：
//- 步骤 1 ：[5,3,4,4,7,3,6,11,8,5,11] 变为 [5,4,4,7,6,11,11]
//- 步骤 2 ：[5,4,4,7,6,11,11] 变为 [5,4,7,11,11]
//- 步骤 3 ：[5,4,7,11,11] 变为 [5,7,11,11]
//[5,7,11,11] 是一个非递减数组，因此，返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,7,7,13]
//输出：0
//解释：nums 已经是一个非递减数组，因此，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 链表 单调栈 👍 132 👎 0


package cn.db117.leetcode.solution22;

import java.util.Stack;

/**
 * 2289.使数组按非递减顺序排列.steps-to-make-array-non-decreasing
 *
 * @author db117
 * @since 2023-10-18 15:59:14
 **/

public class Solution_2289 {
    public static void main(String[] args) {
        Solution solution = new Solution_2289().new Solution();
        // [5,3,4,4,7,3,6,11,8,5,11]
        System.out.println(solution.totalSteps(new int[]{
                5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalSteps(int[] nums) {
            int ans = 0;
            Stack<int[]> stack = new Stack<>();
            int n = nums.length;
            for (int num : nums) {
                int maxT = 0;// 当前数字需要删除的最大时间
                while (!stack.isEmpty() && stack.peek()[0] <= num) {
                    // 当前数字比栈顶数字大,需要删除栈顶数字
                    // 记录当前数字需要删除的最大时间(被前面的数字删除)
                    int[] pop = stack.pop();
                    maxT = Math.max(maxT, pop[1]);
                }
                if (stack.isEmpty()) {
                    // 前面没有比当前数字大的数字,不需要删除
                    // 入栈,后面的数字可能需要当前数字来删除
                    stack.push(new int[]{num, 0});
                } else {
                    // 当前数字和前面比当前数字大的距离中,最大的递减长度
                    ans = Math.max(ans, maxT + 1);
                    stack.push(new int[]{num, maxT + 1});
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}