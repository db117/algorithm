

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 431 👎 0


package cn.db117.leetcode.solution6;

/**
 * 670.最大交换.maximum-swap
 *
 * @author db117
 * @since 2024-01-22 10:25:15
 **/

public class Solution_670 {
    public static void main(String[] args) {
        Solution solution = new Solution_670().new Solution();
        //  99901
        System.out.println(solution.maximumSwap(99901));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumSwap(int num) {
            char[] chars = Integer.toString(num).toCharArray();
            for (char c = '9'; c >= '1'; c--) {
                // 从 9 开始慢慢找
                // 从后面找到 9 ,从前面替换掉
                int last = -1;
                for (int j = chars.length - 1; j >= 0; j--) {
                    if (chars[j] == c) {
                        last = j;
                        break;
                    }
                }
                if (last == -1) {
                    continue;
                }

                for (int j = 0; j < last; j++) {
                    if (chars[j] < c) {
                        // 交换
                        chars[last] = chars[j];
                        chars[j] = c;
                        return Integer.parseInt(new String(chars));
                    }
                }
            }
            return num;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}