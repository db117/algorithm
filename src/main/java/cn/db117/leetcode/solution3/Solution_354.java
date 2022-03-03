

//给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。 
//
// 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。 
//
// 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。 
//
// 注意：不允许旋转信封。 
// 
//
// 示例 1： 
//
// 
//输入：envelopes = [[5,4],[6,4],[6,7],[2,3]]
//输出：3
//解释：最多信封的个数为 3, 组合为: [2,3] => [5,4] => [6,7]。 
//
// 示例 2： 
//
// 
//输入：envelopes = [[1,1],[1,1],[1,1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= envelopes.length <= 10⁵ 
// envelopes[i].length == 2 
// 1 <= wi, hi <= 10⁵ 
// 
// Related Topics 数组 二分查找 动态规划 排序 👍 665 👎 0


package cn.db117.leetcode.solution3;

import java.util.Arrays;

/**
 * 354.俄罗斯套娃信封问题.russian-doll-envelopes
 *
 * @author db117
 * @since 2022-03-02 18:50:52
 **/

public class Solution_354 {
    public static void main(String[] args) {
        Solution solution = new Solution_354().new Solution();
        System.out.println(solution.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(solution.maxEnvelopes(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        // 5
        System.out.println(solution.maxEnvelopes(new int[][]{{15, 8}, {2, 20}, {2, 14}, {4, 17}, {8, 19}, {8, 9},
                {5, 7}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19}, {8, 11}, {13, 11}, {2, 13}, {11, 19},
                {16, 1}, {18, 13}, {14, 17}, {18, 19}}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            // 普通动态规划超时  需要二分

            // 按照宽升序 高降序排列
            // 排列完成后高的严格递增子序列就是答案
            Arrays.sort(envelopes, (o1, o2) -> {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                }
                return o1[0] - o2[0];
            });
            // 最长递增子序列,可能的最小值
            int[] dp = new int[envelopes.length];
            int index = 0;// 下一个要写入的索引位置

            for (int[] envelope : envelopes) {
                int target = envelope[1];
                if (index == 0) {
                    // 初始化
                    dp[index++] = target;
                    continue;
                }
                if (target == dp[index - 1]) {
                    // 等于直接跳过
                    continue;
                }
                if (target > dp[index - 1]) {
                    // 大于最后一个 直接加上去
                    dp[index++] = target;
                    continue;
                }

                // 找第一个大于当前值的位置,并替换
                int left = 0, right = index;
                while (left < right) {
                    int mid = (left + right) / 2;

                    if (dp[mid] < target) {
                        // 当前 mid 不可能是
                        left = mid + 1;
                    } else {
                        // 可能是目标
                        right = mid;
                    }
                }
                dp[right] = target;
            }
            return index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}