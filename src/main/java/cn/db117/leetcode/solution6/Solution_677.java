


//实现一个 MapSum 类，支持两个方法，insert 和 sum： 
//
// 
// MapSum() 初始化 MapSum 对象 
// void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 ke
//y 已经存在，那么原来的键值对将被替代成新的键值对。 
// int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["MapSum", "insert", "sum", "insert", "sum"]
//[[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
//输出：
//[null, null, 3, null, 5]
//
//解释：
//MapSum mapSum = new MapSum();
//mapSum.insert("apple", 3);  
//mapSum.sum("ap");           // return 3 (apple = 3)
//mapSum.insert("app", 2);    
//mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
// 
//
// 
//
// 提示： 
//
// 
// 1 <= key.length, prefix.length <= 50 
// key 和 prefix 仅由小写英文字母组成 
// 1 <= val <= 1000 
// 最多调用 50 次 insert 和 sum 
// 
// Related Topics 设计 字典树 哈希表 字符串 
// 👍 88 👎 0


package cn.db117.leetcode.solution6;

import java.util.HashMap;
import java.util.Map;

/**
 * 677.键值映射.map-sum-pairs
 *
 * @author db117
 * @since 2021-07-01 15:27:21
 **/

public class Solution_677 {
    public static void main(String[] args) {
        MapSum mapSum = new Solution_677().new MapSum();

//        mapSum.insert("apple", 3);
//        System.out.println(mapSum.sum("ap"));
//        mapSum.insert("apple", 1);
//        mapSum.insert("app", 2);
//        System.out.println(mapSum.sum("ap"));

        // ["MapSum", "insert", "sum", "insert", "sum"]
        //[[], ["a",3], ["ap"], ["b",2], ["a"]]
        mapSum.insert("a", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("b", 2);
        System.out.println(mapSum.sum("a"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {
        Map<String, Integer> old = new HashMap<>();
        Trie[] root = new Trie[26];

        /**
         * Initialize your data structure here.
         */
        public MapSum() {

        }

        public void insert(String key, int val) {
            if (old.containsKey(key)) {
                // 已经存在需要减去老的值
                build(root, key, -old.get(key));
            }
            old.put(key, val);
            build(root, key, val);
        }

        public int sum(String prefix) {
            return find(root, prefix);
        }

        // 构建字典树
        public void build(Trie[] root, String key, int val) {
            char[] chars = key.toCharArray();
            Trie cur;
            for (char c : chars) {
                int index = c - 'a';
                if (root[index] == null) {
                    root[index] = new Trie();
                }
                cur = root[index];
                cur.c = c;
                cur.sum += val;

                root = cur.child;
            }
        }

        public int find(Trie[] root, String search) {
            char[] chars = search.toCharArray();

            Trie cur = null;
            for (char c : chars) {
                int index = c - 'a';
                if (root[index] == null) {
                    // 找不到
                    return 0;
                }
                cur = root[index];
                root = cur.child;
            }

            return cur == null ? 0 : cur.sum;
        }

        public class Trie {
            char c;
            int sum;
            Trie[] child = new Trie[26];
        }
    }

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}