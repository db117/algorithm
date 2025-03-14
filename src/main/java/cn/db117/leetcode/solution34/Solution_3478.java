

//给你两个整数数组，nums1 和 nums2，长度均为 n，以及一个正整数 k 。 
//
// 对从 0 到 n - 1 每个下标 i ，执行下述操作： 
//
// 
// 找出所有满足 nums1[j] 小于 nums1[i] 的下标 j 。 
// 从这些下标对应的 nums2[j] 中选出 至多 k 个，并 最大化 这些值的总和作为结果。 
// 
//
// 返回一个长度为 n 的数组 answer ，其中 answer[i] 表示对应下标 i 的结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入：nums1 = [4,2,1,5,3], nums2 = [10,20,30,40,50], k = 2 
// 
//
// 输出：[80,30,0,80,50] 
//
// 解释： 
//
// 
// 对于 i = 0 ：满足 nums1[j] < nums1[0] 的下标为 [1, 2, 4] ，选出其中值最大的两个，结果为 50 + 30 = 80 
//。 
// 对于 i = 1 ：满足 nums1[j] < nums1[1] 的下标为 [2] ，只能选择这个值，结果为 30 。 
// 对于 i = 2 ：不存在满足 nums1[j] < nums1[2] 的下标，结果为 0 。 
// 对于 i = 3 ：满足 nums1[j] < nums1[3] 的下标为 [0, 1, 2, 4] ，选出其中值最大的两个，结果为 50 + 30 = 
//80 。 
// 对于 i = 4 ：满足 nums1[j] < nums1[4] 的下标为 [1, 2] ，选出其中值最大的两个，结果为 30 + 20 = 50 。 
// 
//
// 示例 2： 
//
// 
// 输入：nums1 = [2,2,2,2], nums2 = [3,1,2,3], k = 1 
// 
//
// 输出：[0,0,0,0] 
//
// 解释：由于 nums1 中的所有元素相等，不存在满足条件 nums1[j] < nums1[i]，所有位置的结果都是 0 。 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁶ 
// 1 <= k <= n 
// 
//
// Related Topics 数组 排序 堆（优先队列） 👍 7 👎 0


package cn.db117.leetcode.solution34;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * 3478.选出和最大的 K 个元素.choose-k-elements-with-maximum-sum
 *
 * @author db117
 * @since 2025-03-14 11:09:14
 **/

public class Solution_3478 {
    public static void main(String[] args) {
        Solution solution = new Solution_3478().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            long[] ans = new long[n];
            // 优先队列，保存最大的前k个值
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = nums1[i];
                arr[i][1] = nums2[i];
            }
            TreeMap<Integer, Long> map = new TreeMap<>();
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            long sum = 0;
            for (int i = 0; i < n; i++) {
                // 维护小于当前值的前 k 个值的和
                sum += arr[i][1];
                pq.offer(arr[i][1]);
                if (pq.size() > k) {
                    sum -= pq.poll();
                }
                map.put(arr[i][0], sum);
            }
            // 找到之前维护的值
            for (int i = 0; i < n; i++) {
                Integer i1 = map.lowerKey(nums1[i]);
                if (i1 == null) {
                    continue;
                }
                ans[i] = map.get(i1);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}