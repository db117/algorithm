package cn.db117.template;

import cn.db117.leetcode.solution2.Solution207;
import cn.db117.leetcode.solution2.Solution_210;
import cn.db117.leetcode.solution2.Solution_269;
import cn.db117.leetcode.solution23.Solution_2392;
import cn.db117.leetcode.util.Pair;

import java.util.*;

/**
 * 拓扑排序
 *
 * @author db117
 * @see Solution207
 * @see Solution_210
 * @see Solution_269
 * @see Solution_2392
 * @since 2022/8/29 18:15
 **/
public class TopologicalSort {
    public int[] sort(int numCourses, int[][] prerequisites) {
        // 标准拓扑排序
        // 入度
        int[] in = new int[numCourses];
        // 邻接表
        Queue<Integer>[] graph = new Queue[numCourses];

        // 构建图
        for (int[] prerequisite : prerequisites) {
            int form = prerequisite[0];
            int to = prerequisite[1];

            in[to]++;

            if (graph[form] == null) {
                graph[form] = new LinkedList<>();
            }
            graph[form].offer(to);
        }

        // 0 入度
        Queue<Integer> zeroIn = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (in[i] == 0) {
                zeroIn.offer(i);
            }
        }
        // 记录访问节点
        int index = 0;
        int[] ans = new int[numCourses];


        while (!zeroIn.isEmpty()) {
            Integer from = zeroIn.poll();
            // 记录访问节点
            ans[index++] = from;

            Queue<Integer> queue = graph[from];
            if (queue == null) {
                continue;
            }
            // 下一个节点入度全部减一
            while (!queue.isEmpty()) {
                Integer to = queue.poll();
                in[to]--;
                if (in[to] == 0) {
                    // 下一个节点入度为 0 入队
                    zeroIn.offer(to);
                }
            }
        }
        if (index != numCourses) {
            // 有环
            return new int[0];
        }
        return ans;
    }

    /**
     * 对象形式的拓扑排序
     *
     * @param allElement 所有元素
     * @param args       排序规则
     */
    public <T> List<T> sort(Set<T> allElement, List<Pair<T, T>> args) {
        // 入度
        Map<T, Set<T>> in = new HashMap<>();
        // 邻接表
        Map<T, Set<T>> graph = new HashMap<>();

        // 构建图
        for (Pair<T, T> pair : args) {
            T from = pair.getKey();
            T to = pair.getValue();

            // 入度+1
            in.putIfAbsent(to, new HashSet<>());
            in.get(to).add(from);

            graph.putIfAbsent(from, new HashSet<>());
            graph.get(from).add(to);
        }

        // 找 0 入度的
        Queue<T> zeroIn = new LinkedList<>();
        for (T o : allElement) {
            if (in.get(o) == null) {
                zeroIn.offer(o);
            }
        }

        List<T> ans = new ArrayList<>(allElement.size());
        while (!zeroIn.isEmpty()) {
            int size = zeroIn.size();
            for (int i = 0; i < size; i++) {
                T cur = zeroIn.poll();
                // 加入队列
                ans.add(cur);
                Set<T> list = graph.get(cur);
                if (list == null) {
                    continue;
                }

                for (T next : list) {
                    // 入度-1
                    in.get(next).remove(cur);
                    if (in.get(next).isEmpty()) {
                        // 入队为 0 加入队列
                        zeroIn.offer(next);
                    }
                }
            }
        }
        return ans;
    }
}


