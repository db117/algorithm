

//你和一群强盗准备打劫银行。给你一个下标从 0 开始的整数数组 security ，其中 security[i] 是第 i 天执勤警卫的数量。日子从 0 开始
//编号。同时给你一个整数 time 。 
//
// 如果第 i 天满足以下所有条件，我们称它为一个适合打劫银行的日子： 
//
// 
// 第 i 天前和后都分别至少有 time 天。 
// 第 i 天前连续 time 天警卫数目都是非递增的。 
// 第 i 天后连续 time 天警卫数目都是非递减的。 
// 
//
// 更正式的，第 i 天是一个合适打劫银行的日子当且仅当：security[i - time] >= security[i - time + 1] >= ..
//. >= security[i] <= ... <= security[i + time - 1] <= security[i + time]. 
//
// 请你返回一个数组，包含 所有 适合打劫银行的日子（下标从 0 开始）。返回的日子可以 任意 顺序排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：security = [5,3,3,3,5,6,2], time = 2
//输出：[2,3]
//解释：
//第 2 天，我们有 security[0] >= security[1] >= security[2] <= security[3] <= 
//security[4] 。
//第 3 天，我们有 security[1] >= security[2] >= security[3] <= security[4] <= 
//security[5] 。
//没有其他日子符合这个条件，所以日子 2 和 3 是适合打劫银行的日子。
// 
//
// 示例 2： 
//
// 
//输入：security = [1,1,1,1,1], time = 0
//输出：[0,1,2,3,4]
//解释：
//因为 time 等于 0 ，所以每一天都是适合打劫银行的日子，所以返回每一天。
// 
//
// 示例 3： 
//
// 
//输入：security = [1,2,3,4,5,6], time = 2
//输出：[]
//解释：
//没有任何一天的前 2 天警卫数目是非递增的。
//所以没有适合打劫银行的日子，返回空数组。
// 
//
// 示例 4： 
//
// 
//输入：security = [1], time = 5
//输出：[]
//解释：
//没有日子前面和后面有 5 天时间。
//所以没有适合打劫银行的日子，返回空数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= security.length <= 10⁵ 
// 0 <= security[i], time <= 10⁵ 
// 
// Related Topics 数组 动态规划 前缀和 👍 6 👎 0


package cn.db117.leetcode.solution21;

import java.util.ArrayList;
import java.util.List;

/**
 * 2100.适合打劫银行的日子.find-good-days-to-rob-the-bank
 *
 * @author db117
 * @since 2021-12-22 14:49:32
 **/

public class Solution_2100 {
    public static void main(String[] args) {
        Solution solution = new Solution_2100().new Solution();

        System.out.println(solution.goodDaysToRobBank(new int[]{5, 3, 3, 3, 5, 6, 2}, 2));
        System.out.println(solution.goodDaysToRobBank(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(solution.goodDaysToRobBank(new int[]{1, 2, 3, 4, 5, 6}, 2));
        System.out.println(solution.goodDaysToRobBank(new int[]{1}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> goodDaysToRobBank(int[] security, int time) {
            List<Integer> ans = new ArrayList<>();
            // 左右两边分别遍历
            boolean[] left = new boolean[security.length];
            boolean[] right = new boolean[security.length];

            // 找连续非递增的
            int count = 0;
            for (int i = 0; i < security.length; i++) {
                if (i > 0 && security[i] <= security[i - 1]) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= time) {
                    left[i] = true;
                }
            }

            // 找连续非递减的
            count = 0;
            for (int i = security.length - 1; i >= 0; i--) {
                if (i < security.length - 1 && security[i] <= security[i + 1]) {
                    count++;
                } else {
                    count = 0;
                }
                if (count >= time) {
                    right[i] = true;
                }
            }

            // 都符合
            for (int i = 0; i < security.length; i++) {
                if (left[i] && right[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}