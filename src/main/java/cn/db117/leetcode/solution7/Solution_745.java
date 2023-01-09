

//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
//
// Related Topics 设计 字典树 哈希表 字符串 👍 177 👎 0


package cn.db117.leetcode.solution7;

import cn.db117.template.trie.Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * 745.前缀和后缀搜索.prefix-and-suffix-search
 *
 * @author db117
 * @see Trie
 * @since 2022-09-23 15:24:57
 **/

public class Solution_745 {
    public static void main(String[] args) {
        // ["WordFilter", "f"]
        //[[["apple"]], ["a", "e"]]
        WordFilter solution = new Solution_745().new WordFilter(new String[]{"apple"});

        System.out.println(solution.search("a", "e"));

        // ["WordFilter","f"]
        //[[["abbba","abba"]],["ab","ba"]]
        // [null,1]
        WordFilter solution1 = new Solution_745().new WordFilter(new String[]{"abbba", "abba"});

        System.out.println(solution1.search("ab", "ba"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class WordFilter {
        TrieNode start = new TrieNode();
        TrieNode end = new TrieNode();

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                insert(start, words[i], i, true);
                insert(end, words[i], i, false);
            }
        }

        public int f(String pref, String suff) {
            return search(pref, suff);
        }

        class TrieNode {
            TrieNode[] child = new TrieNode[26];
            // 到这来的索引
            List<Integer> index = new ArrayList<>();

            // 获取子节点
            public TrieNode get(char c1) {
                return child[c1 - 'a'];
            }

            // 获取,如果没有就创建
            private TrieNode getChildAdd(char c) {
                if (child[c - 'a'] == null) {
                    child[c - 'a'] = new TrieNode();
                }
                return child[c - 'a'];
            }
        }


        /**
         * 插入
         */
        public void insert(TrieNode root, String word, int index, boolean isPre) {
            TrieNode trie = root;
            int length = word.length();
            if (isPre) {
                for (int i = 0; i < length; i++) {
                    trie = trie.getChildAdd(word.charAt(i));
                    trie.index.add(index);
                }
            } else {
                for (int i = length - 1; i >= 0; i--) {
                    trie = trie.getChildAdd(word.charAt(i));
                    trie.index.add(index);
                }
            }
        }

        public int search(String pref, String suff) {
            TrieNode startNode = searchNode(start, pref, true);
            TrieNode endNode = searchNode(end, suff, false);
            if (startNode == null || endNode == null) {
                // 没有前缀或者后缀
                return -1;
            }
            List<Integer> s = startNode.index;
            List<Integer> e = endNode.index;

            // 从后面开始找,有一样的就说明是索引最大的那个
            int si = s.size() - 1;
            int ei = e.size() - 1;

            while (si >= 0 && ei >= 0) {
                if (s.get(si).equals(e.get(ei))) {
                    return s.get(si);
                }
                if (s.get(si) > e.get(ei)) {
                    si--;
                } else {
                    ei--;
                }
            }
            return -1;
        }

        /**
         * 查找字符串节点
         */
        public TrieNode searchNode(TrieNode root, String word, boolean isPre) {
            TrieNode trie = root;
            int length = word.length();
            if (isPre) {
                for (int i = 0; i < length; i++) {
                    char c = word.charAt(i);
                    // 获取下一级
                    if (trie.get(c) == null) {
                        return null;
                    }
                    trie = trie.getChildAdd(c);
                }

            } else {
                for (int i = length - 1; i >= 0; i--) {
                    char c = word.charAt(i);
                    // 获取下一级
                    if (trie.get(c) == null) {
                        return null;
                    }
                    trie = trie.getChildAdd(c);
                }

            }

            return trie;
        }
    }

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//leetcode submit region end(Prohibit modification and deletion)

}