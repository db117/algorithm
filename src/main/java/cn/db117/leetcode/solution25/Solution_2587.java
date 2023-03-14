

//给你一个下标从 0 开始的整数数组 nums 。你可以将 nums 中的元素按 任意顺序 重排（包括给定顺序）。 
//
// 令 prefix 为一个数组，它包含了 nums 重新排列后的前缀和。换句话说，prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和
//。nums 的 分数 是 prefix 数组中正整数的个数。 
//
// 返回可以得到的最大分数。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,-1,0,1,-3,3,-3]
//输出：6
//解释：数组重排为 nums = [2,3,1,-1,-3,0,-3] 。
//prefix = [2,5,6,5,2,2,-1] ，分数为 6 。
//可以证明 6 是能够得到的最大分数。
// 
//
// 示例 2： 
//
// 输入：nums = [-2,-3,0]
//输出：0
//解释：不管怎么重排数组得到的分数都是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁶ <= nums[i] <= 10⁶ 
// 
//
// Related Topics 贪心 数组 前缀和 排序 👍 5 👎 0


package cn.db117.leetcode.solution25;

import java.util.Arrays;

/**
 * 2587.重排数组以得到最大前缀分数.rearrange-array-to-maximize-prefix-score
 *
 * @author db117
 * @since 2023-03-14 14:52:58
 **/

public class Solution_2587 {
    public static void main(String[] args) {
        Solution solution = new Solution_2587().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxScore(int[] nums) {
            Arrays.sort(nums);
            long sum = 0;// 所有数的和
            int ans = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                sum += nums[i];//  不小于 0 则和不会减少
                if (sum > 0) {
                    ans++;
                } else {
                    // 负数已经把整数的和减光了
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}