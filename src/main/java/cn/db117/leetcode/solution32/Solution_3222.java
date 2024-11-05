

//给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。 
//
// Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名
//玩家无法执行此操作，那么这名玩家 输掉 游戏。 
//
// 两名玩家都采取 最优 策略，请你返回游戏的赢家。 
//
// 
//
// 示例 1： 
//
// 
// 输入：x = 2, y = 7 
// 
//
// 输出："Alice" 
//
// 解释： 
//
// 游戏一次操作后结束： 
//
// 
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// 
//
// 示例 2： 
//
// 
// 输入：x = 4, y = 11 
// 
//
// 输出："Bob" 
//
// 解释： 
//
// 游戏 2 次操作后结束： 
//
// 
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x, y <= 100 
// 
//
// Related Topics 数学 博弈 模拟 👍 11 👎 0


package cn.db117.leetcode.solution32;

/**
 * 3222.求出硬币游戏的赢家.find-the-winning-player-in-coin-game
 *
 * @author db117
 * @since 2024-11-05 10:10:03
 **/

public class Solution_3222 {
    public static void main(String[] args) {
        Solution solution = new Solution_3222().new Solution();
        // 2
        //			7
        System.out.println(solution.losingPlayer(2, 7));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static String alice = "Alice";
        static String bob = "Bob";

        public String losingPlayer(int x, int y) {
            // 模拟
            boolean isAlice = false;
            while (x >= 1 && y >= 4) {
                x--;
                y -= 4;
                isAlice = !isAlice;
            }
            return isAlice ? alice : bob;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}