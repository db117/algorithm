

//给你一个字符串 s 和一个整数 t，表示要执行的 转换 次数。每次 转换 需要根据以下规则替换字符串 s 中的每个字符： 
//
// 
// 如果字符是 'z'，则将其替换为字符串 "ab"。 
// 否则，将其替换为字母表中的下一个字符。例如，'a' 替换为 'b'，'b' 替换为 'c'，依此类推。 
// 
//
// 返回 恰好 执行 t 次转换后得到的字符串的 长度。 
//
// 由于答案可能非常大，返回其对 10⁹ + 7 取余的结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入： s = "abcyy", t = 2 
// 
//
// 输出： 7 
//
// 解释： 
//
// 
// 第一次转换 (t = 1) 
// 
//
// 
// 'a' 变为 'b' 
// 'b' 变为 'c' 
// 'c' 变为 'd' 
// 'y' 变为 'z' 
// 'y' 变为 'z' 
// 第一次转换后的字符串为："bcdzz" 
// 
// 
// 第二次转换 (t = 2)
// 
// 'b' 变为 'c' 
// 'c' 变为 'd' 
// 'd' 变为 'e' 
// 'z' 变为 "ab" 
// 'z' 变为 "ab" 
// 第二次转换后的字符串为："cdeabab" 
// 
// 
// 最终字符串长度：字符串为 "cdeabab"，长度为 7 个字符。 
//
//
// 示例 2： 
//
// 
// 输入： s = "azbk", t = 1 
// 
//
// 输出： 5 
//
// 解释： 
//
// 
// 第一次转换 (t = 1) 
// 
//
// 
// 'a' 变为 'b' 
// 'z' 变为 "ab" 
// 'b' 变为 'c' 
// 'k' 变为 'l' 
// 第一次转换后的字符串为："babcl" 
// 
// 
// 最终字符串长度：字符串为 "babcl"，长度为 5 个字符。 
//
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 仅由小写英文字母组成。 
// 1 <= t <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 字符串 动态规划 计数 👍 3 👎 0


package cn.db117.leetcode.solution33;

 /**
 * 3335.字符串转换后的长度 I.total-characters-in-string-after-transformations-i
 *
 * @author db117
 * @since  2024-10-29 14:12:04
 **/

  public class Solution_3335{
      public static void main(String[] args) {
           Solution solution = new Solution_3335().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          static int mod = 1000000007;
          // 字符在变化后的长度
          static long[][] arr = new long[128][100005];

          static {
              for (int i = 0; i < 128; i++) {
                  for (int j = 0; j < 100005; j++) {
                      arr[i][j] = -1;
                  }
              }
          }

          public int lengthAfterTransformations(String s, int t) {
              long ans = 0;
              int n = s.length();
              for (int i = 0; i < n; i++) {
                  // 字符 c 在变化 t 次后的长度
                  ans += helper(s.charAt(i), t);
                  ans %= mod;
              }
              return (int) (ans % mod);
          }

          private long helper(char c, int t) {
              if (t <= 0) {
                  return 1;
              }
              if (arr[c][t] != -1) {
                  return arr[c][t];
              }
              if (c == 'z') {
                  // z -》 ab
                  arr[c][t] = helper('a', t - 1) + helper('b', t - 1);
                  arr[c][t] %= mod;
                  return arr[c][t];
              }
              long ans = 0;
              int toZ = 'z' - c;
              if (toZ >= t) {
                  ans = 1;
              } else {
                  ans = helper('z', t - toZ);
              }
              ans %= mod;
              return arr[c][t] = ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }