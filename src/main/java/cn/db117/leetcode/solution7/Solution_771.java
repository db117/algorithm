

//给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，
//你想知道你拥有的石头中有多少是宝石。 
//
// 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：jewels = "aA", stones = "aAAbbbb"
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：jewels = "z", stones = "ZZ"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= jewels.length, stones.length <= 50 
// jewels 和 stones 仅由英文字母组成 
// jewels 中的所有字符都是 唯一的 
// 
//
// Related Topics 哈希表 字符串 👍 752 👎 0


package cn.db117.leetcode.solution7;

/**
 * 771.宝石与石头.jewels-and-stones
 *
 * @author db117
 * @since 2023-07-24 11:23:11
 **/

public class Solution_771 {
    public static void main(String[] args) {
        Solution solution = new Solution_771().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numJewelsInStones(String jewels, String stones) {
            // 状态压缩
            long flag = 0;
            int n = jewels.length();
            for (int i = 0; i < n; i++) {
                flag |= index(jewels.charAt(i));
            }

            int ans = 0;
            int m = stones.length();
            for (int i = 0; i < m; i++) {
                if ((flag & index(stones.charAt(i))) != 0) {
                    ans++;
                }
            }
            return ans;
        }

        private long index(char c) {
            // 取最后 6  位
            // 放到 long 上面
            return 1L << (c & 63);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}