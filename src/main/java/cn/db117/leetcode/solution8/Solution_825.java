// 人们会互相发送好友请求，现在给定一个包含有他们年龄的数组，ages[i] 表示第 i 个人的年龄。
//
// 当满足以下任一条件时，A 不能给 B（A、B不为同一人）发送好友请求： 
//
// 
// age[B] <= 0.5 * age[A] + 7 
// age[B] > age[A] 
// age[B] > 100 && age[A] < 100 
// 
//
// 否则，A 可以给 B 发送好友请求。 
//
// 注意如果 A 向 B 发出了请求，不等于 B 也一定会向 A 发出请求。而且，人们不会给自己发送好友请求。 
//
// 求总共会发出多少份好友请求? 
//
// 
//
// 示例 1： 
//
// 
//输入：[16,16]
//输出：2
//解释：二人可以互发好友申请。
// 
//
// 示例 2： 
//
// 
//输入：[16,17,18]
//输出：2
//解释：好友请求可产生于 17 -> 16, 18 -> 17. 
//
// 示例 3： 
//
// 
//输入：[20,30,100,110,120]
//输出：3
//解释：好友请求可产生于 110 -> 100, 120 -> 110, 120 -> 100.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ages.length <= 20000 
// 1 <= ages[i] <= 120 
// 
// Related Topics 数组 双指针 二分查找 排序 
// 👍 63 👎 0


package cn.db117.leetcode.solution8;

/**
 * 825.适龄的朋友.friends-of-appropriate-ages
 *
 * @author db117
 * @since 2021-07-08 11:48:28
 **/

public class Solution_825 {
    public static void main(String[] args) {
        Solution solution = new Solution_825().new Solution();

        System.out.println(solution.numFriendRequests(new int[]{
                16, 16
        }));
        System.out.println(solution.numFriendRequests(new int[]{
                16, 17, 18
        }));
        System.out.println(solution.numFriendRequests(new int[]{
                20, 30, 100, 110, 120
        }));
        System.out.println(solution.numFriendRequests(new int[]{
                17, 17, 17, 16, 16, 16,
        }));
        // 434
        System.out.println(solution.numFriendRequests(new int[]{
                81, 106, 11, 66, 83, 113, 51, 62, 47, 42, 85, 94, 78, 96, 51, 14, 3, 111, 57, 66, 8, 113, 27, 61, 21, 55,
                87, 15, 20, 23, 14, 105, 38, 85, 2, 108, 103, 46, 44, 27, 79, 108, 106, 86, 113, 24, 39, 8, 7, 97
        }));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numFriendRequests(int[] ages) {
            int[] arr = new int[121];
            for (int age : ages) {
                arr[age]++;
            }
            int ans = 0;

            // 简单说就是：只能给 (当前年龄/2+7,当前年龄] 区间的人发
            // 15 岁以下没有朋友
            for (int i = 15; i < arr.length; i++) {
                if (arr[i] == 0) {
                    continue;
                }
                // 跟自己年龄相同
                ans += arr[i] * (arr[i] - 1);

                // 需要大于 当前年龄/2+7
                for (int j = i / 2 + 8; j < i; j++) {
                    // 中间的都是适龄的朋友
                    ans += arr[j] * arr[i];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}