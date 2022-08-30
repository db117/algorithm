package cn.db117.template;

import cn.db117.leetcode.solution3.Solution_323;

/**
 * 并查集
 *
 * @author db117
 * @see Solution_323
 * @since 2022/8/30 16:13
 **/
public class UnionFind {
    // 连通分量
    int count;
    // 父节点
    int[] parent;

    public UnionFind(int n) {
        count = n;
        parent = new int[n];

        // 初始父节点都是自己
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public void union(int x, int y) {
        int xp = find(x);
        int yp = find(y);
        if (xp == yp) {
            return;
        }
        if (xp < yp) {
            parent[yp] = xp;
        } else {
            parent[xp] = yp;
        }
        // 连通分量
        count--;
    }

    public int find(int n) {
        while (parent[n] != n) {
            // 路径压缩
            parent[n] = parent[parent[n]];
            n = parent[n];
        }
        return n;
    }

    public boolean connected(int x, int y) {
        return find(y) == find(x);
    }

    public int count() {
        return count;
    }

}
