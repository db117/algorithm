// 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
//
// 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
//
// 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。 
//
// 在替换数组 nums1 中最多一个元素之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
//
// |x| 定义为： 
//
// 
// 如果 x >= 0 ，值为 x ，或者 
// 如果 x <= 0 ，值为 -x 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,7,5], nums2 = [2,3,5]
//输出：3
//解释：有两种可能的最优方案：
//- 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [2,4,6,8,10], nums2 = [2,4,6,8,10]
//输出：0
//解释：nums1 和 nums2 相等，所以不用替换元素。绝对差值和为 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [1,10,4,4,2,7], nums2 = [9,3,5,1,7,4]
//输出：20
//解释：将第一个元素替换为第二个元素：[1,10,4,4,2,7] => [10,10,4,4,2,7]
//绝对差值和为 |10-9| + |10-3| + |4-5| + |4-1| + |2-7| + |7-4| = 20
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length 
// n == nums2.length 
// 1 <= n <= 105 
// 1 <= nums1[i], nums2[i] <= 105 
// 
// Related Topics 贪心 数组 二分查找 有序集合 
// 👍 102 👎 0


package cn.db117.leetcode.solution18;

import java.util.Arrays;

/**
 * 1818.绝对差值和.minimum-absolute-sum-difference
 *
 * @author db117
 * @since 2021-07-26 14:15:31
 **/

public class Solution_1818 {
    public static void main(String[] args) {
        Solution solution = new Solution_1818().new Solution();


        System.out.println(solution.minAbsoluteSumDiff(new int[]{
                1, 7, 5
        }, new int[]{
                2, 3, 5
        }));
        System.out.println(solution.minAbsoluteSumDiff(new int[]{
                2, 4, 6, 8, 10
        }, new int[]{
                2, 4, 6, 8, 10
        }));
        System.out.println(solution.minAbsoluteSumDiff(new int[]{
                1, 10, 4, 4, 2, 7
        }, new int[]{
                9, 3, 5, 1, 7, 4
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
            int mod = 1_000_000_007;
            int[] arr = nums1.clone();
            Arrays.sort(arr);

            long sum = 0;
            // 交换后能缩小最大的 绝对差值
            int maxDiff = 0;
            for (int i = 0, length = nums2.length; i < length; i++) {
                // 当前 绝对差值
                int diff = Math.abs(nums2[i] - nums1[i]);
                sum += diff;


                // 交换后能缩小多少 绝对差值
                if (nums2[i] > arr[length - 1]) {
                    // 特殊处理
                    maxDiff = Math.max(maxDiff, diff - (nums2[i] - arr[length - 1]));
                    continue;
                }

                // 找到大于等于目标的最小值
                int bs = bs(arr, nums2[i]);
                if (bs != -1) {
                    maxDiff = Math.max(maxDiff, diff - (arr[bs] - nums2[i]));
                }

                if (bs > 0) {
                    // 尝试找最大的差值
                    maxDiff = Math.max(maxDiff, diff - (nums2[i] - arr[bs - 1]));
                }


            }
            return (int) ((sum - maxDiff) % mod);
        }

        // 找到大于等于目标的最小值
        private int bs(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            if (arr[right] < target) {
                return -1;
            }
            if (arr[left] >= target) {
                return left;
            }

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] >= target) {
                    // 当前值可能是结果，可以继续往下找
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}