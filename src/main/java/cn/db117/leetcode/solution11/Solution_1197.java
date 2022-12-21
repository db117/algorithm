

//一个坐标可以从 -infinity 延伸到 +infinity 的 无限大的 棋盘上，你的 骑士 驻扎在坐标为 [0, 0] 的方格里。 
//
// 骑士的走法和中国象棋中的马相似，走 “日” 字：即先向左（或右）走 1 格，再向上（或下）走 2 格；或先向左（或右）走 2 格，再向上（或下）走 1 格
//。 
//
// 每次移动，他都可以按图示八个方向之一前进。 
//
// 
//
// 返回 骑士前去征服坐标为 [x, y] 的部落所需的最小移动次数 。本题确保答案是一定存在的。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2, y = 1
//输出：1
//解释：[0, 0] → [2, 1]
// 
//
// 示例 2： 
//
// 
//输入：x = 5, y = 5
//输出：4
//解释：[0, 0] → [2, 1] → [4, 2] → [3, 4] → [5, 5]
// 
//
// 
//
// 提示： 
//
// 
// -300 <= x, y <= 300 
// 0 <= |x| + |y| <= 300 
// 
//
// Related Topics 广度优先搜索 👍 83 👎 0


package cn.db117.leetcode.solution11;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 1197.进击的骑士.minimum-knight-moves
 *
 * @author db117
 * @since 2022-12-20 11:34:38
 **/

public class Solution_1197 {
    public static void main(String[] args) {
        Solution solution = new Solution_1197().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int mov[][] = {{-2, 1}, {2, 1}, {2, -1}, {-2, -1},
                {1, -2}, {1, 2}, {-1, 2}, {-1, -2}};


        public int minKnightMoves(int x, int y) {
            // 避免负数,所有点加 400
            int end = (x + 400) * 1000 + y + 400;
            int begin = 400 * 1000 + 400;
            if (begin == end) {
                return 0;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> set = new HashSet<>();
            queue.add(begin);
            set.add(begin);

            int ans = 0;
            while (!queue.isEmpty()) {
                ans++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    Integer poll = queue.poll();
                    int curX = poll / 1000;
                    int curY = poll % 1000;
                    for (int[] m : mov) {
                        int nx = curX + m[0];
                        int ny = curY + m[1];
                        // 稍微支剪一下
                        if (nx < 95 || ny < 95 || nx > 705 || ny > 705) {
                            continue;
                        }
                        int ni = nx * 1000 + ny;
                        if (ni == end) {
                            return ans;
                        }
                        if (set.add(ni)) {
                            queue.add(ni);
                        }
                    }
                }
            }
            return -1;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}