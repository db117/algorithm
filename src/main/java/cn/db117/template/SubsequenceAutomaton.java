package cn.db117.template;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * 子序列自动机
 *
 * @author db117
 * @since 2022/12/10
 */
public class SubsequenceAutomaton {
    /**
     * 存每一个字符出现的位置
     */
    List<Integer>[] arr = new ArrayList[26];

    public static void main(String[] args) {
        SubsequenceAutomaton automaton = new SubsequenceAutomaton();

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
