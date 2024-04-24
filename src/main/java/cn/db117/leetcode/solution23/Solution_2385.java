

//给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发
//。 
//
// 每分钟，如果节点满足以下全部条件，就会被感染： 
//
// 
// 节点此前还没有感染。 
// 节点与一个已感染节点相邻。 
// 
//
// 返回感染整棵树需要的分钟数。 
//
// 
//
// 示例 1： 
// 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
//输出：4
//解释：节点按以下过程被感染：
//- 第 0 分钟：节点 3
//- 第 1 分钟：节点 1、10、6
//- 第 2 分钟：节点5
//- 第 3 分钟：节点 4
//- 第 4 分钟：节点 9 和 2
//感染整棵树需要 4 分钟，所以返回 4 。
// 
//
// 示例 2： 
// 输入：root = [1], start = 1
//输出：0
//解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 每个节点的值 互不相同 
// 树中必定存在值为 start 的节点 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 21 👎 0


package cn.db117.leetcode.solution23;

import cn.db117.leetcode.util.TreeNode;

import java.util.*;

/**
 * 2385.感染二叉树需要的总时间.amount-of-time-for-binary-tree-to-be-infected
 *
 * @author db117
 * @since 2022-08-26 18:23:25
 **/

public class Solution_2385 {
    public static void main(String[] args) {
        Solution solution = new Solution_2385().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int amountOfTime(TreeNode root, int start) {
            int ans = -1;
            Map<Integer, List<Integer>> map = new HashMap<>();
            helper(root, null, map);
            Set<Integer> set = new HashSet<>();
            Queue<Integer> queue = new ArrayDeque<>(map.size());
            queue.add(start);
            while (!queue.isEmpty()) {
                int size = queue.size();

                for (int i = 0; i < size; i++) {
                    Integer next = queue.poll();
                    set.add(next);
                    List<Integer> list = map.get(next);
                    if (list == null || list.isEmpty()) {
                        continue;
                    }
                    for (Integer n : list) {
                        if (set.contains(n)) {
                            continue;
                        }
                        queue.add(n);
                    }
                }
                ans++;
            }
            return ans;
        }

        private void helper(TreeNode node, TreeNode pre, Map<Integer, List<Integer>> map) {
            if (node == null) {
                return;
            }
            if (pre != null) {
                map.putIfAbsent(node.val, new ArrayList<>());
                map.get(node.val).add(pre.val);
            }
            if (node.left != null) {
                map.putIfAbsent(node.val, new ArrayList<>());
                map.get(node.val).add(node.left.val);
            }
            if (node.right != null) {
                map.putIfAbsent(node.val, new ArrayList<>());
                map.get(node.val).add(node.right.val);
            }


            helper(node.left, node, map);
            helper(node.right, node, map);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}