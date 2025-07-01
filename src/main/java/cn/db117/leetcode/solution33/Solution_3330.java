

//Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。 
//
// 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。 
//
// 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。 
//
// 请你返回 Alice 一开始可能想要输入字符串的总方案数。 
//
// 
//
// 示例 1： 
//
// 
// 输入：word = "abbcccc" 
// 
//
// 输出：5 
//
// 解释： 
//
// 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。 
//
// 示例 2： 
//
// 
// 输入：word = "abcd" 
// 
//
// 输出：1 
//
// 解释： 
//
// 唯一可能的字符串是 "abcd" 。 
//
// 示例 3： 
//
// 
// 输入：word = "aaaa" 
// 
//
// 输出：4 
//
// 
//
// 提示： 
//
// 
// 1 <= word.length <= 100 
// word 只包含小写英文字母。 
// 
//
// Related Topics 字符串 👍 14 👎 0


package cn.db117.leetcode.solution33;

/**
 * 3330.找到初始输入字符串 I.find-the-original-typed-string-i
 *
 * @author db117
 * @since 2025-07-01 19:18:05
 **/

public class Solution_3330 {
    public static void main(String[] args) {
        Solution solution = new Solution_3330().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int possibleStringCount(String word) {
            int ans = 1;
            int n = word.length();
            for (int i = 0; i < n; ) {
                char pre = word.charAt(i);
                int count = 0;
                while (i < n && word.charAt(i) == pre) {
                    count++;
                    i++;
                }
                // 如果连续的字符相同，假定这个字符输入错误，则需要减去一个字符
                ans += count - 1;

            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}