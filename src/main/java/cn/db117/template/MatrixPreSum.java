package cn.db117.template;

/**
 * 二维前缀和
 *
 * @see cn.db117.leetcode.solution3.Solution_304
 */
public class MatrixPreSum {
    class NumMatrix {
        int[][] sums;

        public NumMatrix(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) {
                return;
            }
            int n = matrix[0].length;
            if (n == 0) {
                return;
            }
            sums = new int[m + 1][n + 1];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    // 把一整块分成 4 份,其中 3 份已经算过了
                    sums[i + 1][j + 1] = sums[i][j + 1] + sums[i + 1][j] - sums[i][j] + matrix[i][j];
                }
            }


        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return sums[row2 + 1][col2 + 1] + sums[row1][col1] - sums[row1][col2 + 1] - sums[row2 + 1][col1];
        }
    }
}
