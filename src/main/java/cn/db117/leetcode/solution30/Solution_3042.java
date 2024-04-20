

//给你一个下标从 0 开始的字符串数组 words 。 
//
// 定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ： 
//
// 
// 当 str1 同时是 str2 的前缀（prefix）和后缀（suffix）时，isPrefixAndSuffix(str1, str2) 返回 
//true，否则返回 false。 
// 
//
// 例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 
//"ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。 
//
// 以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的
// 数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["a","aba","ababa","aa"]
//输出：4
//解释：在本示例中，计数的下标对包括：
//i = 0 且 j = 1 ，因为 isPrefixAndSuffix("a", "aba") 为 true 。
//i = 0 且 j = 2 ，因为 isPrefixAndSuffix("a", "ababa") 为 true 。
//i = 0 且 j = 3 ，因为 isPrefixAndSuffix("a", "aa") 为 true 。
//i = 1 且 j = 2 ，因为 isPrefixAndSuffix("aba", "ababa") 为 true 。
//因此，答案是 4 。 
//
// 示例 2： 
//
// 
//输入：words = ["pa","papa","ma","mama"]
//输出：2
//解释：在本示例中，计数的下标对包括：
//i = 0 且 j = 1 ，因为 isPrefixAndSuffix("pa", "papa") 为 true 。
//i = 2 且 j = 3 ，因为 isPrefixAndSuffix("ma", "mama") 为 true 。
//因此，答案是 2 。 
//
// 示例 3： 
//
// 
//输入：words = ["abab","ab"]
//输出：0
//解释：在本示例中，唯一有效的下标对是 i = 0 且 j = 1 ，但是 isPrefixAndSuffix("abab", "ab") 为 false 。
//
//因此，答案是 0 。 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 50 
// 1 <= words[i].length <= 10 
// words[i] 仅由小写英文字母组成。 
// 
//
// Related Topics 字典树 数组 字符串 字符串匹配 哈希函数 滚动哈希 👍 6 👎 0


package cn.db117.leetcode.solution30;

import java.util.HashMap;
import java.util.Map;

/**
 * 3042.统计前后缀下标对 I.count-prefix-and-suffix-pairs-i
 *
 * @author db117
 * @since 2024-04-18 11:27:15
 **/

public class Solution_3042 {
    public static void main(String[] args) {
        Solution solution = new Solution_3042().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public int countPrefixSuffixPairs(String[] words) {
            int ans = 0;
            Node root = new Node();
            for (String word : words) {
                int n = word.length();
                Node cur = root;
                for (int i = 0; i < n; i++) {
                    // 把前缀和后缀拼一块,一起放入字典树
                    // 前后缀一块比较
                    int j = n - 1 - i;
                    int p = (word.charAt(i) - 'a') << 5 | (word.charAt(j) - 'a');
                    cur = cur.map.computeIfAbsent(p, k -> new Node());
                    // 如果存在这样的前缀和后缀,则加上之前的数量
                    ans += cur.count;
                }
                // 记录当前字符串
                cur.count++;
            }

            return ans;
        }

        class Node {
            Map<Integer, Node> map = new HashMap<>();
            int count = 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}