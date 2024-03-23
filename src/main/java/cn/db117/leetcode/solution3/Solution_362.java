

//设计一个敲击计数器，使它可以统计在过去 5 分钟内被敲击次数。（即过去 300 秒） 
//
// 您的系统应该接受一个时间戳参数 timestamp (单位为 秒 )，并且您可以假定对系统的调用是按时间顺序进行的(即 timestamp 是单调递增的)
//。几次撞击可能同时发生。 
//
// 实现 HitCounter 类: 
//
// 
// HitCounter() 初始化命中计数器系统。 
// void hit(int timestamp) 记录在 timestamp ( 单位为秒 )发生的一次命中。在同一个 timestamp 中可能会出现几个
//点击。 
// int getHits(int timestamp) 返回 timestamp 在过去 5 分钟内(即过去 300 秒)的命中次数。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入：
//["HitCounter", "hit", "hit", "hit", "getHits", "hit", "getHits", "getHits"]
//[[], [1], [2], [3], [4], [300], [300], [301]]
//输出：
//[null, null, null, null, 3, null, 4, 3]
//
//解释：
//HitCounter counter = new HitCounter();
//counter.hit(1);// 在时刻 1 敲击一次。
//counter.hit(2);// 在时刻 2 敲击一次。
//counter.hit(3);// 在时刻 3 敲击一次。
//counter.getHits(4);// 在时刻 4 统计过去 5 分钟内的敲击次数, 函数返回 3 。
//counter.hit(300);// 在时刻 300 敲击一次。
//counter.getHits(300); // 在时刻 300 统计过去 5 分钟内的敲击次数，函数返回 4 。
//counter.getHits(301); // 在时刻 301 统计过去 5 分钟内的敲击次数，函数返回 3 。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= timestamp <= 2 * 10⁹ 
// 所有对系统的调用都是按时间顺序进行的（即 timestamp 是单调递增的） 
// hit and getHits 最多被调用 300 次 
// 
//
// 
//
// 进阶: 如果每秒的敲击次数是一个很大的数字，你的计数器可以应对吗？ 
//
// Related Topics 设计 队列 数组 二分查找 数据流 👍 102 👎 0


package cn.db117.leetcode.solution3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 362.敲击计数器.design-hit-counter
 *
 * @author db117
 * @since 2024-03-23 15:44:00
 **/

public class Solution_362 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class HitCounter {
        Deque<int[]> deque = new ArrayDeque<>(1000);
        int count = 0;

        public HitCounter() {

        }

        public void hit(int timestamp) {
            count++;
            if (deque.isEmpty()) {
                deque.add(new int[]{timestamp, 1});
                return;
            }
            if (deque.peekLast()[0] == timestamp) {
                // 时间相同
                deque.peekLast()[1]++;
            } else {
                deque.add(new int[]{timestamp, 1});
            }
            // 移除超过5分钟的
            while (!deque.isEmpty() && deque.peekFirst()[0] <= timestamp - 300) {
                count -= deque.pollFirst()[1];
            }
        }

        public int getHits(int timestamp) {
            // 移除超过5分钟的
            while (!deque.isEmpty() && deque.peekFirst()[0] <= timestamp - 300) {
                count -= deque.pollFirst()[1];
            }
            return count;
        }
    }

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */
//leetcode submit region end(Prohibit modification and deletion)

}