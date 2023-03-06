

//给定一个包含 奇数 个整数的 m x n 矩阵 grid，其中每一行按 非递减 的顺序排序，返回矩阵的 中位数。 
//
// 你必须以 O(m * log(n)) 的时间复杂度来解决这个问题。 
//
// 
//
// 示例 1: 
//
// 
//输入: grid = [[1,1,2],[2,3,3],[1,3,4]]
//输出: 2
//解释: 矩阵的元素按顺序排列为 1,1,1,2,2,3,3,3,4。中位数是 2。
// 
//
// 示例 2: 
//
// 
//输入: grid = [[1,1,3,3,4]]
//输出: 3
//解释: 矩阵的元素按顺序排列为 1,1,3,3,4。中位数是 3。
// 
//
// 
//
// 提示: 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 500 
// m 和 n 都是奇数。 
// 1 <= grid[i][j] <= 10⁶ 
// grid[i] 按非递减顺序排序 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 1 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2387.行排序矩阵的中位数.median-of-a-row-wise-sorted-matrix
 *
 * @author db117
 * @since 2023-03-03 11:14:36
 **/

public class Solution_2387 {
    public static void main(String[] args) {
        Solution solution = new Solution_2387().new Solution();
        // [[1,1,2],[2,3,3],[1,3,4]]

        System.out.println(solution.matrixMedian(new int[][]{{1, 1, 2}, {2, 3, 3}, {1, 3, 4}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int matrixMedian(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int left = 0, right = (int) 10e6;
            while (left < right) {
                int mid = (left + right) / 2;
                int check = check(mid, grid);
                if (check == 0) {
                    return mid;
                } else if (check < 0) {
                    right = mid;
                } else {
                    left = mid + 1;
                }

            }
            return -1;
        }

        private int check(int x, int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int all = m * n / 2;
            int left = 0, right = 0;
            for (int[] ints : grid) {
                // 比当前值小的数量
                left += leftCount(x, ints);
                // 比当前值大的数量
                right += rightCount(x, ints);
            }
            if (left <= all && right <= all) {
                // 说明当前数字在中间
                return 0;
            } else if (left > all) {
                // 数字太大了
                return -1;
            } else {
                return 1;
            }

        }

        private int leftCount(int target, int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (arr[mid] < target) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (arr[left] < target) {
                // 返回小于目标的数量
                return left + 1;
            }
            return left;
        }

        private int rightCount(int target, int[] arr) {
            int left = 0, right = arr.length - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (arr[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (arr[right] > target) {
                // 返回大于目标的数量
                return arr.length - right;
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}