package cn.db117.template.TreeArray;

import java.util.Arrays;

/**
 * 树状数组
 *
 * @author db117
 * @since 2022/9/29 18:18
 **/
public class TreeArrayMax {
    // 下标从 1 开始
    long[] tree;

    public TreeArrayMax(int n) {
        tree = new long[n + 7];
        Arrays.fill(tree, Integer.MIN_VALUE);// 初始化默认值
    }


    public TreeArrayMax(int[] nums) {
        tree = new long[nums.length + 10];
        Arrays.fill(tree, Integer.MIN_VALUE);// 初始化默认值
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
    public void add(int x, long v) {
        for (int i = x; i < tree.length; i += lowBit(i)) {
            tree[i] = Math.max(tree[i], v);
        }
    }

    /**
     * 查询[1,x]的和
     *
     * @param x 数组位置(从 1 开始)
     */
    public long query(int x) {
        long ans = Integer.MIN_VALUE;
        for (int i = x; i > 0; i -= lowBit(i)) {
            ans = Math.max(ans, tree[i]);
        }
        return ans;
    }

}
