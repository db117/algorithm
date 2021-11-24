

//一个 k 镜像数字 指的是一个在十进制和 k 进制下从前往后读和从后往前读都一样的 没有前导 0 的 正 整数。 
//
// 
// 比方说，9 是一个 2 镜像数字。9 在十进制下为 9 ，二进制下为 1001 ，两者从前往后读和从后往前读都一样。 
// 相反地，4 不是一个 2 镜像数字。4 在二进制下为 100 ，从前往后和从后往前读不相同。 
// 
//
// 给你进制 k 和一个数字 n ，请你返回 k 镜像数字中 最小 的 n 个数 之和 。 
//
// 
//
// 示例 1： 
//
// 输入：k = 2, n = 5
//输出：25
//解释：
//最小的 5 个 2 镜像数字和它们的二进制表示如下：
//  十进制       二进制
//    1          1
//    3          11
//    5          101
//    7          111
//    9          1001
//它们的和为 1 + 3 + 5 + 7 + 9 = 25 。
// 
//
// 示例 2： 
//
// 输入：k = 3, n = 7
//输出：499
//解释：
//7 个最小的 3 镜像数字和它们的三进制表示如下：
//  十进制       三进制
//    1          1
//    2          2
//    4          11
//    8          22
//    121        11111
//    151        12121
//    212        21212
//它们的和为 1 + 2 + 4 + 8 + 121 + 151 + 212 = 499 。
// 
//
// 示例 3： 
//
// 输入：k = 7, n = 17
//输出：20379000
//解释：17 个最小的 7 镜像数字分别为：
//1, 2, 3, 4, 5, 6, 8, 121, 171, 242, 292, 16561, 65656, 2137312, 4602064, 65979
//56, 6958596
// 
//
// 
//
// 提示： 
//
// 
// 2 <= k <= 9 
// 1 <= n <= 30 
// 
// 👍 7 👎 0


package cn.db117.leetcode.solution20;

/**
 * 2081.k 镜像数字的和.sum-of-k-mirror-numbers
 *
 * @author db117
 * @since 2021-11-23 18:55:48
 **/

public class Solution_2081 {
    public static void main(String[] args) {
        Solution solution = new Solution_2081().new Solution();

        System.out.println(solution.kMirror(2, 5));
        System.out.println(solution.kMirror(3, 7));
        System.out.println(solution.kMirror(7, 17));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long kMirror(int k, int n) {
            long ans = 0;
            String num = "1";
            while (n > 0) {
                ans += Long.parseLong(num);
                n--;

                boolean flag = false;

                while (!flag) {
                    // 下一个对称数字
                    num = next(num);

                    // 转换为 k 进制字符串
                    String kStr = swap(Long.parseLong(num), k);

                    // 判断是否是对称
                    flag = check(kStr);
                }
            }
            return ans;
        }

        private String next(String num) {
            // 保存对称字符串前半部分
            StringBuilder tmp = new StringBuilder(num);
            tmp.setLength((num.length() + 1) / 2);
            long pre = Long.parseLong(tmp.toString());
            String nextStr = Long.toString(pre + 1);


            if (nextStr.length() == tmp.length()) {
                // 没有进位,则 +1 后进行充填
                StringBuilder ans = new StringBuilder(nextStr);
                int len = num.length() / 2;
                for (int i = 0; i < len; i++) {
                    ans.append(nextStr.charAt(len - 1 - i));
                }
                return ans.toString();
            }
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < num.length() + 1; i++) {
                // 位数增加则直接这种为 10...01
                if (i == 0 || i == num.length()) {
                    ans.append('1');
                } else {
                    ans.append('0');
                }
            }
            return ans.toString();
        }

        private String swap(long num, int k) {
            return Long.toString(num, k);
        }

        private boolean check(String num) {
            int length = num.length();
            for (int i = 0; i < length / 2; i++) {
                if (num.charAt(i) != num.charAt(length - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}