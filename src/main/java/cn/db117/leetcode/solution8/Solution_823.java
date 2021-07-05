// 给出一个含有不重复整数元素的数组，每个整数均大于 1。 
// 
//  我们用这些整数来构建二叉树，每个整数可以使用任意次数。 
// 
//  其中：每个非叶结点的值应等于它的两个子结点的值的乘积。 
// 
//  满足条件的二叉树一共有多少个？返回的结果应模除 10 ** 9 + 7。 
// 
//  
// 
//  示例 1: 
// 
//  
// 输入: A = [2, 4]
// 输出: 3
// 解释: 我们可以得到这些二叉树: [2], [4], [4, 2, 2] 
// 
//  示例 2: 
// 
//  
// 输入: A = [2, 4, 5, 10]
// 输出: 7
// 解释: 我们可以得到这些二叉树: [2], [4], [5], [10], [4, 2, 2], [10, 2, 5], [10, 5, 2]. 
// 
//  
// 
//  提示: 
// 
//  
//  1 <= A.length <= 1000. 
//  2 <= A[i] <= 10 ^ 9. 
//  
//  Related Topics 数组 哈希表 动态规划 
//  👍 59 👎 0


package cn.db117.leetcode.solution8;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 823.带因子的二叉树.binary-trees-with-factors
 *
 * @author db117
 * @since 2021-07-02 11:14:57
 **/

public class Solution_823 {
    public static void main(String[] args) {
        Solution solution = new Solution_823().new Solution();

        // 12
        System.out.println(solution.numFactoredBinaryTrees(new int[]{
                18, 3, 6, 2
        }));
    }

    // leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFactoredBinaryTrees(int[] arr) {
            Arrays.sort(arr);
            int len = arr.length;
            long[] dp = new long[len];
            // 每一个数字都可以为根节点
            Arrays.fill(dp, 1);

            // 数字  ->  位置
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < len; i++) {
                map.put(arr[i], i);
            }

            for (int i = 0; i < len; i++) {
                for (int j = 0; j < i; j++) {
                    // 存在另一个子节点
                    if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                        // 加上两个子节点的乘积
                        dp[i] += dp[j] * dp[map.get(arr[i] / arr[j])];
                    }
                }
            }

            return (int) (Arrays.stream(dp).sum() % 1_000_000_007);
        }
    }
// leetcode submit region end(Prohibit modification and deletion)

}