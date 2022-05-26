

//给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 
//pricei 。折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子： 
//
// 请你返回要表示一个折线图所需要的 最少线段数 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
//输出：3
//解释：
//上图为输入对应的图，横坐标表示日期，纵坐标表示价格。
//以下 3 个线段可以表示折线图：
//- 线段 1 （红色）从 (1,7) 到 (4,4) ，经过 (1,7) ，(2,6) ，(3,5) 和 (4,4) 。
//- 线段 2 （蓝色）从 (4,4) 到 (5,4) 。
//- 线段 3 （绿色）从 (5,4) 到 (8,1) ，经过 (5,4) ，(6,3) ，(7,2) 和 (8,1) 。
//可以证明，无法用少于 3 条线段表示这个折线图。
// 
//
// 示例 2： 
//
// 
//
// 输入：stockPrices = [[3,4],[1,2],[7,8],[2,3]]
//输出：1
//解释：
//如上图所示，折线图可以用一条线段表示。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= stockPrices.length <= 10⁵ 
// stockPrices[i].length == 2 
// 1 <= dayi, pricei <= 10⁹ 
// 所有 dayi 互不相同 。 
// 
// Related Topics 几何 数组 数学 数论 排序 👍 10 👎 0


package cn.db117.leetcode.solution22;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2280.表示一个折线图的最少线段数.minimum-lines-to-represent-a-line-chart
 *
 * @author db117
 * @since 2022-05-26 15:53:42
 **/

public class Solution_2280 {
    public static void main(String[] args) {
        Solution solution = new Solution_2280().new Solution();

        System.out.println(solution.minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
        System.out.println(solution.minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println(solution.minimumLines(new int[][]{{3, 4}, {1, 2}}));
        // 29
        System.out.println(solution.minimumLines(new int[][]{{72, 98}, {62, 27}, {32, 7}, {71, 4}, {25, 19}, {91, 30}, {52, 73},
                {10, 9}, {99, 71}, {47, 22}, {19, 30}, {80, 63}, {18, 15}, {48, 17}, {77, 16}, {46, 27}, {66, 87},
                {55, 84}, {65, 38}, {30, 9}, {50, 42}, {100, 60}, {75, 73}, {98, 53}, {22, 80}, {41, 61}, {37, 47}, {95, 8}, {51, 81}, {78, 79}, {57, 95}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLines(int[][] stockPrices) {
            if (stockPrices.length < 2) {
                return 0;
            }
            if (stockPrices.length == 2) {
                return 1;
            }
            // 按天排序
            Arrays.sort(stockPrices, Comparator.comparingInt(o -> o[0]));
            int ans = 1;
            for (int i = 1; i < stockPrices.length - 1; i++) {
                // 判断三个点是否可以连成一条线
                int[] pre = stockPrices[i - 1];
                int[] cur = stockPrices[i];
                int[] post = stockPrices[i + 1];

                if ((cur[1] - pre[1]) * (post[0] - cur[0]) != (post[1] - cur[1]) * (cur[0] - pre[0])) {
                    // 不能练成一条线
                    ans++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}