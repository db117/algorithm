package cn.db117.template;

/**
 * 统计
 *
 * @author zhangdb3
 * @date 2023/01/17
 */
public class Statistic {
    private static final int MX = 9;
    // i 个数里面选 j 个的数量组合数
    private static final int[][] c = new int[MX][MX];

    static {
        for (int i = 0; i < MX; i++) {
            c[i][i] = 1;
            c[i][0] = 1;
            for (int j = 1; j < i; j++) {
                c[i][j] = c[i - 1][j] + c[i - 1][j - 1];// 预处理组合数
            }
        }
    }

}
