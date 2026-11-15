

//给你一个整数数组 arr 。请你返回和为 奇数 的子数组数目。 
//
// 由于答案可能会很大，请你将结果对 10^9 + 7 取余后返回。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [1,3,5]
//输出：4
//解释：所有的子数组为 [[1],[1,3],[1,3,5],[3],[3,5],[5]] 。
//所有子数组的和为 [1,4,9,3,8,5].
//奇数和包括 [1,9,3,5] ，所以答案为 4 。
// 
//
// 示例 2 ： 
//
// 输入：arr = [2,4,6]
//输出：0
//解释：所有子数组为 [[2],[2,4],[2,4,6],[4],[4,6],[6]] 。
//所有子数组和为 [2,6,12,4,10,6] 。
//所有子数组和都是偶数，所以答案为 0 。
// 
//
// 示例 3： 
//
// 输入：arr = [1,2,3,4,5,6,7]
//输出：16
// 
//
// 示例 4： 
//
// 输入：arr = [100,100,99,99]
//输出：4
// 
//
// 示例 5： 
//
// 输入：arr = [7]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10^5 
// 1 <= arr[i] <= 100 
// 
//
// Related Topics 数组 数学 动态规划 前缀和 👍 133 👎 0


package cn.db117.leetcode.solution15;

/**
 * 1524.和为奇数的子数组数目.number-of-sub-arrays-with-odd-sum
 *
 * @author db117
 * @since 2026-11-15 15:35:22
 **/

public class Solution_1524 {
    public static void main(String[] args) {
        Solution solution = new Solution_1524().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int mod = (int) 1e9 + 7;

        public int numOfSubarrays(int[] arr) {
            int n = arr.length;
            // 前缀和,记录奇偶性
            int[] ps = new int[n + 1];
            for (int i = 0; i < n; i++) {
                ps[i + 1] = (ps[i] + arr[i]) % 2;
            }

            int odd = 0, even = 0;
            int res = 0;

            for (int p : ps) {
                if (p % 2 == 0) {
                    // 偶数 + 奇数 = 奇数
                    res = (res + odd) % mod;
                    even++;
                } else {
                    // 奇数 + 偶数 = 奇数
                    res = (res + even) % mod;
                    odd++;
                }
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}