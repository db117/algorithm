

//你打算利用空闲时间来做兼职工作赚些零花钱。 
//
// 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。 
//
// 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，请你计算并返回可以获得的最大报酬。 
//
// 注意，时间上出现重叠的 2 份工作不能同时进行。 
//
// 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
//输出：120
//解释：
//我们选出第 1 份和第 4 份工作， 
//时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
// 
//
// 示例 2： 
//
// 
//
// 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60
//]
//输出：150
//解释：
//我们选择第 1，4，5 份工作。 
//共获得报酬 150 = 20 + 70 + 60。
// 
//
// 示例 3： 
//
// 
//
// 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4 
// 1 <= startTime[i] < endTime[i] <= 10^9 
// 1 <= profit[i] <= 10^4 
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 291 👎 0


package cn.db117.leetcode.solution12;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1235.规划兼职工作.maximum-profit-in-job-scheduling
 *
 * @author db117
 * @since 2022-10-22 21:34:03
 **/

public class Solution_1235 {
    public static void main(String[] args) {
        Solution solution = new Solution_1235().new Solution();
        // [1,2,3,3]
        //[3,4,5,6]
        //[50,10,40,70]
        System.out.println(solution.jobScheduling(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));

        // [43,13,36,31,40,5,47,13,28,16,2,11]
        //[44,22,41,41,47,13,48,35,48,26,21,39]
        //[8,20,3,19,16,8,11,13,2,15,1,1]
        // 66

        System.out.println(solution.jobScheduling(
                new int[]{43, 13, 36, 31, 40, 5, 47, 13, 28, 16, 2, 11},
                new int[]{44, 22, 41, 41, 47, 13, 48, 35, 48, 26, 21, 39},
                new int[]{8, 20, 3, 19, 16, 8, 11, 13, 2, 15, 1, 1}));

        // [1,1,1]
        //[2,3,4]
        //[5,6,4]
        // 6
        System.out.println(solution.jobScheduling(
                new int[]{1, 1, 1},
                new int[]{2, 3, 4},
                new int[]{5, 6, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int[][] info = new int[endTime.length][3];
            for (int i = 0; i < endTime.length; i++) {
                info[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            // 按照结束时间排序
            Arrays.sort(info, Comparator.comparing(ints -> ints[1]));

            int[] dp = new int[info.length];

            dp[0] = info[0][2];
            for (int i = 1; i < info.length; i++) {
                // 找到小于等于当前开始时间的结束时间
                int j = bs(info, i, info[i][0]);
                // f[i]=max(f[i−1],f[j]+profit[i])
                if (j == -1) {
                    // 前面没有可以用的
                    dp[i] = Math.max(dp[i - 1], info[i][2]);
                } else {
                    dp[i] = Math.max(dp[i - 1], dp[j] + info[i][2]);
                }
            }

            return dp[info.length - 1];
        }

        private int bs(int[][] info, int right, int target) {
            int left = -1;
            while (left < right) {
                int mid = (right + left + 1) / 2;
                if (info[mid][1] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}