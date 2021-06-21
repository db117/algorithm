//给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 s
//econdList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。 
//
// 返回这 两个区间列表的交集 。 
//
// 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。 
//
// 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。 
//
// 
//
// 示例 1： 
//
// 
//输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,
//24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
// 
//
// 示例 2： 
//
// 
//输入：firstList = [[1,3],[5,9]], secondList = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：firstList = [], secondList = [[4,8],[10,12]]
//输出：[]
// 
//
// 示例 4： 
//
// 
//输入：firstList = [[1,7]], secondList = [[3,10]]
//输出：[[3,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= firstList.length, secondList.length <= 1000 
// firstList.length + secondList.length >= 1 
// 0 <= starti < endi <= 109 
// endi < starti+1 
// 0 <= startj < endj <= 109 
// endj < startj+1 
// 
// Related Topics 双指针 
// 👍 160 👎 0


package cn.db117.leetcode.solution9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 986.区间列表的交集.interval-list-intersections
 *
 * @author db117
 * @since 2021-06-18 18:27:01
 **/

public class Solution_986 {
    public static void main(String[] args) {
        Solution solution = new Solution_986().new Solution();
        //输入：firstList = [[0,2],[5,10],[13,23],[24,25]], secondList = [[1,5],[8,12],[15,24],[25,26]]
//输出：[[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
        System.out.println(Arrays.deepToString(solution.intervalIntersection(new int[][]{
                {0, 2}, {5, 10}, {13, 23}, {24, 25}
        }, new int[][]{
                {1, 5}, {8, 12}, {15, 24}, {25, 26}
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
            if (firstList.length == 0 || secondList.length == 0) {
                return new int[0][];
            }


            List<int[]> ans = new ArrayList<>();
            int firstIndex = 0, secondIndex = 0;

            while (firstIndex < firstList.length && secondIndex < secondList.length) {
                int[] first = firstList[firstIndex];
                int[] second = secondList[secondIndex];

                // 不连续直接跳过
                if (first[1] < second[0]) {
                    firstIndex++;
                    continue;
                }

                if (first[0] > second[1]) {
                    secondIndex++;
                    continue;
                }

                // 添加区间
                ans.add(new int[]{
                        Math.max(first[0], second[0]),
                        Math.min(first[1], second[1])
                });

                // 去掉小的区间
                if (first[1] < second[1]) {
                    firstIndex++;
                } else {
                    secondIndex++;
                }
            }

            return ans.toArray(new int[0][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}