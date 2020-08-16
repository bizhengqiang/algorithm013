package leetcode.editor.cn;
//[105]:从前序与中序遍历序列构造二叉树
//根据一棵树的前序遍历与中序遍历构造二叉树。 
//
// 注意: 
//你可以假设树中没有重复的元素。 
//
// 例如，给出 
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7] 
//
// 返回如下的二叉树： 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7 
// Related Topics 树 深度优先搜索 数组 
// 👍 620 👎 0

import java.util.HashMap;
import java.util.Map;

public class Week3ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String... args) {

    }
}
//leetcode submit region begin(Prohibit modification and deletion)


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}


/**
 * @Date 2020/8/15
 * @Description 分治思想。我们需要左右子树分别构造，所以可以用递归来做
 * @Param
 * @Return
 **/
class SolutionConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        //建立一个map来存根节点，如果不存下来每次都要遍历，性能很差。
        Map<Integer, Integer> rootMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            rootMap.put(inorder[i], i);
        }
        return _treeBuilder(preorder, rootMap, 0, preorder.length - 1, 0, inorder.length - 1);

    }

    private TreeNode _treeBuilder(int[] preorder, Map<Integer, Integer> rootMap, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        //等到不能再分割
        if (leftStart > leftEnd || rightStart > rightEnd) {
            return null;
        }
        //先构建根节点,前序数组的第一个元素就是第一个根节点
        Integer rootValue = preorder[leftStart];
        TreeNode rootNode = new TreeNode(rootValue);
        //递归构造
        int index = rootMap.get(rootValue);
        //左子树构造
        rootNode.left = _treeBuilder(preorder, rootMap, leftStart + 1, index - rightStart + leftStart, rightStart, index - 1);
        rootNode.right = _treeBuilder(preorder, rootMap, index - rightStart + leftStart + 1, leftEnd, index + 1, rightEnd);
        return rootNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
