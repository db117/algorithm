

//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 364 👎 0


package cn.db117.leetcode.solution7;

import java.util.ArrayList;
import java.util.List;

/**
 * 792.匹配子序列的单词数.number-of-matching-subsequences
 *
 * @author db117
 * @see cn.db117.template.SubsequenceAutomaton
 * @since 2022-12-10 16:06:10
 **/
public class Solution_792_1 {
    public static void main(String[] args) {
        Solution solution = new Solution_792_1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 存每一个字符出现的位置
         */
        List<Integer>[] arr = new ArrayList[26];

        public int numMatchingSubseq(String s, String[] words) {
            build(s);
            int ans = 0;
            for (String word : words) {
                if (query(word)) {
                    ans++;
                }
            }
            return ans;
        }

        /**
         * 构建
         *
         * @param s s
         */
        public void build(String s) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                int arrI = chars[i] - 'a';
                arr[arrI].add(i);
            }
        }

        /**
         * 查询
         *
         * @param t t
         * @return boolean
         */
        public boolean query(String t) {
            char[] chars = t.toCharArray();
            int pre = -1;
            for (char c : chars) {
                int i = c - 'a';
                List<Integer> list = arr[i];
                pre = bs(list, pre);
                if (pre == -1) {
                    return false;
                }
            }

            return true;
        }

        /**
         * 二分搜索找比 q 大的最小值
         *
         * @return int -1 未找到
         */
        public int bs(List<Integer> list, int q) {
            if (list.isEmpty()) {
                return -1;
            }
            if (q == -1) {
                return list.get(0);
            }
            if (list.get(list.size() - 1) <= q) {
                return -1;
            }

            int left = 0, right = list.size() - 1;
            while (left < right) {
                // 两个中位数取左边
                int mid = (left + right) / 2;

                if (list.get(mid) > q) {
                    // 当前值可能是目标
                    right = mid;
                } else {
                    // 当前值肯定不是
                    left = mid + 1;
                }
            }

            return list.get(right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}