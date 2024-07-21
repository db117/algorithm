

//给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。 
//
// 当字符串还存在至少一个 '*' 字符时，你可以执行以下操作： 
//
// 
// 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。 
// 
//
// 请你返回删除所有 '*' 字符以后，剩余字符连接而成的 字典序最小 的字符串。 
//
// 
//
// 示例 1： 
//
// 
// 输入：s = "aaba*" 
// 
//
// 输出："aab" 
//
// 解释： 
//
// 删除 '*' 号和它左边的其中一个 'a' 字符。如果我们选择删除 s[3] ，s 字典序最小。 
//
// 示例 2： 
//
// 
// 输入：s = "abc" 
// 
//
// 输出："abc" 
//
// 解释： 
//
// 字符串中没有 '*' 字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s 只含有小写英文字母和 '*' 字符。 
// 输入保证操作可以删除所有的 '*' 字符。 
// 
//
// Related Topics 栈 贪心 哈希表 字符串 堆（优先队列） 👍 8 👎 0


package cn.db117.leetcode.solution31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 3170.删除星号以后字典序最小的字符串.lexicographically-minimum-string-after-removing-stars
 *
 * @author db117
 * @since 2024-06-07 16:41:27
 **/

public class Solution_3170 {
    public static void main(String[] args) {
        Solution solution = new Solution_3170().new Solution();
        // d*c
        System.out.println(solution.clearStars("d*c"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String clearStars(String s) {
            // 统计每个字符出现的次数
            ArrayList[] count = new ArrayList[26];
            Arrays.setAll(count, value -> new ArrayList<Integer>());
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] == '*') {
                    for (ArrayList list : count) {
                        if (!list.isEmpty()) {
                            // 删除前面最小的一个字符出现的最后面的
                            list.remove(list.size() - 1);
                            break;
                        }
                    }
                } else {
                    count[chars[i] - 'a'].add(i);
                }
            }

            // 把所有索引排序
            List<Integer> idx = new ArrayList<>();
            for (ArrayList list : count) {
                if (!list.isEmpty()) {
                    idx.addAll(list);
                }
            }
            idx.sort(Comparator.naturalOrder());

            StringBuilder ans = new StringBuilder();
            for (Integer i : idx) {
                ans.append(chars[i]);
            }
            return ans.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}