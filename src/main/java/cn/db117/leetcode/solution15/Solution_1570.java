

//给定两个稀疏向量，计算它们的点积（数量积）。 
//
// 实现类 SparseVector： 
//
// 
// SparseVector(nums) 以向量 nums 初始化对象。 
// dotProduct(vec) 计算此向量与 vec 的点积。 
// 
//
// 稀疏向量 是指绝大多数分量为 0 的向量。你需要 高效 地存储这个向量，并计算两个稀疏向量的点积。 
//
// 进阶：当其中只有一个向量是稀疏向量时，你该如何解决此问题？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,0,0,2,3], nums2 = [0,3,0,4,0]
//输出：8
//解释：v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
//v1.dotProduct(v2) = 1*0 + 0*3 + 0*0 + 2*4 + 3*0 = 8
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [0,1,0,0,0], nums2 = [0,0,0,0,2]
//输出：0
//解释：v1 = SparseVector(nums1) , v2 = SparseVector(nums2)
//v1.dotProduct(v2) = 0*0 + 1*0 + 0*0 + 0*0 + 0*2 = 0
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,1,0,0,2,0,0], nums2 = [1,0,0,0,3,0,4]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// n == nums1.length == nums2.length 
// 1 <= n <= 10^5 
// 0 <= nums1[i], nums2[i] <= 100 
// 
//
// Related Topics 设计 数组 哈希表 双指针 👍 30 👎 0


package cn.db117.leetcode.solution15;

import java.util.HashMap;
import java.util.Map;

/**
 * 1570.两个稀疏向量的点积.dot-product-of-two-sparse-vectors
 *
 * @author db117
 * @since 2023-02-22 14:57:36
 **/

public class Solution_1570 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SparseVector {
        int[] nums;

        SparseVector(int[] nums) {
            this.nums = nums;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {

            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                ans += nums[i] * vec.nums[i];
            }
            return ans;
        }
    }

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
//leetcode submit region end(Prohibit modification and deletion)

}