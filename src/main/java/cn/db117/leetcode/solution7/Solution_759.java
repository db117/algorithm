

//给定员工的 schedule 列表，表示每个员工的工作时间。 
//
// 每个员工都有一个非重叠的时间段 Intervals 列表，这些时间段已经排好序。 
//
// 返回表示 所有 员工的 共同，正数长度的空闲时间 的有限时间段的列表，同样需要排好序。 
//
// 示例 1： 
//
// 输入：schedule = [[[1,2],[5,6]],[[1,3]],[[4,10]]]
//输出：[[3,4]]
//解释：
//共有 3 个员工，并且所有共同的
//空间时间段是 [-inf, 1], [3, 4], [10, inf]。
//我们去除所有包含 inf 的时间段，因为它们不是有限的时间段。
// 
//
// 
//
// 示例 2： 
//
// 输入：schedule = [[[1,3],[6,7]],[[2,4]],[[2,5],[9,12]]]
//输出：[[5,6],[7,9]]
// 
//
// 
//
// （尽管我们用 [x, y] 的形式表示 Intervals ，内部的对象是 Intervals 而不是列表或数组。例如，schedule[0][0].
//start = 1, schedule[0][0].end = 2，并且 schedule[0][0][0] 是未定义的） 
//
// 而且，答案中不包含 [5, 5] ，因为长度为 0。 
//
// 
//
// 注： 
//
// 
// schedule 和 schedule[i] 为长度范围在 [1, 50]的列表。 
// 0 <= schedule[i].start < schedule[i].end <= 10^8。 
// 
//
// 注：输入类型于 2019 年 4 月 15 日 改变。请重置为默认代码的定义以获取新方法。 
//
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 106 👎 0


package cn.db117.leetcode.solution7;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 759.员工空闲时间.employee-free-time
 *
 * @author db117
 * @since 2023-09-01 11:22:17
 **/

public class Solution_759 {
    public static void main(String[] args) {
        Solution solution = new Solution_759().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

    class Solution {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            // 全部和在一起.排序
            List<Interval> all = new ArrayList<>();
            schedule.forEach(all::addAll);
            all.sort(Comparator.comparingInt(o -> o.start));

            List<Interval> ans = new ArrayList<>();
            Interval pre = all.get(0);
            for (Interval interval : all) {
                if (interval.start > pre.end) {
                    // 有空闲
                    ans.add(new Interval(pre.end, interval.start));
                    pre = interval;
                } else {
                    // 合并
                    pre.end = Math.max(pre.end, interval.end);
                }
            }

            return ans;
        }
    }

    //leetcode submit region end(Prohibit modification and deletion)
    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }
    }

    ;
}