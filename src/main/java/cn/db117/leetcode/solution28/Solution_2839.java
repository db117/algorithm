

//给你两个字符串 s1 和 s2 ，两个字符串的长度都为 4 ，且只包含 小写 英文字母。 
//
// 你可以对两个字符串中的 任意一个 执行以下操作 任意 次： 
//
// 
// 选择两个下标 i 和 j 且满足 j - i = 2 ，然后 交换 这个字符串中两个下标对应的字符。 
// 
//
// 如果你可以让字符串 s1 和 s2 相等，那么返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "abcd", s2 = "cdab"
//输出：true
//解释： 我们可以对 s1 执行以下操作：
//- 选择下标 i = 0 ，j = 2 ，得到字符串 s1 = "cbad" 。
//- 选择下标 i = 1 ，j = 3 ，得到字符串 s1 = "cdab" = s2 。
// 
//
// 示例 2： 
//
// 
//输入：s1 = "abcd", s2 = "dacb"
//输出：false
//解释：无法让两个字符串相等。
// 
//
// 
//
// 提示： 
//
// 
// s1.length == s2.length == 4 
// s1 和 s2 只包含小写英文字母。 
// 
//
// Related Topics 字符串 👍 6 👎 0


package cn.db117.leetcode.solution28;

import java.util.Arrays;

/**
 * 2839.判断通过操作能否让字符串相等 I.check-if-strings-can-be-made-equal-with-operations-i
 *
 * @author db117
 * @since 2024-04-10 16:48:15
 **/

public class Solution_2839 {
    public static void main(String[] args) {
        Solution solution = new Solution_2839().new Solution();
        // "fymg"
        //			"famj"
        System.out.println(solution.canBeEqual("fymg", "famj"));
        // "abcd"
        //			"cdab"
        System.out.println(solution.canBeEqual("abcd", "cdab"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canBeEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            // 分成两组 两两交换
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            char[] temp1 = new char[2];
            char[] temp2 = new char[2];
            char[] temp3 = new char[2];
            char[] temp4 = new char[2];

            temp1[0] = chars1[0];
            temp1[1] = chars1[2];
            temp2[0] = chars1[1];
            temp2[1] = chars1[3];
            temp3[0] = chars2[0];
            temp3[1] = chars2[2];
            temp4[0] = chars2[1];
            temp4[1] = chars2[3];

            Arrays.sort(temp1);
            Arrays.sort(temp2);
            Arrays.sort(temp3);
            Arrays.sort(temp4);

            return temp1[0] == temp3[0] && temp1[1] == temp3[1] && temp2[0] == temp4[0] && temp2[1] == temp4[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}