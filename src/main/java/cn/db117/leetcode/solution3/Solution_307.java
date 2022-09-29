

//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
//
// Related Topics 设计 树状数组 线段树 数组 👍 558 👎 0


package cn.db117.leetcode.solution3;

/**
 * 307.区域和检索 - 数组可修改.range-sum-query-mutable
 *
 * @author db117
 * @see cn.db117.template.TreeArray
 * @since 2022-09-29 18:57:53
 **/

public class Solution_307 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        public NumArray(int[] nums) {
            this.nums = nums;
            // 初始化树状数组
            tree = new int[nums.length + 10];
            for (int i = 0; i < nums.length; i++) {
                add(i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            // 修改树状数组
            add(index + 1, val - nums[index]);
            // 保存一下,下次可能继续用
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            // 容斥原理
            return query(right + 1) - query(left);
        }


        int[] tree;
        int[] nums;


        /**
         * 最后一个 1
         */
        public int lowBit(int i) {
            return i & -i;
        }

        /**
         * 在指定位置添加值
         *
         * @param x 数组位置(从 1 开始)
         * @param v 增加的值
         */
        public void add(int x, int v) {
            for (int i = x; i <= nums.length; i += lowBit(i)) {
                tree[i] += v;
            }
        }

        /**
         * 查询[1,x]的和
         *
         * @param x 数组位置(从 1 开始)
         */
        public int query(int x) {
            int ans = 0;
            for (int i = x; i > 0; i -= lowBit(i)) {
                ans += tree[i];
            }
            return ans;
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}