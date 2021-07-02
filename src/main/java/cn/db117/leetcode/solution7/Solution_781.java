// 森林中，每个兔子都有颜色。其中一些兔子（可能是全部）告诉你还有多少其他的兔子和自己有相同的颜色。我们将这些回答放在 answers 数组里。 
// 
//  返回森林中兔子的最少数量。 
// 
//  
// 示例:
// 输入: answers = [1, 1, 2]
// 输出: 5
// 解释:
// 两只回答了 "1" 的兔子可能有相同的颜色，设为红色。
// 之后回答了 "2" 的兔子不会是红色，否则他们的回答会相互矛盾。
// 设回答了 "2" 的兔子为蓝色。
// 此外，森林中还应有另外 2 只蓝色兔子的回答没有包含在数组中。
// 因此森林中兔子的最少数量是 5: 3 只回答的和 2 只没有回答的。
// 
// 输入: answers = [10, 10, 10]
// 输出: 11
// 
// 输入: answers = []
// 输出: 0
//  
// 
//  说明: 
// 
//  
//  answers 的长度最大为1000。 
//  answers[i] 是在 [0, 999] 范围内的整数。 
//  
//  Related Topics 贪心 哈希表 数学 
//  👍 183 👎 0


package cn.db117.leetcode.solution7;

import java.util.HashMap;
import java.util.Map;

/**
 * 781.森林中的兔子.rabbits-in-forest
 *
 * @author db117
 * @since 2021-07-02 10:56:56
 **/

public class Solution_781 {
    public static void main(String[] args) {
        Solution solution = new Solution_781().new Solution();

        System.out.println(solution.numRabbits(new int[]{
                1, 1, 1, 1, 1, 1, 1
        }));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numRabbits(int[] answers) {
            // 统计每一种肯的次数
            Map<Integer, Integer> map = new HashMap<>();
            for (int answer : answers) {
                map.put(answer, map.getOrDefault(answer, 0) + 1);
            }

            int ans = 0;

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                Integer num = entry.getKey();
                Integer count = entry.getValue();
                // 算上自己
                num++;

                // 可能存在多总颜色 数量一样
                ans += num * (count / num);
                if (count % num != 0) {
                    ans += num;
                }
            }

            return ans;
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}