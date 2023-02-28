

//有一个 无向 树，有 n 个节点，节点标记为从 1 到 n ，还有 n - 1 条边。给定整数 n。标记为 v 的节点的父节点是标记为 floor (v /
// 2) 的节点。树的根节点是标记为 1 的节点。 
//
// 
// 例如，如果 n = 7，那么标记为 3 的节点将标记 floor(3 / 2) = 1 的节点作为其父节点，标记为 7 的节点将标记 floor(7 / 
//2) = 3 的节点作为其父节点。 
// 
//
// 你还得到一个整数数组 queries。最初，每个节点的值都是 0。对于每个查询 queries[i]，您应该翻转节点标记为 queries[i] 的子树中
//的所有值。 
//
// 在 处理完所有查询后，返回值为 1 的节点总数。 
//
// 注意: 
//
// 
// 翻转节点的值意味着值为 0 的节点变为 1，反之亦然。 
// floor(x) 相当于将 x 舍入到最接近的整数。 
// 
//
// 
//
// 示例 1: 
// 
// 
//输入: n = 5 , queries = [1,2,5]
//输出: 3
//解释: 上图显示了执行查询后的树结构及其状态。蓝色节点表示值 0，红色节点表示值 1。
//在处理查询之后，有三个红色节点 (值为 1 的节点): 1、3、5。
// 
//
// 示例 2: 
// 
// 
//输入: n = 3, queries = [2,3,3]
//输出: 1
//解释: 上图显示了执行查询后的树结构及其状态。蓝色节点表示值 0，红色节点表示值 1。
//在处理查询之后，有一个红色节点 (值为 1 的节点): 2。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁵ 
// 1 <= queries.length <= 10⁵ 
// 1 <= queries[i] <= n 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2445.值为 1 的节点数.number-of-nodes-with-value-one
 *
 * @author db117
 * @since 2023-02-28 17:32:55
 **/

public class Solution_2445 {
    public static void main(String[] args) {
        Solution solution = new Solution_2445().new Solution();
        System.out.println(solution.numberOfNodes(5, new int[]{1, 2, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfNodes(int n, int[] queries) {
            // 满二叉树。从 1 开始
            int[] tree = new int[n + 1];
            // 懒标记，表示当前节点需要翻转
            for (int query : queries) {
                tree[query]++;
            }
            // 往下推
            for (int i = 1; i <= n / 2; i++) {
                int left = i * 2;
                int right = left + 1;

                // 左节点肯定存在
                tree[left] += tree[i];
                if (right <= n) {
                    // 又节点可能不存在
                    tree[right] += tree[i];
                }
            }

            int ans = 0;
            for (int i : tree) {
                // 只有奇数会是 1
                ans += i & 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}