

//在考场里，一排有 N 个座位，分别编号为 0, 1, 2, ..., N-1 。 
//
// 当学生进入考场后，他必须坐在能够使他与离他最近的人之间的距离达到最大化的座位上。如果有多个这样的座位，他会坐在编号最小的座位上。(另外，如果考场里没有人，
//那么学生就坐在 0 号座位上。) 
//
// 返回 ExamRoom(int N) 类，它有两个公开的函数：其中，函数 ExamRoom.seat() 会返回一个 int （整型数据），代表学生坐的位
//置；函数 ExamRoom.leave(int p) 代表坐在座位 p 上的学生现在离开了考场。每次调用 ExamRoom.leave(p) 时都保证有学生坐在
//座位 p 上。 
//
// 
//
// 示例： 
//
// 输入：["ExamRoom","seat","seat","seat","seat","leave","seat"], [[10],[],[],[],[]
//,[4],[]]
//输出：[null,0,9,4,2,null,5]
//解释：
//ExamRoom(10) -> null
//seat() -> 0，没有人在考场里，那么学生坐在 0 号座位上。
//seat() -> 9，学生最后坐在 9 号座位上。
//seat() -> 4，学生最后坐在 4 号座位上。
//seat() -> 2，学生最后坐在 2 号座位上。
//leave(4) -> null
//seat() -> 5，学生最后坐在 5 号座位上。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 10^9 
// 在所有的测试样例中 ExamRoom.seat() 和 ExamRoom.leave() 最多被调用 10^4 次。 
// 保证在调用 ExamRoom.leave(p) 时有学生正坐在座位 p 上。 
// 
//
// Related Topics 设计 有序集合 堆（优先队列） 👍 160 👎 0


package cn.db117.leetcode.solution8;

import java.util.*;

/**
 * 855.考场就座.exam-room
 *
 * @author db117
 * @since 2022-12-30 10:34:05
 **/

public class Solution_855 {
    public static void main(String[] args) {
        // 0 1 2 3 4 5 6 7 8 9
        // 1 0 0 0 1 0 0 0 0 1
        // ["ExamRoom","seat","seat","seat","seat","leave","seat"]
//        ExamRoom examRoom = new Solution_855().new ExamRoom(10);
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        examRoom.leave(4);
//        System.out.println(examRoom.seat());

        // ["ExamRoom","seat","seat","seat","seat","leave","leave","seat"]
        // [[4],[],[],[],[],[1],[3],[]]
        // [null,0,3,1,2,null,null,1]
//        ExamRoom examRoom = new Solution_855().new ExamRoom(4);
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        System.out.println(examRoom.seat());
//        examRoom.leave(1);
//        examRoom.leave(3);
//        System.out.println(examRoom.seat());
//
        // [[8],[],[],[],[0],[7],[],[],[],[],[],[],[],[0],[7],[],[]
        ExamRoom examRoom = new Solution_855().new ExamRoom(8);
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        System.out.println(examRoom.seat());
        examRoom.leave(0);
        examRoom.leave(7);
        System.out.println(examRoom.seat());
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class ExamRoom {
        int N;
        TreeSet<Integer> set;

        public ExamRoom(int N) {
            this.N = N;
            set = new TreeSet<>();
        }

        public int seat() {

            int student = 0;
            if (set.size() > 0) {
                // 选 0
                int dist = set.first();
                Integer prev = null;
                for (Integer s : set) {
                    if (prev != null) {
                        // 与两边最小的距离
                        int d = (s - prev) / 2;
                        if (d > dist) {
                            // 只要第一次
                            dist = d;
                            student = prev + d;
                        }
                    }
                    prev = s;
                }

                // 尝试一下最后一个
                if (N - 1 - set.last() > dist)
                    student = N - 1;
            }

            set.add(student);
            return student;
        }

        public void leave(int p) {
            set.remove(p);
        }
    }

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */
//leetcode submit region end(Prohibit modification and deletion)

}