


//在一根无限长的数轴上，你站在0的位置。终点在target的位置。 
//
// 每次你可以选择向左或向右移动。第 n 次移动（从 1 开始），可以走 n 步。 
//
// 返回到达终点需要的最小移动次数。 
//
// 示例 1: 
//
// 
//输入: target = 3
//输出: 2
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 3 。
// 
//
// 示例 2: 
//
// 
//输入: target = 2
//输出: 3
//解释:
//第一次移动，从 0 到 1 。
//第二次移动，从 1 到 -1 。
//第三次移动，从 -1 到 2 。
// 
//
// 注意: 
//
// 
// target是在[-10^9, 10^9]范围中的非零整数。 
// 
// Related Topics 数学 二分查找 
// 👍 148 👎 0


package cn.db117.leetcode.solution7;

/**
 * 754.到达终点数字.reach-a-number
 *
 * @author db117
 * @since 2021-07-06 15:16:40
 **/

public class Solution_754 {
    public static void main(String[] args) {
        Solution solution = new Solution_754().new Solution();
        System.out.println(solution.reachNumber(5));//  5
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int reachNumber(int target) {
            // 正负无所谓
            target = target < 0 ? -target : target;

            int step = 1, sum = 0;
            while (sum > -1) {
                sum += step;
                // 当 sum 大于 target 时，如果 sum-target 的值是偶数则前面可以凑出和为 (sum-target)/2 的数字
                // 把这些数字变为负数则可是 sum=target
                // sum-target 肯定小于 step，即前面肯定可以凑出 (sum-target)/2
                if (sum >= target && (sum - target) % 2 == 0) {
                    return step;
                }
                // 当差为奇数时肯定凑不出来，继续走
                step++;
            }
            return step;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}