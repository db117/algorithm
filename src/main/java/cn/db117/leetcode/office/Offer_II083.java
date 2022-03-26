


//给定一个不含重复数字的整数数组 nums ，返回其 所有可能的全排列 。可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// 
//
// 注意：本题与主站 46 题相同：https://leetcode-cn.com/problems/permutations/ 
// Related Topics 数组 回溯 👍 17 👎 0


package cn.db117.leetcode.office;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 083.没有重复元素集合的全排列.VvJkup
 *
 * @author db117
 * @since 2022-03-26 22:31:30
 **/

public class Offer_II083 {
    public static void main(String[] args) {
        Solution solution = new Offer_II083().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, new ArrayList<>(), nums, new boolean[nums.length]);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, List<Integer> cur, int[] arr, boolean[] flag) {
            if (cur.size() == arr.length) {
                ans.add(new ArrayList<>(cur));
                return;
            }

            for (int i = 0; i < flag.length; i++) {
                if (flag[i]) {
                    continue;
                }

                flag[i] = true;
                cur.add(arr[i]);
                dfs(ans, cur, arr, flag);
                cur.remove(cur.size() - 1);
                flag[i] = false;
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}