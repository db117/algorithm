

//给你一个 m x n 的矩阵 mat，其中每一行的元素均符合 严格递增 。请返回 所有行中的 最小公共元素 。 
//
// 如果矩阵中没有这样的公共元素，就请返回 -1。 
//
// 
//
// 示例 1： 
//
// 
//输入：mat = [[1,2,3,4,5],[2,4,5,8,10],[3,5,7,9,11],[1,3,5,7,9]]
//输出：5
// 
//
// 示例 2: 
//
// 
//输入：mat = [[1,2,3],[2,3,4],[2,3,5]]
//输出： 2
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁴ 
// mat[i] 已按严格递增顺序排列。 
// 
//
// Related Topics 数组 哈希表 二分查找 计数 矩阵 👍 28 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1198.找出所有行中最小公共元素.find-smallest-common-element-in-all-rows
 *
 * @author db117
 * @since 2023-03-28 17:14:41
 **/

public class Solution_1198 {
    public static void main(String[] args) {
        Solution solution = new Solution_1198().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int smallestCommonElement(int[][] mat) {
            int row = mat.length;
            int[] hash = new int[10001];
            // 统计数字出现的次数
            for (int[] ints : mat) {
                for (int anInt : ints) {
                    hash[anInt]++;
                }
            }
            for (int i = 0; i < hash.length; i++) {
                if (hash[i] == row) {
                    return i;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}