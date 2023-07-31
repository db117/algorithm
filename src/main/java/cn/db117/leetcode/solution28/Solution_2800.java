

//给你三个字符串 a ，b 和 c ， 你的任务是找到长度 最短 的字符串，且这三个字符串都是它的 子字符串 。
//
// 如果有多个这样的字符串，请你返回 字典序最小 的一个。 
//
// 请你返回满足题目要求的字符串。 
//
// 注意： 
//
// 
// 两个长度相同的字符串 a 和 b ，如果在第一个不相同的字符处，a 的字母在字母表中比 b 的字母 靠前 ，那么字符串 a 比字符串 b 字典序小 。 
// 子字符串 是一个字符串中一段连续的字符序列。 
// 
//
// 
//
// 示例 1： 
//
// 输入：a = "abc", b = "bca", c = "aaa"
//输出："aaabca"
//解释：字符串 "aaabca" 包含所有三个字符串：a = ans[2...4] ，b = ans[3..5] ，c = ans[0..2] 。结果字符串的
//长度至少为 6 ，且"aaabca" 是字典序最小的一个。 
//
// 示例 2： 
//
// 输入：a = "ab", b = "ba", c = "aba"
//输出："aba"
//解释：字符串 "aba" 包含所有三个字符串：a = ans[0..1] ，b = ans[1..2] ，c = ans[0..2] 。由于 c 的长度为 
//3 ，结果字符串的长度至少为 3 。"aba" 是字典序最小的一个。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length, b.length, c.length <= 100 
// a ，b ，c 只包含小写英文字母。 
// 
//
// 👍 13 👎 0


package cn.db117.leetcode.solution28;

import java.util.ArrayList;
import java.util.List;

/**
 * 2800.包含三个字符串的最短字符串.shortest-string-that-contains-three-strings
 *
 * @author db117
 * @since 2023-07-31 10:42:00
 **/

public class Solution_2800 {
    public static void main(String[] args) {
        Solution solution = new Solution_2800().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minimumString(String a, String b, String c) {
            // 枚举所有情况
            List<String> list = new ArrayList<>();
            list.add(helper(a, b, c));
            list.add(helper(a, c, b));
            list.add(helper(b, a, c));
            list.add(helper(b, c, a));
            list.add(helper(c, a, b));
            list.add(helper(c, b, a));


            list.sort((s, t1) -> {
                if (s.length() == t1.length()) {
                    return s.compareTo(t1);
                }
                return Integer.compare(s.length(), t1.length());
            });
            return list.get(0);
        }

        public String helper(String a, String b, String c) {
            if (a.length() + b.length() + c.length() == 0) {
                return "";
            }

            int lenA = a.length();
            StringBuilder ans = new StringBuilder(a);

            boolean flag = false;
            if (a.contains(b)) {// 特判包含的情况
                flag = true;
            } else {
                // 一个个比较找到最长的相交字符串
                for (int i = lenA; i > 0; i--) {
                    String aLast = a.substring(lenA - i, lenA);
                    if (b.startsWith(aLast)) {
                        ans.append(b.substring(i));
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                ans.append(b);
            }

            // 重复上面的操作
            flag = false;
            if (ans.toString().contains(c)) {
                flag = true;
            } else {
                for (int i = ans.length(); i > 0; i--) {
                    String aLast = ans.substring(ans.length() - i, ans.length());
                    if (c.startsWith(aLast)) {
                        ans.append(c.substring(i));
                        flag = true;
                        break;
                    }
                }
            }
            if (!flag) {
                ans.append(c);
            }

            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}