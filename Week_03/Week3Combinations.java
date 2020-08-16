package leetcode.editor.cn;
//[77]:组合
//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 330 👎 0

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Week3Combinations{
    public static void main(String... args){
    
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
*@Date 2020/8/16
*@Description n个树共有n的阶乘种组合方式
*@Param
*@Return
**/
class Week3CombinationsSolution {
    private List<List<Integer>> resultList = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        //判断
        if(n<1 || n<k || k<1){
            return resultList;
        }
        //递归组合
        subCombine(n,k,1,new Stack<>());
        return resultList;

    }
    //递归
    private void subCombine(int n, int k, int begin, Stack<Object> objects) {
        //terminator
        if(objects.size() == k){
            resultList.add(new ArrayList(objects));
            return;
        }
        //process
        for (int i = begin; i <= n; i++) {
            objects.add(i);
            subCombine(n, k, i + 1, objects);
            objects.pop();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
