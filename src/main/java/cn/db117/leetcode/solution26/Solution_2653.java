

//给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。 
//
// 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。 
//
// 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。 
//
// 
// 子数组指的是数组中一段连续 非空 的元素序列。 
// 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
//输出：[-1,-2,-2]
//解释：总共有 3 个 k = 3 的子数组。
//第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
//第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
//第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
//输出：[-1,-2,-3,-4]
//解释：总共有 4 个 k = 2 的子数组。
//[-1, -2] 中第二小的数是负数 -1 。
//[-2, -3] 中第二小的数是负数 -2 。
//[-3, -4] 中第二小的数是负数 -3 。
//[-4, -5] 中第二小的数是负数 -4 。 
//
// 示例 3： 
//
// 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
//输出：[-3,0,-3,-3,-3]
//解释：总共有 5 个 k = 2 的子数组。
//[-3, 1] 中最小的数是负数 -3 。
//[1, 2] 中最小的数不是负数，所以美丽值为 0 。
//[2, -3] 中最小的数是负数 -3 。
//[-3, 0] 中最小的数是负数 -3 。
//[0, -3] 中最小的数是负数 -3 。 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= k <= n 
// 1 <= x <= k 
// -50 <= nums[i] <= 50 
// 
//
// 👍 12 👎 0


package cn.db117.leetcode.solution26;

import java.util.Arrays;

/**
 * 2653.滑动子数组的美丽值.sliding-subarray-beauty
 *
 * @author db117
 * @since 2023-04-24 13:59:22
 **/

public class Solution_2653 {
    public static void main(String[] args) {
        Solution solution = new Solution_2653().new Solution();
        // nums = [-3,1,2,-3,0,-3], k = 2, x = 1
        System.out.println(Arrays.toString(solution.getSubarrayBeauty(new int[]{-3, 1, 2, -3, 0, -3}, 2, 1)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int base = 50;

        public int[] getSubarrayBeauty(int[] nums, int k, int x) {
            int n = nums.length;
            // 计数排序
            int[] cnt = new int[2 * base + 1];
            int[] ans = new int[n - k + 1];

            for (int i = 0; i < n; i++) {
                cnt[nums[i] + base]++;
                if (i < k - 1) {
                    continue;
                }

                // 从排序里面找第 x 个数字
                ans[i - k + 1] = hepler(cnt, x);
                // 减去起前面的数字
                cnt[nums[i - k + 1] + base]--;

            }
            return ans;
        }

        private int hepler(int[] arr, int x) {
            int sum = 0;
            for (int i = 0; i < base; i++) {
                sum += arr[i];
                if (sum >= x) {
                    return i - base;
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}