

//给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。 
//
// 子字符串 是字符串中的一个连续、 非空 的字符序列。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "abacb", k = 2 
// 
//
// 输出： 4 
//
// 解释： 
//
// 符合条件的子字符串如下： 
//
// 
// "aba"（字符 'a' 出现 2 次）。 
// "abac"（字符 'a' 出现 2 次）。 
// "abacb"（字符 'a' 出现 2 次）。 
// "bacb"（字符 'b' 出现 2 次）。 
// 
//
// 示例 2： 
//
// 
// 输入： s = "abcde", k = 1 
// 
//
// 输出： 15 
//
// 解释： 
//
// 所有子字符串都有效，因为每个字符至少出现一次。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3000 
// 1 <= k <= s.length 
// s 仅由小写英文字母组成。 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 3 👎 0


package cn.db117.leetcode.solution33;

 /**
 * 3325.字符至少出现 K 次的子字符串 I.count-substrings-with-k-frequency-characters-i
 *
 * @author db117
 * @since  2024-10-24 14:54:15
 **/

  public class Solution_3325{
      public static void main(String[] args) {
           Solution solution = new Solution_3325().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public int numberOfSubstrings(String s, int k) {
              int ans = 0;
              int n = s.length();
              int left = 0;
              int[] count = new int[26];
              for (int right = 0; right < n; right++) {
                  int c = s.charAt(right) - 'a';
                  count[c]++;

                  while (count[c] >= k) {// 只有右边加入的可能超过 k
                      ans += n - right;
                      count[s.charAt(left++) - 'a']--;
                  }
              }

              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }