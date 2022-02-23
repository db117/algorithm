

//给你一个四位 正 整数 num 。请你使用 num 中的 数位 ，将 num 拆成两个新的整数 new1 和 new2 。new1 和 new2 中可以有 
//前导 0 ，且 num 中 所有 数位都必须使用。 
//
// 
// 比方说，给你 num = 2932 ，你拥有的数位包括：两个 2 ，一个 9 和一个 3 。一些可能的 [new1, new2] 数对为 [22, 93]
//，[23, 92]，[223, 9] 和 [2, 329] 。 
// 
//
// 请你返回可以得到的 new1 和 new2 的 最小 和。 
//
// 
//
// 示例 1： 
//
// 输入：num = 2932
//输出：52
//解释：可行的 [new1, new2] 数对为 [29, 23] ，[223, 9] 等等。
//最小和为数对 [29, 23] 的和：29 + 23 = 52 。
// 
//
// 示例 2： 
//
// 输入：num = 4009
//输出：13
//解释：可行的 [new1, new2] 数对为 [0, 49] ，[490, 0] 等等。
//最小和为数对 [4, 9] 的和：4 + 9 = 13 。
// 
//
// 
//
// 提示： 
//
// 
// 1000 <= num <= 9999 
// 
// Related Topics 贪心 数学 排序 👍 8 👎 0


package cn.db117.leetcode.solution21;

import java.util.Arrays;

/**
 * 2160.拆分数位后四位数字的最小和.minimum-sum-of-four-digit-number-after-splitting-digits
 *
 * @author db117
 * @since 2022-02-23 15:20:26
 **/

public class Solution_2160 {
    public static void main(String[] args) {
        Solution solution = new Solution_2160().new Solution();
        System.out.println(solution.minimumSum(1000));
        System.out.println(solution.minimumSum(2932));
        System.out.println(solution.minimumSum(4009));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumSum(int num) {
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) {
                arr[i] = num % 10;
                num /= 10;
            }

            // 排序
            Arrays.sort(arr);
            // 1 3 位组合
            return arr[0] * 10 + arr[2] +
                    arr[1] * 10 + arr[3];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}