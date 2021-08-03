//在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。
//
// 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？ 
//
// 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。 
//
// 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳
//赢（假设两位玩家游戏时都表现最佳）？ 
//
// 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。 
//
// 示例： 
//
// 输入：
//maxChoosableInteger = 10
//desiredTotal = 11
//
//输出：
//false
//
//解释：
//无论第一个玩家选择哪个整数，他都会失败。
//第一个玩家可以选择从 1 到 10 的整数。
//如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
//第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
//同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
// 
// Related Topics 位运算 记忆化搜索 数学 动态规划 状态压缩 博弈 
// 👍 239 👎 0


package cn.db117.leetcode.solution4;

import java.util.HashMap;
import java.util.Map;

/**
 * 464.我能赢吗.can-i-win
 *
 * @author db117
 * @since 2021-07-28 11:08:15
 **/

public class Solution_464 {
    public static void main(String[] args) {
        Solution solution = new Solution_464().new Solution();
//        System.out.println(solution.canIWin(20, 145));
        System.out.println(solution.canIWin(7, 16));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            if (maxChoosableInteger >= desiredTotal) {
                // 直接就赢了
                return true;
            }
            if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) {
                // 不可能赢
                return false;
            }

            Map<Integer, Boolean> map = new HashMap<>();
            return helper(map, 0, maxChoosableInteger, desiredTotal);
        }

        private boolean helper(Map<Integer, Boolean> map, int state, int maxChoosableInteger, int desiredTotal) {
            if (map.containsKey(state)) {
                // 记忆化
                return map.get(state);
            }

            for (int i = 1; i <= maxChoosableInteger; i++) {
                int tmp = 1 << (i - 1);
                if ((tmp & state) != 0) {
                    // 当前数字用过了
                    continue;
                }

                if (desiredTotal <= i) {
                    // 直接就赢了
                    map.put(state, true);
                    return true;
                }
                // 当前选完了对手输了
                if (!helper(map, state | tmp, maxChoosableInteger, desiredTotal - i)) {
                    map.put(state, true);
                    return true;
                }

            }

            // 记忆化
            map.put(state, false);
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}