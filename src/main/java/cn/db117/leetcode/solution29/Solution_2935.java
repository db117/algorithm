

//给你一个下标从 0 开始的整数数组 nums 。如果一对整数 x 和 y 满足以下条件，则称其为 强数对 ： 
//
// 
// |x - y| <= min(x, y) 
// 
//
// 你需要从 nums 中选出两个整数，且满足：这两个整数可以形成一个强数对，并且它们的按位异或（XOR）值是在该数组所有强数对中的 最大值 。 
//
// 返回数组 nums 所有可能的强数对中的 最大 异或值。 
//
// 注意，你可以选择同一个整数两次来形成一个强数对。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4,5]
//输出：7
//解释：数组 nums 中有 11 个强数对：(1, 1), (1, 2), (2, 2), (2, 3), (2, 4), (3, 3), (3, 4), 
//(3, 5), (4, 4), (4, 5) 和 (5, 5) 。
//这些强数对中的最大异或值是 3 XOR 4 = 7 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [10,100]
//输出：0
//解释：数组 nums 中有 2 个强数对：(10, 10) 和 (100, 100) 。
//这些强数对中的最大异或值是 10 XOR 10 = 0 ，数对 (100, 100) 的异或值也是 100 XOR 100 = 0 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [500,520,2500,3000]
//输出：1020
//解释：数组 nums 中有 6 个强数对：(500, 500), (500, 520), (520, 520), (2500, 2500), (2500, 
//3000) 和 (3000, 3000) 。
//这些强数对中的最大异或值是 500 XOR 520 = 1020 ；另一个异或值非零的数对是 (5, 6) ，其异或值是 2500 XOR 3000 = 6
//36 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 10⁴ 
// 1 <= nums[i] <= 2²⁰ - 1 
// 
//
// Related Topics 位运算 字典树 数组 哈希表 滑动窗口 👍 10 👎 0


package cn.db117.leetcode.solution29;

import cn.db117.template.trie.Trie01Revocable;

import java.util.Arrays;

/**
 * 2935.找出强数对的最大异或值 II.maximum-strong-pair-xor-ii
 *
 * @author db117
 * @see Trie01Revocable
 * @since 2023-11-27 14:22:57
 **/

public class Solution_2935 {
    public static void main(String[] args) {
        Solution solution = new Solution_2935().new Solution();
        // [1,2,3,4,5]
//        System.out.println(solution.maximumStrongPairXor(new int[]{
//                1, 2, 3, 4, 5
//        }));
        // [10,100]
        System.out.println(solution.maximumStrongPairXor(new int[]{
                10, 100
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maximumStrongPairXor(int[] nums) {
            // 01 可撤销字典树
            Trie01Revocable trie = new Trie01Revocable();
            int ans = 0;
            // |x - y| <= min(x, y) 在排序后 -> (x<y) x*2>=y
            Arrays.sort(nums);
            int left = 0;// 左边界,最左边的数要满足 x*2>=y
            for (int num : nums) {
                trie.insert(num);
                while (nums[left] * 2 < num) {// 不满足条件,删除
                    trie.remove(nums[left]);
                    left++;
                }
                // 找到最大的异或值
                ans = Math.max(ans, trie.maxXor(num));
            }
            return ans;
        }

        public class Trie01Revocable {
            // 最高位的二进制位
            private static final int HIGH_BIT = 19;
            // 字典树的根节点
            private final Node root = new Node();

            /**
             * num最大异或值
             */
            public int maxXor(int num) {
                Node cur = root;
                int ans = 0;
                for (int i = HIGH_BIT; i >= 0 && cur != null; i--) {
                    int bit = (num >> i) & 1;
                    if (cur.child[bit ^ 1] != null &&
                            cur.child[bit ^ 1].count > 0) {// 子节点的数量大于 0(等于0相当于删除了)
                        // 有相反的,异或后为 1
                        ans |= 1 << i;
                        cur = cur.child[bit ^ 1];
                    } else {
                        // 没有相反的,异或后为 0
                        cur = cur.child[bit];
                    }
                }
                return ans;
            }


            public void insert(int num) {
                Node cur = root;
                for (int i = HIGH_BIT; i >= 0; i--) {
                    int bit = (num >> i) & 1;
                    if (cur.child[bit] == null) {
                        cur.child[bit] = new Node();
                    }
                    cur = cur.child[bit];
                    cur.count++;
                }
            }

            public void remove(int num) {
                Node cur = root;
                for (int i = HIGH_BIT; i >= 0; i--) {
                    int bit = (num >> i) & 1;
                    cur = cur.child[bit];
                    cur.count--;
                }
            }

            static class Node {
                Node[] child = new Node[2];
                int count;// 当前子树的数量
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}