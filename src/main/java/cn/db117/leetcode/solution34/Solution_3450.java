

//给定一个包含学生数据的 2 维数组 students，其中 students[i] = [student_id, bench_id] 表示学生 
//student_id 正坐在长椅 bench_id 上。 
//
// 返回单个长凳上坐着的不同学生的 最大 数量。如果没有学生，返回 0。 
//
// 注意：一个学生在输入中可以出现在同一张长椅上多次，但每个长椅上只能计算一次。 
//
// 
//
// 示例 1： 
//
// 
// 输入：students = [[1,2],[2,2],[3,3],[1,3],[2,3]] 
// 
//
// 输出：3 
//
// 解释： 
//
// 
// 长椅 2 上有 2 个不同学生：[1, 2]。 
// 长椅 3 上有 3 个不同学生：[1, 2, 3]。 
// 一张长椅上不同学生的最大数量是 3。 
// 
//
// 示例 2： 
//
// 
// 输入：students = [[1,1],[2,1],[3,1],[4,2],[5,2]] 
// 
//
// 输出：3 
//
// 示例： 
//
// 
// 长椅 1 上有 3 个不同学生：[1, 2, 3]。 
// 长椅 2 上有 2 个不同学生：[4, 5]。 
// 一张长椅上不同学生的最大数量是 3。 
// 
//
// 示例 3： 
//
// 
// 输入：students = [[1,1],[1,1]] 
// 
//
// 输出：1 
//
// 解释： 
//
// 
// 一张长椅上不同学生的最大数量是 1。 
// 
//
// 示例 4： 
//
// 
// 输入：students = [] 
// 
//
// 输出：0 
//
// 解释： 
//
// 
// 由于不存在学生，输出为 0。 
// 
//
// 
//
// 提示： 
//
// 
// 0 <= students.length <= 100 
// students[i] = [student_id, bench_id] 
// 1 <= student_id <= 100 
// 1 <= bench_id <= 100 
// 
//
// Related Topics 数组 哈希表 👍 0 👎 0


package cn.db117.leetcode.solution34;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3450.一张长椅上的最多学生.maximum-students-on-a-single-bench
 *
 * @author db117
 * @since 2025-04-18 11:29:09
 **/

public class Solution_3450 {
    public static void main(String[] args) {
        Solution solution = new Solution_3450().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxStudentsOnBench(int[][] students) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] student : students) {
                map.computeIfAbsent(student[1], k -> new HashSet<>());
                map.get(student[1]).add(student[0]);
            }
            int max = 0;
            for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
                Set<Integer> v = entry.getValue();
                if (v.size() > max) {
                    max = v.size();
                }
            }

            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}