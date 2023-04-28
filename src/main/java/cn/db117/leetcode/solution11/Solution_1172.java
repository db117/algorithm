

//我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。 
//
// 实现一个叫「餐盘」的类 DinnerPlates： 
//
// 
// DinnerPlates(int capacity) - 给出栈的最大容量 capacity。 
// void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。 
// int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。 
// int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -
//1。 
// 
//
// 
//
// 示例： 
//
// 输入： 
//["DinnerPlates","push","push","push","push","push","popAtStack","push","push",
//"popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
//输出：
//[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
//
//解释：
//DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
//D.push(1);
//D.push(2);
//D.push(3);
//D.push(4);
//D.push(5);         // 栈的现状为：    2  4
//                                    1  3  5
//                                    ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 2。栈的现状为：      4
//                                          1  3  5
//                                          ﹈ ﹈ ﹈
//D.push(20);        // 栈的现状为：  20  4
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.push(21);        // 栈的现状为：  20  4 21
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
//                                            1  3  5
//                                            ﹈ ﹈ ﹈
//D.popAtStack(2);   // 返回 21。栈的现状为：       4
//                                            1  3  5
//                                            ﹈ ﹈ ﹈ 
//D.pop()            // 返回 5。栈的现状为：        4
//                                            1  3 
//                                            ﹈ ﹈  
//D.pop()            // 返回 4。栈的现状为：    1  3 
//                                           ﹈ ﹈   
//D.pop()            // 返回 3。栈的现状为：    1 
//                                           ﹈   
//D.pop()            // 返回 1。现在没有栈。
//D.pop()            // 返回 -1。仍然没有栈。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 20000 
// 1 <= val <= 20000 
// 0 <= index <= 100000 
// 最多会对 push，pop，和 popAtStack 进行 200000 次调用。 
// 
//
// Related Topics 栈 设计 哈希表 堆（优先队列） 👍 63 👎 0


package cn.db117.leetcode.solution11;

import java.util.*;

/**
 * 1172.餐盘栈.dinner-plate-stacks
 *
 * @author db117
 * @since 2023-04-28 10:45:41
 **/

public class Solution_1172 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class DinnerPlates {
        // 栈的容量
        private int capacity;
        // 所有栈
        private List<Deque<Integer>> stacks = new ArrayList<>();
        // 最小堆，保存未满栈的下标
        private PriorityQueue<Integer> idx = new PriorityQueue<>();

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
        }

        public void push(int val) {
            if (!idx.isEmpty() && idx.peek() >= stacks.size()) {
                // 堆里面的下标越界了
                idx.clear();
            }
            if (idx.isEmpty()) {
                // 没有未满的栈
                Deque<Integer> deque = new ArrayDeque<>();
                stacks.add(deque);
                deque.addLast(val);
                if (capacity > 1) {
                    // 新添加的栈没有满
                    idx.add(stacks.size() - 1);
                }
                return;
            }
            Integer min = idx.peek();
            Deque<Integer> deque = stacks.get(min);
            deque.addLast(val);
            if (deque.size() == capacity) {
                // 栈满了，就从堆里面去掉
                idx.poll();
            }
        }

        public int pop() {
            return popAtStack(stacks.size() - 1);
        }

        public int popAtStack(int index) {
            if (stacks.size() <= index || index < 0) {
                return -1;
            }
            Deque<Integer> deque = stacks.get(index);
            if (deque.isEmpty()) {
                return -1;
            }
            if (deque.size() == capacity) {
                // 把不满的 栈加到堆中
                idx.add(index);
            }
            Integer ans = deque.pollLast();
            while (!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
                // 把队尾的空栈都干掉
                stacks.remove(stacks.size() - 1);
            }
            return ans;
        }
    }

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}