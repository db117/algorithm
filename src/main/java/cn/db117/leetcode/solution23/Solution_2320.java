

//一条街道上共有 n * 2 个 地块 ，街道的两侧各有 n 个地块。每一边的地块都按从 1 到 n 编号。每个地块上都可以放置一所房子。 
//
// 现要求街道同一侧不能存在两所房子相邻的情况，请你计算并返回放置房屋的方式数目。由于答案可能很大，需要对 10⁹ + 7 取余后再返回。 
//
// 注意，如果一所房子放置在这条街某一侧上的第 i 个地块，不影响在另一侧的第 i 个地块放置房子。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：4
//解释：
//可能的放置方式：
//1. 所有地块都不放置房子。
//2. 一所房子放在街道的某一侧。
//3. 一所房子放在街道的另一侧。
//4. 放置两所房子，街道两侧各放置一所。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：9
//解释：如上图所示，共有 9 种可能的放置方式。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁴ 
// 
// Related Topics 动态规划 👍 14 👎 0


package cn.db117.leetcode.solution23;

/**
 * 2320.统计放置房子的方式数.count-number-of-ways-to-place-houses
 *
 * @author db117
 * @since 2022-06-28 14:16:07
 **/

public class Solution_2320 {
    public static void main(String[] args) {
        Solution solution = new Solution_2320().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = 1000000007;

        public int countHousePlacements(int n) {
            long ans;
            long zero = 1;
            long one = 1;
            for (int i = 2; i <= n; i++) {
                // 在没增加一位的情况下 只有前面的最后一位为 0 是可以增加 1
                long tmp = zero;
                zero += one;
                zero %= mod;
                one = tmp;
                one %= mod;
            }
            ans = zero + one;
            ans %= mod;
            return (int) ((ans * ans) % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}