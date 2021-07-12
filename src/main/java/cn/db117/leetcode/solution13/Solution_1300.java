//给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和
//最接近 target （最接近表示两者之差的绝对值最小）。 
//
// 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。 
//
// 请注意，答案不一定是 arr 中的数字。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,9,3], target = 10
//输出：3
//解释：当选择 value 为 3 时，数组会变成 [3, 3, 3]，和为 9 ，这是最接近 target 的方案。
// 
//
// 示例 2： 
//
// 输入：arr = [2,3,5], target = 10
//输出：5
// 
//
// 示例 3： 
//
// 输入：arr = [60864,25176,27249,21296,20204], target = 56803
//输出：11361
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^4 
// 1 <= arr[i], target <= 10^5 
// 
// Related Topics 数组 二分查找 排序 
// 👍 132 👎 0


package cn.db117.leetcode.solution13;

import java.util.Arrays;

/**
 * 1300.转变数组后最接近目标值的数组和.sum-of-mutated-array-closest-to-target
 *
 * @author db117
 * @since 2021-07-12 16:28:14
 **/

public class Solution_1300 {
    public static void main(String[] args) {
        Solution solution = new Solution_1300().new Solution();

        System.out.println(solution.findBestValue(new int[]{
                4, 9, 3
        }, 10));

        System.out.println(solution.findBestValue(new int[]{
                2, 3, 5
        }, 10));

        System.out.println(solution.findBestValue(new int[]{
                60864, 25176, 27249, 21296, 20204
        }, 56803));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findBestValue(int[] arr, int target) {
            Arrays.sort(arr);

            // 二分查找
            int left = 1, right = arr[arr.length - 1];
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int sum = sum(arr, mid);
                if (sum == target) {
                    // 找到了
                    return mid;
                } else if (sum > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            // 返回一个最小的
            int leftDiff = Math.abs(sum(arr, left) - target);
            int rightDiff = Math.abs(sum(arr, right) - target);

            return leftDiff < rightDiff ? left : right;
        }

        // 设置最大数后的和
        private int sum(int[] arr, int max) {
            int ans = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < max) {
                    ans += arr[i];
                } else {
                    // 后面都一样
                    ans += (arr.length - i) * max;
                    return ans;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}