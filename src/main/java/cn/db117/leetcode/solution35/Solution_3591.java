

//给你一个整数数组 nums。 
//
// 如果数组中任一元素的 频次 是 质数，返回 true；否则，返回 false。 
//
// 元素 x 的 频次 是它在数组中出现的次数。 
//
// 质数是一个大于 1 的自然数，并且只有两个因数：1 和它本身。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,2,3,4,5,4] 
// 
//
// 输出： true 
//
// 解释： 
//
// 数字 4 的频次是 2，而 2 是质数。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,3,4,5] 
// 
//
// 输出： false 
//
// 解释： 
//
// 所有元素的频次都是 1。 
//
// 示例 3： 
//
// 
// 输入： nums = [2,2,2,4,4] 
// 
//
// 输出： true 
//
// 解释： 
//
// 数字 2 和 4 的频次都是质数。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
//
// 👍 0 👎 0


package cn.db117.leetcode.solution35;

 /**
 * 3591.检查元素频次是否为质数.check-if-any-element-has-prime-frequency
 *
 * @author db117
 * @since  2025-06-23 15:12:44
 **/

  public class Solution_3591{
      public static void main(String[] args) {
           Solution solution = new Solution_3591().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public boolean checkPrimeFrequency(int[] nums) {
              int[] cut= new int[107];
              for (int num : nums) {
                  cut[num]++;
              }
              for (int j : cut) {
                  if (j > 1) {
                      boolean prime = isPrime(j);
                      if (prime) {
                          return true;
                      }
                  }
              }

              return false;
          }

          private boolean isPrime(int n) {
              int size = (int) Math.sqrt(n);
              for (int i = 2; i <= size; i++) {
                  if (n % i == 0) {
                      return false;
                  }
              }
              return true;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }