package cn.db117.template.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author db117
 * @since 2023/6/12
 */
@SuppressWarnings("unchecked")
class TreeAncestor {
    private int[] depth;// 每个节点的深度
    private int[][] pa;// 每个节点的  2^i 次方祖先

    public TreeAncestor(int[][] edges) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n); // n 的二进制长度
        // 建树
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var e : edges) { // 节点编号从 0 开始
            int x = e[0], y = e[1];
            g[x].add(y);
            g[y].add(x);
        }

        depth = new int[n];
        pa = new int[n][m];
        // dfs 初始化节点深度和节点祖先
        dfs(g, 0, -1);

        // 预处理每个节点的 2^i 祖先
        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = pa[x][i];
                pa[x][i + 1] = p < 0 ? -1 : pa[p][i];
            }
        }
    }

    private void dfs(List<Integer>[] g, int x, int fa) {
        pa[x][0] = fa;// 节点的 2^0 祖先
        // 计算深度
        for (int y : g[x]) {
            if (y != fa) {
                depth[y] = depth[x] + 1;
                dfs(g, y, x);
            }
        }
    }

    /**
     * 节点的第 k 祖先
     *
     * @param node 节点
     * @param k    k
     * @return int
     */
    public int getKthAncestor(int node, int k) {
        for (; k > 0; k &= k - 1) {
            // 一步步往上跳
            node = pa[node][Integer.numberOfTrailingZeros(k)];
        }
        return node;
    }

    /**
     * 最近公共祖先
     *
     * @param x x
     * @param y y
     * @return int
     */
    public int getLCA(int x, int y) {
        // 保证 x 的深度 <= y
        if (depth[x] > depth[y]) {
            int tmp = y;
            y = x;
            x = tmp;
        }
        // 使 y 和 x 在同一深度
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (y == x) {// 比较同一深度的祖先
            return x;
        }
        // 如果在同一深度的祖先不同，则继续往上找
        // 每一次都尽量往上爬
        for (int i = pa[x].length - 1; i >= 0; i--) {
            // 每一次都从能跳到最顶端开始往下走，一直走到不相等
            // 如果不相等则说明目标就在上面一点点，然后循环这个路子（每次的循环范围都会缩小一半）
            int px = pa[x][i], py = pa[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return pa[x][0];
    }
}

