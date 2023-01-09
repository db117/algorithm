package cn.db117.template.trie;


/**
 * 字典树
 *
 * @author db117
 * @see cn.db117.leetcode.solution2.Solution208
 * @see cn.db117.leetcode.solution2.Solution_211
 * @see cn.db117.leetcode.solution6.Solution_648
 * @see cn.db117.leetcode.solution6.Solution_676
 * @see cn.db117.leetcode.solution6.Solution_677
 * @see cn.db117.leetcode.solution7.Solution_745
 * @see cn.db117.leetcode.solution24.Solution_2416
 * @since 2022/9/23 11:51
 **/
public class Trie {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        // 是否是最后一个
        boolean isEnd;

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
    public void insert(TrieNode root, String word) {
        TrieNode trie = root;
        for (char c : word.toCharArray()) {
            trie = trie.getChildAdd(c);
        }
        trie.isEnd = true;
    }

    /**
     * 查找字符串
     */
    public boolean search(TrieNode root, String word) {
        TrieNode trie = root;
        for (char c : word.toCharArray()) {
            // 获取下一级
            if (trie.get(c) == null) {
                // 没有找到说明不存在
                return false;
            }
            trie = trie.getChildAdd(c);
        }
        // 判断可以是结尾
        return trie.isEnd;
    }

    /**
     * 查找字符串节点
     */
    public TrieNode searchNode(TrieNode root, String word) {
        TrieNode trie = root;
        for (char c : word.toCharArray()) {
            // 获取下一级
            if (trie.get(c) == null) {
                return null;
            }
            trie = trie.getChildAdd(c);
        }
        return trie;
    }

    /**
     * 是否有该前缀
     */
    public boolean startsWith(TrieNode root, String prefix) {
        TrieNode trie = root;
        for (char c : prefix.toCharArray()) {
            TrieNode next = trie.get(c);
            if (next == null) {
                // 字符不存在
                return false;
            }
            trie = next;
        }
        // 找到了
        return true;

    }
}
