//你的初始 能量 为 P，初始 分数 为 0，只有一包令牌 tokens 。其中 tokens[i] 是第 i 个令牌的值（下标从 0 开始）。
//
// 令牌可能的两种使用方法如下： 
//
// 
// 如果你至少有 token[i] 点 能量 ，可以将令牌 i 置为正面朝上，失去 token[i] 点 能量 ，并得到 1 分 。 
// 如果我们至少有 1 分 ，可以将令牌 i 置为反面朝上，获得 token[i] 点 能量 ，并失去 1 分 。 
// 
//
// 每个令牌 最多 只能使用一次，使用 顺序不限 ，不需 使用所有令牌。 
//
// 在使用任意数量的令牌后，返回我们可以得到的最大 分数 。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：tokens = [100], P = 50
//输出：0
//解释：无法使用唯一的令牌，因为能量和分数都太少了。 
//
// 示例 2： 
//
// 
//输入：tokens = [100,200], P = 150
//输出：1
//解释：令牌 0 正面朝上，能量变为 50，分数变为 1 。不必使用令牌 1 ，因为你无法使用它来提高分数。 
//
// 示例 3： 
//
// 
//输入：tokens = [100,200,300,400], P = 200
//输出：2
//解释：按下面顺序使用令牌可以得到 2 分：
//1. 令牌 0 正面朝上，能量变为 100 ，分数变为 1
//2. 令牌 3 正面朝下，能量变为 500 ，分数变为 0
//3. 令牌 1 正面朝上，能量变为 300 ，分数变为 1
//4. 令牌 2 正面朝上，能量变为 0 ，分数变为 2 
//
// 
//
// 提示： 
//
// 
// 0 <= tokens.length <= 1000 
// 0 <= tokens[i], P < 104 
// 
// Related Topics 贪心算法 排序 双指针 
// 👍 59 👎 0


package cn.db117.leetcode.solution9;

import java.util.Arrays;

/**
 * 948.令牌放置.bag-of-tokens
 *
 * @author db117
 * @since 2021-06-16 16:28:51
 **/

public class Solution_948 {
    public static void main(String[] args) {
        Solution solution = new Solution_948().new Solution();

        System.out.println(solution.bagOfTokensScore(new int[]{
                100, 200
        }, 150));

        System.out.println(solution.bagOfTokensScore(new int[]{
                100, 200, 300, 400
        }, 200));

        System.out.println(solution.bagOfTokensScore(new int[]{
                26
        }, 51));// 1

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int bagOfTokensScore(int[] tokens, int power) {
            Arrays.sort(tokens);

            // 双指针,小的加分减能量,大的减分加能量
            int left = 0, right = tokens.length - 1, score = 0;
            int max = 0;


            while (left <= right) {

                if (power < tokens[left]) {
                    // 换不了分了
                    break;
                }
                // 先换分,换到不能在换为止
                while (left <= right && tokens[left] <= power) {
                    score++;
                    power -= tokens[left];
                    left++;
                }

                // 保存最大分
                max = Math.max(max, score);

                // 换能量
                // 就换一次,寻求最大分
                if (score > 0) {
                    power += tokens[right];
                    right--;
                    score--;
                }


            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}