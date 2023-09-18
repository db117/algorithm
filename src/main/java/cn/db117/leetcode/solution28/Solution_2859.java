

//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。 
//
// 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。 
//
// 整数的二进制表示中的 1 就是这个整数的 置位 。 
//
// 例如，21 的二进制表示为 10101 ，其中有 3 个置位。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,10,1,5,2], k = 1
//输出：13
//解释：下标的二进制表示是： 
//0 = 0002
//1 = 0012
//2 = 0102
//3 = 0112
//4 = 1002 
//下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
//因此，答案为 nums[1] + nums[2] + nums[4] = 13 。 
//
// 示例 2： 
//
// 
//输入：nums = [4,3,2,1], k = 2
//输出：1
//解释：下标的二进制表示是： 
//0 = 002
//1 = 012
//2 = 102
//3 = 112
//只有下标 3 的二进制表示中存在 k = 2 个置位。
//因此，答案为 nums[3] = 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁵ 
// 0 <= k <= 10 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution28;

import java.util.List;

/**
 * 2859.计算 K 置位下标对应元素的和.sum-of-values-at-indices-with-k-set-bits
 *
 * @author db117
 * @since 2023-09-18 11:13:14
 **/

public class Solution_2859 {
    public static void main(String[] args) {
        Solution solution = new Solution_2859().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
            int ans = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (Integer.bitCount(i) == k) {
                    ans += nums.get(i);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}