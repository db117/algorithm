package cn.db117.template.TreeArray;

/**
 * 树状数组
 *
 * @author db117
 * @since 2022/9/29 18:18
 **/
public class TreeArraySum {
    // 下标从 1 开始
    int[] tree;

    public TreeArraySum(int n) {
        tree = new int[n + 7];
    }

    public TreeArraySum(int[] nums) {
        tree = new int[nums.length + 10];
        for (int i = 0; i < nums.length; i++) {
            add(i + 1, nums[i]);
        }
    }

    /**
     * 最后一个 1
     */
    public int lowBit(int i) {
        return i & -i;
    }

    /**
     * 在指定位置添加值
     *
     * @param x 数组位置(从 1 开始)
     * @param v 增加的值
     */
    public void add(int x, int v) {
        for (int i = x; i < tree.length; i += lowBit(i)) {
            tree[i] += v;
        }
    }

    /**
     * 查询[1,x]的和
     *
     * @param x 数组位置(从 1 开始)
     */
    public int query(int x) {
        int ans = 0;
        for (int i = x; i > 0; i -= lowBit(i)) {
            ans += tree[i];
        }
        return ans;
    }

}
