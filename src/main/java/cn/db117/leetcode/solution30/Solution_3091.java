

//给你一个正整数 k 。最初，你有一个数组 nums = [1] 。 
//
// 你可以对数组执行以下 任意 操作 任意 次数（可能为零）： 
//
// 
// 选择数组中的任何一个元素，然后将它的值 增加 1 。 
// 复制数组中的任何一个元素，然后将它附加到数组的末尾。 
// 
//
// 返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：k = 11 
// 
//
// 输出：5 
//
// 解释： 
//
// 可以对数组 nums = [1] 执行以下操作： 
//
// 
// 将元素的值增加 1 三次。结果数组为 nums = [4] 。 
// 复制元素两次。结果数组为 nums = [4,4,4] 。 
// 
//
// 最终数组的和为 4 + 4 + 4 = 12 ，大于等于 k = 11 。 执行的总操作次数为 3 + 2 = 5 。 
//
// 示例 2： 
//
// 
// 输入：k = 1 
// 
//
// 输出：0 
//
// 解释： 
//
// 原始数组的和已经大于等于 1 ，因此不需要执行操作。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 贪心 数学 枚举 👍 2 👎 0


package cn.db117.leetcode.solution30;

 /**
 * 3091.执行操作使数据元素之和大于等于 K.apply-operations-to-make-sum-of-array-greater-than-or-equal-to-k
 *
 * @author db117
 * @since  2024-03-26 23:31:17
 **/

  public class Solution_3091{
      public static void main(String[] args) {
           Solution solution = new Solution_3091().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int minOperations(int k) {
              if (k == 1) {
                  return 0;
              }
              // 二分
              int left = 0, right = k - 1;
              while (left < right) {
                  int mid = left + (right - left ) / 2;
                  if (check(k, mid)) {
                      right = mid;
                  } else {
                      left = mid + 1;
                  }
              }

              return right;
          }

          private boolean check(int k, int mid) {
              // 一个个试
              for (int i = 1; i < mid; i++) {
                  if ((1 + i) * (mid - i + 1) >= k) {
                      return true;
                  }
              }
              return false;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }