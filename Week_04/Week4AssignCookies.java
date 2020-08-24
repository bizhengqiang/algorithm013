package leetcode.editor.cn;
//[455]:分发饼干
//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干
//的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满
//足越多数量的孩子，并输出这个最大数值。 
//
// 注意： 
//
// 你可以假设胃口值为正。 
//一个小朋友最多只能拥有一块饼干。 
//
// 示例 1: 
//
// 
//输入: [1,2,3], [1,1]
//
//输出: 1
//
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: [1,2], [1,2,3]
//
//输出: 2
//
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
// Related Topics 贪心算法 
// 👍 191 👎 0

import java.util.Arrays;

public class Week4AssignCookies {
    public static void main(String... args) {
        Week4AssignCookiesSolution cookies = new Week4AssignCookiesSolution();
        int[] g = new int[]{1,2,3};
        int[] s = new int[]{1,1};
        int mount = cookies.findContentChildren(g,s);
        System.out.println(mount);

    }
}

/**
 * @Date 2020/8/23
 * @Description 第一种，暴力法 时间复杂度O(nK) n为孩子数，k为饼干数量,加上贪心思想，尽量用最小的饼干满足
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class Week4AssignCookiesSolution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int childrenMount = 0;
        int cookieIndex = 0;
        boolean tempState = true;
        for (int i = 0; i < g.length; i++) {
            if(tempState == false){
                return childrenMount;
            }
            for (int j = cookieIndex; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    childrenMount++;
                    s[j] = -1;
                    cookieIndex++;
                    tempState = true;
                    break;
                }
                tempState = false;
            }
        }
        return childrenMount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
