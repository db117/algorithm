


//你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。由垂直、水平或对角连接的水域为池塘。池塘的大小是指
//相连接的水域的个数。编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。 
// 示例： 
// 输入：
//[
//  [0,2,1,0],
//  [0,1,0,1],
//  [1,1,0,1],
//  [0,1,0,1]
//]
//输出： [1,2,4]
// 
// 提示： 
// 
// 0 < len(land) <= 1000 
// 0 < len(land[i]) <= 1000 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 136 👎 0


package cn.db117.leetcode.interview;

import java.util.ArrayList;

/**
 * 面试题 16.19.水域大小.pond-sizes-lcci
 *
 * @author db117
 * @since 2023-06-22 22:00:11
 **/

public class Interview_1619 {
    public static void main(String[] args) {
        Solution solution = new Interview_1619().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] pondSizes(int[][] land) {
            int m = land.length, n = land[0].length;
            var ans = new ArrayList<Integer>();
            for (int i = 0; i < m; i++)
                for (int j = 0; j < n; j++)
                    if (land[i][j] == 0) // 从没有访问过的 0 出发
                        ans.add(dfs(land, i, j));


            return ans.stream().sorted().mapToInt(i -> i).toArray();
        }

        private int dfs(int[][] land, int x, int y) {
            if (x < 0 || x >= land.length || y < 0 || y >= land[x].length || land[x][y] != 0)
                return 0;
            land[x][y] = 1; // 标记 (x,y) 被访问，避免重复访问
            int cnt0 = 1;
            // 访问八方向的 0
            for (int i = x - 1; i <= x + 1; i++)
                for (int j = y - 1; j <= y + 1; j++)
                    cnt0 += dfs(land, i, j);
            return cnt0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}