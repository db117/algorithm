

//你被给定一个 m × n 的二维网格 rooms ，网格中有以下三种可能的初始化值： 
//
// 
// -1 表示墙或是障碍物 
// 0 表示一扇门 
// INF 无限表示一个空的房间。然后，我们用 2³¹ - 1 = 2147483647 代表 INF。你可以认为通往门的距离总是小于 2147483647 
//的。 
// 
//
// 你要给每个空房间位上填上该房间到 最近门的距离 ，如果无法到达门，则填 INF 即可。 
//
// 
//
// 示例 1： 
// 
// 
//输入：rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1]
//,[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
//输出：[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
// 
//
// 示例 2： 
//
// 
//输入：rooms = [[-1]]
//输出：[[-1]]
// 
//
// 示例 3： 
//
// 
//输入：rooms = [[2147483647]]
//输出：[[2147483647]]
// 
//
// 示例 4： 
//
// 
//输入：rooms = [[0]]
//输出：[[0]]
// 
//
// 
//
// 提示： 
//
// 
// m == rooms.length 
// n == rooms[i].length 
// 1 <= m, n <= 250 
// rooms[i][j] 是 -1、0 或 2³¹ - 1 
// 
//
// Related Topics 广度优先搜索 数组 矩阵 👍 240 👎 0


package cn.db117.leetcode.solution2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 286.墙与门.walls-and-gates
 *
 * @author db117
 * @since 2023-04-26 10:26:32
 **/

public class Solution_286 {
    public static void main(String[] args) {
        Solution solution = new Solution_286().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private final static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int base = 1000;

        public void wallsAndGates(int[][] rooms) {
            int m = rooms.length;
            int n = rooms[0].length;

            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (rooms[i][j] == 0) {
                        // 每一个们进行异常 bfs
                        Set<Integer> set = new HashSet<>();
                        set.add(i * base + j);
                        queue.add(i * base + j);
                        int deep = 0;
                        while (!queue.isEmpty()) {
                            int size = queue.size();

                            for (int k = 0; k < size; k++) {
                                Integer poll = queue.poll();
                                int x = poll / base;
                                int y = poll % base;
                                rooms[x][y] = Math.min(rooms[x][y], deep);
                                for (int[] dir : dirs) {
                                    int nextX = x + dir[0];
                                    int nextY = y + dir[1];
                                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                                        continue;
                                    }
                                    if (rooms[nextX][nextY] <= 0) {
                                        // 们或者墙要跳过
                                        continue;
                                    }
                                    if (set.add(nextX * base + nextY)) {
                                        // 不走回头路
                                        queue.offer(nextX * base + nextY);
                                    }
                                }
                            }
                            deep++;
                        }
                    }
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}