

//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
//
// Related Topics 字典树 👍 629 👎 0


package cn.db117.leetcode.solution4;

/**
 * 440.字典序的第K小数字.k-th-smallest-in-lexicographical-order
 *
 * @author db117
 * @since 2025-06-09 18:56:17
 **/

public class Solution_440 {
    public static void main(String[] args) {
        Solution solution = new Solution_440().new Solution();
        // 10
        //	3
        System.out.println(solution.findKthNumber(10, 3));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            // 想象成十一叉数，根节点是0
            // 第一层未 1-9
            // 第一层下面全都是在上一层的基础上加（0-9）
            int node = 1;
            k--;// 减去根节点
            while (k > 0) {
                long size = countNodeSize(n, node);
                if (size <= k) {// 不在当前结点，需要往后面找
                    node++;// 继续兄弟节点
                    k -= (int) size;// 跳过当前节点以及其子节点
                } else {
                    node *= 10;// 继续下一层
                    k--;// 减去当前结点
                }
            }
            return node;
        }


        long countNodeSize(int n, int node) {
            long res = 0;
            long left = node;
            long right = node + 1;// 节点的右边界（不包含）
            while (left <= n) {// 可能这一层就这个一个结点
                res += Math.min(n + 1, right) - left;// 节点的实际右边界不能超过 n
                // 继续下一层
                left *= 10;
                right *= 10;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}