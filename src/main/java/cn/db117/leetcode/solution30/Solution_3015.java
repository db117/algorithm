

//给你三个 正整数 n 、x 和 y 。 
//
// 在城市中，存在编号从 1 到 n 的房屋，由 n 条街道相连。对所有 1 <= i < n ，都存在一条街道连接编号为 i 的房屋与编号为 i + 1 的
//房屋。另存在一条街道连接编号为 x 的房屋与编号为 y 的房屋。 
//
// 对于每个 k（1 <= k <= n），你需要找出所有满足要求的 房屋对 [house1, house2] ，即从 house1 到 house2 需要经
//过的 最少 街道数为 k 。 
//
// 返回一个下标从 1 开始且长度为 n 的数组 result ，其中 result[k] 表示所有满足要求的房屋对的数量，即从一个房屋到另一个房屋需要经过的
// 最少 街道数为 k 。 
//
// 注意，x 与 y 可以 相等 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：n = 3, x = 1, y = 3
//输出：[6,0,0]
//解释：让我们检视每个房屋对
//- 对于房屋对 (1, 2)，可以直接从房屋 1 到房屋 2。
//- 对于房屋对 (2, 1)，可以直接从房屋 2 到房屋 1。
//- 对于房屋对 (1, 3)，可以直接从房屋 1 到房屋 3。
//- 对于房屋对 (3, 1)，可以直接从房屋 3 到房屋 1。
//- 对于房屋对 (2, 3)，可以直接从房屋 2 到房屋 3。
//- 对于房屋对 (3, 2)，可以直接从房屋 3 到房屋 2。
// 
//
// 示例 2： 
// 
// 
//输入：n = 5, x = 2, y = 4
//输出：[10,8,2,0,0]
//解释：对于每个距离 k ，满足要求的房屋对如下：
//- 对于 k == 1，满足要求的房屋对有 (1, 2), (2, 1), (2, 3), (3, 2), (2, 4), (4, 2), (3, 4), 
//(4, 3), (4, 5), 以及 (5, 4)。
//- 对于 k == 2，满足要求的房屋对有 (1, 3), (3, 1), (1, 4), (4, 1), (2, 5), (5, 2), (3, 5), 
//以及 (5, 3)。
//- 对于 k == 3，满足要求的房屋对有 (1, 5)，以及 (5, 1) 。
//- 对于 k == 4 和 k == 5，不存在满足要求的房屋对。
// 
//
// 示例 3： 
// 
// 
//输入：n = 4, x = 1, y = 1
//输出：[6,4,2,0]
//解释：对于每个距离 k ，满足要求的房屋对如下：
//- 对于 k == 1，满足要求的房屋对有 (1, 2), (2, 1), (2, 3), (3, 2), (3, 4), 以及 (4, 3)。
//- 对于 k == 2，满足要求的房屋对有 (1, 3), (3, 1), (2, 4), 以及 (4, 2)。
//- 对于 k == 3，满足要求的房屋对有 (1, 4), 以及 (4, 1)。
//- 对于 k == 4，不存在满足要求的房屋对。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= x, y <= n 
// 
//
// 👍 4 👎 0


package cn.db117.leetcode.solution30;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 3015.按距离统计房屋对数目 I.count-the-number-of-houses-at-a-certain-distance-i
 *
 * @author db117
 * @since 2024-01-22 10:55:55
 **/

public class Solution_3015 {
    public static void main(String[] args) {
        Solution solution = new Solution_3015().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] countOfPairs(int n, int x, int y) {
            int[] ans = new int[n];

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            // 模拟从每一个节点出发
            for (int i = 1; i <= n; i++) {
                set.clear();
                set.add(i);
                // 相邻节点
                if (i + 1 <= n) {
                    queue.add(i + 1);
                    set.add(i + 1);
                }
                if (i - 1 > 0) {
                    queue.add(i - 1);
                    set.add(i - 1);
                }
                // 多的那条
                if (i == x && !set.contains(y)) {
                    queue.add(y);
                    set.add(y);
                }
                if (i == y && !set.contains(x)) {
                    queue.add(x);
                    set.add(x);
                }
                int cur = 0;
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int j = 0; j < size; j++) {
                        Integer poll = queue.poll();
                        if (cur >= n) {
                            break;
                        }
                        ans[cur]++;
                        // 多的那条
                        if (poll == x && !set.contains(y)) {
                            queue.add(y);
                            set.add(y);
                        }
                        if (poll == y && !set.contains(x)) {
                            queue.add(x);
                            set.add(x);
                        }
                        // 相邻节点
                        if (poll - 1 > 0 && !set.contains(poll - 1)) {
                            queue.add(poll - 1);
                            set.add(poll - 1);
                        }
                        if (poll + 1 <= n && !set.contains(poll + 1)) {
                            queue.add(poll + 1);
                            set.add(poll + 1);
                        }
                    }
                    cur++;
                }
            }


            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}