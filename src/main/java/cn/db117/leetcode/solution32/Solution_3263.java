

//给定一个 双链表 的 head 节点，其中的节点具有指向下一个节点的指针和上一个节点的指针。 
//
// 返回一个 按顺序 包含链表中元素的整数数组。 
//
// 
//
// 示例 1： 
//
// 
// 输入：head = [1,2,3,4,3,2,1] 
// 
//
// 输出：[1,2,3,4,3,2,1] 
//
// 示例 2： 
//
// 
// 输入：head = [2,2,2,2,2] 
// 
//
// 输出：[2,2,2,2,2] 
//
// 示例 3： 
//
// 
// 输入：head = [3,2,3,2,3,2] 
// 
//
// 输出：[3,2,3,2,3,2] 
//
// 
//
// 提示： 
//
// 
// 给定链表中节点的数量在 [1, 50] 范围。 
// 1 <= Node.val <= 50 
// 
//
// Related Topics 数组 链表 双向链表 👍 0 👎 0


package cn.db117.leetcode.solution32;

import java.util.ArrayList;
import java.util.List;

/**
 * 3263.将双链表转换为数组 I.convert-doubly-linked-list-to-array-i
 *
 * @author db117
 * @since 2025-04-18 11:00:30
 **/

public class Solution_3263 {
    public static void main(String[] args) {
        Solution solution = new Solution_3263().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

    class Solution {
        public int[] toArray(Node head) {
            List<Integer> ans = new ArrayList<>();
            while (head != null) {
                ans.add(head.val);
                head = head.next;
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Node {
        public int val;
        public Node prev;
        public Node next;
    }

    ;
}