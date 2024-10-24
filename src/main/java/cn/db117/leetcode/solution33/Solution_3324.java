

//给你一个字符串 target。 
//
// Alice 将会使用一种特殊的键盘在她的电脑上输入 target，这个键盘 只有两个 按键： 
//
// 
// 按键 1：在屏幕上的字符串后追加字符 'a'。 
// 按键 2：将屏幕上字符串的 最后一个 字符更改为英文字母表中的 下一个 字符。例如，'c' 变为 'd'，'z' 变为 'a'。 
// 
//
// 注意，最初屏幕上是一个空字符串 ""，所以她 只能 按按键 1。 
//
// 请你考虑按键次数 最少 的情况，按字符串出现顺序，返回 Alice 输入 target 时屏幕上出现的所有字符串列表。 
//
// 
//
// 示例 1： 
//
// 
// 输入： target = "abc" 
// 
//
// 输出： ["a","aa","ab","aba","abb","abc"] 
//
// 解释： 
//
// Alice 按键的顺序如下： 
//
// 
// 按下按键 1，屏幕上的字符串变为 "a"。 
// 按下按键 1，屏幕上的字符串变为 "aa"。 
// 按下按键 2，屏幕上的字符串变为 "ab"。 
// 按下按键 1，屏幕上的字符串变为 "aba"。 
// 按下按键 2，屏幕上的字符串变为 "abb"。 
// 按下按键 2，屏幕上的字符串变为 "abc"。 
// 
//
// 示例 2： 
//
// 
// 输入： target = "he" 
// 
//
// 输出： ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"] 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 400 
// target 仅由小写英文字母组成。 
// 
//
// Related Topics 字符串 模拟 👍 3 👎 0


package cn.db117.leetcode.solution33;

import java.util.ArrayList;
import java.util.List;

/**
 * 3324.出现在屏幕上的字符串序列.find-the-sequence-of-strings-appeared-on-the-screen
 *
 * @author db117
 * @since  2024-10-24 14:52:04
 **/

  public class Solution_3324{
      public static void main(String[] args) {
           Solution solution = new Solution_3324().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<String> stringSequence(String target) {
              int n = target.length();
              List<String> ans = new ArrayList<>();
              StringBuilder s = new StringBuilder();
              for (int i = 0; i < n; i++) {
                  for (char j = 'a'; j <= target.charAt(i); j++) {
                      ans.add(s.toString() + j);
                  }
                  s.append(target.charAt(i));
              }
              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }