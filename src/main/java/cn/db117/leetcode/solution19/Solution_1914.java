

//给你一个大小为 m x n 的整数矩阵 grid ，其中 m 和 n 都是 偶数 ；另给你一个整数 k 。 
//
// 矩阵由若干层组成，如下图所示，每种颜色代表一层： 
//
// 
//
// 矩阵的循环轮转是通过分别循环轮转矩阵中的每一层完成的。在对某一层进行一次循环旋转操作时，层中的每一个元素将会取代其 逆时针 方向的相邻元素。轮转示例如下：
// 
// 返回执行 k 次循环轮转操作后的矩阵。 
//
// 
//
// 示例 1： 
// 输入：grid = [[40,10],[30,20]], k = 1
//输出：[[10,20],[40,30]]
//解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。 
//
// 示例 2： 
// 
// 
//
//
// 输入：grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
//输出：[[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
//解释：上图展示了矩阵在执行循环轮转操作时每一步的状态。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 2 <= m, n <= 50 
// m 和 n 都是 偶数 
// 1 <= grid[i][j] <= 5000 
// 1 <= k <= 10⁹ 
// 
//
// Related Topics 数组 矩阵 模拟 👍 42 👎 0


package cn.db117.leetcode.solution19;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1914.循环轮转矩阵.cyclically-rotating-a-grid
 *
 * @author db117
 * @since 2026-05-09 16:36:35
 **/

public class Solution_1914 {
    public static void main(String[] args) {
        Solution solution = new Solution_1914().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右下左上

        public int[][] rotateGrid(int[][] grid, int k) {
            int m0 = grid.length;
            int n0 = grid[0].length;
            List<Integer> list = new ArrayList<>((m0 + n0) * 2);// 一圈的数据
            int round = Math.min(m0, n0) / 2;// 圈数

            // 记录当前圈的数字
            for (int i = 0; i < round; i++) {
                // 当前圈的数量
                int m = m0 - 2 * i;
                int n = n0 - 2 * i;
                int x = i, y = i; // 这一圈的左上角

                list.clear();
                for (int[] dir : DIRS) {
                    for (int j = 0; j < n - 1; j++) {
                        list.add(grid[x][y]);
                        x += dir[0];
                        y += dir[1];
                    }
                    // 旋转方向
                    int tmp = n;
                    n = m;
                    m = tmp;
                }

                // 当前 xy 又回到了起始位置
                int shift = k % list.size();
                Collections.rotate(list, -shift);

                int z = 0;
                for (int[] dir : DIRS) {
                    // 按照方向赋值
                    for (int j = 0; j < n - 1; j++) {
                        grid[x][y] = list.get(z++);
                        x += dir[0];
                        y += dir[1];
                    }
                    // 旋转方向
                    int tmp = n;
                    n = m;
                    m = tmp;
                }
            }


            return grid;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}