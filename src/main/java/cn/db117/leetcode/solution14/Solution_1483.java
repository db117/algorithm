

//给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0
// 的节点。 
//
// 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。 
//
// 实现 TreeAncestor 类： 
//
// 
// TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。 
// getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：
//["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
//[[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
//
//输出：
//[null,1,0,-1]
//
//解释：
//TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
//
//treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
//treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
//treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= n <= 5 * 10⁴ 
// parent[0] == -1 表示编号为 0 的节点是根节点。 
// 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立 
// 0 <= node < n 
// 至多查询 5 * 10⁴ 次 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二分查找 动态规划 👍 156 👎 0


package cn.db117.leetcode.solution14;

/**
 * 1483.树节点的第 K 个祖先.kth-ancestor-of-a-tree-node
 *
 * @author db117
 * @since 2023-06-12 13:51:25
 **/

public class Solution_1483 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TreeAncestor {
        // 树上倍增算法
        private final int[][] treeP;

        public TreeAncestor(int n, int[] parent) {
            int m = 32 - Integer.numberOfLeadingZeros(n);// n 的二进制长度
            treeP = new int[n][m];// 节点 i ，的第 2 pow j 个祖先
            for (int i = 0; i < n; i++) {
                treeP[i][0] = parent[i];// 自己的第一个（2 pow 0）父类
            }
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n; j++) {
                    int p = treeP[j][i];// 节点 j 的 (2 pow i )个祖先
                    // 如果为负数，说明没有节点
                    // 第二维是表示 2 pow i，所以是  treeP[treeP[j][j]][i]
                    treeP[j][i + 1] = p < 0 ? -1 : treeP[p][i];
                }
            }

        }

        public int getKthAncestor(int node, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            // 在初始化的时候，处理好每个节点的 2……n 的祖节点
            // 把 k 分解成 2 的 n 次方，一次跳一部分
            for (int i = 0; i < m; i++) {
                if ((k >> i & 1) == 1) {
                    // 一步步往上跳
                    node = treeP[node][i];
                }

                if (node < 0) {
                    // 找不到了
                    break;
                }
            }
            return node;
        }
    }

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */
//leetcode submit region end(Prohibit modification and deletion)

}