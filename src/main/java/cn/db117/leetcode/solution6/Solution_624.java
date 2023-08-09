

//给定 m 个数组，每个数组都已经按照升序排好序了。现在你需要从两个不同的数组中选择两个整数（每个数组选一个）并且计算它们的距离。两个整数 a 和 b 之间的
//距离定义为它们差的绝对值 |a-b| 。你的任务就是去找到最大距离 
//
// 示例 1： 
//
// 输入： 
//[[1,2,3],
// [4,5],
// [1,2,3]]
//输出： 4
//解释：
//一种得到答案 4 的方法是从第一个数组或者第三个数组中选择 1，同时从第二个数组中选择 5 。
// 
//
// 
//
// 注意： 
//
// 
// 每个给定数组至少会有 1 个数字。列表中至少有两个非空数组。 
// 所有 m 个数组中的数字总数目在范围 [2, 10000] 内。 
// m 个数组中所有整数的范围在 [-10000, 10000] 内。 
// 
//
// 
//
// Related Topics 贪心 数组 👍 90 👎 0


package cn.db117.leetcode.solution6;

import java.util.List;

/**
 * 624.数组列表中的最大距离.maximum-distance-in-arrays
 *
 * @author db117
 * @since 2023-08-09 17:44:34
 **/

public class Solution_624 {
    public static void main(String[] args) {
        Solution solution = new Solution_624().new Solution();
        // [[1,4],[0,5]]
        System.out.println(solution.maxDistance(List.of(
                List.of(1, 4),
                List.of(0, 5)
        )));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxDistance(List<List<Integer>> arrays) {
            int ans = 0;
            // 找到最小的 2 个数和最大的 2 个数
            int min1 = Integer.MAX_VALUE, maxNext = Integer.MIN_VALUE;
            int min2 = Integer.MAX_VALUE, maxFirst = Integer.MIN_VALUE;
            // 最小值和最大值所在的数组
            int indexMin = -1, indexMax = -1;

            for (int i = 0; i < arrays.size(); i++) {
                List<Integer> array = arrays.get(i);
                int size = array.size();
                int num1 = array.get(0);
                int num2 = array.get(size - 1);

                if (num1 <= min1) {
                    min2 = min1;
                    min1 = num1;
                    indexMin = i;
                } else if (num1 < min2) {
                    min2 = num1;
                }

                if (num2 >= maxFirst) {
                    maxNext = maxFirst;
                    maxFirst = num2;
                    indexMax = i;
                } else if (num2 > maxNext) {
                    maxNext = num2;
                }
            }

            if (indexMax == indexMin) {
                // 最大值和最小值在同一个数组
                ans = Math.max(ans, maxFirst - min2);
                ans = Math.max(ans, maxNext - min1);
            } else {
                ans = Math.max(ans, maxFirst - min1);

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}