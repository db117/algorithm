// 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
//
// 在开始时，我们同时把一些多米诺骨牌向左或向右推。 
//
// 
//
// 每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。 
//
// 同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。 
//
// 如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。 
//
// 就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。 
//
// 给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；如果第 i 张多米诺骨牌被推向右边，则 S[i] = '
//R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。 
//
// 返回表示最终状态的字符串。 
//
// 示例 1： 
//
// 输入：".L.R...LR..L.."
//输出："LL.RR.LLRRLL.." 
//
// 示例 2： 
//
// 输入："RR.L"
//输出："RR.L"
//说明：第一张多米诺骨牌没有给第二张施加额外的力。 
//
// 提示： 
//
// 
// 0 <= N <= 10^5 
// 表示多米诺骨牌状态的字符串只含有 'L'，'R'; 以及 '.'; 
// 
// Related Topics 双指针 动态规划 
// 👍 102 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;

/**
 * 838.推多米诺.push-dominoes
 *
 * @author db117
 * @since 2021-06-09 16:37:31
 **/

public class Solution_838 {
    public static void main(String[] args) {
        Solution solution = new Solution_838().new Solution();
        System.out.println(solution.pushDominoes(".L.R...LR..L..").equals("LL.RR.LLRRLL.."));
        System.out.println(solution.pushDominoes("RR.L").equals("RR.L"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String pushDominoes(String dominoes) {
            char[] chars = dominoes.toCharArray();

            // 左右指针不是 L 就是 R
            // 一段 . 的左右指针
            int left = -1, right = 0;

            while (left <= right && right < chars.length) {
                if (chars[right] == '.') {
                    while (right < chars.length && chars[right] == '.') {
                        // 找到下一个非 .
                        right++;
                    }

                    // 中间全是 .
                    helper(chars, left, right);
                    // 开始下一段
                    left = right;
                    right++;
                } else {
                    // 往后面找到第一个非 .
                    while (right < chars.length && chars[right] != '.') {
                        left = right;
                        right++;
                    }
                }
            }
            return new String(chars);
        }


        private void helper(char[] chars, int left, int right) {
            if (right == chars.length) {
                // 走完了
                if (left != -1 && chars[left] == 'R') {
                    // R 后面全是 .
                    Arrays.fill(chars, left + 1, chars.length, 'R');
                    while (left < chars.length) {
                        chars[left] = 'R';
                        left++;
                    }
                }
                return;
            }
            if (left == -1) {
                // 以 ... 开始
                if (chars[right] == 'L') {
                    Arrays.fill(chars, 0, right, 'L');
                }
                return;
            }

            char cL = chars[left];
            char cR = chars[right];
            if (cL == 'L' && cR == 'R') {
                return;
            }

            if (cL == 'R' && cR == 'R') {
                Arrays.fill(chars, left, right, 'R');
                return;
            }
            if (cL == 'L' && cR == 'L') {
                Arrays.fill(chars, left, right, 'L');
                return;
            }

            // 平均分
            while (left < right) {
                chars[left++] = 'R';
                chars[right--] = 'L';
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}