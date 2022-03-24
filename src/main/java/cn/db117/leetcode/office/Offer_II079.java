


//给定一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
//
// 
//
// 注意：本题与主站 78 题相同： https://leetcode-cn.com/problems/subsets/ 
// Related Topics 位运算 数组 回溯 👍 22 👎 0


package cn.db117.leetcode.office;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 079.所有子集.TVdhkn
 *
 * @author db117
 * @since 2022-03-24 11:09:49
 **/

public class Offer_II079 {
    public static void main(String[] args) {
        Solution solution = new Offer_II079().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(new ArrayList<>(), ans, nums, 0);
            return ans;
        }

        private void dfs(List<Integer> cur, List<List<Integer>> ans, int[] nums, int index) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            // 不加入
            dfs(cur, ans, nums, index + 1);

            // 加入
            cur.add(nums[index]);
            dfs(cur, ans, nums, index + 1);
            cur.remove(cur.size() - 1);

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}