

//Related Topics 贪心 数组 前缀和 👍 3 👎 0


package cn.db117.leetcode.solution22;

/**
 * 2214.Minimum Health to Beat Game.minimum-health-to-beat-game
 *
 * @author db117
 * @since 2022-12-20 10:33:31
 **/

public class Solution_2214 {
    public static void main(String[] args) {
        Solution solution = new Solution_2214().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long minimumHealth(int[] damage, int armor) {
            // 全部加起来 - 小于等于铠甲的最大值
            long ans = 1;
            int max = 0;
            for (int n : damage) {
                ans += n;
                max = Math.max(max, n);
            }

            return ans - Math.min(max, armor);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}