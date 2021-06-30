// 一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意： 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 
//
// 示例 1： 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2： 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3： 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// Related Topics 广度优先搜索 哈希表 字符串 
// 👍 78 👎 0


package cn.db117.leetcode.solution4;

import java.util.*;

/**
 * 433.最小基因变化.minimum-genetic-mutation
 *
 * @author db117
 * @since 2021-06-30 15:31:56
 **/

public class Solution_433 {
    public static void main(String[] args) {
        Solution solution = new Solution_433().new Solution();

        System.out.println(solution.minMutation("AACCGGTT", "AAACGGTA", new String[]{
                "AACCGATT", "AACCGATA", "AAACGATA", "AAACGGTA"
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minMutation(String start, String end, String[] bank) {
            // "A", "C", "G", "T"
            char[] arr = new char[]{'A', 'C', 'G', 'T'};
            // 基因库
            Set<String> set = new HashSet<>(Arrays.asList(bank));

            if (!set.contains(end)) {
                return -1;
            }
            // 已经出现过的
            Set<String> has = new HashSet<>();
            has.add(start);

            Queue<String> queue = new LinkedList<>();
            queue.offer(start);

            int res = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String poll = queue.poll();

                    if (end.equals(poll)) {
                        // 找到了
                        return res;
                    }

                    // 遍历所有能变成的基因
                    char[] chars = poll.toCharArray();
                    for (int j = 0; j < 8; j++) {

                        char tmp = chars[j];

                        for (char c : arr) {
                            if (c == chars[j]) {
                                continue;
                            }

                            chars[j] = c;

                            String next = new String(chars);
                            if (next.equals(end)) {
                                return res + 1;
                            }
                            if (set.contains(next) && !has.contains(next)) {
                                // 在库里面
                                queue.offer(next);
                                has.add(next);
                            }
                            // 复位,继续找下一个不同位置
                            chars[j] = tmp;
                        }


                    }
                }
                res++;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}