package leetcode.editor.cn;
//[64]:最小路径和
//给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。 
//
// 说明：每次只能向下或者向右移动一步。 
//
// 示例: 
//
// 输入:
//[
//  [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//输出: 7
//解释: 因为路径 1→3→1→1→1 的总和最小。
// 
// Related Topics 数组 动态规划 
// 👍 651 👎 0

public class Week6MinimumPathSum {
    public static void main(String... args) {

    }
}

/**
 * @Date 2020/8/31
 * @Description 典型的动态规划问题，
 *              1.因为grid[i][j]上最小路径等于grid[i][]j-1]和grid[i-1][j]中的最小值加grid[i][j]
 *              2.用array[i][j]来存储中间的状态
 *              3.dp方程：array[i][j] = Math.min(array[i-1][j],array[i][j-1])+grid[i][j];
 *
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class MinimumPathSumSolution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int rows = grid.length;
        int columns = grid[0].length;
        //建立一个和原数组的同大小的数组来存放中间状态
        int[][] array = new int[rows][columns];
        array[0][0] = grid[0][0];
        //第一行 注意数组越界
        for (int i = 1; i < columns; i++) {
            array[0][i] = array[0][i-1]+grid[0][i];
        }
        //第一列 注意数组越界
        for (int i = 1; i < rows; i++) {
            array[i][0] = array[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                array[i][j] = Math.min(array[i-1][j],array[i][j-1])+grid[i][j];
            }
        }
        return array[rows-1][columns-1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
