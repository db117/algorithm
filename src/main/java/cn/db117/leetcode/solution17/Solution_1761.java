

//给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条
//无向边。 
//
// 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。 
//
// 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。 
//
// 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
//输出：3
//解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
// 
//
// 示例 2： 
// 
// 
//输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
//输出：0
//解释：有 3 个三元组：
//1) [1,4,3]，度数为 0 。
//2) [2,5,6]，度数为 2 。
//3) [5,6,7]，度数为 2 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 400 
// edges[i].length == 2 
// 1 <= edges.length <= n * (n-1) / 2 
// 1 <= ui, vi <= n 
// ui != vi 
// 图中没有重复的边。 
// 
//
// Related Topics 图 👍 53 👎 0


package cn.db117.leetcode.solution17;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 1761.一个图中连通三元组的最小度数.minimum-degree-of-a-connected-trio-in-a-graph
 *
 * @author db117
 * @since 2023-08-31 10:39:48
 **/

public class Solution_1761 {
    public static void main(String[] args) {
        Solution solution = new Solution_1761().new Solution();
        // 15
        //[[6,15],[12,10],[14,7],[4,6],[14,10],[3,10],[5,1],[4,15],[14,13],[8,3],[8,6],[10,9],[2,5],[1,3],[15,2],[2,14],[15,5],[7,4],[6,2],[10,15],[15,8],[15,14],[1,15],[6,14],[4,5],[3,9],[5,6],[3,6],[4,14],[5,9],[8,2],[3,12],[3,15],[8,5],[11,4],[9,4],[5,12],[11,7],[2,4],[1,2],[9,13],[10,11],[2,7],[10,8],[1,11],[2,10],[15,7],[1,14],[2,13],[7,9],[6,13],[7,6],[6,10],[8,11],[3,2],[14,5],[3,14],[5,11],[4,13],[8,1],[10,4],[11,9],[10,7],[10,13],[1,4],[8,13],[11,6],[1,7],[1,13],[2,9],[2,12],[13,12],[15,9],[14,12]]
        System.out.println(solution.minTrioDegree(15, new int[][]{
                {6, 15}, {12, 10}, {14, 7}, {4, 6}, {14, 10}, {3, 10}, {5, 1}, {4, 15}, {14, 13}, {8, 3}, {8, 6}, {10, 9}, {2, 5}, {1, 3}, {15, 2}, {2, 14}, {15, 5}, {7, 4}, {6, 2}, {10, 15}, {15, 8}, {15, 14}, {1, 15}, {6, 14}, {4, 5}, {3, 9}, {5, 6}, {3, 6}, {4, 14}, {5, 9}, {8, 2}, {3, 12}, {3, 15}, {8, 5}, {11, 4}, {9, 4}, {5, 12}, {11, 7}, {2, 4}, {1, 2}, {9, 13}, {10, 11}, {2, 7}, {10, 8}, {1, 11}, {2, 10}, {15, 7}, {1, 14}, {2, 13}, {7, 9}, {6, 13}, {7, 6}, {6, 10}, {8, 11}, {3, 2}, {14, 5}, {3, 14}, {5, 11}, {4, 13}, {8, 1}, {10, 4}, {11, 9}, {10, 7}, {10, 13}, {1, 4}, {8, 13}, {11, 6}, {1, 7}, {1, 13}, {2, 9}, {2, 12}, {13, 12}, {15, 9}, {14, 12}
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minTrioDegree(int n, int[][] edges) {
            int ans = Integer.MAX_VALUE;
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                map.put(i, new HashSet<>());
            }
            // 建图
            for (int[] edge : edges) {
                map.get(edge[0]).add(edge[1]);
                map.get(edge[1]).add(edge[0]);
            }

            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    for (int k = j + 1; k <= n; k++) {
                        if (map.get(i).contains(j) && map.get(i).contains(k) && map.get(j).contains(k)) {
                            // 三元组
                            int count = map.get(i).size() + map.get(j).size() + map.get(k).size() - 6;
                            ans = Math.min(ans, count);
                        }
                    }
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}