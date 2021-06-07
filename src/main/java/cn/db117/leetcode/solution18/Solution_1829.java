//给你一个 有序 数组 nums ，它由 n 个非负整数组成，同时给你一个整数 maximumBit 。你需要执行以下查询 n 次：
//
// 
// 找到一个非负整数 k < 2maximumBit ，使得 nums[0] XOR nums[1] XOR ... XOR nums[nums.length
//-1] XOR k 的结果 最大化 。k 是第 i 个查询的答案。 
// 从当前数组 nums 删除 最后 一个元素。 
// 
//
// 请你返回一个数组 answer ，其中 answer[i]是第 i 个查询的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,1,3], maximumBit = 2
//输出：[0,3,2,3]
//解释：查询的答案如下：
//第一个查询：nums = [0,1,1,3]，k = 0，因为 0 XOR 1 XOR 1 XOR 3 XOR 0 = 3 。
//第二个查询：nums = [0,1,1]，k = 3，因为 0 XOR 1 XOR 1 XOR 3 = 3 。
//第三个查询：nums = [0,1]，k = 2，因为 0 XOR 1 XOR 2 = 3 。
//第四个查询：nums = [0]，k = 3，因为 0 XOR 3 = 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,3,4,7], maximumBit = 3
//输出：[5,2,6,5]
//解释：查询的答案如下：
//第一个查询：nums = [2,3,4,7]，k = 5，因为 2 XOR 3 XOR 4 XOR 7 XOR 5 = 7。
//第二个查询：nums = [2,3,4]，k = 2，因为 2 XOR 3 XOR 4 XOR 2 = 7 。
//第三个查询：nums = [2,3]，k = 6，因为 2 XOR 3 XOR 6 = 7 。
//第四个查询：nums = [2]，k = 5，因为 2 XOR 5 = 7 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1,2,2,5,7], maximumBit = 3
//输出：[4,3,6,4,6,7]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// 1 <= n <= 105 
// 1 <= maximumBit <= 20 
// 0 <= nums[i] < 2maximumBit 
// nums 中的数字已经按 升序 排好序。 
// 
// Related Topics 位运算 
// 👍 11 👎 0


package cn.db117.leetcode.solution18;

import java.util.Arrays;

/**
 * 1829.每个查询的最大异或值.maximum-xor-for-each-query
 *
 * @author db117
 * @since 2021-06-07 14:21:07
 **/

public class Solution_1829 {
    public static void main(String[] args) {
        Solution solution = new Solution_1829().new Solution();
        System.out.println(Arrays.toString(solution.getMaximumXor(new int[]{
                0, 1, 2, 2, 5, 7
        }, 3)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getMaximumXor(int[] nums, int maximumBit) {
            int[] ans = new int[nums.length];
            // 最大值为 11..11 = 数组异或和 ^ k
            // k= 1111111(mark) ^ 数字异或和
            int mark = (1 << maximumBit) - 1;

            // 数组异或和
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }

            for (int i = 0; i < ans.length; i++) {
                ans[i] = xor ^ mark;
                xor ^= nums[nums.length - 1 - i];
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}