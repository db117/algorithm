

//给你一个下标从 0 开始、由 n 个整数组成的数组 arr 。 
//
// arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。 
//
// 返回一个长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同
//）的 间隔之和 。 
//
// 注意：|x| 是 x 的绝对值。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,1,3,1,2,3,3]
//输出：[4,2,7,2,4,4,5]
//解释：
//- 下标 0 ：另一个 2 在下标 4 ，|0 - 4| = 4
//- 下标 1 ：另一个 1 在下标 3 ，|1 - 3| = 2
//- 下标 2 ：另两个 3 在下标 5 和 6 ，|2 - 5| + |2 - 6| = 7
//- 下标 3 ：另一个 1 在下标 1 ，|3 - 1| = 2
//- 下标 4 ：另一个 2 在下标 0 ，|4 - 0| = 4
//- 下标 5 ：另两个 3 在下标 2 和 6 ，|5 - 2| + |5 - 6| = 4
//- 下标 6 ：另两个 3 在下标 2 和 5 ，|6 - 2| + |6 - 5| = 5
// 
//
// 示例 2： 
//
// 输入：arr = [10,5,10,10]
//输出：[5,0,3,4]
//解释：
//- 下标 0 ：另两个 10 在下标 2 和 3 ，|0 - 2| + |0 - 3| = 5
//- 下标 1 ：只有这一个 5 在数组中，所以到相同元素的间隔之和是 0
//- 下标 2 ：另两个 10 在下标 0 和 3 ，|2 - 0| + |2 - 3| = 3
//- 下标 3 ：另两个 10 在下标 0 和 2 ，|3 - 0| + |3 - 2| = 4
// 
//
// 
//
// 提示： 
//
// 
// n == arr.length 
// 1 <= n <= 10⁵ 
// 1 <= arr[i] <= 10⁵ 
// 
// Related Topics 数组 哈希表 前缀和 👍 27 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 2121.相同元素的间隔之和.intervals-between-identical-elements
 *
 * @author db117
 * @since 2022-01-05 15:21:17
 **/

public class Solution_2121 {
    public static void main(String[] args) {
        Solution solution = new Solution_2121().new Solution();

        System.out.println(Arrays.toString(solution.getDistances(new int[]{2, 1, 3, 1, 2, 3, 3})));
        System.out.println(Arrays.toString(solution.getDistances(new int[]{10, 5, 10, 10})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] getDistances(int[] arr) {
            long[] ans = new long[arr.length];
            // 分开计算 前缀和 后缀和

            // 前面一个相同数字的索引
            Map<Integer, Integer> pre = new HashMap<>();
            // 相同数字的次数
            Map<Integer, Integer> count = new HashMap<>();

            // 前缀和
            long[] preSum = new long[arr.length];
            for (int i = 0; i < arr.length; i++) {
                int num = arr[i];
                // 上一个相同数字出现的位置
                Integer perIndex = pre.get(num);
                if (perIndex == null) {
                    // 第一次出现
                    pre.put(num, i);
                    count.put(num, 1);
                    continue;
                }

                // 当前前缀和 = 上一个数字前缀和 + 两个索引差 * 前面数量
                preSum[i] = preSum[perIndex] + (i - perIndex) * count.get(num);

                pre.put(num, i);
                count.put(num, count.get(num) + 1);
            }

            pre.clear();
            count.clear();
            // 后缀和
            long[] nextSum = new long[arr.length];
            for (int i = arr.length - 1; i >= 0; i--) {
                int num = arr[i];
                // 下一个相同数字出现的位置
                Integer nextIndex = pre.get(num);
                if (nextIndex == null) {
                    // 第一次出现
                    pre.put(num, i);
                    count.put(num, 1);
                    continue;
                }

                // 当前前缀和 = 下一个数字后缀和 + 两个索引差 * 前面数量
                nextSum[i] = nextSum[nextIndex] + (nextIndex - i) * count.get(num);

                pre.put(num, i);
                count.put(num, count.get(num) + 1);
            }

            // 合并前缀和与后缀和
            for (int i = 0; i < ans.length; i++) {
                ans[i] = preSum[i] + nextSum[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}