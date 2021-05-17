//小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。 
//
// 如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。 
//
// 请你计算 最多 能喝到多少瓶酒。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：numBottles = 9, numExchange = 3
//输出：13
//解释：你可以用 3 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 9 + 3 + 1 = 13 瓶酒。
// 
//
// 示例 2： 
//
// 
//
// 输入：numBottles = 15, numExchange = 4
//输出：19
//解释：你可以用 4 个空酒瓶兑换 1 瓶酒。
//所以最多能喝到 15 + 3 + 1 = 19 瓶酒。
//
//
// 示例 3： 
//
// 输入：numBottles = 5, numExchange = 5
//输出：6
// 
//
// 示例 4： 
//
// 输入：numBottles = 2, numExchange = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= numBottles <= 100 
// 2 <= numExchange <= 100 
// 
// Related Topics 贪心算法 
// 👍 37 👎 0


package cn.db117.leetcode.solution15;

/**
 * 1518.换酒问题.water-bottles
 *
 * @author db117
 * @since 2020-12-23 16:34:54
 **/

public class Solution1518 {
    public static void main(String[] args) {
        Solution solution = new Solution1518().new Solution();
        System.out.println(solution.numWaterBottles(9, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int nullBot = numBottles;
            while (true) {
                // 空酒瓶换的酒
                int num = nullBot / numExchange;
                if (num == 0) {
                    // 换不了酒
                    break;
                }

                numBottles += num;


                nullBot = num + (nullBot % numExchange);
            }
            return numBottles;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}