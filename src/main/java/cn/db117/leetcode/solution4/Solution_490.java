

//由空地（用 0 表示）和墙（用 1 表示）组成的迷宫 maze 中有一个球。球可以途经空地向 上、下、左、右 四个方向滚动，且在遇到墙壁前不会停止滚动。当球
//停下时，可以选择向下一个方向滚动。
//
// 
// 
// 
// 给你一个大小为 m x n 的迷宫 maze ，以及球的初始位置 start 和目的地 destination ，其中 start = [
//startrow, startcol] 且 destination = [destinationrow, destinationcol] 。请你判断球能否在目的地停下：如果可以
//，返回 true ；否则，返回 false 。 
// 
// 
// 
//
// 你可以 假定迷宫的边缘都是墙壁（参考示例）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], 
//start = [0,4], destination = [4,4]
//输出：true
//解释：一种可能的路径是 : 左 -> 下 -> 左 -> 下 -> 右 -> 下 -> 右。
// 
//
// 示例 2： 
// 
// 
//输入：maze = [[0,0,1,0,0],[0,0,0,0,0],[0,0,0,1,0],[1,1,0,1,1],[0,0,0,0,0]], 
//start = [0,4], destination = [3,2]
//输出：false
//解释：不存在能够使球停在目的地的路径。注意，球可以经过目的地，但无法在那里停驻。
// 
//
// 示例 3： 
//
// 
//输入：maze = [[0,0,0,0,0],[1,1,0,0,1],[0,0,0,0,0],[0,1,0,0,1],[0,1,0,0,0]], 
//start = [4,3], destination = [0,1]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == maze.length 
// n == maze[i].length 
// 1 <= m, n <= 100 
// maze[i][j] is 0 or 1. 
// start.length == 2 
// destination.length == 2 
// 0 <= startrow, destinationrow <= m 
// 0 <= startcol, destinationcol <= n 
// 球和目的地都在空地上，且初始时它们不在同一位置 
// 迷宫 至少包括 2 块空地 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 数组 矩阵 👍 181 👎 0


package cn.db117.leetcode.solution4;

/**
 * 490.迷宫.the-maze
 *
 * @author db117
 * @since 2024-03-23 15:51:31
 **/

public class Solution_490 {
    public static void main(String[] args) {
        Solution solution = new Solution_490().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    public class Solution {
        public boolean hasPath(int[][] maze, int[] start, int[] destination) {
            boolean[][] visited = new boolean[maze.length][maze[0].length];
            return dfs(maze, start, destination, visited);
        }

        public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
            if (visited[start[0]][start[1]]) {
                // 已经访问过
                return false;
            }
            if (start[0] == destination[0] && start[1] == destination[1]) {
                // 到达目的地
                return true;
            }
            visited[start[0]][start[1]] = true;
            // 向四个方向走
            int r = start[1] + 1, l = start[1] - 1, u = start[0] - 1, d = start[0] + 1;
            while (r < maze[0].length && maze[start[0]][r] == 0) { // right
                r++;
            }
            if (dfs(maze, new int[]{start[0], r - 1}, destination, visited)) {

                return true;
            }
            while (l >= 0 && maze[start[0]][l] == 0) { //left
                l--;
            }
            if (dfs(maze, new int[]{start[0], l + 1}, destination, visited)) {

                return true;
            }
            while (u >= 0 && maze[u][start[1]] == 0) { //up
                u--;
            }
            if (dfs(maze, new int[]{u + 1, start[1]}, destination, visited)) {

                return true;
            }
            while (d < maze.length && maze[d][start[1]] == 0) { //down
                d++;
            }
            if (dfs(maze, new int[]{d - 1, start[1]}, destination, visited)) {
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}