package cn.db117.leetcode.util;

/**
 * 矩阵工具类
 *
 * @author zhangdb3
 * @since 2022/12/27
 */
public class GridUtil {

    /**
     * 上下左右 索引变化
     */
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * 获取索引
     * 将 (x, y) 转换为 index
     *
     * @param n 每行的数量
     */
    int getIndex(int x, int y, int n) {
        return x * n + y;
    }

    /**
     * 解析索引
     * 将 index 解析回 (x, y)
     *
     * @param idx 索引
     * @param n   每行的数量
     * @return {@link int[]}
     */
    int[] parseIdx(int idx, int n) {
        return new int[]{idx / n, idx % n};
    }
}
