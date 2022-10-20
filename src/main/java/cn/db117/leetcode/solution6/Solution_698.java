

//给定一个整数数组 nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。 
//
// 
//
// 示例 1： 
//
// 
//输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
//输出： True
//说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。 
//
// 示例 2: 
//
// 
//输入: nums = [1,2,3,4], k = 3
//输出: false 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= len(nums) <= 16 
// 0 < nums[i] < 10000 
// 每个元素的频率在 [1,4] 范围内 
// 
//
// Related Topics 位运算 记忆化搜索 数组 动态规划 回溯 状态压缩 👍 848 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 698.划分为k个相等的子集.partition-to-k-equal-sum-subsets
 *
 * @author db117
 * @since 2022-10-20 17:07:08
 **/

public class Solution_698 {
    public static void main(String[] args) {
        Solution solution = new Solution_698().new Solution();
        //[4,3,2,3,5,2,1]
        //4
        // true
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));

        // [2,2,2,2,3,4,5]
        //4
        // false
        System.out.println(solution.canPartitionKSubsets(new int[]{2, 2, 2, 2, 3, 4, 5}, 4));

        //[4,5,9,3,10,2,10,7,10,8,5,9,4,6,4,9]
        //5
        // true
        System.out.println(solution.canPartitionKSubsets(new int[]{4, 5, 9, 3, 10, 2, 10, 7, 10, 8, 5, 9, 4, 6, 4, 9}, 5));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0) {
                return false;
            }
            int target = sum / k;
            Arrays.sort(nums);
            if (nums[nums.length - 1] > target) {
                return false;
            }

            int[] arr = new int[k];
            // k 个桶
            Arrays.fill(arr, target);

            // 看能不能放完
            return dfs(nums, arr, nums.length - 1);
        }

        private boolean dfs(int[] nums, int[] arr, int index) {
            // 所有数字都放完了
            if (index < 0) {
                return true;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    // 桶放满了
                    continue;
                }
                if (i > 0 && arr[i] == arr[i - 1]) {
                    // 上一个桶一样的树放不下,这个肯定放不下
                    continue;
                }
                if (arr[i] >= nums[index]) {
                    arr[i] -= nums[index];

                    if (dfs(nums, arr, index - 1)) {
                        // 都放完了
                        return true;
                    }
                    // 放不了,回溯 从下一个桶开始试
                    arr[i] += nums[index];
                }
            }

            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}