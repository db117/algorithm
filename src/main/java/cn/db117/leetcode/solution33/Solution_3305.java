

//给你一个字符串 word 和一个 非负 整数 k。 
//
// 返回 word 的 子字符串 中，每个元音字母（'a'、'e'、'i'、'o'、'u'）至少 出现一次，并且 恰好 包含 k 个辅音字母的子字符串的总数。
// 
//
// 
//
// 示例 1： 
//
// 
// 输入：word = "aeioqq", k = 1 
// 
//
// 输出：0 
//
// 解释： 
//
// 不存在包含所有元音字母的子字符串。 
//
// 示例 2： 
//
// 
// 输入：word = "aeiou", k = 0 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一一个包含所有元音字母且不含辅音字母的子字符串是 word[0..4]，即 "aeiou"。 
//
// 示例 3： 
//
// 
// 输入：word = "ieaouqqieaouqq", k = 1 
// 
//
// 输出：3 
//
// 解释： 
//
// 包含所有元音字母并且恰好含有一个辅音字母的子字符串有： 
//
// 
// word[0..5]，即 "ieaouq"。 
// word[6..11]，即 "qieaou"。 
// word[7..12]，即 "ieaouq"。 
// 
//
// 
//
// 提示： 
//
// 
// 5 <= word.length <= 250 
// word 仅由小写英文字母组成。 
// 0 <= k <= word.length - 5 
// 
//
// Related Topics 哈希表 字符串 滑动窗口 👍 48 👎 0


package cn.db117.leetcode.solution33;

 /**
 * 3305.元音辅音字符串计数 I.count-of-substrings-containing-every-vowel-and-k-consonants-i
 *
 * @author db117
 * @since  2025-03-13 19:44:20
 **/

  public class Solution_3305{
      public static void main(String[] args) {
           Solution solution = new Solution_3305().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          char[] chars;
          String s = "aeiou";

          public int countOfSubstrings(String word, int k) {
              chars = word.toCharArray();
              // 【最少为 k 的子字符串的总数】 - 【最少为 k+1 的子字符串的总数】=【恰好为 k 的子字符串的总数】
              return helper(k) - helper(k + 1);
          }

          // 至少包含 k 个小写英文字母的子字符串的总数。
          public int helper(int k) {
              int ans = 0;
              int[] cut = new int[26];// 统计元音字母的个数
              int count = 0;// 窗口内的元音字母个数

              int other = 0;// 统计非元音字母的个数

              int left = 0;
              for (char c : chars) {
                  if (s.indexOf(c) != -1) {
                      cut[c - 'a']++;
                      if (cut[c - 'a'] == 1) {
                          count++;
                      }
                  } else {
                      other++;
                  }

                  while (count == 5 && other >= k) {
                      if (s.indexOf(chars[left]) != -1) {
                          cut[chars[left] - 'a']--;
                          if (cut[chars[left] - 'a'] == 0) {
                              count--;
                          }
                      } else {
                          other--;
                      }
                      left++;
                  }
                  // 窗口左边的全部满足
                  ans += left;
              }

              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }