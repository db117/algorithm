//给你一个下标从 0 开始的整数数组 nums 。现有一个长度等于 nums.length 的数组 arr 。对于满足 nums[j] == nums[i] 
//且 j != i 的所有 j ，arr[i] 等于所有 |i - j| 之和。如果不存在这样的 j ，则令 arr[i] 等于 0 。 
//
// 返回数组 arr 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1,1,2]
//输出：[5,0,3,4,0]
//解释：
//i = 0 ，nums[0] == nums[2] 且 nums[0] == nums[3] 。因此，arr[0] = |0 - 2| + |0 - 3| 
//= 5 。 
//i = 1 ，arr[1] = 0 因为不存在值等于 3 的其他下标。
//i = 2 ，nums[2] == nums[0] 且 nums[2] == nums[3] 。因此，arr[2] = |2 - 0| + |2 - 3| 
//= 3 。
//i = 3 ，nums[3] == nums[0] 且 nums[3] == nums[2] 。因此，arr[3] = |3 - 0| + |3 - 2| 
//= 4 。 
//i = 4 ，arr[4] = 0 因为不存在值等于 2 的其他下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,5,3]
//输出：[0,0,0]
//解释：因为 nums 中的元素互不相同，对于所有 i ，都有 arr[i] = 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 70 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
function distance(nums: number[]): number[] {
    const n = nums.length;
    let ans: number[] = new Array(n).fill(0);
    let map: Map<number, number[]> = new Map();

    // 按照相同数字分组
    for (let i = 0; i < n; i++) {
        let arr: number[] = map.get(nums[i]);
        if (arr === undefined) {
            arr = [];
            map.set(nums[i], arr);
        }
        arr.push(i);
    }

    for (const arr of map.values()) {
        let m = arr.length;
        if (m == 1) {
            continue;
        }

        // 组内前缀和，记录距离其他数字的距离和
        let preSum: number[] = new Array(m + 1).fill(0);
        for (let i = 0; i < m; i++) {
            preSum[i + 1] = preSum[i] + arr[i];
        }

        for (let i = 0; i < m; i++) {
            const target = arr[i];// 当前数字
            const left = i * target - preSum[i]; // 左侧距离
            const right = (preSum[m] - preSum[i + 1]) - (m - i - 1) * target;
            ans[target] = left + right;
        }

    }

    return ans;
}

//leetcode submit region end(Prohibit modification and deletion)

console.log(distance([1, 3, 1, 1, 2]))
console.log(distance([0, 5, 3]))