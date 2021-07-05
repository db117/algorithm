// 给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 105 
// -109 <= nums[i] <= 109 
// 
// Related Topics 栈 数组 二分查找 有序集合 单调栈 
// 👍 525 👎 0


package cn.db117.leetcode.solution4;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 456.132 模式.132-pattern
 *
 * @author db117
 * @since 2021-07-05 17:53:23
 **/

public class Solution_456 {
    public static void main(String[] args) {
        Solution solution = new Solution_456().new Solution();

        System.out.println(solution.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(solution.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(solution.find132pattern(new int[]{-1, 3, 2, 0}));

        // true
        System.out.println(solution.find132pattern(new int[]{3, 5, 0, 3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean find132pattern(int[] nums) {
            // 单调栈
            // 遍历 3 ，维护一个单调递减的栈 从后面开始遍历

            // 先找到左边最小值
            int[] leftMin = new int[nums.length];
            int min = nums[0];
            for (int i = 0; i < nums.length; i++) {
                leftMin[i] = Math.min(nums[i], min);
                min = leftMin[i];
            }

            Deque<Integer> deque = new LinkedList<>();

            for (int i = nums.length - 1; i >= 0; i--) {
                if (deque.isEmpty()) {
                    deque.offerFirst(nums[i]);
                    continue;
                }

                // 比当前值小的最大值
                int last = Integer.MIN_VALUE;
                while (!deque.isEmpty() && deque.peekFirst() < nums[i]) {
                    last = deque.pollFirst();
                }

                if (leftMin[i] < last) {
                    // 左边最小值，小于比当前值小的最大值
                    return true;
                }

                // 把当前值添加到队列
                deque.offerFirst(nums[i]);
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}