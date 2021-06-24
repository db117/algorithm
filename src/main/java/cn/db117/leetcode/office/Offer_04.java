//在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个
//整数，判断数组中是否含有该整数。 
//
// 
//
// 示例: 
//
// 现有矩阵 matrix 如下： 
//
// 
//[
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
//
// 
//
// 限制： 
//
// 0 <= n <= 1000 
//
// 0 <= m <= 1000 
//
// 
//
// 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/ 
// Related Topics 数组 双指针 
// 👍 360 👎 0


package cn.db117.leetcode.office;

/**
 * 剑指 Offer 04.二维数组中的查找.er-wei-shu-zu-zhong-de-cha-zhao-lcof
 *
 * @author db117
 * @since 2021-06-24 11:57:25
 **/

public class Offer_04 {
    public static void main(String[] args) {
        Solution solution = new Offer_04().new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 19));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
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