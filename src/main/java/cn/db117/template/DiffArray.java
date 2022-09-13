package cn.db117.template;

import cn.db117.leetcode.solution2.Solution_253;

import java.util.Map;
import java.util.TreeMap;

/**
 * 差分数组
 * 处理区间更新的问题
 * 可以理解为公交车上下车,车上最多多少人的问题
 *
 * @author db117
 * @see cn.db117.leetcode.solution24.Solution_2406
 * @see Solution_253
 * @since 2022/9/13 18:06
 **/
public class DiffArray {
    public int diffArray(int[][] intervals) {
        // 差分数组
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int[] interval : intervals) {
            treeMap.put(interval[0], treeMap.getOrDefault(interval[0], 0) + 1);
            treeMap.put(interval[1] + 1, treeMap.getOrDefault(interval[1] + 1, 0) - 1);
        }

        int max = 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            Integer count = entry.getValue();
            sum += count;
            max = Math.max(max, sum);
        }
        return max;
    }
}
