// 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// [
//  [1,   4,  7, 11, 15],
//  [2,   5,  8, 12, 19],
//  [3,   6,  9, 16, 22],
//  [10, 13, 14, 17, 24],
//  [18, 21, 23, 26, 30]
//]
// 
//
// 给定 target = 5，返回 true。 
//
// 给定 target = 20，返回 false。 
// Related Topics 双指针 二分查找 分治算法 
// 👍 28 👎 0


package cn.db117.leetcode.interview;

/**
 * 面试题 10.09.排序矩阵查找.sorted-matrix-search-lcci
 *
 * @author db117
 * @since 2021-06-24 16:15:13
 **/

public class Interview_1009 {
    public static void main(String[] args) {
        Solution solution = new Interview_1009().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }
            // 一行一行二分
            for (int[] arr : matrix) {
                if (arr[0] <= target && arr[arr.length - 1] >= target) {
                    // 可能在这一行
                    if (bs(arr, target) != -1) {
                        return true;
                    }
                }
            }

            return false;
        }

        // 简单二分
        private int bs(int[] arr, int target) {
            int left = 0, right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    left = left + 1;
                } else {
                    right = mid - 1;
                }
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}