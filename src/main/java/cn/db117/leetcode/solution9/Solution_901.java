

//编写一个 StockSpanner 类，它收集某些股票的每日报价，并返回该股票当日价格的跨度。 
//
// 今天股票价格的跨度被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。 
//
// 例如，如果未来7天股票的价格是 [100, 80, 60, 70, 60, 75, 85]，那么股票跨度将是 [1, 1, 1, 2, 1, 4, 6]。
// 
//
// 
//
// 示例： 
//
// 输入：["StockSpanner","next","next","next","next","next","next","next"], [[],[10
//0],[80],[60],[70],[60],[75],[85]]
//输出：[null,1,1,1,2,1,4,6]
//解释：
//首先，初始化 S = StockSpanner()，然后：
//S.next(100) 被调用并返回 1，
//S.next(80) 被调用并返回 1，
//S.next(60) 被调用并返回 1，
//S.next(70) 被调用并返回 2，
//S.next(60) 被调用并返回 1，
//S.next(75) 被调用并返回 4，
//S.next(85) 被调用并返回 6。
//
//注意 (例如) S.next(75) 返回 4，因为截至今天的最后 4 个价格
//(包括今天的价格 75) 小于或等于今天的价格。
// 
//
// 
//
// 提示： 
//
// 
// 调用 StockSpanner.next(int price) 时，将有 1 <= price <= 10^5。 
// 每个测试用例最多可以调用 10000 次 StockSpanner.next。 
// 在所有测试用例中，最多调用 150000 次 StockSpanner.next。 
// 此问题的总时间限制减少了 50%。 
// 
//
// Related Topics 栈 设计 数据流 单调栈 👍 252 👎 0


package cn.db117.leetcode.solution9;

import cn.db117.leetcode.util.Pair;

import java.util.Stack;

/**
 * 901.股票价格跨度.online-stock-span
 *
 * @author db117
 * @since 2022-10-21 15:17:05
 **/

public class Solution_901 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class StockSpanner {
        // 单调栈 递减
        Stack<Pair<Integer, Integer>> stack = new Stack<>();
        int cur = 0;

        public StockSpanner() {
        }

        public int next(int price) {
            cur++;
            while (!stack.isEmpty() && stack.peek().getKey() <= price) {
                stack.pop();
            }
            int ans;
            if (stack.isEmpty()) {
                ans = cur;
            } else {
                ans = cur - stack.peek().getValue();
            }

            stack.push(new Pair<>(price, cur));

            return ans;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
//leetcode submit region end(Prohibit modification and deletion)

}