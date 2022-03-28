

//给定一个整数数据流和一个窗口大小，根据该滑动窗口的大小，计算其所有整数的移动平均值。 
//
// 实现 MovingAverage 类： 
//
// 
// MovingAverage(int size) 用窗口大小 size 初始化对象。 
// double next(int val) 计算并返回数据流中最后 size 个值的移动平均值。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MovingAverage", "next", "next", "next", "next"]
//[[3], [1], [10], [3], [5]]
//输出：
//[null, 1.0, 5.5, 4.66667, 6.0]
//
//解释：
//MovingAverage movingAverage = new MovingAverage(3);
//movingAverage.next(1); // 返回 1.0 = 1 / 1
//movingAverage.next(10); // 返回 5.5 = (1 + 10) / 2
//movingAverage.next(3); // 返回 4.66667 = (1 + 10 + 3) / 3
//movingAverage.next(5); // 返回 6.0 = (10 + 3 + 5) / 3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= size <= 1000 
// -10⁵ <= val <= 10⁵ 
// 最多调用 next 方法 10⁴ 次 
// 
// Related Topics 设计 队列 数组 数据流 👍 80 👎 0


package cn.db117.leetcode.solution3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346.数据流中的移动平均值.moving-average-from-data-stream
 *
 * @author db117
 * @since 2022-03-27 22:58:21
 **/

public class Solution_346 {
    public static void main(String[] args) {
        MovingAverage solution = new Solution_346().new MovingAverage(0);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MovingAverage {
        double sum = 0;
        int size;
        Queue<Integer> queue = new LinkedList<>();

        public MovingAverage(int size) {
            this.size = size;
        }

        public double next(int val) {
            queue.offer(val);
            sum += val;
            if (queue.size() > size) {
                sum -= queue.poll();
            }
            return sum / queue.size();
        }
    }

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
//leetcode submit region end(Prohibit modification and deletion)

}