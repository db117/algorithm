package cn.db117.template.trie;

/**
 * 01 字典树
 * 01-trie 高位到低位,查询和某个数字异或后小于 N 的数量
 *
 * @author zhangdb3
 * @date 2023/01/05
 */
public class Trie01High {
    // 最高位的二进制位编号为 14
    private static final int HIGH_BIT = 14;
    // 字典树的根节点
    private final Trie root = new Trie();

    /**
     * 搜索和 num 异或后小于 limit 的数量
     *
     * @param num   num
     * @param limit 限制
     * @return int
     */
    public int search(int num, int limit) {
        Trie cur = root;
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0 && cur != null; i--) {
            int bit = (num >> i) & 1;
            if ((limit >> i & 1) == 1) {
                // limit 当前位为 1 ,则当前位异或后为 0 时小于 limit
                if (cur.child[bit] != null) {
                    ans += cur.child[bit].count;
                }

                // 继续找等于 limit 的
                cur = cur.child[bit ^ 1];
            } else {
                // limit 当前位为 0 时,异或后的值肯定不会小于 limit
                // 可以对当前在等于 limit 的继续找
                cur = cur.child[bit];
            }
        }
        return ans;
    }

    /**
     * 插入
     */
    public void insert(int num) {
        Trie cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.child[bit] == null) {
                cur.child[bit] = new Trie();
            }
            cur = cur.child[bit];
            cur.count++;
        }
    }

    class Trie {
        Trie[] child = new Trie[2];
        int count;
    }

}
