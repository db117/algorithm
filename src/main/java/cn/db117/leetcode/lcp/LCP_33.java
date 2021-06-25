


//给定 N 个无限容量且初始均空的水缸，每个水缸配有一个水桶用来打水，第 `i` 个水缸配备的水桶容量记作 `bucket[i]`。小扣有以下两种操作：
//- 升级水桶：选择任意一个水桶，使其容量增加为 `bucket[i]+1`
//- 蓄水：将全部水桶接满水，倒入各自对应的水缸
//
//每个水缸对应最低蓄水量记作 `vat[i]`，返回小扣至少需要多少次操作可以完成所有水缸蓄水要求。
//
//注意：实际蓄水量 **达到或超过** 最低蓄水量，即完成蓄水要求。
//
//**示例 1：**
//>输入：`bucket = [1,3], vat = [6,8]`
//>
//>输出：`4`
//>
//>解释：
//>第 1 次操作升级 bucket[0]；
//>第 2 ~ 4 次操作均选择蓄水，即可完成蓄水要求。
//![vat1.gif](https://pic.leetcode-cn.com/1616122992-RkDxoL-vat1.gif)
//
//
//
//**示例 2：**
//>输入：`bucket = [9,0,1], vat = [0,2,2]`
//>
//>输出：`3`
//>
//>解释：
//>第 1 次操作均选择升级 bucket[1]
//>第 2~3 次操作选择蓄水，即可完成蓄水要求。
//
//**提示：**
//- `1 <= bucket.length == vat.length <= 100`
//- `0 <= bucket[i], vat[i] <= 10^4`
// 👍 25 👎 0


package cn.db117.leetcode.lcp;

import java.util.Arrays;

/**
 * LCP 33.蓄水
 *
 * @author db117
 * @since 2021-06-24 18:58:06
 **/

public class LCP_33 {
    public static void main(String[] args) {
        Solution solution = new LCP_33().new Solution();
//        // 2
//        System.out.println(solution.storeWater(new int[]{0}, new int[]{1}));
//        // 0
//        System.out.println(solution.storeWater(new int[]{3,2,5}, new int[]{0,0,0}));
        // 11
        System.out.println(solution.storeWater(new int[]{16, 29, 42, 70, 42, 9}, new int[]{89, 44, 50, 90, 94, 91}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int storeWater(int[] bucket, int[] vat) {

            int max = Arrays.stream(vat).max().getAsInt();
            if (max == 0) {
                return 0;
            }
            int ans = Integer.MAX_VALUE;

            // 模拟
            // 设定加水的次数,加上需要增加桶容量的次数
            // max+1 为最多倒水的次数
            for (int i = 1; i <= max + 1; i++) {
                // 当前蓄水的次数
                int cur = i;

                for (int j = 0; j < bucket.length; j++) {
                    if (bucket[j] * i < vat[j]) {
                        // 需要升级水桶
                        // 需要的水桶量,+(i-1) 向上取整
                        int tmp = (vat[j] + (i - 1)) / i;
                        cur += tmp - bucket[j];
                    }
                }
                ans = Math.min(ans, cur);
            }

            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}