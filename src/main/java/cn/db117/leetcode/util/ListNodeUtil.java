package cn.db117.leetcode.util;

import java.util.Arrays;

/**
 * @author db117
 * @date 2019/7/10
 **/

public class ListNodeUtil {
    private ListNodeUtil() {
    }

    /**
     * 构建链表
     *
     * @param ints 数组
     * @return 链表头
     */
    public static ListNode builder(int[] ints) {
        ListNode last = new ListNode(ints[0]);
        ListNode head = last;
        for (int i = 1; i < ints.length; i++) {
            last.next = new ListNode(ints[i]);
            last = last.next;
        }
        return head;
    }

    /**
     * 构建
     *
     * @param args arg
     */
    public static ListNode builder(String args) {
        int[] ints = Arrays.stream(args.replace("[", "")
                        .replace("]", "")
                        .split(",")).map(Integer::parseInt)
                .mapToInt(v -> v)
                .toArray();
        return builder(ints);
    }

    /**
     * 打印
     *
     * @param node 链表头
     */
    public static void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
