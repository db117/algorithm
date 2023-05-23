

//对于一棵深度小于 5 的树，可以用一组三位十进制整数来表示。对于每个整数： 
//
// 
// 百位上的数字表示这个节点的深度 d，1 <= d <= 4。 
// 十位上的数字表示这个节点在当前层所在的位置 P， 1 <= p <= 8。位置编号与一棵满二叉树的位置编号相同。 
// 个位上的数字表示这个节点的权值 v，0 <= v <= 9。 
// 
//
// 给定一个包含三位整数的 升序 数组 nums ，表示一棵深度小于 5 的二叉树，请你返回 从根到所有叶子结点的路径之和 。 
//
// 保证 给定的数组表示一个有效的连接二叉树。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: nums = [113, 215, 221]
//输出: 12
//解释: 列表所表示的树如上所示。
//路径和 = (3 + 5) + (3 + 1) = 12.
// 
//
// 示例 2： 
//
// 
//
// 
//输入: nums = [113, 221]
//输出: 4
//解释: 列表所表示的树如上所示。
//路径和 = (3 + 1) = 4.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 15 
// 110 <= nums[i] <= 489 
// nums 表示深度小于 5 的有效二叉树 
// 
//
// Related Topics 树 深度优先搜索 数组 二叉树 👍 59 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;

/**
 * 666.路径总和 IV.path-sum-iv
 *
 * @author db117
 * @since 2023-05-23 16:19:46
 **/

public class Solution_666 {
    public static void main(String[] args) {
        Solution solution = new Solution_666().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 上一层最有一个索引（堆）
        int[] deepIndex = new int[]{0, 0, 1, 3, 7};

        public int pathSum(int[] nums) {
            int[] tree = new int[16];
            Arrays.fill(tree, -1);

            // 建堆
            for (int num : nums) {
                int deep = num / 100;
                int index = (num % 100) / 10;
                int value = num % 10;

                tree[deepIndex[deep] + index] = value;
            }

            // 遍历堆
            return dfs(tree, 1, 0);
        }

        private int dfs(int[] tree, int cur, int sum) {
            if (cur >= tree.length || tree[cur] == -1) {
                return -1;
            }
            sum += tree[cur];

            int left = dfs(tree, cur * 2, sum);
            int right = dfs(tree, cur * 2 + 1, sum);

            if (left == -1 && right == -1) {// 当前节点是子节点
                return sum;
            }
            if (left > -1 && right > -1) {
                // 两个子节点都有值
                return left + right;
            }
            // 只有一个节点有值
            return Math.max(left, right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}