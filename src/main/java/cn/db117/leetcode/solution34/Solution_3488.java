

//给你一个 循环 数组 nums 和一个数组 queries 。 
//
// 对于每个查询 i ，你需要找到以下内容： 
//
// 
// 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 
//距离。如果不存在这样的下标 j，则该查询的结果为 -1 。 
// 
//
// 返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。 
//
// 
//
// 示例 1： 
//
// 
// 输入： nums = [1,3,1,4,1,3,2], queries = [0,3,5] 
// 
//
// 输出： [2,-1,3] 
//
// 解释： 
//
// 
// 查询 0：下标 queries[0] = 0 处的元素为 nums[0] = 1 。最近的相同值下标为 2，距离为 2。 
// 查询 1：下标 queries[1] = 3 处的元素为 nums[3] = 4 。不存在其他包含值 4 的下标，因此结果为 -1。 
// 查询 2：下标 queries[2] = 5 处的元素为 nums[5] = 3 。最近的相同值下标为 1，距离为 3（沿着循环路径：5 -> 6 -> 
//0 -> 1）。 
// 
//
// 示例 2： 
//
// 
// 输入： nums = [1,2,3,4], queries = [0,1,2,3] 
// 
//
// 输出： [-1,-1,-1,-1] 
//
// 解释： 
//
// 数组 nums 中的每个值都是唯一的，因此没有下标与查询的元素值相同。所有查询的结果均为 -1。 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁶ 
// 0 <= queries[i] < nums.length 
// 
//
// Related Topics 数组 哈希表 二分查找 👍 0 👎 0


package cn.db117.leetcode.solution34;

import java.util.*;

/**
 * 3488.距离最小相等元素查询.closest-equal-element-queries
 *
 * @author db117
 * @since  2025-03-19 17:21:53
 **/

  public class Solution_3488{
      public static void main(String[] args) {
           Solution solution = new Solution_3488().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
      class Solution {
          public List<Integer> solveQueries(int[] nums, int[] queries) {
              List<Integer> ans = new ArrayList<>();
              int n = nums.length;
              // 记录每个数字出现的下标
              Map<Integer, TreeSet<Integer>> map = new HashMap<>();

              for (int i = 0; i < n; i++) {
                  map.putIfAbsent(nums[i], new TreeSet<>());
                  map.get(nums[i]).add(i);
              }

              for (int query : queries) {
                  int num = nums[query];
                  TreeSet<Integer> set = map.get(num);
                  if (set == null || set.size() < 2) {
                      ans.add(-1);
                      continue;
                  }
                  int res = n;

                  // 找到比当前下标更小的一个
                  Integer lower = set.lower(query);
                  if (lower != null) {
                      res = Math.min(res, query - lower);
                  }
                  // 找到比当前下标更大的一个
                  Integer higher = set.higher(query);
                  if (higher != null) {
                      res = Math.min(res, higher - query);
                  }

                  // 前面没有找到，和第一个最后一个比较
                  if (query != set.last()) {
                      res = Math.min(res, query + n - set.last());
                  }
                  if (query != set.first()) {
                      res = Math.min(res, set.first() + n - query);
                  }
                  ans.add(res);
              }

              return ans;
          }
      }
//leetcode submit region end(Prohibit modification and deletion)

  }