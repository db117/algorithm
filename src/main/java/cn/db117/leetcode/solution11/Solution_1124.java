

//给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。 
//
// 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。 
//
// 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。 
//
// 请你返回「表现良好时间段」的最大长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：hours = [9,9,6,0,6,6,9]
//输出：3
//解释：最长的表现良好时间段是 [9,9,6]。 
//
// 示例 2： 
//
// 
//输入：hours = [6,6,6]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= hours.length <= 10⁴ 
// 0 <= hours[i] <= 16 
// 
//
// Related Topics 栈 数组 哈希表 前缀和 单调栈 👍 364 👎 0


package cn.db117.leetcode.solution11;

import java.util.Stack;

/**
 * 1124.表现良好的最长时间段.longest-well-performing-interval
 *
 * @author db117
 * @since 2023-02-14 14:39:25
 **/

public class Solution_1124 {
    public static void main(String[] args) {
        Solution solution = new Solution_1124().new Solution();
        System.out.println(solution.longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));

        System.out.println(solution.longestWPI(new int[]{6, 6, 9}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestWPI(int[] hours) {
            int ans = 0;
            // 把大于 8 记为 1， 其他记为 -1，并统计前缀和
            // 先用栈找到，单调递减的前缀和，
            // 然后从后面开始遍历
            // [left,right)左闭右开，右边界+1
            int[] presSum = new int[hours.length + 1];
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            for (int i = 0; i < hours.length; i++) {
                // 前缀和
                presSum[i + 1] = presSum[i] + (hours[i] > 8 ? 1 : -1);
                if (presSum[i + 1] < presSum[stack.peek()]) {
                    // 单调递减
                    stack.push(i + 1);
                }
            }

            // 遍历的是右边界
            for (int i = hours.length; i > 0; i--) {
                while (!stack.isEmpty() && presSum[stack.peek()] < presSum[i]) {
                    ans = Math.max(ans, i - stack.pop());
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}