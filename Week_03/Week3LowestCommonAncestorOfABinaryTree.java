package leetcode.editor.cn;
//[236]:二叉树的最近公共祖先
//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉树: root = [3,5,1,6,2,0,8,null,null,7,4] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出: 3
//解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
// 
//
// 示例 2: 
//
// 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出: 5
//解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 691 👎 0

public class Week3LowestCommonAncestorOfABinaryTree {
    public static void main(String... args) {

    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**
 * @Date 2020/8/15
 * @Description 可以确定用递归方法来解决，可以用二叉树的后续遍历方法。递归的时间复杂度是o(n)，空间复杂度也是o(n)
 * @Param
 * @Return
 **/
class SolutionBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //terminator终止条件
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        //process 处理
        TreeNode rootLeft = root.left;
        TreeNode rootRight = root.right;
        //drill down(进入下一层）
        TreeNode leftReturnNode = lowestCommonAncestor(rootLeft, p, q);
        TreeNode rightReturnNode = lowestCommonAncestor(rootRight, p, q);
        //如果两边遍历都返回，说明p和q在左右子树，所以root就是最近公共节点
        if (leftReturnNode != null && rightReturnNode != null) {
            return root;
        }
        //如果只有右边返回，说明p、q都在右子树。那最近公共祖先不是p就是q，就是返回的节点，左边同理
        if (leftReturnNode != null && rightReturnNode == null) {
            return leftReturnNode;
        }
        if (leftReturnNode == null && rightReturnNode != null) {
            return rightReturnNode;
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
