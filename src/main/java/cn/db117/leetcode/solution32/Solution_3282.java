

//给你一个长度为 n 的整数数组 nums 。 
//
// 你的目标是从下标 0 出发，到达下标 n - 1 处。每次你只能移动到 更大 的下标处。 
//
// 从下标 i 跳到下标 j 的得分为 (j - i) * nums[i] 。 
//
// 请你返回你到达最后一个下标处能得到的 最大总得分 。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums = [1,3,1,5] 
// 
//
// 输出：7 
//
// 解释： 
//
// 一开始跳到下标 1 处，然后跳到最后一个下标处。总得分为 1 * 1 + 2 * 3 = 7 。 
//
// 示例 2： 
//
// 
// 输入：nums = [4,3,1,3,2] 
// 
//
// 输出：16 
//
// 解释： 
//
// 直接跳到最后一个下标处。总得分为 4 * 4 = 16 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 贪心 数组 👍 7 👎 0


package cn.db117.leetcode.solution32;

import java.util.List;

/**
 * 3282.到达数组末尾的最大得分.reach-end-of-array-with-max-score
 *
 * @author db117
 * @since  2024-09-12 14:51:20
 **/

  public class Solution_3282{
      public static void main(String[] args) {
           Solution solution = new Solution_3282().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public long findMaximumScore(List<Integer> nums) {
              long ans = 0;
              long pre = nums.get(0);
              long preIndex = 0;
              // 贪心，找到后面比当前大的数字
              for (int i = 1; i < nums.size(); i++) {
                  int num = nums.get(i);
                  if (num > pre || i == nums.size() - 1) {
                      ans += pre * (i - preIndex);
                      pre = num;
                      preIndex = i;
                  }
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }