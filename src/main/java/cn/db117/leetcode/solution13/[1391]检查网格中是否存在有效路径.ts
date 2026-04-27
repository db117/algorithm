//给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是： 
//
// 
// 1 表示连接左单元格和右单元格的街道。 
// 2 表示连接上单元格和下单元格的街道。 
// 3 表示连接左单元格和下单元格的街道。 
// 4 表示连接右单元格和下单元格的街道。 
// 5 表示连接左单元格和上单元格的街道。 
// 6 表示连接右单元格和上单元格的街道。 
// 
//
// 
//
// 你最开始从左上角的单元格 (0,0) 开始出发，网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径
//。该路径必须只沿着街道走。 
//
// 注意：你 不能 变更街道。 
//
// 如果网格中存在有效的路径，则返回 true，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：grid = [[2,4,3],[6,5,2]]
//输出：true
//解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
// 
//
// 示例 2： 
//
// 
//
// 输入：grid = [[1,2,1],[1,2,1]]
//输出：false
//解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
// 
//
// 示例 3： 
//
// 输入：grid = [[1,1,2]]
//输出：false
//解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
// 
//
// 示例 4： 
//
// 输入：grid = [[1,1,1,1,1,1,3]]
//输出：true
// 
//
// 示例 5： 
//
// 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// 1 <= grid[i][j] <= 6 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
const DIRS = [
    [],
    [[0, -1], [0, 1]],  // 站在街道 1，可以往左或者往右
    [[-1, 0], [1, 0]],  // 站在街道 2，可以往上或者往下
    [[0, -1], [1, 0]],  // 站在街道 3，可以往左或者往下
    [[0, 1], [1, 0]],   // 站在街道 4，可以往右或者往下
    [[0, -1], [-1, 0]], // 站在街道 5，可以往左或者往上
    [[0, 1], [-1, 0]],  // 站在街道 6，可以往右或者往上
];

function contain(street: number, dx: number, dy: number) {
    return DIRS[street].some(dir => dir[0] === dx && dir[1] === dy);
}

function hasValidPath(grid: number[][]): boolean {
    const m = grid.length;
    const n = grid[0].length;
    // 创建一个二维数组，用于记录是否访问过
    const visited: boolean[][] = new Array(m).fill(0).map(() => new Array(n).fill(false));


    function dfs(x: number, y: number): boolean {
        if (x < 0 || x >= m || y < 0 || y >= n) {
            return false;
        }
        if (visited[x][y]) {
            return false;
        }

        if (x === m - 1 && y === n - 1) {
            return true;
        }
        visited[x][y] = true;

        for (const [dx, dy] of DIRS[grid[x][y]]) {
            const nx = x + dx
            const ny = y + dy
            if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                continue
            }
            // 检查下一个位置能不能走回来，不能就说明路不通
            if (contain(grid[nx][ny], -dx, -dy)) {
                if (dfs(nx, ny)) {
                    return true;
                }
            }
        }
        return false
    }

    return dfs(0, 0);
};
//leetcode submit region end(Prohibit modification and deletion)

console.log(hasValidPath([[2, 4, 3], [6, 5, 2]]))
console.log(hasValidPath([[1, 2, 1], [1, 2, 1]]))
console.log(hasValidPath([[1, 1, 2]]))
console.log(hasValidPath([[1, 1, 1, 1, 1, 1, 3]]))
console.log(hasValidPath([[2], [2], [2], [2], [2], [2], [6]]))
