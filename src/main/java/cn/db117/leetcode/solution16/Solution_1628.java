

//给定一个算术表达式的后缀表示法的标记（token） postfix ，构造并返回该表达式对应的二叉表达式树。 
//
// 后缀表示法是一种将操作数写在运算符之前的表示法。例如，表达式 4*(5-(2+7)) 的后缀表示法表示为数组 postfix = ["4","5","7
//","2","+","-","*"] 。 
//
// 抽象类 Node 需要用于实现二叉表达式树。我们将通过 evaluate 函数来测试返回的树是否能够解析树中的值。你不可以移除 Node 类，但你可以按需
//修改此类，也可以定义其他类来实现它。 
//
// 二叉表达式树是一种表达算术表达式的二叉树。二叉表达式树中的每一个节点都有零个或两个子节点。 叶节点（有 0 个子节点的节点）表示操作数，非叶节点（有 2 
//个子节点的节点）表示运算符： '+' （加）、 '-' （减）、 '*' （乘）和 '/' （除）。 
//
// 我们保证任何子树对应值的绝对值不超过 10⁹ ，且所有操作都是有效的（即没有除以零的操作） 
//
// 进阶： 你可以将表达式树设计得更模块化吗？例如，你的设计能够不修改现有的 evaluate 的实现就能支持更多的操作符吗？ 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入： s = ["3","4","+","2","*","7","/"]
//输出： 2
//解释： 此表达式可解析为上述二叉树，其对应表达式为 ((3+4)*2)/7) = 14/7 = 2.
// 
//
// 示例 2: 
//
// 
//
// 
//输入: s = ["4","5","7","2","+","-","*"]
//输出: -16
//解释: 此表达式可解析为上述二叉树，其对应表达式为 4*(5-(2+7)) = 4*(-4) = -16.
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length < 100 
// s.length 是奇数。 
// s 包含数字和字符 '+' 、 '-' 、 '*' 以及 '/' 。 
// 如果 s[i] 是数，则对应的整数不超过 10⁵ 。 
// s 保证是一个有效的表达式。 
// 结果值和所有过程值的绝对值均不超过 10⁹ 。 
// 保证表达式不包含除以零的操作。 
// 
//
// Related Topics 栈 树 设计 数学 二叉树 👍 18 👎 0


package cn.db117.leetcode.solution16;

import java.util.Stack;
import java.util.function.BiFunction;

/**
 * 1628.设计带解析函数的表达式树.design-an-expression-tree-with-evaluate-function
 *
 * @author db117
 * @since 2023-02-23 14:04:36
 **/

public class Solution_1628 {
    public static void main(String[] args) {

    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    class Node {
        boolean isNumber = false;// 是否是数字
        int value;
        BiFunction<Integer, Integer, Integer> function;// 处理方法

        Node left, right;

        // define your fields here
        public Node(int value) {
            this.value = value;
            isNumber = true;
        }

        ;

        public Node(String s) {
            switch (s) {
                case "+" -> function = Integer::sum;
                case "-" -> function = (i1, i2) -> i1 - i2;
                case "*" -> function = (i1, i2) -> i1 * i2;
                case "/" -> function = (i1, i2) -> i1 / i2;
            }
        }

        public int evaluate() {
            if (isNumber) {
                return value;
            }
            return function.apply(left.evaluate(), right.evaluate());
        }
    }

    ;


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<Node> stack = new Stack<>();
            for (String p : postfix) {
                if (Character.isDigit(p.charAt(0))) {
                    // 数字直接入栈
                    stack.push(new Node(Integer.parseInt(p)));
                } else {
                    Node root = new Node(p);
                    // 先找右子节点
                    root.right = stack.pop();
                    root.left = stack.pop();
                    // 当前节点入栈
                    stack.push(root);
                }
            }

            // 表达式没有问题，则肯定只有最后一个
            return stack.pop();
        }

    }


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
//leetcode submit region end(Prohibit modification and deletion)

}