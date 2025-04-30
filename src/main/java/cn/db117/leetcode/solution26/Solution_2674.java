

//现给定一个由正整数组成的 循环链表 list ，你的任务是将其拆分为 2 个 循环链表 ，使得第一个链表包含 list 前半部分 的节点（即 ceil(
//list.length / 2) 个节点），顺序与 list 中的顺序相同，而第二个链表包含 list 中 剩余 的节点，顺序也与 list 中的顺序相同。 
//
// 返回一个长度为 2 的数组，其中第一个元素是表示 前半部分 链表的 循环链表 ，第二个元素是表示 后半部分 链表的 循环链表 。 
//
// 循环链表 是一个普通的链表，唯一的区别是最后一个节点的下一个节点是头节点。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,5,7]
//输出：[[1,5],[7]]
//解释：初始链表有3个节点，因此前半部分是前两个元素，剩下的 1 个节点在后半部分。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,6,1,5]
//输出：[[2,6],[1,5]]
//解释：初始链表有4个节点，因此前半部分是前两个元素，剩下的 2 个节点在后半部分。
// 
//
// 
//
// 提示： 
//
// 
// list 中的节点数范围为 [2, 10⁵] 
// 0 <= Node.val <= 10⁹ 
// LastNode.next = FirstNode ，其中 LastNode 是链表的最后一个节点，FirstNode 是第一个节点。 
// 
//
// Related Topics 链表 双指针 👍 1 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2674.拆分循环链表.split-a-circular-linked-list
 *
 * @author db117
 * @since 2025-04-30 15:10:59
 **/

public class Solution_2674 {
    public static void main(String[] args) {
        Solution solution = new Solution_2674().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public ListNode[] splitCircularLinkedList(ListNode list) {
            ListNode first = list;
            ListNode last = list;
            int len = 1;// 链表长度
            while (list.next != first) {
                len++;
                list = list.next;
                last = list;
            }
            int left = (len + 1) / 2;
            // 左边最后一个结点
            ListNode cur = first;
            for (int i = 0; i < left-1; i++) {
                cur = cur.next;
            }
            last.next = cur.next;
            cur.next = first;

            return new ListNode[]{first, last.next};
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}