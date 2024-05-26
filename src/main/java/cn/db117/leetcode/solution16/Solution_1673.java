

//给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。 
//
// 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。 
//
// 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力 
//。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,5,2,6], k = 2
//输出：[2,6]
//解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,4,3,3,5,4,9,6], k = 4
//输出：[2,3,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 栈 贪心 数组 单调栈 👍 160 👎 0


package cn.db117.leetcode.solution16;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1673.找出最具竞争力的子序列.find-the-most-competitive-subsequence
 *
 * @author db117
 * @since 2024-05-24 17:04:21
 **/

public class Solution_1673 {
    public static void main(String[] args) {
        Solution solution = new Solution_1673().new Solution();
        // [2,4,3,3,5,4,9,6]
        //			4
        System.out.println(Arrays.toString(solution.mostCompetitive(new int[]{
                2, 4, 3, 3, 5, 4, 9, 6
        }, 4)));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            int[] ans = new int[k];
            // 可以简单的看成单调递增队列
            Deque<Integer> queue = new ArrayDeque<>(k);
            for (int i = 0; i < n; i++) {
                // 如果当前数字比队尾数字小,则出队
                while (!queue.isEmpty() &&
                        queue.peekLast() > nums[i]
                        && queue.size() + n - i > k) {
                    // 保证后面的数据还能凑够 k 则把前面比当前数字大的出队
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
            }
            for (int i = 0; i < k; i++) {
                ans[i] = queue.pollFirst();
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}