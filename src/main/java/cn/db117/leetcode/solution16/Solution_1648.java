//你有一些球的库存 inventory ，里面包含着不同颜色的球。一个顾客想要 任意颜色 总数为 orders 的球。
//
// 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的 同色球 的数目。比方说还剩下 6 个黄球，那么顾客买第一个黄球的时候该黄球的价值为 6 。
//这笔交易以后，只剩下 5 个黄球了，所以下一个黄球的价值为 5 （也就是球的价值随着顾客购买同色球是递减的） 
//
// 给你整数数组 inventory ，其中 inventory[i] 表示第 i 种颜色球一开始的数目。同时给你整数 orders ，表示顾客总共想买的球数
//目。你可以按照 任意顺序 卖球。 
//
// 请你返回卖了 orders 个球以后 最大 总价值之和。由于答案可能会很大，请你返回答案对 109 + 7 取余数 的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：inventory = [2,5], orders = 4
//输出：14
//解释：卖 1 个第一种颜色的球（价值为 2 )，卖 3 个第二种颜色的球（价值为 5 + 4 + 3）。
//最大总和为 2 + 5 + 4 + 3 = 14 。
// 
//
// 示例 2： 
//
// 
//输入：inventory = [3,5], orders = 6
//输出：19
//解释：卖 2 个第一种颜色的球（价值为 3 + 2），卖 4 个第二种颜色的球（价值为 5 + 4 + 3 + 2）。
//最大总和为 3 + 2 + 5 + 4 + 3 + 2 = 19 。
// 
//
// 示例 3： 
//
// 
//输入：inventory = [2,8,4,10,6], orders = 20
//输出：110
// 
//
// 示例 4： 
//
// 
//输入：inventory = [1000000000], orders = 1000000000
//输出：21
//解释：卖 1000000000 次第一种颜色的球，总价值为 500000000500000000 。 500000000500000000 对 109 + 
//7 取余为 21 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= inventory.length <= 105 
// 1 <= inventory[i] <= 109 
// 1 <= orders <= min(sum(inventory[i]), 109) 
// 
// Related Topics 贪心 数组 数学 二分查找 排序 堆（优先队列） 
// 👍 35 👎 0


package cn.db117.leetcode.solution16;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1648.销售价值减少的颜色球.sell-diminishing-valued-colored-balls
 *
 * @author db117
 * @since 2021-07-22 10:31:01
 **/

public class Solution_1648 {
    public static void main(String[] args) {
        Solution solution = new Solution_1648().new Solution();

        System.out.println(solution.maxProfit(new int[]{2, 5}, 4));
        System.out.println(solution.maxProfit(new int[]{3, 5}, 6));
        System.out.println(solution.maxProfit(new int[]{2, 8, 4, 10, 6}, 20));
        System.out.println(solution.maxProfit(new int[]{1000000000}, 1000000000));
        System.out.println(solution.maxProfit(new int[]{497978859, 167261111, 483575207, 591815159}, 836556809));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProfit(int[] inventory, int orders) {
            // 二分
            int left = 0, right = 0;
            for (int i : inventory) {
                right = Math.max(right, i);
            }

            while (left < right) {
                int mid = left + (right - left + 1) / 2;

                if (check(inventory, mid, orders)) {
                    // 可以继续尝试增加
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }

            long ans = 0;
            int down = right + 1;
            // 所有大于 down 的数字都会加入
            for (int i : inventory) {
                if (i <= down) {
                    continue;
                }

                orders -= i - down;
                ans += sum(i, down + 1);

                ans %= 1_000_000_007;
            }

            // 还有一下 等于 down 的
            ans += (long) down * orders;

            return (int) (ans % 1_000_000_007);
        }

        // 数组中大于 min 的数量是否大于等于 orders
        public boolean check(int[] arr, int mid, int orders) {
            for (int i : arr) {
                if (i <= mid) {
                    continue;
                }
                orders -= i - mid;
                if (orders <= 0) {
                    return true;
                }
            }
            return false;
        }

        // 从 min 累加到 max
        private long sum(long max, long min) {
            long count = max - min + 1;
            long ans = (min + max) * (count / 2);

            if ((count & 1) == 1) {
                ans += (min + max) / 2;
            }
            return ans;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

    // 超时
    class Solution1 {
        public int maxProfit(int[] inventory, int orders) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : inventory) {
                queue.offer(i);
            }

            long ans = 0;
            while (orders > 0) {
                Integer one = queue.poll();
                if (queue.isEmpty() || queue.peek() + orders <= one) {
                    // 就剩一个数字了，直接算
                    // 或者不需要用到下一个数字
                    int two = one - orders + 1;
                    ans += sum(one, two);
                    ans %= 1_000_000_007;
                    break;
                }


                int two = queue.peek();

                ans += sum(one, two);
                ans %= 1_000_000_007;
                // 减去用掉的数字
                orders -= one - two + 1;

                // 把剩下的球放入队列中
                queue.offer(two - 1);
            }

            return (int) ans;
        }

        // 从 two 累加到 one
        private long sum(long one, long two) {
            long count = one - two + 1;
            long ans = (two + one) * (count / 2);

            if ((count & 1) == 1) {
                ans += (two + one) / 2;
            }
            return ans;
        }
    }


}