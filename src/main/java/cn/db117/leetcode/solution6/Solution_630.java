

//这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [durationi, 
//lastDayi] 表示第 i 门课将会 持续 上 durationi 天课，并且必须在不晚于 lastDayi 的时候完成。 
//
// 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。 
//
// 返回你最多可以修读的课程数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：courses = [[100, 200], [200, 1300], [1000, 1250], [2000, 3200]]
//输出：3
//解释：
//这里一共有 4 门课程，但是你最多可以修 3 门：
//首先，修第 1 门课，耗费 100 天，在第 100 天完成，在第 101 天开始下门课。
//第二，修第 3 门课，耗费 1000 天，在第 1100 天完成，在第 1101 天开始下门课程。
//第三，修第 2 门课，耗时 200 天，在第 1300 天完成。
//第 4 门课现在不能修，因为将会在第 3300 天完成它，这已经超出了关闭日期。 
//
// 示例 2： 
//
// 
//输入：courses = [[1,2]]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：courses = [[3,2],[4,3]]
//输出：0
// 
//
// 
//
// 提示: 
//
// 
// 1 <= courses.length <= 10⁴ 
// 1 <= durationi, lastDayi <= 10⁴ 
// 
//
// Related Topics 贪心 数组 排序 堆（优先队列） 👍 476 👎 0


package cn.db117.leetcode.solution6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630.课程表 III.course-schedule-iii
 *
 * @author db117
 * @since 2023-09-11 11:10:50
 **/

public class Solution_630 {
    public static void main(String[] args) {
        Solution solution = new Solution_630().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int scheduleCourse(int[][] courses) {
            // 按照结束时间排序
            Arrays.sort(courses, Comparator.comparing(o -> o[1]));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            int cur = 0;    // 当前使用时间
            for (int[] cours : courses) {
                int during = cours[0];
                int lastDay = cours[1];
                if (lastDay >= cur + during) {
                    // 可以学
                    cur += during;
                    pq.offer(during);
                } else {
                    // 不能学
                    if (!pq.isEmpty() && pq.peek() > during) {
                        // 用时最长的课程替换当前课程
                        cur += during - pq.poll();
                        pq.offer(during);
                    }
                }
            }
            return pq.size();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}