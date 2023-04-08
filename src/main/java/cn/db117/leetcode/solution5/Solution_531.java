

//给你一个大小为 m x n 的图像 picture ，图像由黑白像素组成，'B' 表示黑色像素，'W' 表示白色像素，请你统计并返回图像中 黑色 孤独像素的
//数量。 
//
// 黑色孤独像素 的定义为：如果黑色像素 'B' 所在的同一行和同一列不存在其他黑色像素，那么这个黑色像素就是黑色孤独像素。 
//
// 
//
// 示例 1： 
// 
// 
//输入：picture = [["W","W","B"],["W","B","W"],["B","W","W"]]
//输出：3
//解释：全部三个 'B' 都是黑色的孤独像素
// 
//
// 示例 2： 
// 
// 
//输入：picture = [["B","B","B"],["B","B","W"],["B","B","B"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == picture.length 
// n == picture[i].length 
// 1 <= m, n <= 500 
// picture[i][j] 为 'W' 或 'B' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 43 👎 0


package cn.db117.leetcode.solution5;

/**
 * 531.孤独像素 I.lonely-pixel-i
 *
 * @author db117
 * @since 2023-03-31 11:08:23
 **/

public class Solution_531 {
    public static void main(String[] args) {
        Solution solution = new Solution_531().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLonelyPixel(char[][] picture) {
            int m = picture.length;
            int n = picture[0].length;
            int[] rowCount = new int[m];
            int[] colCount = new int[n];
            // 记录每行，每列 B 的数量
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] == 'B') {
                        rowCount[i]++;
                        colCount[j]++;
                    }
                }
            }

            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1) {
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}