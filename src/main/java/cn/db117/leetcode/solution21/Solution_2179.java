

//给你两个下标从 0 开始且长度为 n 的整数数组 nums1 和 nums2 ，两者都是 [0, 1, ..., n - 1] 的 排列 。 
//
// 好三元组 指的是 3 个 互不相同 的值，且它们在数组 nums1 和 nums2 中出现顺序保持一致。换句话说，如果我们将 pos1v 记为值 v 在 
//nums1 中出现的位置，pos2v 为值 v 在 nums2 中的位置，那么一个好三元组定义为 0 <= x, y, z <= n - 1 ，且 pos1x 
//< pos1y < pos1z 和 pos2x < pos2y < pos2z 都成立的 (x, y, z) 。 
//
// 请你返回好三元组的 总数目 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [2,0,1,3], nums2 = [0,1,2,3]
//输出：1
//解释：
//总共有 4 个三元组 (x,y,z) 满足 pos1x < pos1y < pos1z ，分别是 (2,0,1) ，(2,0,3) ，(2,1,3) 和 (
//0,1,3) 。
//这些三元组中，只有 (0,1,3) 满足 pos2x < pos2y < pos2z 。所以只有 1 个好三元组。
// 
//
// 示例 2： 
//
// 输入：nums1 = [4,0,1,3,2], nums2 = [4,1,0,2,3]
//输出：4
//解释：总共有 4 个好三元组 (4,0,3) ，(4,0,2) ，(4,1,3) 和 (4,1,2) 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 3 <= n <= 10⁵ 
// 0 <= nums1[i], nums2[i] <= n - 1 
// nums1 和 nums2 是 [0, 1, ..., n - 1] 的排列。 
// 
//
// Related Topics 树状数组 线段树 数组 二分查找 分治 有序集合 归并排序 👍 84 👎 0


package cn.db117.leetcode.solution21;

/**
 * 2179.统计数组中好三元组数目.count-good-triplets-in-an-array
 *
 * @author db117
 * @since 2025-04-15 19:41:46
 **/

public class Solution_2179 {
    public static void main(String[] args) {
        Solution solution = new Solution_2179().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long goodTriplets(int[] nums1, int[] nums2) {
            long ans = 0;
            int n = nums1.length;

            int[] p = new int[n];// 置换出一个数组，假定nums1 是有序的，那么数字按照 p 排列那么就是符合题意的
            for (int i = 0; i < n; i++) {
                p[nums1[i]] = i;
            }

            TreeArraySum tree = new TreeArraySum(n);
            // 枚举中间的数字
            for (int i = 0; i < n; i++) {
                // nums2 中的数字的 p
                int z = p[nums2[i]];
                // 找到比 z 小的数量，那么这个数字就是左边数字的数量
                int left = tree.query(z);

                int right = (n - 1 - z)/*剩下比当前 p 大的数量*/ - (i - left)/*已经枚举过的比当前 p 大的数量*/;
                ans += (long) left * right;
                tree.add(z + 1/*树状数组的索引从 1 开始*/, 1);
            }


            return ans;
        }


    }

    public class TreeArraySum {
        // 下标从 1 开始
        int[] tree;

        public TreeArraySum(int n) {
            tree = new int[n + 7];
        }

        public TreeArraySum(int[] nums) {
            tree = new int[nums.length + 10];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

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