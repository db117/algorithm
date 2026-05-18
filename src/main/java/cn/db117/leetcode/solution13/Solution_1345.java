

//给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。 
//
// 每一步，你可以从下标 i 跳到下标 i + 1 、i - 1 或者 j ： 
//
// 
// i + 1 需满足：i + 1 < arr.length 
// i - 1 需满足：i - 1 >= 0 
// j 需满足：arr[i] == arr[j] 且 i != j 
// 
//
// 请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。 
//
// 注意：任何时候你都不能跳到数组外面。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
//输出：3
//解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
// 
//
// 示例 2： 
//
// 
//输入：arr = [7]
//输出：0
//解释：一开始就在最后一个元素处，所以你不需要跳跃。
// 
//
// 示例 3： 
//
// 
//输入：arr = [7,6,9,6,9,6,9,7]
//输出：1
//解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 5 * 10⁴ 
// -10⁸ <= arr[i] <= 10⁸ 
// 
//
// Related Topics 广度优先搜索 数组 哈希表 👍 296 👎 0


package cn.db117.leetcode.solution13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 1345.跳跃游戏 IV.jump-game-iv
 *
 * @author db117
 * @since 2026-05-18 18:47:31
 **/

public class Solution_1345 {
    public static void main(String[] args) {
        Solution solution = new Solution_1345().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minJumps(int[] arr) {
            int n = arr.length;
            boolean[] visited = new boolean[n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
            }

            PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            queue.offer(new int[]{0, 0});
            visited[0] = true;
            while (!queue.isEmpty()) {
                int[] poll = queue.poll();
                int index = poll[1];
                int step = poll[0];
                if (index == n - 1) {
                    // 找到了
                    return step;
                }

                if (index - 1 >= 0 && !visited[index - 1]) {
                    queue.offer(new int[]{step + 1, index - 1});
                    visited[index - 1] = true;
                }
                if (index + 1 < n && !visited[index + 1]) {
                    queue.offer(new int[]{step + 1, index + 1});
                    visited[index + 1] = true;
                }
                // 可以随便跳的地方
                for (Integer i : map.getOrDefault(arr[index], new ArrayList<>())) {
                    if (visited[i]) {
                        continue;
                    }
                    queue.offer(new int[]{step + 1, i});
                    visited[i] = true;
                }
                map.remove(arr[index]);
            }

            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}