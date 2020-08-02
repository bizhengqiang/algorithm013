package leetcode.editor.cn;
//[20]:有效的括号
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 1730 👎 0

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String... args) {
        String markString = "[()]";
        SolutionValidParentheses1 solutionValidParentheses = new SolutionValidParentheses1();
        boolean result = solutionValidParentheses.isValid(markString);
        System.out.println("the result:"+result);
    }
}

/**
 * @Date 2020/8/1
 * @Description 用栈来匹配括号，如果匹配就弹出，最后看栈是否为空
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class SolutionValidParentheses {
    private static Map<String, String> markMap;

    static {
        markMap = new HashMap<String, String>();
        markMap.put(")", "(");
        markMap.put("]", "[");
        markMap.put("}", "{");
    }

    public boolean isValid(String s) {
        Stack<String> markStack = new Stack<String>();
        //如果长度不匹配，直接返回false
        if ((s.length() % 2) == 1) {
            return false;
        }
        char[] inputByte = s.toCharArray();
        for (int i = 0; i < inputByte.length; i++) {
            if(markStack.isEmpty()){
                markStack.push(String.valueOf(inputByte[i]));
                continue;
            }
            if (String.valueOf(markMap.get(String.valueOf(inputByte[i]))).equals(markStack.peek())) {
                markStack.pop();
                continue;
            }
            markStack.push(String.valueOf(inputByte[i]));
        }
        return markStack.isEmpty();
    }
}
/**
 *@Date 2020/8/1
 *@Description  直接用replace来做
 *@Param
 *@Return
 **/
class SolutionValidParentheses1{
    public boolean isValid(String s) {
        if(s.length()%2 == 1){
            return false;
        }
        int halfLength = s.length()/2;
        while (halfLength>0){
            s.replace("()","").replace("[]","").replace("{}","");
            halfLength--;
        }
        return s.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)
