// 你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和相等。
//
// 你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没
//有穿过一块砖的。 
//
// 给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的
//砖块数量最少 ，并且返回 穿过的砖块数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：wall = [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：wall = [[1],[1],[1]]
//输出：3
// 
// 
//
// 提示： 
//
// 
// n == wall.length 
// 1 <= n <= 104 
// 1 <= wall[i].length <= 104 
// 1 <= sum(wall[i].length) <= 2 * 104 
// 对于每一行 i ，sum(wall[i]) 是相同的 
// 1 <= wall[i][j] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 241 👎 0


package cn.db117.leetcode.solution5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 554.砖墙.brick-wall
 *
 * @author db117
 * @since 2021-07-01 11:32:34
 **/

public class Solution_554 {
    public static void main(String[] args) {
        Solution solution = new Solution_554().new Solution();
        // [[1,2,2,1],[3,1,2],[1,3,2],[2,4],[3,1,2],[1,3,1,1]]
        System.out.println(solution.leastBricks(new ArrayList<>() {{
            add(List.of(1, 2, 2, 1));
            add(List.of(3, 1, 2));
            add(List.of(1, 3, 2));
            add(List.of(2, 4));
            add(List.of(3, 1, 2));
            add(List.of(1, 3, 1, 1));
        }}));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int leastBricks(List<List<Integer>> wall) {
            // 前缀和 相同则不会穿过砖块
            int rowSum = 0; // 每一行的总行数
            // 前缀和 -> 出现的次数
            Map<Integer, Integer> map = new HashMap<>();

            for (List<Integer> list : wall) {
                int sum = 0;
                for (Integer n : list) {
                    sum += n;
                    map.put(sum, map.getOrDefault(sum, 0) + 1);
                }
                rowSum = sum;
            }

            // 不能再两边搞
            map.remove(rowSum);

            // 最多在一条线上的数量
            // 前缀和相同的数量的最大值
            int max = map.values()
                    .stream()
                    .max(Integer::compareTo)
                    .orElse(-1);

            return max == -1 ? wall.size() : wall.size() - max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}