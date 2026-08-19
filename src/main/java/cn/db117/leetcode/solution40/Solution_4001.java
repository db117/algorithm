package cn.db117.leetcode.solution40;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4001. 聚合两个时间序列
 */
public class Solution_4001 {


    //leetcode submit region begin(Prohibit modification and deletion)
    static
    class Solution {
        public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
            List<List<Integer>> ans = new ArrayList<>();

            int i = 0;
            int j = 0;

            while (i < series1.length || j < series2.length) {
                int timestamp;

                if (i == series1.length) {
                    timestamp = series2[j][0];
                } else if (j == series2.length) {
                    timestamp = series1[i][0];
                } else {
                    timestamp = Math.min(series1[i][0], series2[j][0]);
                }

                // 当前指针指向该时间戳或下一个更晚的时间戳
                int value1 = i < series1.length ? series1[i][1] : 0;
                int value2 = j < series2.length ? series2[j][1] : 0;

                ans.add(Arrays.asList(timestamp, value1 + value2));

                // 只有当前时间戳真实存在于序列中时，才移动指针
                if (i < series1.length && series1[i][0] == timestamp) {
                    i++;
                }

                if (j < series2.length && series2[j][0] == timestamp) {
                    j++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
