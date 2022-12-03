

//给你一个链表的头节点 head 。 
//
// 对于列表中的每个节点 node ，如果其右侧存在一个具有 严格更大 值的节点，则移除 node 。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
// 
//
// 
//
// 提示： 
//
// 
// 给定列表中的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 栈 递归 链表 单调栈 👍 14 👎 0


package cn.db117.leetcode.solution24;

import cn.db117.leetcode.util.ListNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 2487.从链表中移除节点.remove-nodes-from-linked-list
 *
 * @author db117
 * @since 2022-12-03 11:10:04
 **/

public class Solution_2487 {
    public static void main(String[] args) {
        Solution solution = new Solution_2487().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public ListNode removeNodes(ListNode head) {
            List<Integer> list = new ArrayList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }

            LinkedList<Integer> queue = new LinkedList<>();
            for (Integer val : list) {
                while (!queue.isEmpty() && queue.peekLast() < val) {
                    queue.pollLast();
                }
                queue.offerLast(val);
            }

            ListNode ans = new ListNode();
            ListNode cur = ans;
            for (Integer integer : queue) {
                cur.next = new ListNode(integer);
                cur = cur.next;
            }

            return ans.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}