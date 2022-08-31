

//给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有
//单元格都是 0）。 
//
// 可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是
//要执行第 i 次操作的位置 (ri, ci) 。 
//
// 返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。 
//
// 岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。 
//
// 示例 1： 
// 
// 
//输入：m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
//输出：[1,1,2,3]
//解释：
//起初，二维网格 grid 被全部注入「水」。（0 代表「水」，1 代表「陆地」）
//- 操作 #1：addLand(0, 0) 将 grid[0][0] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #2：addLand(0, 1) 将 grid[0][1] 的水变为陆地。此时存在 1 个岛屿。
//- 操作 #3：addLand(1, 2) 将 grid[1][2] 的水变为陆地。此时存在 2 个岛屿。
//- 操作 #4：addLand(2, 1) 将 grid[2][1] 的水变为陆地。此时存在 3 个岛屿。
// 
//
// 示例 2： 
//
// 
//输入：m = 1, n = 1, positions = [[0,0]]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n, positions.length <= 10⁴ 
// 1 <= m * n <= 10⁴ 
// positions[i].length == 2 
// 0 <= ri < m 
// 0 <= ci < n 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度 O(k log(mn)) 的算法解决此问题吗？（其中 k == positions.length） 
//
// Related Topics 并查集 数组 👍 143 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayList;
import java.util.List;

/**
 * 305.岛屿数量 II.number-of-islands-ii
 *
 * @author db117
 * @see cn.db117.template.UnionFind
 * @since 2022-08-30 16:22:21
 **/

public class Solution_305 {
    public static void main(String[] args) {
        Solution solution = new Solution_305().new Solution();
        // m = 3, n = 3, positions = [[0,0],[0,1],[1,2],[2,1]]
        System.out.println(solution.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {2, 1}}));

        // 3
        // 3
        // [[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]
        // [1,2,3,4,3,2,1]
        System.out.println(solution.numIslands2(3, 3, new int[][]{{0, 1}, {1, 2}, {2, 1}, {1, 0}, {0, 2}, {0, 0}, {1, 1}}));

        // 3
        //3
        //[[0,0],[0,1],[1,2],[1,2]]
        // [1,1,2,2]
        System.out.println(solution.numIslands2(3, 3, new int[][]{{0, 0}, {0, 1}, {1, 2}, {1, 2}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] dict = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

        public List<Integer> numIslands2(int m, int n, int[][] positions) {
            boolean[] hash = new boolean[m * n];
            // 并查集
            UnionFind unionFind = new UnionFind(hash.length);
            // 先把通量设为 0,每一次操作加一
            unionFind.count = 0;
            List<Integer> ans = new ArrayList<>(positions.length);

            for (int[] position : positions) {
                int curIndex = index(position[0], position[1], m);
                if (hash[curIndex]) {
                    // 恶心的用例
                    ans.add(ans.get(ans.size() - 1));
                    continue;
                }
                // 添加通量
                unionFind.count++;
                for (int[] ints : dict) {
                    int x = position[0] + ints[0];
                    int y = position[1] + ints[1];
                    if (x < 0 || x >= m || y < 0 || y >= n) {
                        // 检查越界
                        continue;
                    }
                    int next = index(x, y, m);
                    if (next >= 0 && next < hash.length &&
                            hash[next] &&// 旁边是陆地
                            !unionFind.connected(curIndex, next)/*旁边的没有连通*/) {
                        // 发送合并则通量会减掉
                        unionFind.union(curIndex, next);
                    }
                }
                // 标记陆地
                hash[curIndex] = true;
                // 通量即为岛屿数量
                ans.add(unionFind.count());
            }
            return ans;
        }

        private int index(int x, int y, int m) {
            return y * m + x;
        }

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
    }
//leetcode submit region end(Prohibit modification and deletion)

}