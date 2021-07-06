// 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
//
// 
//
// 示例： 
//
// 输入：
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//输出：3
//解释：
//长度最长的公共子数组是 [3, 2, 1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(A), len(B) <= 1000 
// 0 <= A[i], B[i] < 100 
// 
// Related Topics 数组 二分查找 动态规划 滑动窗口 哈希函数 滚动哈希 
// 👍 480 👎 0


package cn.db117.leetcode.solution7;

/**
 * 718.最长重复子数组.maximum-length-of-repeated-subarray
 *
 * @author db117
 * @since 2021-07-06 14:46:29
 **/

public class Solution_718 {
    public static void main(String[] args) {
        Solution solution = new Solution_718().new Solution();

        // 4
        System.out.println(solution.findLength(new int[]{
                0, 0, 0, 0, 1
        }, new int[]{
                1, 0, 0, 0, 0
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            // 动态规划
            //  dp[i][j] 表示 以 nums1[i-1]，nums2[j-1] 结尾的子数组长度
            int[][] dp = new int[nums1.length + 1][nums2.length + 1];
            int max = 0;
            for (int i = 0; i < nums1.length; i++) {
                for (int j = 0; j < nums2.length; j++) {
                    if (nums1[i] == nums2[j]) {
                        // 以当前数字为子数组尾部的数量 = 前面一个数字为尾部的数量 + 1
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                        max = Math.max(dp[i + 1][j + 1], max);
                    }
                }
            }


            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}