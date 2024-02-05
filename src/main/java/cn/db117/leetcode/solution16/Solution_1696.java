

//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, 
//i + k)] 包含 两个端点的任意位置。 
//
// 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。 
//
// 请你返回你能得到的 最大得分 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,-1,-2,4,-7,3], k = 2
//输出：7
//解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,-5,-2,4,0,3], k = 3
//输出：17
//解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
//
// Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 171 👎 0


package cn.db117.leetcode.solution16;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1696.跳跃游戏 VI.jump-game-vi
 *
 * @author db117
 * @since 2024-02-05 13:58:13
 **/

public class Solution_1696 {
    public static void main(String[] args) {
        Solution solution = new Solution_1696().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public int maxResult(int[] nums, int k) {
            int n = nums.length;
            int[] f = new int[n];
            f[0] = nums[0];
            // 单调栈,单调递减
            // 从左边取,从右边弹出
            Deque<Integer> q = new ArrayDeque<>(n);

            for (int i = 0; i < n; i++) {
                // 去掉超出范围的
                while (!q.isEmpty() && q.peek() < i - k) {
                    q.poll();
                }
                if (!q.isEmpty()) {
                    // 找到 k 距离内的最大值
                    f[i] = f[q.peek()] + nums[i];
                } else {
                    f[i] = nums[i];
                }
                // 保持单调递减
                while (!q.isEmpty() && f[q.peekLast()] <= f[i]) {
                    q.pollLast();
                }
                q.offer(i);
            }
            return f[n - 1];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}