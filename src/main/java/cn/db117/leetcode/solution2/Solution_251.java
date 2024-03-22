

//请设计并实现一个能够展开二维向量的迭代器。该迭代器需要支持 next 和 hasNext 两种操作。 
//
// 
//
// 示例： 
//
// 
//Vector2D iterator = new Vector2D([[1,2],[3],[4]]);
//
//iterator.next(); // 返回 1
//iterator.next(); // 返回 2
//iterator.next(); // 返回 3
//iterator.hasNext(); // 返回 true
//iterator.hasNext(); // 返回 true
//iterator.next(); // 返回 4
//iterator.hasNext(); // 返回 false
// 
//
// 
//
// 注意： 
//
// 
// 请记得 重置 在 Vector2D 中声明的类变量（静态变量），因为类变量会 在多个测试用例中保持不变，影响判题准确。请 查阅 这里。 
// 你可以假定 next() 的调用总是合法的，即当 next() 被调用时，二维向量总是存在至少一个后续元素。 
// 
//
// 
//
// 进阶：尝试在代码中仅使用 C++ 提供的迭代器 或 Java 提供的迭代器。 
//
// Related Topics 设计 数组 双指针 迭代器 👍 77 👎 0


package cn.db117.leetcode.solution2;

/**
 * 251.展开二维向量.flatten-2d-vector
 *
 * @author db117
 * @since 2024-03-22 16:54:30
 **/

public class Solution_251 {
    public static void main(String[] args) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Vector2D {
        int i = 0, j = 0;
        int[][] vec;

        public Vector2D(int[][] vec) {
            this.vec = vec;
        }

        public int next() {
            int ans = vec[i][j];
            j++;
            if (j == vec[i].length) {
                // 当前数组遍历完
                i++;
                j = 0;
            }
            return ans;
        }

        public boolean hasNext() {
            if (i >= vec.length) {
                return false;
            }
            if (j >= vec[i].length) {
                // 当前数组遍历完
                i++;
                j = 0;
                return hasNext();
            }
            return true;
        }
    }

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
//leetcode submit region end(Prohibit modification and deletion)

}