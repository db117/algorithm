// 在一排树中，第 i 棵树产生 tree[i] 型的水果。
// 你可以从你选择的任何树开始，然后重复执行以下步骤：
//
// 
// 把这棵树上的水果放进你的篮子里。如果你做不到，就停下来。 
// 移动到当前树右侧的下一棵树。如果右边没有树，就停下来。 
// 
//
// 请注意，在选择一颗树后，你没有任何选择：你必须执行步骤 1，然后执行步骤 2，然后返回步骤 1，然后执行步骤 2，依此类推，直至停止。 
//
// 你有两个篮子，每个篮子可以携带任何数量的水果，但你希望每个篮子只携带一种类型的水果。 
//
// 用这个程序你能收集的水果树的最大总量是多少？ 
//
// 
//
// 示例 1： 
//
// 输入：[1,2,1]
//输出：3
//解释：我们可以收集 [1,2,1]。
// 
//
// 示例 2： 
//
// 输入：[0,1,2,2]
//输出：3
//解释：我们可以收集 [1,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [0, 1]。
// 
//
// 示例 3： 
//
// 输入：[1,2,3,2,2]
//输出：4
//解释：我们可以收集 [2,3,2,2]
//如果我们从第一棵树开始，我们将只能收集到 [1, 2]。
// 
//
// 示例 4： 
//
// 输入：[3,3,3,1,2,1,1,2,3,3,4]
//输出：5
//解释：我们可以收集 [1,2,1,1,2]
//如果我们从第一棵树或第八棵树开始，我们将只能收集到 4 棵水果树。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= tree.length <= 40000 
// 0 <= tree[i] < tree.length 
// 
// Related Topics 双指针 
// 👍 89 👎 0


package cn.db117.leetcode.solution9;

import java.util.HashMap;
import java.util.Map;

/**
 * 904.水果成篮.fruit-into-baskets
 *
 * @author db117
 * @since 2021-06-11 18:06:53
 **/

public class Solution_904 {
    public static void main(String[] args) {
        Solution solution = new Solution_904().new Solution();

        System.out.println(solution.totalFruit(new int[]{
                0, 1, 2, 2
        }));
        System.out.println(solution.totalFruit(new int[]{
                1, 2, 3, 2, 2
        }));
        System.out.println(solution.totalFruit(new int[]{
                3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4
        }));
        System.out.println(solution.totalFruit(new int[]{
                0, 1, 1, 4, 3
        }));
        // 6
        System.out.println(solution.totalFruit(new int[]{
                1, 1, 6, 5, 6, 6, 1, 1, 1, 1
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int totalFruit(int[] tree) {
            int ans = 0;
            int left = 0;

            // 数字出现的次数
            Map<Integer, Integer> map = new HashMap<>();

            for (int right = 0; right < tree.length; right++) {
                int n = tree[right];

                map.put(n, map.getOrDefault(n, 0) + 1);
                // 篮子的数量,可以扩展
                if (map.size() < 2) {
                    continue;
                }

                // 从左边删除,一直删除到 篮子里面只剩两个数字
                while (left < tree.length && map.size() > 2) {
                    int leftNum = tree[left];
                    Integer leftCount = map.get(leftNum);
                    if (leftCount == 1) {
                        map.remove(leftNum);
                    } else {
                        map.put(leftNum, leftCount - 1);
                    }
                    left++;
                }

                // 两个数字,计算长度
                ans = Math.max(ans, right - left + 1);
            }
            // 不够两个数字
            ans = Math.max(ans, tree.length - left);
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}