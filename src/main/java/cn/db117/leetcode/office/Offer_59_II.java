


//请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都
//是O(1)。 
//
// 若队列为空，pop_front 和 max_value 需要返回 -1 
//
// 示例 1： 
//
// 输入: 
//["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
//[[],[1],[2],[],[],[]]
//输出: [null,null,null,2,1,2]
// 
//
// 示例 2： 
//
// 输入: 
//["MaxQueue","pop_front","max_value"]
//[[],[],[]]
//输出: [null,-1,-1]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= push_back,pop_front,max_value的总操作数 <= 10000 
// 1 <= value <= 10^5 
// 
//
// Related Topics 设计 队列 单调队列 👍 496 👎 0


package cn.db117.leetcode.office;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 59 - II.队列的最大值.dui-lie-de-zui-da-zhi-lcof
 *
 * @author db117
 * @since 2023-07-21 16:11:26
 **/

public class Offer_59_II {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MaxQueue {
        // 单调队列
        Deque<Integer> helper;
        Deque<Integer> deque;

        public MaxQueue() {
            deque = new ArrayDeque<>();
            helper = new ArrayDeque<>();

        }

        public int max_value() {
            if (deque.isEmpty()) {
                return -1;
            }
            return helper.peekFirst();
        }

        public void push_back(int value) {
            deque.offerLast(value);

            // 保证队列中的值是单调递减的
            // 从队尾开始移除比当前值小的
            while (!helper.isEmpty() && helper.peekLast() < value) {
                helper.pollLast();
            }
            helper.offerLast(value);
        }

        public int pop_front() {
            if (deque.isEmpty()) {
                return -1;
            }
            Integer first = deque.pollFirst();
            if (!helper.isEmpty() && helper.peekFirst().equals(first)) {
                // 如果移除的是最大值,则需要移除一个数字
                helper.pollFirst();
            }

            return first;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
//leetcode submit region end(Prohibit modification and deletion)

}