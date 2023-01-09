

//给你一个下标从 0 开始的整数数组 nums 。 
//
// 三个下标 i ，j 和 k 的 有效值 定义为 ((nums[i] | nums[j]) & nums[k]) 。 
//
// 一个数组的 xor 美丽值 是数组中所有满足 0 <= i, j, k < n 的三元组 (i, j, k) 的 有效值 的异或结果。 
//
// 请你返回 nums 的 xor 美丽值。 
//
// 注意： 
//
// 
// val1 | val2 是 val1 和 val2 的按位或。 
// val1 & val2 是 val1 和 val2 的按位与。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,4]
//输出：5
//解释：
//三元组和它们对应的有效值如下：
//- (0,0,0) 有效值为 ((1 | 1) & 1) = 1
//- (0,0,1) 有效值为 ((1 | 1) & 4) = 0
//- (0,1,0) 有效值为 ((1 | 4) & 1) = 1
//- (0,1,1) 有效值为 ((1 | 4) & 4) = 4
//- (1,0,0) 有效值为 ((4 | 1) & 1) = 1
//- (1,0,1) 有效值为 ((4 | 1) & 4) = 4
//- (1,1,0) 有效值为 ((4 | 4) & 1) = 0
//- (1,1,1) 有效值为 ((4 | 4) & 4) = 4 
//数组的 xor 美丽值为所有有效值的按位异或 1 ^ 0 ^ 1 ^ 4 ^ 1 ^ 4 ^ 0 ^ 4 = 5 。 
//
// 示例 2： 
//
// 
//输入：nums = [15,45,20,2,34,35,5,44,32,30]
//输出：34
//解释：数组的 xor 美丽值为 34 。
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
// 👍 6 👎 0


package cn.db117.leetcode.solution25;

/**
 * 2527.查询数组 Xor 美丽值.find-xor-beauty-of-array
 *
 * @author db117
 * @since 2023-01-09 17:46:10
 **/

public class Solution_2527 {
    public static void main(String[] args) {
        Solution solution = new Solution_2527().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int xorBeauty(int[] nums) {
            // 一顿乱推,直接求数组异或
            int ans = 0;
            for (int num : nums) {
                ans ^= num;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}