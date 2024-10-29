

//给你一个整数数组 nums。 
//
// 因子得分 定义为数组所有元素的最小公倍数（LCM）与最大公约数（GCD）的 乘积。 
//
// 在 最多 移除一个元素的情况下，返回 nums 的 最大因子得分。 
//
// 注意，单个数字的 LCM 和 GCD 都是其本身，而 空数组 的因子得分为 0。 
//
// lcm(a, b) 表示 a 和 b 的 最小公倍数。 
//
// gcd(a, b) 表示 a 和 b 的 最大公约数。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [2,4,8,16] 
// 
//
// 输出： 64 
//
// 解释： 
//
// 移除数字 2 后，剩余元素的 GCD 为 4，LCM 为 16，因此最大因子得分为 4 * 16 = 64。 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,3,4,5] 
// 
//
// 输出： 60 
//
// 解释： 
//
// 无需移除任何元素即可获得最大因子得分 60。 
//
// 示例 3： 
//
// 
// 输入： nums = [3] 
// 
//
// 输出： 9 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 1 <= nums[i] <= 30 
// 
//
// Related Topics 数组 数学 数论 👍 3 👎 0


package cn.db117.leetcode.solution33;

 /**
 * 3334.数组的最大因子得分.find-the-maximum-factor-score-of-array
 *
 * @author db117
 * @since  2024-10-29 11:24:12
 **/

  public class Solution_3334{
      public static void main(String[] args) {
           Solution solution = new Solution_3334().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {

          public long maxScore(int[] nums) {
              int n = nums.length;
              long ans = helper(nums);
              for (int i = 0; i < n; i++) {
                  // 删掉一个数
                  int[] nums2 = new int[n - 1];
                  for (int j = 0; j < n; j++) {
                      if (j != i) {
                          nums2[j - (j > i ? 1 : 0)] = nums[j];
                      }
                  }
                  ans = Math.max(ans, helper(nums2));
              }
              return ans;
          }

          private long helper(int[] nums) {
              if (nums.length == 0) {
                  return 0;
              }
              // 数组的最大公约数
              long arrGcd;
              long arrLcm;
              if (nums.length == 1) {
                  arrGcd = nums[0];
                  arrLcm = nums[0];
              } else {
                  arrGcd = gcd(nums[0], nums[1]);
                  arrLcm = lcm(nums[0], nums[1]);
                  for (int i = 2; i < nums.length; i++) {
                      arrGcd = gcd(arrGcd, nums[i]);
                      arrLcm = lcm(arrLcm, nums[i]);
                  }
              }
              return arrGcd * arrLcm;
          }

          // 最大公约数
          public static long gcd(long a, long b) {
              if (b == 0) {
                  return a;
              }

              return gcd(b, a % b);
          }

          public static long lcm(long x, long y) {
              if (x == 0) {
                  return y;
              } else if (y == 0) {
                  return x;
              }

              return x * y / gcd(x,y);
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }