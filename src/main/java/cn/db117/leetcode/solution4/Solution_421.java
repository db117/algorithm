

// 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
//
// 进阶：你可以在 O(n) 的时间解决这个问题吗？ 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [3,10,5,25,2,8]
//输出：28
//解释：最大运算结果是 5 XOR 25 = 28. 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [2,4]
//输出：6
// 
//
// 示例 4： 
//
// 
//输入：nums = [8,10,2]
//输出：10
// 
//
// 示例 5： 
//
// 
//输入：nums = [14,70,53,83,49,91,36,80,92,51,66,70]
//输出：127
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 0 <= nums[i] <= 231 - 1 
// 
// 
// 
// Related Topics 位运算 字典树 
// 👍 362 👎 0


package cn.db117.leetcode.solution4;

/**
 * 421.数组中两个数的最大异或值.maximum-xor-of-two-numbers-in-an-array
 *
 * @author db117
 * @since 2021-06-01 11:09:48
 **/

public class Solution_421 {
    public static void main(String[] args) {
        Solution solution = new Solution_421().new Solution();
        System.out.println(solution.findMaximumXOR(new int[]{
                14, 70, 53, 83, 49, 91, 36, 80, 92, 51, 66, 70
        }));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class TrieTree {
        /*字典树
        思想：最大异或值为m。[从高到低依次求m的每一个bit。]
        用32层字典树（前缀数）保存所有num。然后遍历每一个num，求出其最大异或值m_num，方法：
        从高到低依次求m_num的每一个bit，检查能否为1。[每一个bit对应字典树的一层，用p表示节点指针]
        1.如果num当前bit为0，那么要使m_num的当前bit为1，则num当前位对应的应该是1：
            如果p有1节点，说明m_num当前位可以为1，则p指向1节点；否则说明m_num当前位只能为0，则p指向0节点。
        2.如果num当前bit为1，那么要使m_num的当前bit为1，则num当前位对应的应该是0：
            如果p有0节点，说明m_num当前位可以为1，则p指向0节点；否则说明m_num当前位只能为0，则p指向1节点。
         */

        // 0
        public TrieTree left;
        // 1
        public TrieTree right;
    }

    class Solution {
        private final TrieTree root = new TrieTree();

        public int findMaximumXOR(int[] nums) {
            int max = 0;
            // 构建前缀树
            for (int num : nums) {
                add(num);
            }

            for (int num : nums) {
                max = Math.max(max, helper(num));
            }

            return max;
        }

        private int helper(int num) {
            int ans = 0;
            TrieTree cur = root;
            for (int i = 30; i >= 0; i--) {
                ans <<= 1;
                if ((num & (1 << i)) > 0) {
                    if (cur.left != null) {
                        // 1 选 0
                        cur = cur.left;
                        ans++;
                    } else {
                        cur = cur.right;
                    }
                } else {
                    if (cur.right != null) {
                        // 0 选 1
                        cur = cur.right;
                        ans++;
                    } else {
                        cur = cur.left;
                    }
                }
            }
            return ans;
        }

        private void add(int num) {
            // 构建前缀树
            TrieTree cur = root;
            for (int i = 30; i >= 0; i--) {
                if ((num & (1 << i)) > 0) {
                    if (cur.right == null) {
                        cur.right = new TrieTree();
                    }
                    cur = cur.right;
                } else {
                    if (cur.left == null) {
                        cur.left = new TrieTree();
                    }
                    cur = cur.left;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}