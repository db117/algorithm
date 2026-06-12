package cn.db117.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 最近公共祖先
 * 树上倍增找公共祖先
 *
 *@since 2026/6/12
 *@author zhangdabing
 */
public class TreeAncestor {
    /**
     * depth[i] 表示节点 i 到根节点 0 的距离。
     */
    private final int[] depth;

    /**
     * pa[x][i] 表示节点 x 向上跳 2^i 步后的祖先；不存在时为 -1。
     */
    private final int[][] pa;

    /**
     * 根据无向树的边构造倍增表。
     *
     * @param edges 树边，节点编号从 0 开始，默认以 0 为根
     */
    public TreeAncestor(int[][] edges) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1]; // 节点编号从 0 开始
            g[x].add(y);
            g[y].add(x);
        }

        depth = new int[n];
        pa = new int[n][m];
        dfs(g, 0, -1);// 找到所有的深度

        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    /**
     * 深度优先遍历，记录每个节点的深度和直接父节点。
     *
     * @param g 邻接表
     * @param x 当前节点
     * @param fa 父节点，根节点的父节点为 -1
     */
    private void dfs(List<Integer>[] g, int x, int fa) {
        pa[x][0] = fa;
        for (int y : g[x]) {
            if (y != fa) {
                depth[y] = depth[x] + 1;
                dfs(g, y, x);
            }
        }
    }

    /**
     * 查询 node 向上跳 k 步后的祖先。
     *
     * @param node 起始节点
     * @param k 向上跳的步数，调用方需保证不会连续跳出树外
     * @return 第 k 级祖先
     */
    public int getKthAncestor(int node, int k) {
        for (; k > 0; k &= k - 1) {
            node = pa[node][Integer.numberOfTrailingZeros(k)];
        }
        return node;
    }

    /**
     * 查询两个节点的最近公共祖先。
     *
     * @param x 节点 x
     * @param y 节点 y
     * @return x 和 y 的最近公共祖先
     */
    public int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        y = getKthAncestor(y, depth[y] - depth[x]); // 使 y 和 x 在同一深度
        if (y == x) {
            return x;
        }
        for (int i = pa[x].length - 1; i >= 0; i--) {
            int px = pa[x][i], py = pa[y][i];
            if (px != py) {
                x = px;
                y = py; // 同时往上跳 2^i 步
            }
        }
        return pa[x][0];
    }

}
