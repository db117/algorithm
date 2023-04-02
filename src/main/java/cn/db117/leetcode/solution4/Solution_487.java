

//给定一个二进制数组 nums ，如果最多可以翻转一个 0 ，则返回数组中连续 1 的最大个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,1,1,0]
//输出：4
//解释：翻转第一个 0 可以得到最长的连续 1。
//     当翻转以后，最大连续 1 的个数为 4。
// 
//
// 示例 2: 
//
// 
//输入：nums = [1,0,1,1,0,1]
//输出：4
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1. 
// 
//
// 
//
// 进阶：如果输入的数字是作为 无限流 逐个输入如何处理？换句话说，内存不能存储下所有从流中输入的数字。您可以有效地解决吗？ 
//
// Related Topics 数组 动态规划 滑动窗口 👍 128 👎 0


package cn.db117.leetcode.solution4;

/**
 * 487.最大连续1的个数 II.max-consecutive-ones-ii
 *
 * @author db117
 * @since 2023-03-30 15:12:07
 **/

public class Solution_487 {
    public static void main(String[] args) {
        Solution solution = new Solution_487().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int n = nums.length;
            int ans = 0;
            int preZero = 0;// 前面翻转过 0 次连续最长 1
            int preOne = 0;// 前面翻转过 1 次连续最长 1
            for (int num : nums) {
                if (num == 0) {
                    preOne = preZero + 1; // 前面一次没有换过 + 当前换过一次
                    preZero = 0;// 一次没有换过肯定是 0
                } else {
                    // 不需要转换
                    preOne++;
                    preZero++;
                }
                ans = Math.max(ans, Math.max(preOne, preZero));
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}