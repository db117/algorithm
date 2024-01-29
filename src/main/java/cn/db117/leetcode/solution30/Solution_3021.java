

//Alice 和 Bob 在一个长满鲜花的环形草地玩一个回合制游戏。环形的草地上有一些鲜花，Alice 到 Bob 之间顺时针有 x 朵鲜花，逆时针有 y 朵
//鲜花。 
//
// 游戏过程如下： 
//
// 
// Alice 先行动。 
// 每一次行动中，当前玩家必须选择顺时针或者逆时针，然后在这个方向上摘一朵鲜花。 
// 一次行动结束后，如果所有鲜花都被摘完了，那么 当前 玩家抓住对手并赢得游戏的胜利。 
// 
//
// 给你两个整数 n 和 m ，你的任务是求出满足以下条件的所有 (x, y) 对： 
//
// 
// 按照上述规则，Alice 必须赢得游戏。 
// Alice 顺时针方向上的鲜花数目 x 必须在区间 [1,n] 之间。 
// Alice 逆时针方向上的鲜花数目 y 必须在区间 [1,m] 之间。 
// 
//
// 请你返回满足题目描述的数对 (x, y) 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, m = 2
//输出：3
//解释：以下数对满足题目要求：(1,2) ，(3,2) ，(2,1) 。
// 
//
// 示例 2： 
//
// 
//输入：n = 1, m = 1
//输出：0
//解释：没有数对满足题目要求。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, m <= 10⁵ 
// 
//
// 👍 2 👎 0


package cn.db117.leetcode.solution30;

/**
 * 3021.Alice 和 Bob 玩鲜花游戏.alice-and-bob-playing-flower-game
 *
 * @author db117
 * @since 2024-01-29 14:48:40
 **/

public class Solution_3021 {
    public static void main(String[] args) {
        Solution solution = new Solution_3021().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long flowerGame(int n, int m) {
            // 总数是奇数就可以了
            // 想象成棋盘,符合条件的刚好是一半
            return (long) n * m / 2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}