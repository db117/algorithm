

//给你一个二维矩阵 matrix ，你需要处理下面两种类型的若干次查询： 
//
// 
// 更新：更新 matrix 中某个单元的值。 
// 求和：计算矩阵 matrix 中某一矩形区域元素的 和 ，该区域由 左上角 (row1, col1) 和 右下角 (row2, col2) 界定。 
// 
//
// 实现 NumMatrix 类： 
//
// 
// NumMatrix(int[][] matrix) 用整数矩阵 matrix 初始化对象。 
// void update(int row, int col, int val) 更新 matrix[row][col] 的值到 val 。 
// int sumRegion(int row1, int col1, int row2, int col2) 返回矩阵 matrix 中指定矩形区域元素的 
//和 ，该区域由 左上角 (row1, col1) 和 右下角 (row2, col2) 界定。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入
//["NumMatrix", "sumRegion", "update", "sumRegion"]
//[[[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 
//3, 0, 5]]], [2, 1, 4, 3], [3, 2, 2], [2, 1, 4, 3]]
//输出
//[null, 8, null, 10]
// 
//
//解释
//NumMatrix numMatrix = new NumMatrix([[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 
//0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]);
//numMatrix.sumRegion(2, 1, 4, 3); // 返回 8 (即, 左侧红色矩形的和)
//numMatrix.update(3, 2, 2); // 矩阵从左图变为右图
//numMatrix.sumRegion(2, 1, 4, 3); // 返回 10 (即，右侧红色矩形的和)
//
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 200 
// -10⁵ <= matrix[i][j] <= 10⁵ 
// 0 <= row < m 
// 0 <= col < n 
// -10⁵ <= val <= 10⁵ 
// 0 <= row1 <= row2 < m 
// 0 <= col1 <= col2 < n 
// 最多调用10⁴ 次 sumRegion 和 update 方法 
// 
//
// Related Topics 设计 树状数组 线段树 数组 矩阵 👍 74 👎 0


package cn.db117.leetcode.solution3;

/**
 * 308.二维区域和检索 - 可变.range-sum-query-2d-mutable
 *
 * @author db117
 * @since 2022-09-30 16:50:51
 **/

public class Solution_308 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumMatrix {
        TreeArray[] treeArrays;
        int m;
        int n;
        int[][] matrix;

        public NumMatrix(int[][] matrix) {
            this.matrix = matrix;
            m = matrix.length;
            n = matrix[0].length;
            // 初始化树状数组
            treeArrays = new TreeArray[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                treeArrays[i] = new TreeArray(matrix[i]);
            }
        }

        public void update(int row, int col, int val) {
            // 找到目标树状数组,并修改位置值
            treeArrays[row].add(col + 1, val - matrix[row][col]);
            matrix[row][col] = val;
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int ans = 0;
            for (int i = row1; i <= row2; i++) {
                // 对区间类树状数组进行查询
                ans += treeArrays[i].query(col2 + 1) - treeArrays[i].query(col1);
            }
            return ans;
        }


        public class TreeArray {
            // 下标从 1 开始
            int[] tree;

            public TreeArray(int[] nums) {
                tree = new int[nums.length + 10];
                for (int i = 0; i < nums.length; i++) {
                    add(i + 1, nums[i]);
                }
            }

            /**
             * 最后一个 1
             */
            public int lowBit(int i) {
                return i & -i;
            }

            /**
             * 在指定位置添加值
             *
             * @param x 数组位置(从 1 开始)
             * @param v 增加的值
             */
            public void add(int x, int v) {
                for (int i = x; i < tree.length; i += lowBit(i)) {
                    tree[i] += v;
                }
            }

            /**
             * 查询[1,x]的和
             *
             * @param x 数组位置(从 1 开始)
             */
            public int query(int x) {
                int ans = 0;
                for (int i = x; i > 0; i -= lowBit(i)) {
                    ans += tree[i];
                }
                return ans;
            }

        }
    }

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.update(row,col,val);
 * int param_2 = obj.sumRegion(row1,col1,row2,col2);
 */
//leetcode submit region end(Prohibit modification and deletion)

}