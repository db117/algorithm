package cn.db117.template;

/**
 * 二维差分
 *
 * @see cn.db117.leetcode.solution25.Solution_2536
 */
public class DiffArrayMatrix {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        // 二维差分
        // 数组开大防止越界
        int[][] diff = new int[n + 2][n + 2];

        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            // 向右下方平移,减少越界处理逻辑
            row1++;
            col1++;
            row2++;
            col2++;

            diff[row1][col1]++;
            diff[row2 + 1][col2 + 1]++;
            // 下面两个是从
            diff[row1][col2 + 1]--;
            diff[row2 + 1][col1]--;

        }

        int[][] ans = new int[n][n];

        // 还原数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                diff[i + 1][j + 1] += diff[i][j + 1] + diff[i + 1][j] - diff[i][j];
                ans[i][j] = diff[i + 1][j + 1];
            }
        }
        return ans;
    }
}
