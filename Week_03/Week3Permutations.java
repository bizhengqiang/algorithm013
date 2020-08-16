package leetcode.editor.cn;
//[46]:全排列
//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 842 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Week3Permutations{
    public static void main(String... args){
    
    }
}
/**
*@Date 2020/8/16
*@Description 回溯算法，主要是递归时候要掌握剪枝的判断
*@Param
*@Return
**/
//leetcode submit region begin(Prohibit modification and deletion)
class SolutionWeek3Permutations {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>(factorial(len));
        //输入合法判断
        if (len == 0) {
            return res;
        }
        int used = 0;
        Deque<Integer> path = new ArrayDeque<>(len);
        //深度优先遍历
        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private int factorial(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }

    private void dfs(int[] nums, int len, int depth,
                     Deque<Integer> path, int used,
                     List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (((used >> i) & 1) == 0) {
                path.addLast(nums[i]);
                used ^= (1 << i);
                dfs(nums, len, depth + 1, path, used, res);
                used ^= (1 << i);
                path.removeLast();
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
