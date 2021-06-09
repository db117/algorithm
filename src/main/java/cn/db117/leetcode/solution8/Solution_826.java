// 有一些工作：difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
//
// 现在我们有一些工人。worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。 
//
// 每一个工人都最多只能安排一个工作，但是一个工作可以完成多次。 
//
// 举个例子，如果 3 个工人都尝试完成一份报酬为 1 的同样工作，那么总收益为 $3。如果一个工人不能完成任何工作，他的收益为 $0 。 
//
// 我们能得到的最大收益是多少？ 
//
// 
//
// 示例： 
//
// 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
//输出: 100 
//解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 
//
// 
//
// 提示: 
//
// 
// 1 <= difficulty.length = profit.length <= 10000 
// 1 <= worker.length <= 10000 
// difficulty[i], profit[i], worker[i] 的范围是 [1, 10^5] 
// 
// Related Topics 双指针 
// 👍 61 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;

/**
 * 826.安排工作以达到最大收益.most-profit-assigning-work
 *
 * @author db117
 * @since 2021-06-09 15:30:15
 **/

public class Solution_826 {
    public static void main(String[] args) {
        Solution solution = new Solution_826().new Solution();
        // :[68,35,52,47,86]
        //				[67,17,1,81,3]
        //				[92,10,85,84,82]
        //				测试结果:204
        //				期望结果:324
        System.out.println(solution.maxProfitAssignment(new int[]{
                68, 35, 52, 47, 86
        }, new int[]{
                67, 17, 1, 81, 3
        }, new int[]{
                92, 10, 85, 84, 82
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
            int mark = (1 << 30) - 1;
            // 使用一个数组来保存难度和收益
            // 低30位保存收益
            long[] arr = new long[difficulty.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (long) difficulty[i] << 30 | profit[i];
            }
            // 根据难度排序
            Arrays.sort(arr);
            Arrays.sort(worker);

            // 如果难度和收益不成正比,则可以保存小于等于当前难度的最大收益
            int max = -1;
            for (int i = 0; i < arr.length; i++) {
                long d = arr[i] >> 30;
                max = (int) Math.max(max, arr[i] & mark);
                arr[i] = (d << 30) | max;
            }


            int di = 0;// 难度索引位置
            int ans = 0;// 总收益
            for (int w : worker) {
                int d = (int) (arr[di] >> 30);//难度
                if (d > w) {
                    continue;
                }
                while (di + 1 < arr.length && (arr[di + 1] >> 30) <= w) {
                    // 找到当前工人能够做的最大难度
                    di++;
                }

                ans += arr[di] & mark;// 当前难度收益
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}