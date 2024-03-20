

//给定一个以 0 为起始索引的整数 二维数组 nodes ，你的任务是确定给定的数组是否表示某个 二叉 树的 前序 遍历。 
//
// 对于每个索引 i ，nodes[i] = [id, parentId] ，其中 id 是索引 i 处节点的 id，parentId 是其在树中的父节点 
//id（如果该节点没有父节点，则 parentId = -1 ）。 
//
// 如果给定的数组表示某个树的前序遍历，则返回 true ，否则返回 false 。 
//
// 注意：树的 前序 遍历是一种递归的遍历方式，它首先访问当前节点，然后对左子节点进行前序遍历，最后对右子节点进行前序遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：nodes = [[0,-1],[1,0],[2,0],[3,2],[4,2]]
//输出：true
//解释：给定的 nodes 数组可以构成下面图片中的树。 
//我们可以验证这是树的前序遍历，首先访问节点 0，然后对左子节点进行前序遍历，即 [1] ，然后对右子节点进行前序遍历，即 [2,3,4] 。
// 
//
// 
//
// 示例 2： 
//
// 
//输入：nodes = [[0,-1],[1,0],[2,0],[3,1],[4,1]]
//输出：false
//解释：给定的 nodes 数组可以构成下面图片中的树。 
//对于前序遍历，首先访问节点 0，然后对左子节点进行前序遍历，即 [1,3,4]，但是我们可以看到在给定的顺序中，2 位于 1 和 3 之间，因此它不是树的前
//序遍历。
// 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nodes.length <= 10⁵ 
// nodes[i].length == 2 
// 0 <= nodes[i][0] <= 10⁵ 
// -1 <= nodes[i][1] <= 10⁵ 
// 生成的输入保证 nodes 可以组成二叉树。 
// 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 2 👎 0


package cn.db117.leetcode.solution27;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 2764.数组是否表示某二叉树的前序遍历.is-array-a-preorder-of-some-binary-tree
 *
 * @author db117
 * @since 2024-03-20 21:07:50
 **/

public class Solution_2764 {
    public static void main(String[] args) {
        Solution solution = new Solution_2764().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPreorder(List<List<Integer>> nodes) {
            if (nodes.get(0).get(1) != -1) {
                // 根节点的父节点必须是 -1
                return false;
            }
            Deque<Integer> stack = new ArrayDeque<>();
            // 根节点入栈
            stack.push(nodes.get(0).get(0));
            int index = 1;
            while (!stack.isEmpty()) {
                List<Integer> node = nodes.get(index);
                int cur = node.get(0);
                int parent = node.get(1);

                // 父节点不是栈顶元素,则一直出栈
                // 直到栈顶元素是父节点
                while (!stack.isEmpty() && parent != stack.peek()) {
                    stack.poll();
                }

                // 父节点不在栈中，说明不是前序遍历
                if (stack.isEmpty()) {
                    return false;
                }

                stack.push(cur);
                index++;

                if (index == nodes.size()) {
                    break;
                }
            }
            return true;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}