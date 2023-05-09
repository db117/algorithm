

//在一个社交圈子当中，有 n 个人。每个人都有一个从 0 到 n - 1 的唯一编号。我们有一份日志列表 logs，其中 logs[i] = [
//timestampi, xi, yi] 表示 xi 和 yi 将在同一时间 timestampi 成为朋友。 
//
// 友谊是 相互 的。也就是说，如果 a 和 b 是朋友，那么 b 和 a 也是朋友。同样，如果 a 和 b 是朋友，或者 a 是 b 朋友的朋友 ，那么 
//a 和 b 是熟识友。 
//
// 返回圈子里所有人之间都熟识的最早时间。如果找不到最早时间，就返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[201902
//24,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
//输出：20190301
//解释：
//第一次结交发生在 timestamp = 20190101，0 和 1 成为好友，社交朋友圈如下 [0,1], [2], [3], [4], [5]。
//第二次结交发生在 timestamp = 20190104，3 和 4 成为好友，社交朋友圈如下 [0,1], [2], [3,4], [5].
//第三次结交发生在 timestamp = 20190107，2 和 3 成为好友，社交朋友圈如下 [0,1], [2,3,4], [5].
//第四次结交发生在 timestamp = 20190211，1 和 5 成为好友，社交朋友圈如下 [0,1,5], [2,3,4].
//第五次结交发生在 timestamp = 20190224，2 和 4 已经是好友了。
//第六次结交发生在 timestamp = 20190301，0 和 3 成为好友，大家都互相熟识了。
// 
//
// 示例 2: 
//
// 
//输入: logs = [[0,2,0],[1,0,1],[3,0,3],[4,1,2],[7,3,1]], n = 4
//输出: 3
// 
//
// 
//
// 提示： 
//
// 
// 2 <= n <= 100 
// 1 <= logs.length <= 10⁴ 
// logs[i].length == 3 
// 0 <= timestampi <= 10⁹ 
// 0 <= xi, yi <= n - 1 
// xi != yi 
// timestampi 中的所有时间戳 均不同 
// 所有的对 (xi, yi) 在输入中最多出现一次 
// 
//
// Related Topics 并查集 数组 👍 35 👎 0


package cn.db117.leetcode.solution11;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1101.彼此熟识的最早时间.the-earliest-moment-when-everyone-become-friends
 *
 * @author db117
 * @since 2023-05-09 17:37:04
 **/

public class Solution_1101 {
    public static void main(String[] args) {
        Solution solution = new Solution_1101().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int earliestAcq(int[][] logs, int n) {
            Arrays.sort(logs, Comparator.comparingInt(o -> o[0]));
            UnionFind uf = new UnionFind(n);
            for (int[] log : logs) {
                uf.union(log[1], log[2]);
                if (uf.count == 1) {
                    return log[0];
                }
            }
            return -1;
        }

        public class UnionFind {
            // 连通分量
            int count;
            // 父节点
            int[] parent;

            public UnionFind(int n) {
                count = n;
                parent = new int[n];

                // 初始父节点都是自己
                for (int i = 0; i < parent.length; i++) {
                    parent[i] = i;
                }
            }

            public void union(int x, int y) {
                int xp = find(x);
                int yp = find(y);
                if (xp == yp) {
                    return;
                }
                if (xp < yp) {
                    parent[yp] = xp;
                } else {
                    parent[xp] = yp;
                }
                // 连通分量
                count--;
            }

            public int find(int n) {
                while (parent[n] != n) {
                    // 路径压缩
                    parent[n] = parent[parent[n]];
                    n = parent[n];
                }
                return n;
            }

            public boolean connected(int x, int y) {
                return find(y) == find(x);
            }

            public int count() {
                return count;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}