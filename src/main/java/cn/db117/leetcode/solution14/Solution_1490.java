

//给定一棵 N 叉树的根节点 root ，返回该树的深拷贝（克隆）。 
//
// N 叉树的每个节点都包含一个值（ int ）和子节点的列表（ List[Node] ）。 
//
// 
//class Node {
//    public int val;
//    public List<Node> children;
//}
// 
//
// N 叉树的输入序列用层序遍历表示，每组子节点用 null 分隔（见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[1,null,3,2,4,null,5,6]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13
//,null,null,14]
// 
//
// 
//
// 提示： 
//
// 
// 给定的 N 叉树的深度小于或等于 1000。 
// 节点的总个数在 [0, 10^4] 之间 
// 
//
// 
//
// 进阶：你的解决方案可以适用于克隆图问题吗？ 
// Related Topics 树 深度优先搜索 广度优先搜索 哈希表 👍 10 👎 0


package cn.db117.leetcode.solution14;

import java.util.ArrayList;
import java.util.List;

/**
 * 1490.克隆 N 叉树.clone-n-ary-tree
 *
 * @author db117
 * @since 2022-03-28 15:16:16
 **/

public class Solution_1490 {
    public static void main(String[] args) {
        Solution solution = new Solution_1490().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
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
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

    class Solution {
        public Node cloneTree(Node root) {
            if (root == null) {
                return null;
            }
            Node newNode = new Node(root.val);
            for (Node child : root.children) {
                newNode.children.add(cloneTree(child));
            }
            return newNode;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    // Definition for a Node.
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