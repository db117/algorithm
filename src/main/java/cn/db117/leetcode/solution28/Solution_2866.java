

//给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。 
//
// 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。 
//
// 如果以下条件满足，我们称这些塔是 美丽 的： 
//
// 
// 1 <= heights[i] <= maxHeights[i] 
// heights 是一个 山状 数组。 
// 
//
// 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山状 数组： 
//
// 
// 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j] 
// 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k] 
// 
//
// 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。 
//
// 
//
// 示例 1： 
//
// 
//输入：maxHeights = [5,3,4,1,1]
//输出：13
//解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]  
//- heights 是个山状数组，峰值在 i = 0 处。
//13 是所有美丽塔方案中的最大高度和。 
//
// 示例 2： 
//
// 
//输入：maxHeights = [6,5,3,9,2,7]
//输出：22
//解释： 和最大的美丽塔方案为 heights = [3,3,3,9,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山状数组，峰值在 i = 3 处。
//22 是所有美丽塔方案中的最大高度和。 
//
// 示例 3： 
//
// 
//输入：maxHeights = [3,2,5,5,2,3]
//输出：18
//解释：和最大的美丽塔方案为 heights = [2,2,5,5,2,2] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山状数组，最大值在 i = 2 处。
//注意，在这个方案中，i = 3 也是一个峰值。
//18 是所有美丽塔方案中的最大高度和。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n == maxHeights <= 10⁵ 
// 1 <= maxHeights[i] <= 10⁹ 
// 
//
// 👍 17 👎 0


package cn.db117.leetcode.solution28;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 2866.美丽塔 II.beautiful-towers-ii
 *
 * @author db117
 * @since 2023-09-26 10:30:49
 **/

public class Solution_2866 {
    public static void main(String[] args) {
        Solution solution = new Solution_2866().new Solution();
        // [5,3,4,1,1]
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(5, 3, 4, 1, 1)));
        // [314324228,526196638,971780775,141382951,44825730,92939243,869702460,692214717,396184442,271863091,452818943,124554145,194393992,813279621,476977123,291285997,195696382,80619001,296691434,24194433,834306546,337273583,612960339,252148987,498162770,641751698,580675254,66186200,192009966,590634046,590252844,510204257,235020771,606202644,338253570,224352005,183647397,867961176,521468453,365745792,508222499,360685429,851354307,177768509,955097078,227459453,644376561,467834249,594236609,319781404,648225233,524439197,532203513,463002246,498592686,691351312,208635346,155682966,294639403,341617283,604365123,79112831,22440031,809193898,675993946,99928197,644324211,170555722,218906830,782039120,686747235,356537885]
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(314324228, 526196638, 971780775, 141382951, 44825730, 92939243,
                869702460, 692214717, 396184442, 271863091, 452818943, 124554145, 194393992, 813279621, 476977123, 291285997, 195696382,
                80619001, 296691434, 24194433, 834306546, 337273583, 612960339, 252148987, 498162770, 641751698, 580675254, 66186200,
                192009966, 590634046, 590252844, 510204257, 235020771, 606202644, 338253570, 224352005, 183647397, 867961176, 521468453,
                365745792, 508222499, 360685429, 851354307, 177768509, 955097078, 227459453, 644376561, 467834249, 594236609, 319781404,
                648225233, 524439197, 532203513, 463002246, 498592686, 691351312, 208635346, 155682966, 294639403, 341617283,
                604365123, 79112831, 22440031, 809193898, 675993946, 99928197, 644324211, 170555722, 218906830, 782039120, 686747235, 356537885)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long maximumSumOfHeights(List<Integer> maxHeights) {
            int[] arr = new int[maxHeights.size()];
            for (int i = 0; i < maxHeights.size(); i++) {
                arr[i] = maxHeights.get(i);
            }
            long ans = 0;
            int n = maxHeights.size();
            long[] right = new long[n + 1];

            // 单调栈
            Deque<Integer> queue = new ArrayDeque<>();
            // 计算以当前位置为最高点的右边的和
            queue.push(n);// 哨兵
            long sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (queue.size() > 1 && arr[i] <= arr[queue.peek()]) {
                    Integer pre = queue.pop();
                    // 去掉比当前值小的,之前的都多算了
                    sum -= (long) (queue.peek() - pre) * arr[pre];
                }
                // 栈里面现在有的都比当前值小,且栈顶到当前索引中间全是当前值
                sum += (long) arr[i] * (queue.peek() - i);
                right[i] = sum;
                queue.push(i);
            }

            // 计算以当前位置为最高点的左边的和
            queue.clear();
            queue.push(-1);// 哨兵
            sum = 0;
            for (int i = 0; i < n; i++) {
                while (queue.size() > 1 && arr[i] <= arr[queue.peek()]) {
                    Integer pre = queue.pop();
                    sum -= (long) (pre - queue.peek()) * arr[pre];
                }
                sum += (long) arr[i] * (i - queue.peek());
                queue.push(i);
                ans = Math.max(ans, sum + right[i + 1]);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}