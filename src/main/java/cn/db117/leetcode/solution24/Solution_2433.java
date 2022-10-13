

//给你一个长度为 n 的 整数 数组 pref 。找出并返回满足下述条件且长度为 n 的数组 arr ： 
//
// 
// pref[i] = arr[0] ^ arr[1] ^ ... ^ arr[i]. 
// 
//
// 注意 ^ 表示 按位异或（bitwise-xor）运算。 
//
// 可以证明答案是 唯一 的。 
//
// 
//
// 示例 1： 
//
// 输入：pref = [5,2,0,3,1]
//输出：[5,7,2,3,2]
//解释：从数组 [5,7,2,3,2] 可以得到如下结果：
//- pref[0] = 5
//- pref[1] = 5 ^ 7 = 2
//- pref[2] = 5 ^ 7 ^ 2 = 0
//- pref[3] = 5 ^ 7 ^ 2 ^ 3 = 3
//- pref[4] = 5 ^ 7 ^ 2 ^ 3 ^ 2 = 1
// 
//
// 示例 2： 
//
// 输入：pref = [13]
//输出：[13]
//解释：pref[0] = arr[0] = 13
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pref.length <= 10⁵ 
// 0 <= pref[i] <= 10⁶ 
// 
//
// Related Topics 位运算 数组 👍 6 👎 0


package cn.db117.leetcode.solution24;

/**
 * 2433.找出前缀异或的原始数组.find-the-original-array-of-prefix-xor
 *
 * @author db117
 * @since 2022-10-13 17:17:24
 **/

public class Solution_2433 {
    public static void main(String[] args) {
        Solution solution = new Solution_2433().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findArray(int[] pref) {
            int[] arr = pref.clone();
            for (int i = 1; i < pref.length; i++) {
                arr[i] ^= pref[i - 1];
            }
            return arr;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}