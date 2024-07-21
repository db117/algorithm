

//给你一个整数数组 nums 和一个 正 整数 k 。
//
// nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ： 
//
// 
// (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x 
//- 1]) % k 
// 返回 
//nums 的 
//最长
//有效子序列 的长度。
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,2,3,4,5], k = 2 
// 
//
// 输出：5 
//
// 解释： 
//
// 最长有效子序列是 [1, 2, 3, 4, 5] 。 
//
// 示例 2： 
//
// 
// 输入：nums = [1,4,2,3,1,4], k = 3 
// 
//
// 输出：4 
//
// 解释： 
//
// 最长有效子序列是 [1, 4, 1, 4] 。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10³ 
// 1 <= nums[i] <= 10⁷ 
// 1 <= k <= 10³ 
// 
//
// Related Topics 数组 动态规划 👍 5 👎 0


package cn.db117.leetcode.solution32;

/**
 * 3202.找出有效子序列的最大长度 II.find-the-maximum-length-of-valid-subsequence-ii
 *
 * @author db117
 * @since 2024-07-04 13:54:53
 **/

public class Solution_3202 {
    public static void main(String[] args) {
        Solution solution = new Solution_3202().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums, int k) {
            int ans = 0;
            // fn[i][j] 表示以 i j 相互交替出现的次数
            int[][] fn = new int[k][k];
            for (int num : nums) {
                int x = num % k;
                for (int j = 0; j < k; j++) {
                    // x j 交替出现的次数 = j x 交替出现的次数 + 1
                    fn[x][j] = fn[j][x] + 1;
                    ans = Math.max(ans, fn[x][j]);
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}