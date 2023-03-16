

//给定一棵 N 叉树的根节点 root ，计算这棵树的直径长度。 
//
// N 叉树的直径指的是树中任意两个节点间路径中 最长 路径的长度。这条路径可能经过根节点，也可能不经过根节点。 
//
// （N 叉树的输入序列以层序遍历的形式给出，每组子节点用 null 分隔） 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：3
//解释：直径如图中红线所示。 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,null,3,4,null,5,null,6]
//输出：4
// 
//
// 示例 3： 
//
// 
//
// 
//输入: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12
//,null,13,null,null,14]
//输出: 7
// 
//
// 
//
// 提示： 
//
// 
// N 叉树的深度小于或等于 1000 。 
// 节点的总个数在 [0, 10^4] 间。 
// 
//
// Related Topics 树 深度优先搜索 👍 32 👎 0


package cn.db117.leetcode.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1522.N 叉树的直径.diameter-of-n-ary-tree
 *
 * @author db117
 * @since 2023-03-16 15:43:32
 **/

public class Solution_1522 {
    public static void main(String[] args) {
        Solution solution = new Solution_1522().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        int max = 0;

        public int diameter(Node root) {
            helper(root);
            return max;
        }

        private int helper(Node root) {
            if (root == null) {
                return 0;
            }
            int ans = 1;
            List<Node> children = root.children;
            if (children != null && !children.isEmpty()) {
                children.add(null);// 当只有一个时也可以找前两个
                int size = children.size();
                // 所有子节点深度
                int[] deep = new int[size];
                for (int i = 0; i < children.size(); i++) {
                    deep[i] = helper(children.get(i));
                }
                Arrays.sort(deep);
                // 当前深度
                ans += deep[size - 1];
                // 通过当前节点的最大路径=最大的两个深度和
                max = Math.max(max, deep[size - 1] + deep[size - 2]);
            }
            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}