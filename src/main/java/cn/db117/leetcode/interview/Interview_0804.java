


//幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。 
//
// 说明：解集不能包含重复的子集。 
//
// 示例: 
//
//  输入： nums = [1,2,3]
// 输出：
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 60 👎 0


package cn.db117.leetcode.interview;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 面试题 08.04.幂集.power-set-lcci
 *
 * @author db117
 * @since 2021-05-27 17:16:09
 **/

public class Interview_0804 {
    public static void main(String[] args) {
        Solution solution = new Interview_0804().new Solution();
        System.out.println(solution.subsets(new int[]{
                1, 2, 3
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> ans = new LinkedList<>();

            dfs(nums, ans, new LinkedList<>(), 0);

            return ans;
        }

        private void dfs(int[] nums, List<List<Integer>> ans, Deque<Integer> cur, int index) {
            if (index == nums.length) {
                ans.add(new ArrayList<>(cur));
                return;
            }
            // 不要当前数字
            dfs(nums, ans, cur, index + 1);


            // 要当前数字
            cur.offerLast(nums[index]);

            dfs(nums, ans, cur, index + 1);

            // 回溯
            cur.removeLast();

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}