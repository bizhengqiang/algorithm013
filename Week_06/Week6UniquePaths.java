package leetcode.editor.cn;
//[62]:不同路径
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。 
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。 
//
// 问总共有多少条不同的路径？ 
//
// 
//
// 例如，上图是一个7 x 3 的网格。有多少可能的路径？ 
//
// 
//
// 示例 1: 
//
// 输入: m = 3, n = 2
//输出: 3
//解释:
//从左上角开始，总共有 3 条路径可以到达右下角。
//1. 向右 -> 向右 -> 向下
//2. 向右 -> 向下 -> 向右
//3. 向下 -> 向右 -> 向右
// 
//
// 示例 2: 
//
// 输入: m = 7, n = 3
//输出: 28 
//
// 
//
// 提示： 
//
// 
// 1 <= m, n <= 100 
// 题目数据保证答案小于等于 2 * 10 ^ 9 
// 
// Related Topics 数组 动态规划 
// 👍 665 👎 0

public class Week6UniquePaths {
    public static void main(String... args) {

    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Date 2020/9/6
 * @Description 因为只有两种走法，向下和向向右，所以到grip[m][n]上的走法为grip[m-1][n]和grip[m][n-1]的和
 * 中间状态数组temp[m][n]
 * dp方程：f(m,n) = f(m-1,n)+f(m,n-1)
 * @Param
 * @Return
 **/
class UniquePathsSolution {
    public int uniquePaths(int m, int n) {
        //特殊情况判断
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] temp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0){
                    temp[i][j] = 1;
                    continue;
                }
                if(j==0){
                    temp[i][j] = 1;
                    continue;
                }
                temp[i][j] = temp[i - 1][j] + temp[i][j - 1];
            }
        }
        return temp[m - 1][n - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
