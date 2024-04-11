

//给你一个 n 个节点的树（也就是一个无环连通无向图），节点编号从 0 到 n - 1 ，且恰好有 n - 1 条边，每个节点有一个值。树的 根节点 为 0 
//号点。 
//
// 给你一个整数数组 nums 和一个二维数组 edges 来表示这棵树。nums[i] 表示第 i 个点的值，edges[j] = [uj, vj] 表示节
//点 uj 和节点 vj 在树中有一条边。 
//
// 当 gcd(x, y) == 1 ，我们称两个数 x 和 y 是 互质的 ，其中 gcd(x, y) 是 x 和 y 的 最大公约数 。 
//
// 从节点 i 到 根 最短路径上的点都是节点 i 的祖先节点。一个节点 不是 它自己的祖先节点。 
//
// 请你返回一个大小为 n 的数组 ans ，其中 ans[i]是离节点 i 最近的祖先节点且满足 nums[i] 和 nums[ans[i]] 是 互质的 
//，如果不存在这样的祖先节点，ans[i] 为 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：nums = [2,3,3,2], edges = [[0,1],[1,2],[1,3]]
//输出：[-1,0,0,1]
//解释：上图中，每个节点的值在括号中表示。
//- 节点 0 没有互质祖先。
//- 节点 1 只有一个祖先节点 0 。它们的值是互质的（gcd(2,3) == 1）。
//- 节点 2 有两个祖先节点，分别是节点 1 和节点 0 。节点 1 的值与它的值不是互质的（gcd(3,3) == 3）但节点 0 的值是互质的(gcd(
//2,3) == 1)，所以节点 0 是最近的符合要求的祖先节点。
//- 节点 3 有两个祖先节点，分别是节点 1 和节点 0 。它与节点 1 互质（gcd(3,2) == 1），所以节点 1 是离它最近的符合要求的祖先节点。
//
// 
//
// 示例 2： 
//
// 
//
// 
//输入：nums = [5,6,10,2,3,6,15], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
//输出：[-1,0,-1,0,0,0,-1]
// 
//
// 
//
// 提示： 
//
// 
// nums.length == n 
// 1 <= nums[i] <= 50 
// 1 <= n <= 10⁵ 
// edges.length == n - 1 
// edges[j].length == 2 
// 0 <= uj, vj < n 
// uj != vj 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 数组 数学 数论 👍 54 👎 0


package cn.db117.leetcode.solution17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1766.互质树.tree-of-coprimes
 *
 * @author db117
 * @since 2024-04-11 15:27:31
 **/

public class Solution_1766 {
    public static void main(String[] args) {
        Solution solution = new Solution_1766().new Solution();
        // [2,3,3,2]
        //			[[0,1],[1,2],[1,3]]
//        System.out.println(Arrays.toString(solution.getCoprimes(new int[]{
//                2, 3, 3, 2
//        }, new int[][]{
//                {0, 1},
//                {1, 2},
//                {1, 3}
//        })));

        // [9,16,30,23,33,35,9,47,39,46,16,38,5,49,21,44,17,1,6,37,49,15,23,46,38,9,27,3,24,1,14,17,12,23,43,38,12,4,8,17,11,18,26,22,49,14,9]
        //			[[17,0],[30,17],[41,30],[10,30],[13,10],[7,13],[6,7],[45,10],[2,10],[14,2],[40,14],[28,40],[29,40],[8,29],[15,29],[26,15],[23,40],[19,23],[34,19],[18,23],[42,18],[5,42],[32,5],[16,32],[35,14],[25,35],[43,25],[3,43],[36,25],[38,36],[27,38],[24,36],[31,24],[11,31],[39,24],[12,39],[20,12],[22,12],[21,39],[1,21],[33,1],[37,1],[44,37],[9,44],[46,2],[4,46]]
        System.out.println(Arrays.toString(solution.getCoprimes(new int[]{
                9, 16, 30, 23, 33, 35, 9, 47, 39, 46, 16, 38, 5, 49, 21, 44, 17, 1, 6, 37, 49, 15, 23, 46, 38, 9, 27, 3, 24, 1, 14, 17, 12, 23, 43, 38, 12, 4, 8, 17, 11, 18, 26, 22, 49, 14, 9
        }, new int[][]{
                {17, 0}, {30, 17}, {41, 30}, {10, 30}, {13, 10}, {7, 13}, {6, 7}, {45, 10}, {2, 10}, {14, 2}, {40, 14}, {28, 40}, {29, 40}, {8, 29}, {15, 29}, {26, 15}, {23, 40}, {19, 23}, {34, 19}, {18, 23}, {42, 18}, {5, 42}, {32, 5}, {16, 32}, {35, 14}, {25, 35}, {43, 25}, {3, 43}, {36, 25}, {38, 36}, {27, 38}, {24, 36}, {31, 24}, {11, 31}, {39, 24}, {12, 39}, {20, 12}, {22, 12}, {21, 39}, {1, 21}, {33, 1}, {37, 1}, {44, 37}, {9, 44}, {46, 2}, {4, 46}
        })));
        // [-1,21,17,43,10,42,7,13,29,44,17,31,39,10,10,29,32,0,40,23,12,39,12,40,25,35,15,38,40,40,17,24,5,1,19,14,17,21,25,24,14,17,40,25,37,17,10]

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 记录两个数是否互质
        static int[][] temp = new int[51][51];

        static {
            for (int i = 1; i <= 50; i++) {
                for (int j = 1; j <= 50; j++) {
                    if (gcd(i, j) == 1) {
                        temp[i][j] = 1;
                    }
                }
            }
        }

        List<Integer>[] tree;
        int n;
        int[] nums;
        int[] ans;

        public int[] getCoprimes(int[] nums, int[][] edges) {
            n = nums.length;
            this.nums = nums;
            ans = new int[n];
            Arrays.fill(ans, -1);

            // 构建树
            tree = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                tree[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                tree[edge[0]].add(edge[1]);
                tree[edge[1]].add(edge[0]);
            }

            // 记录祖先中最近的节点和深度
            int[] valNodeId = new int[51];
            int[] valDepth = new int[51];
            Arrays.fill(valNodeId, -1);
            Arrays.fill(valDepth, -1);
            dfs(0, -1, 0, valNodeId, valDepth);

            return ans;
        }

        private void dfs(int cur, int pre, int depth, int[] valNodeId, int[] valDepth) {
            // 找到50个数中与当前数互质的最近的深度
            int maxDepth = -1;
            int val = nums[cur];
            for (int i = 1; i <= 50; i++) {
                if (temp[val][i] == 1 && valNodeId[i] != -1) {
                    if (valDepth[i] > maxDepth) {
                        maxDepth = valDepth[i];
                        ans[cur] = valNodeId[i];
                    }
                }
            }

            // 备份
            int oldNodeId = valNodeId[val];
            int oldDepth = valDepth[val];
            // 更新当前节点的信息
            valNodeId[val] = cur;
            valDepth[val] = depth;

            for (int next : tree[cur]) {
                if (next != pre) {
                    dfs(next, cur, depth + 1, valNodeId, valDepth);
                }
            }
            // 恢复
            valNodeId[val] = oldNodeId;
            valDepth[val] = oldDepth;
        }


        private static int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}