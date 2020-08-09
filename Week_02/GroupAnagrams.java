package leetcode.editor.cn;//package leetcode.editor.cn;
//[49]:字母异位词分组
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串 
// 👍 416 👎 0

import java.util.*;

public class GroupAnagrams {
    public static void main(String... args) {

    }
}

/**
 * @Date 2020/8/3
 * @Description 第一种当然是暴力法，
 * 第二种加一个map用来存放相同字母异位组，比较是否是字母异位组可以通过先排序，再比较的方式
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> tmpMap = new HashMap<String, List<String>>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (tmpMap.containsKey(String.valueOf(chars))) {
                List<String> valueList = tmpMap.get(String.valueOf(chars));
                valueList.add(strs[i]);
                tmpMap.put(String.valueOf(chars), valueList);
            } else {
                List<String> valueList = new ArrayList<>();
                valueList.add(strs[i]);
                tmpMap.put(String.valueOf(chars), valueList);
            }
        }
        return new ArrayList<List<String>>(tmpMap.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
