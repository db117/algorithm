

//给你一个整数数组 target 和一个数组 initial ，initial 数组与 target 数组有同样的维度，且一开始全部为 0 。 
//
// 请你返回从 initial 得到 target 的最少操作次数，每次操作需遵循以下规则： 
//
// 
// 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。 
// 
//
// 答案保证在 32 位有符号整数以内。 
//
// 
//
// 示例 1： 
//
// 输入：target = [1,2,3,2,1]
//输出：3
//解释：我们需要至少 3 次操作从 intial 数组得到 target 数组。
//[0,0,0,0,0] 将下标为 0 到 4 的元素（包含二者）加 1 。
//[1,1,1,1,1] 将下标为 1 到 3 的元素（包含二者）加 1 。
//[1,2,2,2,1] 将下表为 2 的元素增加 1 。
//[1,2,3,2,1] 得到了目标数组。
// 
//
// 示例 2： 
//
// 输入：target = [3,1,1,2]
//输出：4
//解释：(initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (
//target) 。
// 
//
// 示例 3： 
//
// 输入：target = [3,1,5,4,2]
//输出：7
//解释：(initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1] 
//                                  -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2]
// -> [3,1,5,4,2] (target)。
// 
//
// 示例 4： 
//
// 输入：target = [1,1,1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 10^5 
// 1 <= target[i] <= 10^5 
// 
//
// Related Topics 栈 贪心 数组 动态规划 单调栈 👍 114 👎 0


package cn.db117.leetcode.solution15;

/**
 * 1526.形成目标数组的子数组最少增加次数.minimum-number-of-increments-on-subarrays-to-form-a-target-array
 *
 * @author db117
 * @since 2025-10-30 16:08:44
 **/

public class Solution_1526 {
    public static void main(String[] args) {
        Solution solution = new Solution_1526().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minNumberOperations(int[] target) {
            int res = target[0];
            // 还原到差分数组中。差分数组正数和就是答案
            int n = target.length;
            for (int i = 1; i < n; i++) {
                res += Math.max(target[i] - target[i - 1], 0);
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}