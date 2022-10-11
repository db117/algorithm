

//n 个灯泡排成一行，编号从 1 到
// n 。最初，所有灯泡都关闭。每天 只打开一个 灯泡，直到
// n 天后所有灯泡都打开。 
//
// 给你一个长度为
// n 的灯泡数组 blubs ，其中 bulls[i] = x 意味着在第 (i+1) 天，我们会把在位置 x 的灯泡打开，其中 i 从 0 开始，x 从 
//1 开始。 
//
// 给你一个整数
// k ，请返回恰好有两个打开的灯泡，且它们中间 正好 有
// k 个 全部关闭的 灯泡的 最小的天数 。如果不存在这种情况，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：
//bulbs = [1,3,2]，k = 1
//输出：2
//解释：
//第一天 bulbs[0] = 1，打开第一个灯泡 [1,0,0]
//第二天 bulbs[1] = 3，打开第三个灯泡 [1,0,1]
//第三天 bulbs[2] = 2，打开第二个灯泡 [1,1,1]
//返回2，因为在第二天，两个打开的灯泡之间恰好有一个关闭的灯泡。
// 
//
// 示例 2： 
//
// 
//输入：bulbs = [1,2,3]，k = 1
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == bulbs.length 
// 1 <= n <= 2 * 10⁴ 
// 1 <= bulbs[i] <= n 
// bulbs 是一个由从 1 到 n 的数字构成的排列 
// 0 <= k <= 2 * 10⁴ 
// 
//
// Related Topics 树状数组 数组 有序集合 滑动窗口 👍 75 👎 0


package cn.db117.leetcode.solution6;

/**
 * 683.K 个关闭的灯泡.k-empty-slots
 *
 * @author db117
 * @since 2022-10-11 17:07:25
 **/

public class Solution_683 {
    public static void main(String[] args) {
        Solution solution = new Solution_683().new Solution();
        // [10,1,9,3,5,7,6,4,8,2]
        //8
        // 2
        System.out.println(solution.kEmptySlots(new int[]{10, 1, 9, 3, 5, 7, 6, 4, 8, 2}, 8));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int kEmptySlots(int[] bulbs, int k) {
            // 亮灯的地方
            boolean[] light = new boolean[bulbs.length + 1];
            // 树状数组
            tree = new int[bulbs.length + 10];
            for (int i = 0; i < bulbs.length; i++) {
                // 亮灯位置
                int curIndex = bulbs[i];
                int preIndex = curIndex - 1 - k;
                int postIndex = curIndex + 1 + k;

                // 亮灯
                add(curIndex, 1);
                light[curIndex] = true;

                // [1,cur] 一共有多少个等亮了
                int curSum = query(curIndex);
                if (preIndex > 0 && light[preIndex]) {
                    int preSum = query(preIndex);
                    if (preSum + 1 == curSum) {
                        // 两个地方都亮了,而且中间有 k 个没有亮
                        return i + 1;
                    }
                }

                if (postIndex <= bulbs.length && light[postIndex]) {
                    int query = query(postIndex);
                    if (query - 1 == curSum) {
                        // 两个地方都亮了,而且中间有 k 个没有亮
                        return i + 1;
                    }
                }
            }
            return -1;
        }


        int[] tree;


        /**
         * 最后一个 1
         */
        public int lowBit(int i) {
            return i & -i;
        }

        /**
         * 在指定位置添加值
         *
         * @param x 数组位置(从 1 开始)
         * @param v 增加的值
         */
        public void add(int x, int v) {
            for (int i = x; i < tree.length; i += lowBit(i)) {
                tree[i] += v;
            }
        }

        /**
         * 查询[1,x]的和
         *
         * @param x 数组位置(从 1 开始)
         */
        public int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowBit(i)) {
                ans += tree[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}