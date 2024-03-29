

//下标从 0 开始、长度为 n 的数组 derived 是由同样长度为 n 的原始 二进制数组 original 通过计算相邻值的 按位异或（⊕）派生而来。 
//
//
// 特别地，对于范围 [0, n - 1] 内的每个下标 i ： 
//
// 
// 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0] 
// 否则 derived[i] = original[i] ⊕ original[i + 1] 
// 
//
// 给你一个数组 derived ，请判断是否存在一个能够派生得到 derived 的 有效原始二进制数组 original 。 
//
// 如果存在满足要求的原始二进制数组，返回 true ；否则，返回 false 。 
//
// 
// 二进制数组是仅由 0 和 1 组成的数组。 
// 
//
// 
//
// 示例 1： 
//
// 输入：derived = [1,1,0]
//输出：true
//解释：能够派生得到 [1,1,0] 的有效原始二进制数组是 [0,1,0] ：
//derived[0] = original[0] ⊕ original[1] = 0 ⊕ 1 = 1 
//derived[1] = original[1] ⊕ original[2] = 1 ⊕ 0 = 1
//derived[2] = original[2] ⊕ original[0] = 0 ⊕ 0 = 0
// 
//
// 示例 2： 
//
// 输入：derived = [1,1]
//输出：true
//解释：能够派生得到 [1,1] 的有效原始二进制数组是 [0,1] ：
//derived[0] = original[0] ⊕ original[1] = 1
//derived[1] = original[1] ⊕ original[0] = 1
// 
//
// 示例 3： 
//
// 输入：derived = [1,0]
//输出：false
//解释：不存在能够派生得到 [1,0] 的有效原始二进制数组。
// 
//
// 
//
// 提示： 
//
// 
// n == derived.length 
// 1 <= n <= 10⁵ 
// derived 中的值不是 0 就是 1 。 
// 
//
// Related Topics 位运算 数组 👍 7 👎 0


package cn.db117.leetcode.solution26;

/**
 * 2683.相邻值的按位异或.neighboring-bitwise-xor
 *
 * @author db117
 * @since 2023-05-22 10:41:20
 **/

public class Solution_2683 {
    public static void main(String[] args) {
        Solution solution = new Solution_2683().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 如果 i = n - 1 ，那么 derived[i] = original[i] ⊕ original[0]
        //否则 derived[i] = original[i] ⊕ original[i + 1]
        // o[0]=d[n-1]^o[n-1]
        // o[i]=o[i-1]^d[i-1]
        public boolean doesValidArrayExist(int[] derived) {
            int n = derived.length;
            int[] original = new int[n];
            // 1
            original[n - 1] = 1;
            original[0] = original[n - 1] ^ derived[n - 1];
            for (int i = 1; i < n - 1; i++) {
                original[i] = original[i - 1] ^ derived[i];
            }
            if (check(derived, original)) {
                return true;
            }

            // 0
            original[n - 1] = 0;
            original[0] = original[n - 1] ^ derived[n - 1];
            for (int i = 1; i < n - 1; i++) {
                original[i] = original[i - 1] ^ derived[i - 1];
            }
            return check(derived, original);
        }

        private boolean check(int[] derived, int[] original) {
            int n = derived.length;
            if (derived[n - 1] != (original[n - 1] ^ original[0])) {
                return false;
            }
            for (int i = 0; i < n - 1; i++) {
                if (derived[i] != (original[i] ^ original[i + 1])) {
                    return false;
                }
            }

            return true;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}