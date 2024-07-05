

//给定三个整数数组 a，b 和 c，返回组内元素按位 XOR 有 偶数 个 设置位 的三元组 (a[i], b[j], c[k]) 的数量。 
//
// 
//
// 示例 1: 
//
// 
// 输入：a = [1], b = [2], c = [3] 
// 
//
// 输出：1 
//
// 解释： 
//
// 只有一个三元组 (a[0], b[0], c[0]) 并且它们的 XOR 为：1 XOR 2 XOR 3 = 002。 
//
// 示例 2: 
//
// 
// 输入：a = [1,1], b = [2,3], c = [1,5] 
// 
//
// 输出：4 
//
// 解释： 
//
// 考虑以下 4 个三元组： 
//
// 
// (a[0], b[1], c[0]): 1 XOR 3 XOR 1 = 0112 
// (a[1], b[1], c[0]): 1 XOR 3 XOR 1 = 0112 
// (a[0], b[0], c[1]): 1 XOR 2 XOR 5 = 1102 
// (a[1], b[0], c[1]): 1 XOR 2 XOR 5 = 1102 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length, c.length <= 100 
// 0 <= a[i], b[i], c[i] <= 100 
// 
//
// Related Topics 位运算 数组 👍 1 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3199.用偶数异或设置位计数三元组 I.count-triplets-with-even-xor-set-bits-i
 *
 * @author db117
 * @since 2024-07-05 17:50:54
 **/

public class Solution_3199 {
    public static void main(String[] args) {
        Solution solution = new Solution_3199().new Solution();
        // [1]
        //			[2]
        //			[3]
//        System.out.println(solution.tripletCount(new int[]{1}, new int[]{2}, new int[]{3}));
        // [1,1]
        //			[2,3]
        //			[1,5]
        System.out.println(solution.tripletCount(new int[]{1, 1}, new int[]{2, 3}, new int[]{1, 5}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int tripletCount(int[] a, int[] b, int[] c) {
            int n = a.length;
            int ans = 0;
            for (int value : a) {
                for (int j = 0; j < n; j++)
                    for (int k = 0; k < n; k++) {
                        int num = value ^ b[j] ^ c[k];
                        if ((Integer.bitCount(num)) % 2 == 0) {
                            ans++;
                        }
                    }
            }

            return ans;

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}