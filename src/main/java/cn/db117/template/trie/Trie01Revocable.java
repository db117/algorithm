package cn.db117.template.trie;

/**
 * 01 字典树
 * 01-trie 高位到低位,查询和某个数字异或后小于 N 的数量
 * 可以撤销
 *
 * @author zhangdb3
 * @date 2023/01/05
 */
public class Trie01Revocable {
    // 最高位的二进制位
    private static final int HIGH_BIT = 19;
    // 字典树的根节点
    private final Node root = new Node();

    /**
     * num最大异或值
     */
    public int maxXor(int num) {
        Node cur = root;
        int ans = 0;
        for (int i = HIGH_BIT; i >= 0 && cur != null; i--) {
            int bit = (num >> i) & 1;
            if (cur.child[bit ^ 1] != null &&
                    cur.child[bit ^ 1].count > 0) {// 子节点的数量大于 0(等于0相当于删除了)
                // 有相反的,异或后为 1
                ans |= 1 << i;
                cur = cur.child[bit ^ 1];
            } else {
                // 没有相反的,异或后为 0
                cur = cur.child[bit];
            }
        }
        return ans;
    }


    public void insert(int num) {
        Node cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (cur.child[bit] == null) {
                cur.child[bit] = new Node();
            }
            cur = cur.child[bit];
            cur.count++;
        }
    }

    public void remove(int num) {
        Node cur = root;
        for (int i = HIGH_BIT; i >= 0; i--) {
            int bit = (num >> i) & 1;
            cur = cur.child[bit];
            cur.count--;
        }
    }

    static class Node {
        Node[] child = new Node[2];
        int count;// 当前子树的数量
    }

}
