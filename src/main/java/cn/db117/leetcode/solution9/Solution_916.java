// 我们给出两个单词数组 A 和 B。每个单词都是一串小写字母。
//
// 现在，如果 b 中的每个字母都出现在 a 中，包括重复出现的字母，那么称单词 b 是单词 a 的子集。 例如，“wrr” 是 “warrior” 的子集，
//但不是 “world” 的子集。 
//
// 如果对 B 中的每一个单词 b，b 都是 a 的子集，那么我们称 A 中的单词 a 是通用的。 
//
// 你可以按任意顺序以列表形式返回 A 中所有的通用单词。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","o"]
//输出：["facebook","google","leetcode"]
// 
//
// 示例 2： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["l","e"]
//输出：["apple","google","leetcode"]
// 
//
// 示例 3： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["e","oo"]
//输出：["facebook","google"]
// 
//
// 示例 4： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["lo","eo"]
//输出：["google","leetcode"]
// 
//
// 示例 5： 
//
// 输入：A = ["amazon","apple","facebook","google","leetcode"], B = ["ec","oc","ceo
//"]
//输出：["facebook","leetcode"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length, B.length <= 10000 
// 1 <= A[i].length, B[i].length <= 10 
// A[i] 和 B[i] 只由小写字母组成。 
// A[i] 中所有的单词都是独一无二的，也就是说不存在 i != j 使得 A[i] == A[j]。 
// 
// Related Topics 数组 哈希表 字符串 
// 👍 55 👎 0


package cn.db117.leetcode.solution9;

import java.util.LinkedList;
import java.util.List;

/**
 * 916.单词子集.word-subsets
 *
 * @author db117
 * @since 2021-06-29 18:34:31
 **/

public class Solution_916 {
    public static void main(String[] args) {
        Solution solution = new Solution_916().new Solution();

        System.out.println(solution.wordSubsets(new String[]{
                "amazon", "apple", "facebook", "google", "leetcode"
        }, new String[]{
                "ec", "oc", "ceo"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<String> wordSubsets(String[] words1, String[] words2) {
            List<String> ans = new LinkedList<>();
            int[] max = new int[26];
            // 遍历 words2 获取每一个字符出现的最大次数
            for (String s : words2) {
                char[] chars = s.toCharArray();
                int[] cur = new int[26];
                for (char c : chars) {
                    cur[c - 'a']++;
                }
                for (int i = 0; i < 26; i++) {
                    max[i] = Math.max(max[i], cur[i]);
                }
            }

            // 遍历 words1 所有字符都大于 max 则符合
            for (String s : words1) {
                char[] chars = s.toCharArray();
                int[] cur = new int[26];
                for (char c : chars) {
                    cur[c - 'a']++;
                }

                boolean flag = true;

                for (int i = 0; i < 26; i++) {
                    if (cur[i] < max[i]) {
                        // 存在不满足的情况
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    ans.add(s);
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}