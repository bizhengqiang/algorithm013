package leetcode.editor.cn;
//[22]:括号生成
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1300 👎 0

import java.util.ArrayList;
import java.util.List;

public class Week7GenerateParentheses{
    public static void main(String... args){
    
    }
}
/**
*@Date 2020/9/13
*@Description 广度遍历
*@Param
*@Return
**/
//leetcode submit region begin(Prohibit modification and deletion)
class GenerateParenthesesSolution {
    ArrayList[] cache = new ArrayList[100];
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left: generate(c))
                    for (String right: generate(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        cache[n] = ans;
        return ans;
    }
    public List<String> generateParenthesis(int n) {
        return generate(n);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
