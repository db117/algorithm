

//给定一个链表的第一个节点 head ，找到链表中所有出现多于一次的元素，并删除这些元素所在的节点。 
//
// 返回删除后的链表。 
//
// 
//
// 示例 1: 
// 输入: head = [1,2,3,2]
//输出: [1,3]
//解释: 2 在链表中出现了两次，所以所有的 2 都需要被删除。删除了所有的 2 之后，我们还剩下 [1,3] 。
// 
//
// 示例 2: 
// 输入: head = [2,1,1,2]
//输出: []
//解释: 2 和 1 都出现了两次。所有元素都需要被删除。
// 
//
// 示例 3: 
// 输入: head = [3,2,2,1,3,2,4]
//输出: [1,4]
//解释: 3 出现了两次，且 2 出现了三次。移除了所有的 3 和 2 后，我们还剩下 [1,4] 。
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点个数的范围是 [1, 10⁵] 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 哈希表 链表 👍 15 👎 0


package cn.db117.leetcode.solution18;

import cn.db117.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1836.从未排序的链表中移除重复元素.remove-duplicates-from-an-unsorted-linked-list
 *
 * @author db117
 * @since 2023-04-08 21:13:39
 **/

public class Solution_1836 {
    public static void main(String[] args) {
        Solution solution = new Solution_1836().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicatesUnsorted(ListNode head) {
            // 虚拟节点
            ListNode pre = new ListNode();
            pre.next = head;
            Map<Integer, Integer> map = new HashMap<>();

            ListNode cur = head;
            while (cur != null) {
                map.merge(cur.val, 1, Integer::sum);
                cur = cur.next;
            }

            cur = pre;
            while (cur != null && cur.next != null) {
                if (map.get(cur.next.val) > 1) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }


            return pre.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}