

//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 1 <= low <= high <= 2 * 10⁴ 
// 
//
// Related Topics 位运算 字典树 数组 👍 115 👎 0


package cn.db117.leetcode.solution18;

/**
 * 1803.统计异或值在范围内的数对有多少.count-pairs-with-xor-in-a-range
 *
 * @author db117
 * @since 2023-01-05 14:52:05
 **/

public class Solution_1803 {
    public static void main(String[] args) {
        // nums =
        //[9,8,4,2,1]
        //low =
        //5
        //high =
        //14

        // - (0, 2): nums[0] XOR nums[2] = 13
        //    - (0, 3): nums[0] XOR nums[3] = 11
        //    - (0, 4): nums[0] XOR nums[4] = 8
        //    - (1, 2): nums[1] XOR nums[2] = 12
        //    - (1, 3): nums[1] XOR nums[3] = 10
        //    - (1, 4): nums[1] XOR nums[4] = 9
        //    - (2, 3): nums[2] XOR nums[3] = 6
        //    - (2, 4): nums[2] XOR nums[4] = 5

        Solution solution = new Solution_1803().new Solution();
        System.out.println(solution.countPairs(new int[]{9, 8, 4, 2, 1}, 5, 14));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 最高位的二进制位编号为 14
        private static final int HIGH_BIT = 14;
        private final Trie root = new Trie();

        public int countPairs(int[] nums, int low, int high) {
            int ans = 0;
            for (int num : nums) {
                // {所有和 num 异或小于 high+1 的数量} - {和 num 异或小于 low 的数量}
                ans += search(num, high + 1) - search(num, low);
                insert(num);
            }
            return ans;
        }

        /**
         * 搜索和 num 异或后小于 limit 的数量
         *
         * @param num   num
         * @param limit 限制
         * @return int
         */
        public int search(int num, int limit) {
            Trie cur = root;
            int ans = 0;
            for (int i = HIGH_BIT; i >= 0 && cur != null; i--) {
                int bit = (num >> i) & 1;
                if ((limit >> i & 1) == 1) {
                    // limit 当前位为 1 ,则当前位异或后为 0 时小于 limit
                    if (cur.child[bit] != null) {
                        ans += cur.child[bit].count;
                    }

                    // 继续找等于 limit 的
                    cur = cur.child[bit ^ 1];
                } else {
                    // limit 当前位为 0 时,异或后的值肯定不会小于 limit
                    // 可以对当前在等于 limit 的继续找
                    cur = cur.child[bit];
                }
            }
            return ans;
        }

        /**
         * 插入
         */
        public void insert(int num) {
            Trie cur = root;
            for (int i = HIGH_BIT; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (cur.child[bit] == null) {
                    cur.child[bit] = new Trie();
                }
                cur = cur.child[bit];
                cur.count++;
            }
        }

        class Trie {
            Trie[] child = new Trie[2];
            int count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}