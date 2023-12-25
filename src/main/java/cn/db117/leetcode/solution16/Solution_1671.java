

//我们定义 arr 是 山形数组 当且仅当它满足： 
//
// 
// arr.length >= 3 
// 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且： 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给你整数数组 nums ，请你返回将 nums 变成 山形状数组 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1]
//输出：0
//解释：数组本身就是山形数组，所以我们不需要删除任何元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,1,5,6,2,3,1]
//输出：3
//解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 题目保证 nums 删除一些元素后一定能得到山形数组。 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 👍 76 👎 0


package cn.db117.leetcode.solution16;

import java.util.ArrayList;

/**
 * 1671.得到山形数组的最少删除次数.minimum-number-of-removals-to-make-mountain-array
 *
 * @author db117
 * @since 2023-12-22 10:38:16
 **/

public class Solution_1671 {
    public static void main(String[] args) {
        Solution solution = new Solution_1671().new Solution();
        // 4,3,2,1,1,2,3,1
        // 4
//        System.out.println(solution.minimumMountainRemovals(new int[]{
//                4, 3, 2, 1, 1, 2, 3, 1
//        }));

        // 23,47,63,72,81,99,88,55,21,33,32
        // 1
//        System.out.println(solution.minimumMountainRemovals(new int[]{
//                23, 47, 63, 72, 81, 99, 88, 55, 21, 33, 32
//        }));

        // [100,92,89,77,74,66,64,66,64]
        // 6
        System.out.println(solution.minimumMountainRemovals(new int[]{
                100, 92, 89, 77, 74, 66, 64, 66, 64
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumMountainRemovals(int[] nums) {
            int n = nums.length;
            // 单调栈找最长递增子序列
            int[] left = new int[n];
            int[] right = new int[n];
            int ans = n;

            // 最长递增子序列(lts) 模板
            ArrayList<Integer> g = new ArrayList<>();
            for (int i = 0; i < n - 1; i++) {
                int num = nums[i];
                int index = bsGreaterEqualMin(g, num);
                if (index == g.size()) {
                    g.add(num);
                } else {
                    g.set(index, num);
                }
                left[i] = index + 1;
            }
            g.clear();
            for (int i = n - 1; i > 0; i--) {
                int num = nums[i];
                int index = bsGreaterEqualMin(g, num);
                if (index == g.size()) {
                    g.add(num);
                } else {
                    g.set(index, num);
                }
                right[i] = index + 1;
            }

            // 两边的最长递增子序列
            for (int i = 1; i < n - 1; i++) {
                if (left[i] >= 2 && right[i] >= 2) {// 左右必须有值
                    ans = Math.min(ans, n - (left[i] + right[i] - 1));
                }
            }
            return ans;
        }


        /**
         * 大于等于目标值的最小值
         */
        public int bsGreaterEqualMin(ArrayList<Integer> nums, int target) {
            if (nums.isEmpty()) {
                return 0;
            }
            int left = 0, right = nums.size() - 1;
            while (left < right) {
                // 左边中位数
                int mid = left + ((right - left) >> 1);
                if (nums.get(mid) < target) {
                    // 移动左边界
                    // 上面选择左边中位数,所有加一
                    left = mid + 1;
                } else {
                    // 大于等于则保持右边界
                    // 等于则继续往左边查找
                    right = mid;
                }
            }

            // 需要判断是否找到
            return nums.get(right) >= target ? right : nums.size();// 找不到返回最后一个
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}