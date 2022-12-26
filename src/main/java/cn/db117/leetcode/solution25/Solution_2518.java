

//给你一个正整数数组 nums 和一个整数 k 。 
//
// 分区 的定义是：将数组划分成两个有序的 组 ，并满足每个元素 恰好 存在于 某一个 组中。如果分区中每个组的元素和都大于等于 k ，则认为分区是一个好分区
//。 
//
// 返回 不同 的好分区的数目。由于答案可能很大，请返回对 10⁹ + 7 取余 后的结果。 
//
// 如果在两个分区中，存在某个元素 nums[i] 被分在不同的组中，则认为这两个分区不同。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4], k = 4
//输出：6
//解释：好分区的情况是 ([1,2,3], [4]), ([1,3], [2,4]), ([1,4], [2,3]), ([2,3], [1,4]), ([2
//,4], [1,3]) 和 ([4], [1,2,3]) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3,3], k = 4
//输出：0
//解释：数组中不存在好分区。
// 
//
// 示例 3： 
//
// 
//输入：nums = [6,6], k = 2
//输出：2
//解释：可以将 nums[0] 放入第一个分区或第二个分区中。
//好分区的情况是 ([6], [6]) 和 ([6], [6]) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 
//
// 👍 13 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2518.好分区的数目.number-of-great-partitions
 *
 * @author db117
 * @since 2022-12-26 10:52:25
 **/

public class Solution_2518 {
    public static void main(String[] args) {
        Solution solution = new Solution_2518().new Solution();
        // nums = [1,2,3,4], k = 4
//        System.out.println(solution.countPartitions(new int[]{1, 2, 3, 4}, 4));
        // [770,299,300,773,102,29,662,999,537,851,312,204,950,585,849,139,842,279,504,130,753,233,138,113,123,25,646,438,454]
        //k =
        //411
//        System.out.println(solution.countPartitions(new int[]{770, 299, 300, 773, 102, 29, 662, 999, 537, 851, 312, 204, 950, 585, 849, 139, 842, 279, 504, 130, 753, 233, 138, 113, 123, 25, 646, 438, 454}, 411));

        // [452712990,304923574,514804081,516542653,302633600,387844856,254193892,514125672,231231273,537828972,739788846,997137192,323638612,980131474,932473011,451725510,603721810,314059822,812497197,880888575,270244953,703545293,853537357,744164576,92185020,481926703,917558408,760008715,101971293]
        System.out.println(solution.countPartitions(new int[]{452712990, 304923574, 514804081, 516542653, 302633600
                , 387844856, 254193892, 514125672, 231231273, 537828972, 739788846, 997137192, 323638612, 980131474, 932473011,
                451725510, 603721810, 314059822, 812497197, 880888575, 270244953
                , 703545293, 853537357, 744164576, 92185020, 481926703, 917558408, 760008715, 101971293}, 778));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) (1e9 + 7);

        public int countPartitions(int[] nums, int k) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
                sum %= mod;
            }
            if (sum / 2 < k) {
                // 不符合题意
                return 0;
            }

            // 找到所有不符合题意的分组
            // 0 1 背包
            // 前 i 个数,和为 j 的数量
            long[][] f = new long[nums.length + 1][k];
            f[0][0] = 1;
            for (int i = 1; i <= nums.length; i++) {
                for (int j = 0; j < k; j++) {
                    // 选当前值
                    if (j >= nums[i - 1]) {
                        f[i][j] += f[i - 1][j - nums[i - 1]];
                    }
                    // 不选当前值
                    f[i][j] += f[i - 1][j];
                    f[i][j] %= mod;
                }
            }
            // 总数为 2*n 减去坏区间的数量
            // 坏区间的数量
            long ans = 0;
            for (long i : f[nums.length]) {
                ans += 2L * i;
                ans %= mod;
            }
            // 总数
            long total = (long) (Math.pow(2, nums.length) % mod + mod);

            return ((int) (total - ans) % mod + mod) % mod;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}