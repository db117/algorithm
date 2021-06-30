// 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。
//
// 
//
// 示例： 
//
// 
//输入：[4, 6, 7, 7]
//输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]
//] 
//
// 
//
// 提示： 
//
// 
// 给定数组的长度不会超过15。 
// 数组中的整数范围是 [-100,100]。 
// 给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。 
// 
// Related Topics 位运算 数组 哈希表 回溯 
// 👍 299 👎 0


package cn.db117.leetcode.solution4;

import java.util.ArrayList;
import java.util.List;

/**
 * 491.递增子序列.increasing-subsequences
 *
 * @author db117
 * @since 2021-06-30 16:44:43
 **/

public class Solution_491 {
    public static void main(String[] args) {
        Solution solution = new Solution_491().new Solution();

        System.out.println(solution.findSubsequences(new int[]{
                4, 6, 7, 7
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> findSubsequences(int[] nums) {

            // set 去重
            List<List<Integer>> ans = new ArrayList<>();

            dfs(ans, new ArrayList<>(), nums, 0);

            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> cur, int[] nums, int index) {
            if (index == nums.length) {
                if (cur.size() > 1) {
                    ans.add(new ArrayList<>(cur));
                }
                return;
            }

            // 每一个数字分 要 不要

            // 不要
            if (cur.size() == 0 || cur.get(cur.size() - 1) != nums[index]) {
                // 当有相同数字时
                // 要    要
                // 要    不要
                // 不要  要
                // 不要  不要

                // 第二和第三总相同，会发生重复
                // 删除第二种保证不会出现重复

                dfs(ans, cur, nums, index + 1);
            }

            // 要当前数字
            if (cur.size() > 0 && nums[index] < cur.get(cur.size() - 1)) {
                // 不递增
                return;
            }
            cur.add(nums[index]);

            dfs(ans, cur, nums, index + 1);

            // 回溯
            cur.remove(cur.size() - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}