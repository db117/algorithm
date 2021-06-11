


// 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
//
// 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。 
//
// 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。 
//
// 
//
// 示例 1： 
//
// 输入：people = [1,2], limit = 3
//输出：1
//解释：1 艘船载 (1, 2)
// 
//
// 示例 2： 
//
// 输入：people = [3,2,2,1], limit = 3
//输出：3
//解释：3 艘船分别载 (1, 2), (2) 和 (3)
// 
//
// 示例 3： 
//
// 输入：people = [3,5,3,4], limit = 5
//输出：4
//解释：4 艘船分别载 (3), (3), (4), (5) 
//
// 提示： 
//
// 
// 1 <= people.length <= 50000 
// 1 <= people[i] <= limit <= 30000 
// 
// Related Topics 贪心算法 双指针 
// 👍 100 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;

/**
 * 881.救生艇.boats-to-save-people
 *
 * @author db117
 * @since 2021-06-11 17:42:34
 **/

public class Solution_881 {
    public static void main(String[] args) {
        Solution solution = new Solution_881().new Solution();

//        System.out.println(solution.numRescueBoats(new int[]{1,2}, 3));
//        System.out.println(solution.numRescueBoats(new int[]{3,2,2,1}, 3));
//        System.out.println(solution.numRescueBoats(new int[]{3, 5, 3, 4}, 5));
//        System.out.println(solution.numRescueBoats(new int[]{5, 1, 4, 2}, 6));
//        System.out.println(solution.numRescueBoats(new int[]{3, 2, 2, 1}, 3));
        System.out.println(solution.numRescueBoats(new int[]{3, 8, 4, 9, 2, 2, 7, 1, 6, 10, 6, 7, 1, 7, 7, 6, 4, 4, 10, 1}, 10)); //11
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRescueBoats(int[] people, int limit) {
            Arrays.sort(people);

            int ans = 0;
            int left = 0, right = people.length - 1;

            while (left <= right) {
                // 当前还可以放多少重量
                int cur = limit;
                ans++;

                // 贪心,每一次都想装最多的重量
                // 先装大的
                if (people[right] <= cur) {
                    cur -= people[right];
                    right--;
                }

                // 大都装不下了,在装小的
                if (people[left] <= cur) {
                    left++;
                }
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}