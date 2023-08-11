

//给你一个长度为 n 的二维整数数组 items 和一个整数 k 。 
//
// items[i] = [profiti, categoryi]，其中 profiti 和 categoryi 分别表示第 i 个项目的利润和类别。 
//
// 现定义 items 的 子序列 的 优雅度 可以用 total_profit + distinct_categories² 计算，其中 total_
//profit 是子序列中所有项目的利润总和，distinct_categories 是所选子序列所含的所有类别中不同类别的数量。 
//
// 你的任务是从 items 所有长度为 k 的子序列中，找出 最大优雅度 。 
//
// 用整数形式表示并返回 items 中所有长度恰好为 k 的子序列的最大优雅度。 
//
// 注意：数组的子序列是经由原数组删除一些元素（可能不删除）而产生的新数组，且删除不改变其余元素相对顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：items = [[3,2],[5,1],[10,1]], k = 2
//输出：17
//解释：
//在这个例子中，我们需要选出长度为 2 的子序列。
//其中一种方案是 items[0] = [3,2] 和 items[2] = [10,1] 。
//子序列的总利润为 3 + 10 = 13 ，子序列包含 2 种不同类别 [2,1] 。
//因此，优雅度为 13 + 2² = 17 ，可以证明 17 是可以获得的最大优雅度。 
// 
//
// 示例 2： 
//
// 
//输入：items = [[3,1],[3,1],[2,2],[5,3]], k = 3
//输出：19
//解释：
//在这个例子中，我们需要选出长度为 3 的子序列。 
//其中一种方案是 items[0] = [3,1] ，items[2] = [2,2] 和 items[3] = [5,3] 。
//子序列的总利润为 3 + 2 + 5 = 10 ，子序列包含 3 种不同类别 [1, 2, 3] 。 
//因此，优雅度为 10 + 3² = 19 ，可以证明 19 是可以获得的最大优雅度。 
//
// 示例 3： 
//
// 
//输入：items = [[1,1],[2,1],[3,1]], k = 3
//输出：7
//解释：
//在这个例子中，我们需要选出长度为 3 的子序列。
//我们需要选中所有项目。
//子序列的总利润为 1 + 2 + 3 = 6，子序列包含 1 种不同类别 [1] 。
//因此，最大优雅度为 6 + 1² = 7 。 
//
// 
//
// 提示： 
//
// 
// 1 <= items.length == n <= 10⁵ 
// items[i].length == 2 
// items[i][0] == profiti 
// items[i][1] == categoryi 
// 1 <= profiti <= 10⁹ 
// 1 <= categoryi <= n 
// 1 <= k <= n 
// 
//
// Related Topics 贪心 数组 哈希表 排序 堆（优先队列） 👍 16 👎 0


package cn.db117.leetcode.solution28;

import java.util.*;

/**
 * 2813.子序列最大优雅度.maximum-elegance-of-a-k-length-subsequence
 *
 * @author db117
 * @since 2023-08-11 10:59:20
 **/

public class Solution_2813 {
    public static void main(String[] args) {
        Solution solution = new Solution_2813().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long findMaximumElegance(int[][] items, int k) {
            int n = items.length;
            long ans = 0;
            Map<Integer, Integer> type = new HashMap<>();

            // 按照利润排序
            Arrays.sort(items, (o1, o2) -> Integer.compare(o2[0], o1[0]));

            long curSum = 0;
            int curLen = 0;
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));// 出现相同类型的最小值
            for (int[] item : items) {
                if (curLen < k) {
                    curSum += item[0];
                    type.put(item[1], type.getOrDefault(item[1], 0) + 1);
                    if (type.get(item[1]) > 1) {
                        pq.offer(item);
                    }
                    curLen++;
                }
                if (curLen == k) {
                    ans = Math.max(ans, curSum + (long) type.size() * type.size());
                }
                // 去掉最小的
                if (curLen == k && !pq.isEmpty()) {
                    int[] min = pq.poll();
                    curSum -= min[0];
                    type.put(min[1], type.get(min[1]) - 1);
                    curLen--;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}