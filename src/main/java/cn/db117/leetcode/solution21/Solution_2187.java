

//给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。 
//
// 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在
//运行且互不影响。 
//
// 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。 
//
//
// 
//
// 示例 1： 
//
// 输入：time = [1,2,3], totalTrips = 5
//输出：3
//解释：
//- 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
//  已完成的总旅途数为 1 + 0 + 0 = 1 。
//- 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
//  已完成的总旅途数为 2 + 1 + 0 = 3 。
//- 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
//  已完成的总旅途数为 3 + 1 + 1 = 5 。
//所以总共完成至少 5 趟旅途的最少时间为 3 。
// 
//
// 示例 2： 
//
// 输入：time = [2], totalTrips = 1
//输出：2
//解释：
//只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
//所以完成 1 趟旅途的最少时间为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= time.length <= 10⁵ 
// 1 <= time[i], totalTrips <= 10⁷ 
// 
// 👍 19 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2187.完成旅途的最少时间.minimum-time-to-complete-trips
 *
 * @author db117
 * @since 2022-02-28 15:14:59
 **/

public class Solution_2187 {
    public static void main(String[] args) {
        Solution solution = new Solution_2187().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumTime(int[] time, int totalTrips) {
            // 二分
            long left = 0, right = (long) time[0] * totalTrips;
            long mid;

            while (left < right) {
                mid = (right + left) / 2;

                long helper = helper(time, mid);
                if (helper < totalTrips) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return right;
        }

        private long helper(int[] time, long t) {
            long ans = 0;

            for (int i : time) {
                ans += t / i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}