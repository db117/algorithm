

//给你一个二维数组 points 和一个字符串 s ，其中 points[i] 表示第 i 个点的坐标，s[i] 表示第 i 个点的 标签 。 
//
// 如果一个正方形的中心在 (0, 0) ，所有边都平行于坐标轴，且正方形内 不 存在标签相同的两个点，那么我们称这个正方形是 合法 的。 
//
// 请你返回 合法 正方形中可以包含的 最多 点数。 
//
// 注意： 
//
// 
// 如果一个点位于正方形的边上或者在边以内，则认为该点位于正方形内。 
// 正方形的边长可以为零。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
// 输入：points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = "abdca" 
// 
//
// 输出：2 
//
// 解释： 
//
// 边长为 4 的正方形包含两个点 points[0] 和 points[1] 。 
//
// 示例 2： 
//
// 
//
// 
// 输入：points = [[1,1],[-2,-2],[-2,2]], s = "abb" 
// 
//
// 输出：1 
//
// 解释： 
//
// 边长为 2 的正方形包含 1 个点 points[0] 。 
//
// 示例 3： 
//
// 
// 输入：points = [[1,1],[-1,-1],[2,-2]], s = "ccd" 
// 
//
// 输出：0 
//
// 解释： 
//
// 任何正方形都无法只包含 points[0] 和 points[1] 中的一个点，所以合法正方形中都不包含任何点。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, points.length <= 10⁵ 
// points[i].length == 2 
// -10⁹ <= points[i][0], points[i][1] <= 10⁹ 
// s.length == points.length 
// points 中的点坐标互不相同。 
// s 只包含小写英文字母。 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 32 👎 0


package cn.db117.leetcode.solution31;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3143.正方形中的最多点数.maximum-points-inside-the-square
 *
 * @author db117
 * @since 2024-08-03 22:53:45
 **/

public class Solution_3143 {
    public static void main(String[] args) {
        Solution solution = new Solution_3143().new Solution();
        // [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]]
        //			"abdca"
//        System.out.println(solution.maxPointsInsideSquare(new int[][]{
//                        {2, 2}, {-1, -2}, {-4, 4}, {-3, 1}, {3, -3}
//                },
//                "abdca"
//        ));

        // [[16,32],[27,3],[23,-14],[-32,-16],[-3,26],[-14,33]]
        //			"aaabfc"
        System.out.println(solution.maxPointsInsideSquare(new int[][]{
                        {16, 32}, {27, 3}, {23, -14}, {-32, -16}, {-3, 26}, {-14, 33}
                },
                "aaabfc"
        ));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxPointsInsideSquare(int[][] points, String s) {
            char[] chars = s.toCharArray();
            int n = chars.length;
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                // 记录在那个边上
                arr[i][0] = Math.max(Math.abs(points[i][0]), Math.abs(points[i][1]));
                arr[i][1] = chars[i] - 'a';
            }
            int ans = 0;
            // 按照边长排序
            Arrays.sort(arr, Comparator.comparingInt(o -> o[0]));
            boolean[] visited = new boolean[26];
            // 分组循环
            int start = 0;
            for (int i = 0; i < n; ) {
                // 在用一个边长的分到一组
                while (i < n && arr[i][0] == arr[start][0]) {
                    i++;
                }
                for (int j = start; j < i; j++) {
                    if (visited[arr[j][1]]) {
                        return ans;
                    }
                    visited[arr[j][1]] = true;

                }
                ans += i - start;
                start = i;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}