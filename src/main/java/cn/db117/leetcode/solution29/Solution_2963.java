

//给你一个下标从 0 开始、由 正整数 组成的数组 nums。 
//
// 将数组分割成一个或多个 连续 子数组，如果不存在包含了相同数字的两个子数组，则认为是一种 好分割方案 。 
//
// 返回 nums 的 好分割方案 的 数目。 
//
// 由于答案可能很大，请返回答案对 10⁹ + 7 取余 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：8
//解释：有 8 种 好分割方案 ：([1], [2], [3], [4]), ([1], [2], [3,4]), ([1], [2,3], [4]), ([
//1], [2,3,4]), ([1,2], [3], [4]), ([1,2], [3,4]), ([1,2,3], [4]) 和 ([1,2,3,4]) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,1]
//输出：1
//解释：唯一的 好分割方案 是：([1,1,1,1]) 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,1,3]
//输出：2
//解释：有 2 种 好分割方案 ：([1,2,1], [3]) 和 ([1,2,1,3]) 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 数学 组合数学 👍 7 👎 0


package cn.db117.leetcode.solution29;

import java.util.HashMap;
import java.util.Map;

/**
 * 2963.统计好分割方案的数目.count-the-number-of-good-partitions
 * 合并区间
 *
 * @author db117
 * @since 2023-12-13 11:37:47
 **/

public class Solution_2963 {
    public static void main(String[] args) {
        Solution solution = new Solution_2963().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int mod = (int) (1e9 + 7);

        public int numberOfGoodPartitions(int[] nums) {
            long ans = 1;
            // 每个数字出现的最大下标
            Map<Integer, Integer> max = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                max.put(nums[i], i);
            }

            // 找到最小的区间(相同数字必须在一个区间)
            int right = -1;// 区间右边界
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                right = Math.max(right, max.get(num));

                if (i >= right) {
                    // 当前位置是这个区间的最后一个
                    count++;
                    right = i + 1;
                }
            }

            // 一共有 count 的小区间 随意组合 2 的 count-1 次方
            for (int i = 0; i < count - 1; i++) {
                ans *= 2;
                ans %= mod;
            }

            return (int) (ans % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}