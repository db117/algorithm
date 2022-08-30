

//现有一种使用英语字母的火星语言，这门语言的字母顺序与英语顺序不同。 
//
// 给你一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 243 👎 0


package cn.db117.leetcode.solution2;

import cn.db117.leetcode.util.Pair;
import cn.db117.template.TopologicalSort;

import java.util.*;

/**
 * 269.火星词典.alien-dictionary
 *
 * @author db117
 * @see TopologicalSort
 * @since 2022-08-29 18:58:59
 **/

public class Solution_269 {
    public static void main(String[] args) {
        Solution solution = new Solution_269().new Solution();
        System.out.println(solution.alienOrder(new String[]{"ac", "ab", "zc", "zb"}));
        System.out.println(solution.alienOrder(new String[]{"abc", "ab"}));
        System.out.println(solution.alienOrder(new String[]{"z", "x", "a", "zb", "zx"}));
        System.out.println(solution.alienOrder(new String[]{"aba"}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            Set<Character> allChar = new HashSet<>();
            List<Pair<Character, Character>> args = new ArrayList<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    allChar.add(c);
                }
            }
            for (int i = 1; i < words.length; i++) {
                char[] pre = words[i - 1].toCharArray();
                char[] cur = words[i].toCharArray();
                int index = 0;
                while (index < pre.length || index < cur.length) {
                    if (cur.length == index) {
                        // 字典序异常,如 abc 不能再 ab 前面
                        return "";
                    }
                    if (pre.length == index) {
                        break;
                    }
                    if (pre[index] == cur[index]) {
                        index++;
                        continue;
                    }
                    args.add(new Pair<>(pre[index], cur[index]));
                    break;
                }
            }

            // 拓扑排序
            List<Character> sort = sort(allChar, args);
            if (sort.size() != allChar.size()) {
                // 有环
                return "";
            }
            StringBuilder b = new StringBuilder();
            for (Character c : sort) {
                b.append(c);
            }

            return b.toString();
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
//leetcode submit region end(Prohibit modification and deletion)

}