

//给你一个二维整数数组 properties，其维度为 n x m，以及一个整数 k。 
//
// 定义一个函数 intersect(a, b)，它返回数组 a 和 b 中 共有的不同整数的数量 。 
//
// 构造一个 无向图，其中每个索引 i 对应 properties[i]。如果且仅当 intersect(properties[i], properties[
//j]) >= k（其中 i 和 j 的范围为 [0, n - 1] 且 i != j），节点 i 和节点 j 之间有一条边。 
//
// 返回结果图中 连通分量 的数量。 
//
// 
//
// 示例 1： 
//
// 
// 输入： properties = [[1,2],[1,1],[3,4],[4,5],[5,6],[7,7]], k = 1 
// 
//
// 输出： 3 
//
// 解释： 
//
// 生成的图有 3 个连通分量： 
//
// 
//
// 示例 2： 
//
// 
// 输入： properties = [[1,2,3],[2,3,4],[4,3,5]], k = 2 
// 
//
// 输出： 1 
//
// 解释： 
//
// 生成的图有 1 个连通分量： 
//
// 
//
// 示例 3： 
//
// 
// 输入： properties = [[1,1],[1,1]], k = 2 
// 
//
// 输出： 2 
//
// 解释： 
//
// intersect(properties[0], properties[1]) = 1，小于 k。因此在图中 properties[0] 和 
//properties[1] 之间没有边。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == properties.length <= 100 
// 1 <= m == properties[i].length <= 100 
// 1 <= properties[i][j] <= 100 
// 1 <= k <= m 
// 
//
// 👍 3 👎 0


package cn.db117.leetcode.solution34;

import java.util.HashSet;
import java.util.Set;

/**
 * 3493.属性图.properties-graph
 *
 * @author db117
 * @since  2025-03-24 10:13:20
 **/

  public class Solution_3493{
      public static void main(String[] args) {
           Solution solution = new Solution_3493().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          int[][] properties;
          int k;
          UnionFind uf;

          public int numberOfComponents(int[][] properties, int k) {
              this.properties = properties;
              int n = properties.length;
              uf = new UnionFind(n);
              this.k = k;
              for (int i = 0; i < n; i++) {
                  for (int j = i + 1; j < n; j++) {
                      if (intersect(i, j))// 如果可以连接
                          uf.union(i, j);
                  }
              }
              return uf.count;// 连通分量
          }

          private boolean intersect(int a, int b) {
              int cur = 0;
              Set<Integer> setA = new HashSet<>();
              Set<Integer> setB = new HashSet<>();
              for (int i : properties[a]) {
                  setA.add(i);
              }
              for (int i : properties[b]) {
                  setB.add(i);
              }
              for (Integer i : setA) {
                  if (setB.contains(i)) {
                      cur++;
                  }
              }
              return cur >= k;
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