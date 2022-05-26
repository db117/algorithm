

//你有一些苹果和一个可以承载 5000 单位重量的篮子。 
//
// 给定一个整数数组 weight ，其中 weight[i] 是第 i 个苹果的重量，返回 你可以放入篮子的最大苹果数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：weight = [100,200,150,1000]
//输出：4
//解释：所有 4 个苹果都可以装进去，因为它们的重量之和为 1450。
// 
//
// 示例 2： 
//
// 
//输入：weight = [900,950,800,1000,700,800]
//输出：5
//解释：6 个苹果的总重量超过了 5000，所以我们只能从中任选 5 个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= weight.length <= 10³ 
// 1 <= weight[i] <= 10³ 
// 
// Related Topics 贪心 数组 排序 👍 11 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;

/**
 * 1196.最多可以买到的苹果数量.how-many-apples-can-you-put-into-the-basket
 *
 * @author db117
 * @since 2022-05-26 16:44:30
 **/

public class Solution_1196 {
    public static void main(String[] args) {
        Solution solution = new Solution_1196().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxNumberOfApples(int[] weight) {
            int ans = 0;
            Arrays.sort(weight);
            int max = 5000;
            for (int num : weight) {
                if (num <= max) {
                    ans++;
                    max -= num;
                } else {
                    break;
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}