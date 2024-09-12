

//给你一个整数数组 start 和一个整数 d，代表 n 个区间 [start[i], start[i] + d]。 
//
// 你需要选择 n 个整数，其中第 i 个整数必须属于第 i 个区间。所选整数的 得分 定义为所选整数两两之间的 最小 绝对差。 
//
// 返回所选整数的 最大可能得分 。 
//
// 
//
// 示例 1： 
//
// 
// 输入： start = [6,0,3], d = 2 
// 
//
// 输出： 4 
//
// 解释： 
//
// 可以选择整数 8, 0 和 4 获得最大可能得分，得分为 min(|8 - 0|, |8 - 4|, |0 - 4|)，等于 4。 
//
// 示例 2： 
//
// 
// 输入： start = [2,6,13,13], d = 5 
// 
//
// 输出： 5 
//
// 解释： 
//
// 可以选择整数 2, 7, 13 和 18 获得最大可能得分，得分为 min(|2 - 7|, |2 - 13|, |2 - 18|, |7 - 13|, 
//|7 - 18|, |13 - 18|)，等于 5。 
//
// 
//
// 提示： 
//
// 
// 2 <= start.length <= 10⁵ 
// 0 <= start[i] <= 10⁹ 
// 0 <= d <= 10⁹ 
// 
//
// Related Topics 贪心 数组 二分查找 排序 👍 10 👎 0


package cn.db117.leetcode.solution32;

import java.util.Arrays;

/**
 * 3281.范围内整数的最大得分.maximize-score-of-numbers-in-ranges
 *
 * @author db117
 * @since 2024-09-12 14:52:49
 **/

public class Solution_3281 {
    public static void main(String[] args) {
        Solution solution = new Solution_3281().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPossibleScore(int[] start, int d) {
            Arrays.sort(start);
            long left = 0, right = Integer.MAX_VALUE;
            while (left < right) {
                long mid = (left + right + 1) >> 1;
                if (check(start, d, mid)) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            return (int) left;
        }

        private boolean check(int[] start, int d, long step) {
            int n = start.length;
            long pre = start[0];

            for (int i = 1; i < n; i++) {
                if (pre + step > start[i] + d) {
                    // 这两个数字直接不满足间距 step
                    return false;
                }
                // 计算下一个区间的开始位置
                pre = Math.max(pre + step, start[i]);
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}