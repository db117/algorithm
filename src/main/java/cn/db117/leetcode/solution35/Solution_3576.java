

//给你一个大小为 n 的整数数组 nums，其中只包含 1 和 -1，以及一个整数 k。 
//
// 你可以最多进行 k 次以下操作： 
//
// 
// 选择一个下标 i（0 <= i < n - 1），然后将 nums[i] 和 nums[i + 1] 同时 乘以 -1。 
// 
//
// 注意：你可以在 不同 的操作中多次选择相同的下标 i。 
//
// 如果在最多 k 次操作后可以使数组的所有元素相等，则返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,-1,1,-1,1], k = 3 
// 
//
// 输出： true 
//
// 解释： 
//
// 我们可以通过以下两次操作使数组的所有元素相等： 
//
// 
// 选择下标 i = 1，将 nums[1] 和 nums[2] 同时乘以 -1。此时 nums = [1,1,-1,-1,1]。 
// 选择下标 i = 2，将 nums[2] 和 nums[3] 同时乘以 -1。此时 nums = [1,1,1,1,1]。 
// 
//
// 示例 2： 
//
// 
// 输入： nums = [-1,-1,-1,1,1,1], k = 5 
// 
//
// 输出： false 
//
// 解释： 
//
// 在最多 5 次操作内，无法使数组的所有元素相等。 
//
// 
//
// 提示： 
//
// 
// 1 <= n == nums.length <= 10⁵ 
// nums[i] 的值为 -1 或 1。 
// 1 <= k <= n 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution35;

 /**
 * 3576.数组元素相等转换.transform-array-to-all-equal-elements
 *
 * @author db117
 * @since  2025-06-09 19:32:46
 **/

  public class Solution_3576{
      public static void main(String[] args) {
           Solution solution = new Solution_3576().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public boolean canMakeEqual(int[] nums, int k) {
              return canMakeEqual1(nums.clone(), k) || canMakeEqual2(nums.clone(), k);
          }

          public boolean canMakeEqual1(int[] nums, int k) {
              // 全变成 1
              int n = nums.length;
              for (int i = 0; i < n - 1; i++) {
                  if (nums[i] != 1) {
                      nums[i] *= -1;
                      nums[i + 1] *= -1;
                      k--;
                  }
                  if (k < 0) {
                      return false;
                  }
              }

              return nums[n - 1] == 1;

          }

          public boolean canMakeEqual2(int[] nums, int k) {
              // 全变成 -1
              int n = nums.length;
              for (int i = 0; i < n - 1; i++) {
                  if (nums[i] == 1) {
                      nums[i] *= -1;
                      nums[i + 1] *= -1;
                      k--;
                  }
                  if (k < 0) {
                      return false;
                  }
              }

              return nums[n - 1] == -1;

          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }