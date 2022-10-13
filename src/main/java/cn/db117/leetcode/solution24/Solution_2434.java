

//给你一个字符串 s 和一个机器人，机器人当前有一个空字符串 t 。执行以下操作之一，直到 s 和 t 都变成空字符串： 
//
// 
// 删除字符串 s 的 第一个 字符，并将该字符给机器人。机器人把这个字符添加到 t 的尾部。 
// 删除字符串 t 的 最后一个 字符，并将该字符给机器人。机器人将该字符写到纸上。 
// 
//
// 请你返回纸上能写出的字典序最小的字符串。 
//
// 
//
// 示例 1： 
//
// 输入：s = "zza"
//输出："azz"
//解释：用 p 表示写出来的字符串。
//一开始，p="" ，s="zza" ，t="" 。
//执行第一个操作三次，得到 p="" ，s="" ，t="zza" 。
//执行第二个操作三次，得到 p="azz" ，s="" ，t="" 。
// 
//
// 示例 2： 
//
// 输入：s = "bac"
//输出："abc"
//解释：用 p 表示写出来的字符串。
//执行第一个操作两次，得到 p="" ，s="c" ，t="ba" 。
//执行第二个操作两次，得到 p="ab" ，s="c" ，t="" 。
//执行第一个操作，得到 p="ab" ，s="" ，t="c" 。
//执行第二个操作，得到 p="abc" ，s="" ，t="" 。
// 
//
// 示例 3： 
//
// 输入：s = "bdda"
//输出："addb"
//解释：用 p 表示写出来的字符串。
//一开始，p="" ，s="bdda" ，t="" 。
//执行第一个操作四次，得到 p="" ，s="" ，t="bdda" 。
//执行第二个操作四次，得到 p="addb" ，s="" ，t="" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只包含小写英文字母。 
// 
//
// Related Topics 栈 贪心 哈希表 字符串 👍 31 👎 0


package cn.db117.leetcode.solution24;

import java.util.Stack;

/**
 * 2434.使用机器人打印字典序最小的字符串.using-a-robot-to-print-the-lexicographically-smallest-string
 *
 * @author db117
 * @since 2022-10-13 17:17:34
 **/

public class Solution_2434 {
    public static void main(String[] args) {
        Solution solution = new Solution_2434().new Solution();
        System.out.println(solution.robotWithString("zza"));
        System.out.println(solution.robotWithString("bac"));
        System.out.println(solution.robotWithString("bdda"));

        // "fnohopzv"
        System.out.println(solution.robotWithString("vzhofnpo"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String robotWithString(String s) {
            StringBuilder ans = new StringBuilder(s.length());
            char[] chars = s.toCharArray();
            // 统计字符数量
            int[] count = new int[26];
            for (char c : chars) {
                count[c - 'a']++;
            }
            // 剩余字符串中的最小值
            char min = minChar(count);

            Stack<Character> stack = new Stack<>();
            for (char c : chars) {
                while (!stack.isEmpty() && min >= stack.peek()) {
                    // 把所有等于最小值的字符加入
                    Character pop = stack.pop();
                    ans.append(pop);
                }

                if (c > min) {
                    // 当前字符不是最小的,入栈
                    stack.push(c);
                    count[c - 'a']--;
                    continue;
                }

                // 当前字符是最小值,直接加入
                ans.append(c);
                // 更新最小值
                count[c - 'a']--;
                if (count[c - 'a'] == 0) {
                    min = minChar(count);
                }

            }

            // 剩余全部加入
            while (!stack.isEmpty()) {
                ans.append(stack.pop());
            }

            return ans.toString();
        }

        private char minChar(int[] count) {
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    return (char) (i + 'a');
                }
            }
            return ' ';
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}