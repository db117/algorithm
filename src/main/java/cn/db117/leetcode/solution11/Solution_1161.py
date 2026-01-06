# 1161.最大层内元素和
# 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。 
# 
#  返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。 
# 
#  
# 
#  示例 1： 
# 
#  
# 
#  
# 输入：root = [1,7,0,7,-8,null,null]
# 输出：2
# 解释：
# 第 1 层各元素之和为 1，
# 第 2 层各元素之和为 7 + 0 = 7，
# 第 3 层各元素之和为 7 + -8 = -1，
# 所以我们返回第 2 层的层号，它的层内元素之和最大。
#  
# 
#  示例 2： 
# 
#  
# 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
# 输出：2
#  
# 
#  
# 
#  提示： 
# 
#  
#  树中的节点数在
#  [1, 10⁴]范围内
#  
#  -10⁵ <= Node.val <= 10⁵ 
#  
# 
#  Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 163 👎 0
from math import inf
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


# leetcode submit region begin(Prohibit modification and deletion)
# Definition for a binary tree node.


class Solution:

    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        arr = []

        def helper(node: TreeNode, level: int):
            if node is None:
                return
            if len(arr) == level:
                arr.append(0)
            arr[level] += node.val  # 累加对应层的值

            helper(node.left, level + 1)
            helper(node.right, level + 1)

        helper(root, 0)
        ans = -1
        max_sum = -inf
        for i in range(0, len(arr)):
            if arr[i] > max_sum:
                max_sum = arr[i]
                ans = i  # 记录最大值对应的层数
        return ans + 1


# leetcode submit region end(Prohibit modification and deletion)
if __name__ == '__main__':
    # [-100,-200,-300,-20,-5,-10,null]
    # print(Solution().maxLevelSum(TreeNode(
    #     -100,
    #     TreeNode(-200, TreeNode(-20), TreeNode(-5)),
    #     TreeNode(-300, TreeNode(-10))
    # )))

    # [1]
    print(Solution().maxLevelSum(TreeNode(1)))
