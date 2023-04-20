

//给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。 
//
// 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j 
//< arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。 
//
// 如果无法让 arr1 严格递增，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
//输出：1
//解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
// 
//
// 示例 2： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
//输出：2
//解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
// 
//
// 示例 3： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
//输出：-1
//解释：无法使 arr1 严格递增。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 2000 
// 0 <= arr1[i], arr2[i] <= 10^9 
// 
//
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 128 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1187.使数组严格递增.make-array-strictly-increasing
 *
 * @author db117
 * @since 2023-04-20 09:53:07
 **/

public class Solution_1187 {
    public static void main(String[] args) {
        Solution solution = new Solution_1187().new Solution();
        // 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
        //输出：1
//        System.out.println(solution.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4}));

        // [1,5,3,6,7]
        //arr2 =
        //[4,3,1]
//        System.out.println(solution.makeArrayIncreasing(new int[]{1, 5, 3, 6, 7}, new int[]{4, 3, 1}));

        // [5,16,19,2,1,12,7,14,5,16]
        // [6,17,4,3,6,13,4,3,18,17,16,7,14,1,16]
        // 8
        System.out.println(solution.makeArrayIncreasing(new int[]{5, 16, 19, 2, 1, 12, 7, 14, 5, 16},
                new int[]{6, 17, 4, 3, 6, 13, 4, 3, 18, 17, 16, 7, 14, 1, 16}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] a;
        int[] b;
        Map<Integer, Integer>[] memo;

        public int makeArrayIncreasing(int[] arr1, int[] arr2) {
            Arrays.sort(arr2);
            this.a = arr1;
            this.b = arr2;
            memo = new HashMap[arr1.length];
            // 从最后一个数字开始，选择换和不换，找最小值
            int dfs = dfs(arr1.length - 1, Integer.MAX_VALUE);

            return dfs >= Integer.MAX_VALUE / 2 ? -1 : dfs;
        }

        public int dfs(int i, int max) {
            if (i < 0) {
                return 0;
            }
            // 备忘
            if (memo[i] == null) {
                memo[i] = new HashMap<>();
            }
            if (memo[i].containsKey(max)) {
                return memo[i].get(max);
            }
            // Integer.MAX_VALUE / 2 比这个数字大的都不行
            int ans = Integer.MAX_VALUE / 2;

            // 对当前数字进行替换
            int lowerBound = lowerBound(b, max);
            if (lowerBound != -1) {
                // 前面的数字不能比当前选的值大
                // 前面需要换的次数
                ans = dfs(i - 1, b[lowerBound] - 1) + 1;

            }

            // 不换
            // 前面的最大值不能比当前值大
            if (a[i] <= max) {
                ans = Math.min(ans, dfs(i - 1, a[i] - 1));
            }

            memo[i].put(max, ans);
            return ans;
        }

        // 找小于等于目标值的最大值
        public int lowerBound(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (arr[mid] <= target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            return arr[left] <= target ? left : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}