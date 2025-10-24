

//如果整数 x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。 
//
// 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 1
//输出：22
//解释：
//22 是一个数值平衡数，因为：
//- 数字 2 出现 2 次 
//这也是严格大于 1 的最小数值平衡数。
// 
//
// 示例 2： 
//
// 
//输入：n = 1000
//输出：1333
//解释：
//1333 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 1000 的最小数值平衡数。
//注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。 
//
// 示例 3： 
//
// 
//输入：n = 3000
//输出：3133
//解释：
//3133 是一个数值平衡数，因为：
//- 数字 1 出现 1 次。
//- 数字 3 出现 3 次。 
//这也是严格大于 3000 的最小数值平衡数。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁶ 
// 
//
// Related Topics 哈希表 数学 回溯 计数 枚举 👍 90 👎 0


package cn.db117.leetcode.solution20;

import java.util.TreeSet;

/**
 * 2048.下一个更大的数值平衡数.next-greater-numerically-balanced-number
 *
 * @author db117
 * @since 2025-10-24 17:59:28
 **/

public class Solution_2048_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_2048_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static TreeSet<Integer> set = new TreeSet<>();

        static {
            // 1224444
            set.add(1224444); // 最大为 1000000 ，下一个数字为 1224444
            for (int i = 0; i <= 999999; i++) {
                if (helper(i)) {
                    set.add(i);
                }
            }
        }

        public int nextBeautifulNumber(int n) {
            return set.higher(n);
        }


        public static boolean helper(int n) {
            int[] tmp = new int[7];
            while (n > 0) {
                int cur = n % 10;
                if (cur == 0 || cur > 6) {
                    // 不会出现 0 7 8 9
                    return false;
                }
                tmp[cur]++;
                if (tmp[cur] > cur) {
                    return false;
                }
                n /= 10;
            }
            for (int i = 1; i < tmp.length; i++) {
                if (tmp[i] != 0 && tmp[i] != i) {
                    return false;
                }
            }

            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}