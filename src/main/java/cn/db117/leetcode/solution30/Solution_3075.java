

//给你一个长度为 n 的数组 happiness ，以及一个 正整数 k 。 
//
// n 个孩子站成一队，其中第 i 个孩子的 幸福值 是 happiness[i] 。你计划组织 k 轮筛选从这 n 个孩子中选出 k 个孩子。 
//
// 在每一轮选择一个孩子时，所有 尚未 被选中的孩子的 幸福值 将减少 1 。注意，幸福值 不能 变成负数，且只有在它是正数的情况下才会减少。 
//
// 选择 k 个孩子，并使你选中的孩子幸福值之和最大，返回你能够得到的 最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：happiness = [1,2,3], k = 2
//输出：4
//解释：按以下方式选择 2 个孩子：
//- 选择幸福值为 3 的孩子。剩余孩子的幸福值变为 [0,1] 。
//- 选择幸福值为 1 的孩子。剩余孩子的幸福值变为 [0] 。注意幸福值不能小于 0 。
//所选孩子的幸福值之和为 3 + 1 = 4 。
// 
//
// 示例 2： 
//
// 
//输入：happiness = [1,1,1,1], k = 2
//输出：1
//解释：按以下方式选择 2 个孩子：
//- 选择幸福值为 1 的任意一个孩子。剩余孩子的幸福值变为 [0,0,0] 。
//- 选择幸福值为 0 的孩子。剩余孩子的幸福值变为 [0,0] 。
//所选孩子的幸福值之和为 1 + 0 = 1 。
// 
//
// 示例 3： 
//
// 
//输入：happiness = [2,3,4,5], k = 1
//输出：5
//解释：按以下方式选择 1 个孩子：
//- 选择幸福值为 5 的孩子。剩余孩子的幸福值变为 [1,2,3] 。
//所选孩子的幸福值之和为 5 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == happiness.length <= 2 * 10⁵ 
// 1 <= happiness[i] <= 10⁸ 
// 1 <= k <= n 
// 
//
// Related Topics 贪心 数组 排序 👍 1 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;

/**
 * 3075.幸福值最大化的选择方案.maximize-happiness-of-selected-children
 *
 * @author db117
 * @since 2024-03-12 15:10:27
 **/

public class Solution_3075 {
    public static void main(String[] args) {
        Solution solution = new Solution_3075().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            long ans = 0;
            Arrays.sort(happiness);
            int n = happiness.length;
            int step = 0;
            for (int i = n - 1; i >= 0 && k > 0; i--, k--) {
                int h = happiness[i];
                if (h <= step) {
                    // 后面都是 0
                    break;
                }
                ans += h - step;
                step++;
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}