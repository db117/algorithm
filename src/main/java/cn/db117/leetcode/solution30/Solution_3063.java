

//给定包含 k 个 不同 元素的链表的 head 节点，创建一个长度为 k 的链表，包含给定链表中每个 不同元素 以 任何顺序 出现的 频率 。返回这个链表的
//头节点。 
//
// 
//
// 示例 1: 
//
// 
//输入：head = [1,1,2,1,2,3]
//
//输出：[3,2,1]
//
//解释：列表中有 3 个不同的元素。1 的频率是 3，2 的频率是 2，3 的频率是 1。因此，我们返回 3 -> 2 -> 1。
//
//注意 1 -> 2 -> 3，1 -> 3 -> 2，2 -> 1 -> 3，2 -> 3 -> 1，和 3 -> 1 -> 2 都是合法的答案。
// 
//
// 示例 2: 
//
// 
//输入：head = [1,1,2,2,2]
//
//输出：[2,3]
//
//解释：列表中有 2 个不同的元素。1 和 2 出现的频率是 2 和 3。因此，我们返回 2 -> 3。
// 
//
// 示例 3: 
//
// 
//输入：head = [6,5,4,3,2,1]
//
//输出：[1,1,1,1,1,1]
//
//解释：列表中有 6 个不同的元素。每个元素的频率是 1。因此，我们返回 1 -> 1 -> 1 -> 1 -> 1 -> 1。
// 
//
// 
//
// 提示： 
//
// 
// 链表中的节点数字范围在 [1, 10⁵]之间。 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 哈希表 链表 计数 👍 0 👎 0


package cn.db117.leetcode.solution30;

import cn.db117.leetcode.util.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 3063.链表频率.linked-list-frequency
 *
 * @author db117
 * @since 2024-03-19 16:09:29
 **/

public class Solution_3063 {
    public static void main(String[] args) {
        Solution solution = new Solution_3063().new Solution();
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
        public ListNode frequenciesOfElements(ListNode head) {
            Map<Integer, Integer> map = new HashMap<>();
            ListNode cur = head;
            // 计数
            while (cur != null) {
                map.put(cur.val, map.getOrDefault(cur.val, 0) + 1);
                cur = cur.next;
            }

            // 构建返回值
            ListNode dummy = new ListNode();
            ListNode tail = dummy;
            for (Integer value : map.values()) {
                ListNode node = new ListNode(value);
                tail.next = node;
                tail = node;
            }
            return dummy.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}