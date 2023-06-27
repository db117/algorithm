

//给你一个整数数组，返回它的某个 非空 子数组（连续元素）在执行一次可选的删除操作后，所能得到的最大元素总和。换句话说，你可以从原数组中选出一个子数组，并可以
//决定要不要从中删除一个元素（只能删一次哦），（删除后）子数组中至少应当有一个元素，然后该子数组（剩下）的元素总和是所有子数组之中最大的。 
//
// 注意，删除一个元素后，子数组 不能为空。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,-2,0,3]
//输出：4
//解释：我们可以选出 [1, -2, 0, 3]，然后删掉 -2，这样得到 [1, 0, 3]，和最大。 
//
// 示例 2： 
//
// 
//输入：arr = [1,-2,-2,3]
//输出：3
//解释：我们直接选出 [3]，这就是最大和。
// 
//
// 示例 3： 
//
// 
//输入：arr = [-1,-1,-1,-1]
//输出：-1
//解释：最后得到的子数组不能为空，所以我们不能选择 [-1] 并从中删去 -1 来得到 0。
//     我们应该直接选择 [-1]，或者选择 [-1, -1] 再从中删去一个 -1。
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i] <= 10⁴ 
// 
//
// Related Topics 数组 动态规划 👍 201 👎 0


package cn.db117.leetcode.solution11;

/**
 * 1186.删除一次得到子数组最大和.maximum-subarray-sum-with-one-deletion
 *
 * @author db117
 * @since 2023-06-27 10:27:31
 **/

public class Solution_1186 {
    public static void main(String[] args) {
        Solution solution = new Solution_1186().new Solution();
        // [1,-2,0,3]
        System.out.println(solution.maximumSum(new int[]{
                1, -2, 0, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] arr;
        int[][] memo;

        public int maximumSum(int[] arr) {
            int n = arr.length;
            this.arr = arr;
            this.memo = new int[n][2];
            for (int i = 0; i < n; i++) {
                memo[i][0] = Integer.MIN_VALUE;
                memo[i][1] = Integer.MIN_VALUE;
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, Math.max(dfs(i, 0), dfs(i, 1)));
            }
            return ans;
        }

        public int dfs(int i, int j) {
            if (i < 0) {
                return Integer.MIN_VALUE / 2; // 除 2 防止负数相加溢出
            }
            if (memo[i][j] != Integer.MIN_VALUE) {
                return memo[i][j];
            }
            if (j == 0) {
                // 当前数字只能被选中
                return memo[i][j] = Math.max(dfs(i - 1, 0), 0) + arr[i];
            }
            // 当前数字可以被删除也可以不被删除
            return memo[i][j] = Math.max(dfs(i - 1, 1) + arr[i], dfs(i - 1, 0));
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}