


//字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。 
//
// S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。 
//
// 返回任意一种符合条件的字符串T。 
//
// 
//示例:
//输入:
//S = "cba"
//T = "abcd"
//输出: "cbad"
//解释: 
//S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a". 
//由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
// 
//
// 注意: 
//
// 
// S的最大长度为26，其中没有重复的字符。 
// T的最大长度为200。 
// S和T只包含小写字符。 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 80 👎 0


package cn.db117.leetcode.solution7;

/**
 * 791.自定义字符串排序.custom-sort-string
 *
 * @author db117
 * @since 2021-07-02 18:35:16
 **/

public class Solution_791 {
    public static void main(String[] args) {
        Solution solution = new Solution_791().new Solution();

        System.out.println(solution.customSortString("cba", "abcd"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String customSortString(String order, String str) {
            // 字符出现次数
            int[] counts = new int[26];
            char[] chars = str.toCharArray();
            for (char c : chars) {
                counts[c - 'a']++;
            }

            char[] orderChars = order.toCharArray();
            int index = 0;
            // 添加 order 中有的
            for (char c : orderChars) {
                int count = counts[c - 'a'];

                for (int i = 0; i < count; i++) {
                    chars[index++] = c;
                }
                // 情况数量
                counts[c - 'a'] = 0;
            }

            // 添加 order 中没有的
            // count 中不为 0 则说明 order 中没有
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] == 0) {
                    continue;
                }
                // 当前字符出现的数量
                int count = counts[i];
                char c = (char) (i + 'a');
                for (int j = 0; j < count; j++) {
                    chars[index++] = c;
                }
            }

            return new String(chars);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}