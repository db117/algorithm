

//给你两个整数 m 和 k ，以及数据流形式的若干整数。你需要实现一个数据结构，计算这个数据流的 MK 平均值 。 
//
// MK 平均值 按照如下步骤计算： 
//
// 
// 如果数据流中的整数少于 m 个，MK 平均值 为 -1 ，否则将数据流中最后 m 个元素拷贝到一个独立的容器中。 
// 从这个容器中删除最小的 k 个数和最大的 k 个数。 
// 计算剩余元素的平均值，并 向下取整到最近的整数 。 
// 
//
// 请你实现 MKAverage 类： 
//
// 
// MKAverage(int m, int k) 用一个空的数据流和两个整数 m 和 k 初始化 MKAverage 对象。 
// void addElement(int num) 往数据流中插入一个新的元素 num 。 
// int calculateMKAverage() 对当前的数据流计算并返回 MK 平均数 ，结果需 向下取整到最近的整数 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["MKAverage", "addElement", "addElement", "calculateMKAverage", "addElement", 
//"calculateMKAverage", "addElement", "addElement", "addElement", 
//"calculateMKAverage"]
//[[3, 1], [3], [1], [], [10], [], [5], [5], [5], []]
//输出：
//[null, null, null, -1, null, 3, null, null, null, 5]
//
//解释：
//MKAverage obj = new MKAverage(3, 1); 
//obj.addElement(3);        // 当前元素为 [3]
//obj.addElement(1);        // 当前元素为 [3,1]
//obj.calculateMKAverage(); // 返回 -1 ，因为 m = 3 ，但数据流中只有 2 个元素
//obj.addElement(10);       // 当前元素为 [3,1,10]
//obj.calculateMKAverage(); // 最后 3 个元素为 [3,1,10]
//                          // 删除最小以及最大的 1 个元素后，容器为 [3]
//                          // [3] 的平均值等于 3/1 = 3 ，故返回 3
//obj.addElement(5);        // 当前元素为 [3,1,10,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5]
//obj.addElement(5);        // 当前元素为 [3,1,10,5,5,5]
//obj.calculateMKAverage(); // 最后 3 个元素为 [5,5,5]
//                          // 删除最小以及最大的 1 个元素后，容器为 [5]
//                          // [5] 的平均值等于 5/1 = 5 ，故返回 5
// 
//
// 
//
// 提示： 
//
// 
// 3 <= m <= 10⁵ 
// 1 <= k*2 < m 
// 1 <= num <= 10⁵ 
// addElement 与 calculateMKAverage 总操作次数不超过 10⁵ 次。 
// 
//
// Related Topics 设计 队列 数据流 有序集合 堆（优先队列） 👍 47 👎 0


package cn.db117.leetcode.solution18;

import cn.db117.leetcode.base.Copy;

import java.util.*;

/**
 * 1825.求出 MK 平均值.finding-mk-average
 *
 * @author db117
 * @since 2023-01-18 10:22:56
 **/
@Copy("大模拟太恶心了")
public class Solution_1825 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MKAverage {

        private int m, k;
        private long s;
        private int size1, size3;
        private Deque<Integer> q = new ArrayDeque<>();
        private TreeMap<Integer, Integer> lo = new TreeMap<>();
        private TreeMap<Integer, Integer> mid = new TreeMap<>();
        private TreeMap<Integer, Integer> hi = new TreeMap<>();


        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;
        }

        public void addElement(int num) {
            if (lo.isEmpty() || num <= lo.lastKey()) {
                lo.merge(num, 1, Integer::sum);
                ++size1;
            } else if (hi.isEmpty() || num >= hi.firstKey()) {
                hi.merge(num, 1, Integer::sum);
                ++size3;
            } else {
                mid.merge(num, 1, Integer::sum);
                s += num;
            }
            q.offer(num);
            if (q.size() > m) {
                int x = q.poll();
                if (lo.containsKey(x)) {
                    lo.merge(x, -1, Integer::sum);
                    if (lo.get(x) == 0) {
                        lo.remove(x);
                    }
                    --size1;
                } else if (hi.containsKey(x)) {
                    hi.merge(x, -1, Integer::sum);
                    if (hi.get(x) == 0) {
                        hi.remove(x);
                    }
                    --size3;
                } else {
                    mid.merge(x, -1, Integer::sum);
                    if (mid.get(x) == 0) {
                        mid.remove(x);
                    }
                    s -= x;
                }
            }
            for (; size1 > k; --size1) {
                int x = lo.lastKey();
                lo.merge(x, -1, Integer::sum);
                if (lo.get(x) == 0) {
                    lo.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size3 > k; --size3) {
                int x = hi.firstKey();
                hi.merge(x, -1, Integer::sum);
                if (hi.get(x) == 0) {
                    hi.remove(x);
                }
                mid.merge(x, 1, Integer::sum);
                s += x;
            }
            for (; size1 < k && !mid.isEmpty(); ++size1) {
                int x = mid.firstKey();
                mid.merge(x, -1, Integer::sum);
                if (mid.get(x) == 0) {
                    mid.remove(x);
                }
                s -= x;
                lo.merge(x, 1, Integer::sum);
            }
            for (; size3 < k && !mid.isEmpty(); ++size3) {
                int x = mid.lastKey();
                mid.merge(x, -1, Integer::sum);
                if (mid.get(x) == 0) {
                    mid.remove(x);
                }
                s -= x;
                hi.merge(x, 1, Integer::sum);
            }
        }

        public int calculateMKAverage() {
            return q.size() < m ? -1 : (int) (s / (q.size() - k * 2));
        }
    }

/**
 * Your MKAverage object will be instantiated and called as such:
 * MKAverage obj = new MKAverage(m, k);
 * obj.addElement(num);
 * int param_2 = obj.calculateMKAverage();
 */
//leetcode submit region end(Prohibit modification and deletion)

}