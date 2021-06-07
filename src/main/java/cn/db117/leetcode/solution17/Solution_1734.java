//给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。 
//
// 它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说
//，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。 
//
// 给你 encoded 数组，请你返回原始数组 perm 。题目保证答案存在且唯一。 
//
// 
//
// 示例 1： 
//
// 输入：encoded = [3,1]
//输出：[1,2,3]
//解释：如果 perm = [1,2,3] ，那么 encoded = [1 XOR 2,2 XOR 3] = [3,1]
// 
//
// 示例 2： 
//
// 输入：encoded = [6,5,4,6]
//输出：[2,4,1,5,3]
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n < 105 
// n 是奇数。 
// encoded.length == n - 1 
// 
// Related Topics 位运算 
// 👍 131 👎 0


package cn.db117.leetcode.solution17;

import java.util.Arrays;

/**
 * 1734.解码异或后的排列.decode-xored-permutation
 *
 * @author db117
 * @since 2021-06-04 16:35:26
 **/

public class Solution_1734 {
    public static void main(String[] args) {
        Solution solution = new Solution_1734().new Solution();
        System.out.println(Arrays.toString(solution.decode(new int[]{
                6, 5, 4, 6
        })));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] decode(int[] encoded) {
            int n = encoded.length + 1;
            // 1^2^...^n-1
            int full = 0;
            for (int i = 1; i <= n; i++) {
                full ^= i;
            }

            // 奇数位^
            // 所有奇数位异或,则相当于原数组除第一个数字外全部异或
            int odd = 0;
            for (int i = 1; i < encoded.length; i += 2) {
                odd ^= encoded[i];
            }

            // 原数组第一个数字
            int[] perm = new int[n];
            perm[0] = odd ^ full;

            // encoded[i] = perm[i] XOR perm[i + 1] -->  perm[i + 1] = encoded[i] XOR perm[i]
            for (int i = 1; i < n; i++) {
                perm[i] = perm[i - 1] ^ encoded[i - 1];
            }

            return perm;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}