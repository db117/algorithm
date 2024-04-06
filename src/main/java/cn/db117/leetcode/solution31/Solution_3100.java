

//给你两个整数 numBottles 和 numExchange 。 
//
// numBottles 代表你最初拥有的满水瓶数量。在一次操作中，你可以执行以下操作之一： 
//
// 
// 喝掉任意数量的满水瓶，使它们变成空水瓶。 
// 用 numExchange 个空水瓶交换一个满水瓶。然后，将 numExchange 的值增加 1 。 
// 
//
// 注意，你不能使用相同的 numExchange 值交换多批空水瓶。例如，如果 numBottles == 3 并且 numExchange == 1 ，则
//不能用 3 个空水瓶交换成 3 个满水瓶。 
//
// 返回你 最多 可以喝到多少瓶水。 
//
// 
//
// 示例 1： 
// 
// 
//输入：numBottles = 13, numExchange = 6
//输出：15
//解释：上表显示了满水瓶的数量、空水瓶的数量、numExchange 的值，以及累计喝掉的水瓶数量。
// 
//
// 示例 2： 
// 
// 
//输入：numBottles = 10, numExchange = 3
//输出：13
//解释：上表显示了满水瓶的数量、空水瓶的数量、numExchange 的值，以及累计喝掉的水瓶数量。 
//
// 
//
// 提示： 
//
// 
// 1 <= numBottles <= 100 
// 1 <= numExchange <= 100 
// 
//
// Related Topics 数学 模拟 👍 2 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3100.换水问题 II.water-bottles-ii
 *
 * @author db117
 * @since 2024-04-06 19:38:39
 **/

public class Solution_3100 {
    public static void main(String[] args) {
        Solution solution = new Solution_3100().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int ans = 0;
            int empty = 0;
            while (numBottles > 0) {
                // 喝掉的
                ans += numBottles;
                // 剩下的
                empty += numBottles;
                numBottles = 0;

                while (empty >= numExchange) {
                    // 空瓶换酒
                    empty -= numExchange;
                    numBottles++;
                    numExchange++;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}