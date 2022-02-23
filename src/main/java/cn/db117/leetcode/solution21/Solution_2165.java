

//给你一个整数 num 。重排 num 中的各位数字，使其值 最小化 且不含 任何 前导零。 
//
// 返回不含前导零且值最小的重排数字。 
//
// 注意，重排各位数字后，num 的符号不会改变。 
//
// 
//
// 示例 1： 
//
// 输入：num = 310
//输出：103
//解释：310 中各位数字的可行排列有：013、031、103、130、301、310 。
//不含任何前导零且值最小的重排数字是 103 。
// 
//
// 示例 2： 
//
// 输入：num = -7605
//输出：-7650
//解释：-7605 中各位数字的部分可行排列为：-7650、-6705、-5076、-0567。
//不含任何前导零且值最小的重排数字是 -7650 。 
//
// 
//
// 提示： 
//
// 
// -10¹⁵ <= num <= 10¹⁵ 
// 
// Related Topics 数学 排序 👍 5 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2165.重排数字的最小值.smallest-value-of-the-rearranged-number
 *
 * @author db117
 * @since 2022-02-23 16:36:52
 **/

public class Solution_2165 {
    public static void main(String[] args) {
        Solution solution = new Solution_2165().new Solution();
        System.out.println(solution.smallestNumber(310));
        System.out.println(solution.smallestNumber(-7605));
        System.out.println(solution.smallestNumber(-3000006657L));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long smallestNumber(long num) {
            if (num > -10 && num <= 10) {
                return num;
            }
            // 统计数字数量
            int[] arr = new int[10];
            long n = Math.abs(num);
            while (n != 0) {
                arr[(int) (n % 10)]++;
                n /= 10;
            }

            long ans = 0;
            if (num > 0) {
                // 到第一位
                for (int i = 1; i < 10; i++) {
                    if (arr[i] != 0) {
                        ans = i;
                        arr[i]--;
                        break;
                    }
                }
                // 补齐
                for (int i = 0; i < 10; i++) {
                    if (arr[i] == 0) {
                        continue;
                    }
                    for (int j = 0; j < arr[i]; j++) {
                        ans *= 10;
                        ans += i;
                    }
                }
            } else {
                // 负数就简单粗暴,从大到小
                for (int i = 9; i >= 0; i--) {
                    if (arr[i] == 0) {
                        continue;
                    }
                    for (int j = 0; j < arr[i]; j++) {
                        ans *= 10;
                        ans += i;
                    }
                }

                ans *= -1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}