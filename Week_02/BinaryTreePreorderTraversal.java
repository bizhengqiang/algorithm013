package leetcode.editor.cn;
//[144]:二叉树的前序遍历
//给定一个二叉树，返回它的 前序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [1,2,3]
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 329 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public static void main(String... args) {

    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Date 2020/8/4
 * @Description 首先可以考虑用递归的方式实现，但是难点是要构造返回的List,所以list应该是放在递归方法之外
 * @Param
 * @Return
 **/
class SolutionBinaryTreePreorderTraversal {
    List<Integer> returnList = new ArrayList<>();

    //中序遍历
    public List<Integer> midorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        preorderTraversal(root.leftNode);
        returnList.add(root.val);
        preorderTraversal(root.rightNode);
        return returnList;
    }

    //前序遍历
    public List<Integer> preorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        returnList.add(root.val);
        preorderTraversal(root.leftNode);
        preorderTraversal(root.rightNode);
        return returnList;
    }

    //后序遍历
    public List<Integer> hindorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        preorderTraversal(root.leftNode);
        preorderTraversal(root.rightNode);
        returnList.add(root.val);
        return returnList;
    }


}

class TreeNodes {
    int val;
    TreeNodes leftNode;
    TreeNodes rightNode;

    public TreeNodes(int x) {
        this.val = x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * @Date 2020/8/4
 * @Description 第二种方式是迭代解法，其实本质上是模拟递归。用一个栈来系统栈。
 * @Param
 * @Return
 **/
class SolutionBinaryTreePreorderTraversal1 {
    List<Integer> returnList = new ArrayList<>();

    //前序遍历
    public List<Integer> preorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        Stack<TreeNodes> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodes treeNode = stack.pop();
            returnList.add(treeNode.val);
            //因为要保证的是左节点先加到list里面，所以放入stack的时候要先放右节点
            if (treeNode.rightNode != null) {
                stack.push(root.rightNode);
            }
            if (treeNode.leftNode != null) {
                stack.push(root.leftNode);
            }
        }
        return returnList;
    }

    //中序遍历
    public List<Integer> midorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        TreeNodes cur = root;
        Stack<TreeNodes> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            //要尽量先节点压入栈，再将左节点压入栈，就能保证可以先输出左节点
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftNode;
            }
            TreeNodes treeNode = stack.pop();
            returnList.add(treeNode.val);
            if (treeNode.rightNode != null) {
                cur = treeNode.rightNode;
            }
        }
        return returnList;
    }

    //后序遍历
    public List<Integer> hindorderTraversal(TreeNodes root) {
        if (root == null) {
            return returnList;
        }
        //一个栈用来模拟系统栈、另一个用来输出
        Stack<TreeNodes> stack1 = new Stack<>();
        Stack<TreeNodes> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            //压入栈的顺序应该是中、左、右
            TreeNodes node = stack1.pop();
            stack2.push(node);
            if (node.leftNode != null) {
                stack1.push(node.leftNode);
            }
            if (node.rightNode != null) {
                stack1.push(node.rightNode);
            }
        }
        while (!stack2.isEmpty()) {
            returnList.add(stack2.pop().val);
        }
        return returnList;
    }

}

