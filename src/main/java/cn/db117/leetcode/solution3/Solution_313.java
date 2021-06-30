//编写一段程序来查找第 n 个超级丑数。
//
// 超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。 
//
// 示例: 
//
// 输入: n = 12, primes = [2,7,13,19]
//输出: 32 
//解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26
//,28,32] 。 
//
// 说明: 
//
// 
// 1 是任何给定 primes 的超级丑数。 
// 给定 primes 中的数字以升序排列。 
// 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。 
// 第 n 个超级丑数确保在 32 位有符整数范围内。 
// 
// Related Topics 数组 哈希表 数学 动态规划 堆（优先队列） 
// 👍 171 👎 0


package cn.db117.leetcode.solution3;

import cn.db117.leetcode.base.Optimized;

import java.util.PriorityQueue;

/**
 * 313.超级丑数.super-ugly-number
 *
 * @author db117
 * @since 2021-06-30 10:32:12
 **/
@Optimized
public class Solution_313 {
    public static void main(String[] args) {
        Solution solution = new Solution_313().new Solution();
        // 100000
        //[7,19,29,37,41,47,53,59,61,79,83,89,101,103,109,127,131,137,139,157,167,179,181,199,211,229,233,239,241,251]
        // 1092889481
        System.out.println(solution.nthSuperUglyNumber(100000, new int[]{
                7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int nthSuperUglyNumber(int n, int[] primes) {
            // 用 long 防止越界
            PriorityQueue<Long> queue = new PriorityQueue<>();
            queue.offer(1L);
            int index = 0;

            while (!queue.isEmpty()) {
                index++;

                // 堆中最小的数字
                Long min = queue.poll();
                if (n == index) {
                    // 第几个丑数
                    return min.intValue();
                }

                // 删除重复项
                while (!queue.isEmpty() && min.equals(queue.peek())) {
                    queue.poll();
                }

                // 所有的数字都乘以 质因数
                for (int prime : primes) {
                    long num = min * prime;
                    queue.offer(num);
                }

            }
            return n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}