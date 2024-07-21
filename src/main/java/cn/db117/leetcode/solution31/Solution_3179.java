

//给你两个整数 n 和 k。 
//
// 最初，你有一个长度为 n 的整数数组 a，对所有 0 <= i <= n - 1，都有 a[i] = 1 。每过一秒，你会同时更新每个元素为其前面所有元素
//的和加上该元素本身。例如，一秒后，a[0] 保持不变，a[1] 变为 a[0] + a[1]，a[2] 变为 a[0] + a[1] + a[2]，以此类推。 
//
//
// 返回 k 秒后 a[n - 1] 的值。 
//
// 由于答案可能非常大，返回其对 10⁹ + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入：n = 4, k = 5 
// 
//
// 输出：56 
//
// 解释： 
//
// 
// 
// 
// 时间（秒） 
// 数组状态 
// 
// 
// 0 
// [1,1,1,1] 
// 
// 
// 1 
// [1,2,3,4] 
// 
// 
// 2 
// [1,3,6,10] 
// 
// 
// 3 
// [1,4,10,20] 
// 
// 
// 4 
// [1,5,15,35] 
// 
// 
// 5 
// [1,6,21,56] 
// 
// 
// 
//
// 示例 2： 
//
// 
// 输入：n = 5, k = 3 
// 
//
// 输出：35 
//
// 解释： 
//
// 
// 
// 
// 时间（秒） 
// 数组状态 
// 
// 
// 0 
// [1,1,1,1,1] 
// 
// 
// 1 
// [1,2,3,4,5] 
// 
// 
// 2 
// [1,3,6,10,15] 
// 
// 
// 3 
// [1,4,10,20,35] 
// 
// 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n, k <= 1000 
// 
//
// Related Topics 数组 数学 组合数学 前缀和 模拟 👍 1 👎 0


package cn.db117.leetcode.solution31;

/**
 * 3179.K 秒后第 N 个元素的值.find-the-n-th-value-after-k-seconds
 *
 * @author db117
 * @since 2024-06-11 11:31:04
 **/

public class Solution_3179 {
    public static void main(String[] args) {
        Solution solution = new Solution_3179().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        static int mod = (int) 1e9 + 7;
        static int[][] arr = new int[1002][1002];

        static {
            // 初始化
            for (int i = 0; i < 1002; i++) {
                arr[i][0] = 1;
            }
            for (int i = 1; i < 1002; i++) {
                for (int j = 1; j < 1002; j++) {
                    // 等于上面的加上左边的
                    arr[i][j] = (arr[i - 1][j] + arr[i][j - 1]) % mod;
                }
            }
        }

        public int valueAfterKSeconds(int n, int k) {
            // 直接取预处理的结果
            return arr[k + 1][n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}