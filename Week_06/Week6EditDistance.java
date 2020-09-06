package leetcode.editor.cn;
//[72]:编辑距离
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划 
// 👍 1121 👎 0

public class Week6EditDistance {
    public static void main(String... args) {
        String s1 = "miracle";
        System.out.println(s1.charAt(0));

    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Date 2020/9/6
 * @Description 1:本质上只有三种操作方式：在word1上插入一个字符、在word2插入一个字符，修改word2的一个字符。
 * 如何得到这个状态方程呢？如果word1和word2的最后一个字母相同，那有三种方式，temp[i-1][j]+1、temp[i][j-1]+1、temp[i-1][j-1]
 * 2.中间状态方程 temp[word1.length][word2.length]
 * 3.dp方程
 * (1)最后一个字母相同：min(temp[i][j-1]+1,temp[i-1][j]+1,temp[i-1][j-1])
 * (2)最后一个字母不同：min(temp[i][j-1]+1,temp[i-1][j]+1,temp[i-1][j-1])
 * @Param
 * @Return
 **/
class EditDistanceSolution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // 有一个字符串为空串
        if (n * m == 0)
            return n + m;

        // DP 数组
        int[][] D = new int[n + 1][m + 1];

        // 边界状态初始化
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // 计算所有 DP 值
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                int left = D[i - 1][j] + 1;
                int down = D[i][j - 1] + 1;
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1))
                    left_down += 1;
                D[i][j] = Math.min(left, Math.min(down, left_down));

            }
        }
        return D[n][m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
