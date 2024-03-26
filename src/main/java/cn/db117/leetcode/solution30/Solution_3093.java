

//给你两个字符串数组 wordsContainer 和 wordsQuery 。 
//
// 对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果
// wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 
//wordsContainer 中出现 更早 的一个。 
//
// 请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。 
//
// 
//
// 示例 1： 
//
// 
// 输入：wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"] 
// 
//
// 输出：[1,1,1] 
//
// 解释： 
//
// 我们分别来看每一个 wordsQuery[i] ： 
//
// 
// 对于 wordsQuery[0] = "cd" ，wordsContainer 中有最长公共后缀 "cd" 的字符串下标分别为 0 ，1 和 2 。这些字
//符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 对于 wordsQuery[1] = "bcd" ，wordsContainer 中有最长公共后缀 "bcd" 的字符串下标分别为 0 ，1 和 2 。这
//些字符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 对于 wordsQuery[2] = "xyz" ，wordsContainer 中没有字符串跟它有公共后缀，所以最长公共后缀为 "" ，下标为 0 ，1
// 和 2 的字符串都得到这一公共后缀。这些字符串中， 答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 
//
// 示例 2： 
//
// 
// 输入：wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh",
//"acbfgh","acbfegh"] 
// 
//
// 输出：[2,0,2] 
//
// 解释： 
//
// 我们分别来看每一个 wordsQuery[i] ： 
//
// 
// 对于 wordsQuery[0] = "gh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2 。这些字
//符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。 
// 对于 wordsQuery[1] = "acbfgh" ，只有下标为 0 的字符串有最长公共后缀 "fgh" 。所以尽管下标为 2 的字符串是最短的字符串
//，但答案是 0 。 
// 对于 wordsQuery[2] = "acbfegh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2
// 。这些字符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= wordsContainer.length, wordsQuery.length <= 10⁴ 
// 1 <= wordsContainer[i].length <= 5 * 10³ 
// 1 <= wordsQuery[i].length <= 5 * 10³ 
// wordsContainer[i] 只包含小写英文字母。 
// wordsQuery[i] 只包含小写英文字母。 
// wordsContainer[i].length 的和至多为 5 * 10⁵ 。 
// wordsQuery[i].length 的和至多为 5 * 10⁵ 。 
// 
//
// Related Topics 字典树 数组 字符串 👍 3 👎 0


package cn.db117.leetcode.solution30;

import java.util.Arrays;

/**
 * 3093.最长公共后缀查询.longest-common-suffix-queries
 *
 * @author db117
 * @since 2024-03-26 23:34:20
 **/

public class Solution_3093 {
    public static void main(String[] args) {
        Solution solution = new Solution_3093().new Solution();
        // ["abcdefgh","poiuygh","ghghgh"]
        //			["gh","acbfgh","acbfegh"]
//        System.out.println(Arrays.toString(solution.stringIndices(new String[]{
//                "abcdefgh", "poiuygh", "ghghgh"
//        }, new String[]{
//                "gh", "acbfgh", "acbfegh"
//        })));


        // ["orrgoypyy","roorgyrg","yypgyro","opggpyrpgg","ggroyyr","pyryg","rrpoo","gopoy","ggyrgppg"]
        //			["ygoogyg","gyoorgorgp","rypprrgpr","orprrry","groprrrpo","ppoggropop","yryyorr"]
        // [5,5,4,7,6,5,4]
        System.out.println(Arrays.toString(solution.stringIndices(new String[]{
                "orrgoypyy", "roorgyrg", "yypgyro", "opggpyrpgg", "ggroyyr", "pyryg", "rrpoo", "gopoy", "ggyrgppg"
        }, new String[]{
                "ygoogyg", "gyoorgorgp", "rypprrgpr", "orprrry", "groprrrpo", "ppoggropop", "yryyorr"
        })));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        String[] wordsContainer;

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            this.wordsContainer = wordsContainer;
            int n = wordsQuery.length;
            int[] ans = new int[n];
            TrieNode root = new TrieNode();
            // 兜底的最短的字符串
            int min = 0;
            for (int i = wordsContainer.length - 1; i >= 0; i--) {
                insert(root, wordsContainer[i], i);
                if (wordsContainer[i].length() <= wordsContainer[min].length()) {
                    min = i;
                }
            }

            for (int i = 0; i < n; i++) {
                int index = search(root, wordsQuery[i]);
                ans[i] = index == Integer.MAX_VALUE ? min : index;
            }

            return ans;
        }


        static class TrieNode {
            TrieNode[] child = new TrieNode[26];

            // 维护一个最小长度的最小索引
            int index = Integer.MAX_VALUE;

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
        public void insert(TrieNode root, String word, int index) {
            TrieNode trie = root;
            char[] chars = word.toCharArray();

            for (int i = chars.length - 1; i >= 0; i--) {
                char c = chars[i];
                trie = trie.getChildAdd(c);
                // 维护一个最小长度的最小索引
                if (trie.index == Integer.MAX_VALUE) {
                    trie.index = index;
                } else {
                    if (wordsContainer[trie.index].length() == wordsContainer[index].length()) {
                        trie.index = Math.min(trie.index, index);
                    } else if (wordsContainer[trie.index].length() > wordsContainer[index].length()) {
                        trie.index = index;
                    }
                }

            }

        }

        public int search(TrieNode root, String word) {
            TrieNode trie = root;
            char[] chars = word.toCharArray();
            for (int i = chars.length - 1; i >= 0; i--) {
                char c = chars[i];
                if (trie.child[c - 'a'] == null) {
                    // 到这就可以了
                    return trie.index;
                }
                trie = trie.child[c - 'a'];
            }
            // 判断可以是结尾
            return trie.index;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}