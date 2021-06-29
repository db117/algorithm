// 给定字符串 S 和单词字典 words, 求 words[i] 中是 S 的子序列的单词个数。
//
// 
//示例:
//输入: 
//S = "abcde"
//words = ["a", "bb", "acd", "ace"]
//输出: 3
//解释: 有三个是S 的子序列的单词: "a", "acd", "ace"。
// 
//
// 注意: 
//
// 
// 所有在words和 S 里的单词都只由小写字母组成。 
// S 的长度在 [1, 50000]。 
// words 的长度在 [1, 5000]。 
// words[i]的长度在[1, 50]。 
// 
// Related Topics 字典树 哈希表 字符串 排序 
// 👍 157 👎 0


package cn.db117.leetcode.solution7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 792.匹配子序列的单词数.number-of-matching-subsequences
 *
 * @author db117
 * @since 2021-06-29 16:01:39
 **/

public class Solution_792 {
    public static void main(String[] args) {
        Solution solution = new Solution_792().new Solution();

        System.out.println(solution.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            // 保存某个字符开头的单词队列
            Map<Character, Queue<StringBuilder>> map = new HashMap<>();

            // 提前放入队列,后面就不用判断
            for (char i = 'a'; i <= 'z'; i++) {
                map.put(i, new LinkedList<>());
            }

            for (String word : words) {
                StringBuilder b = new StringBuilder(word);

                map.get(b.charAt(0)).offer(b);
            }

            int ans = 0;
            for (char c : s.toCharArray()) {
                if (!map.containsKey(c)) {
                    continue;
                }

                Queue<StringBuilder> queue = map.get(c);

                // 当前队列可能继续添加,有连续两个一样的字符
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    StringBuilder b = queue.poll();
                    if (b.length() == 1) {
                        // 后面没有字符了
                        ans++;
                    } else {
                        // 删除当前字符
                        b.deleteCharAt(0);
                        // 后续字符进行进行
                        map.get(b.charAt(0)).offer(b);
                    }
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}