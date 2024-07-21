

//给你一个整数数组 nums。 
//
// nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列： 
//
// 
// (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x 
//- 1]) % 2 
// 
//
// 返回 nums 的 最长的有效子序列 的长度。 
//
// 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3,4] 
// 
//
// 输出： 4 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 3, 4]。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,1,1,2,1,2] 
// 
//
// 输出： 6 
//
// 解释： 
//
// 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。 
//
// 示例 3： 
//
// 
// 输入： nums = [1,3] 
// 
//
// 输出： 2 
//
// 解释： 
//
// 最长的有效子序列是 [1, 3]。 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 2 * 10⁵ 
// 1 <= nums[i] <= 10⁷ 
// 
//
// Related Topics 数组 动态规划 👍 2 👎 0


package cn.db117.leetcode.solution32;

/**
 * 3201.找出有效子序列的最大长度 I.find-the-maximum-length-of-valid-subsequence-i
 *
 * @author db117
 * @since 2024-07-04 14:25:19
 **/

public class Solution_3201 {
    public static void main(String[] args) {
        Solution solution = new Solution_3201().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumLength(int[] nums) {
            return maximumLength(nums, 2);
        }

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