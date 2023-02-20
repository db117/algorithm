

//一所学校里有一些班级，每个班级里有一些学生，现在每个班都会进行一场期末考试。给你一个二维数组 classes ，其中 classes[i] = [
//passi, totali] ，表示你提前知道了第 i 个班级总共有 totali 个学生，其中只有 passi 个学生可以通过考试。 
//
// 给你一个整数 extraStudents ，表示额外有 extraStudents 个聪明的学生，他们 一定 能通过任何班级的期末考。你需要给这 
//extraStudents 个学生每人都安排一个班级，使得 所有 班级的 平均 通过率 最大 。 
//
// 一个班级的 通过率 等于这个班级通过考试的学生人数除以这个班级的总人数。平均通过率 是所有班级的通过率之和除以班级数目。 
//
// 请你返回在安排这 extraStudents 个学生去对应班级后的 最大 平均通过率。与标准答案误差范围在 10⁻⁵ 以内的结果都会视为正确结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：classes = [[1,2],[3,5],[2,2]], extraStudents = 2
//输出：0.78333
//解释：你可以将额外的两个学生都安排到第一个班级，平均通过率为 (3/4 + 3/5 + 2/2) / 3 = 0.78333 。
// 
//
// 示例 2： 
//
// 
//输入：classes = [[2,4],[3,9],[4,5],[2,10]], extraStudents = 4
//输出：0.53485
// 
//
// 
//
// 提示： 
//
// 
// 1 <= classes.length <= 10⁵ 
// classes[i].length == 2 
// 1 <= passi <= totali <= 10⁵ 
// 1 <= extraStudents <= 10⁵ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 116 👎 0


package cn.db117.leetcode.solution17;

import java.util.PriorityQueue;

/**
 * 1792.最大平均通过率.maximum-average-pass-ratio
 *
 * @author db117
 * @since 2023-02-19 17:26:08
 **/

public class Solution_1792 {
    public static void main(String[] args) {
        Solution solution = new Solution_1792().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double maxAverageRatio(int[][] classes, int extraStudents) {
            // 通过率排序
            PriorityQueue<double[]> queue = new PriorityQueue<>((o1, o2) -> {
                // 分子分母都加一  通过率增长大小排序
                double a = (o1[0] + 1) / (o1[1] + 1) - (o1[0] / o1[1]);
                double b = (o2[0] + 1) / (o2[1] + 1) - (o2[0] / o2[1]);
                // 大的在前面
                return Double.compare(b, a);
            });
            for (int[] ints : classes) {
                queue.offer(new double[]{ints[0], ints[1]});
            }

            // 每次都加到增长大的班级
            for (int i = 0; i < extraStudents; i++) {
                double[] poll = queue.poll();
                poll[0]++;
                poll[1]++;
                queue.offer(poll);
            }

            double ans = 0;

            for (double[] ints : queue) {
                ans += ints[0] / ints[1];
            }
            return ans / classes.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}