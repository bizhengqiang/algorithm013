package leetcode.editor.cn;//package leetcode.editor.cn;
//[70]:爬楼梯
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1165 👎 0

public class ClimbingStairs {
    public static void main(String... args) {
        int waysMount = new SolutionclimbStairs1().climbStairs(5);
        System.out.println("the way to top:" + waysMount);
    }
}
//leetcode submit region begin(Prohibit modification and deletion)

/**
 * @Date 2020/7/31
 * @Description 第一种：递归：f(n) = f(n-1)+f(n-2)
 * @Param
 * @Return
 **/
class SolutionclimbStairs1 {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

/**
 * @Date 2020/7/31
 * @Description 第二种 记录状态递归
 * @Param
 * @Return
 **/
class SolutionclimbStairs2 {
    public int climbStairs(int n) {
        int[] memoryArray = new int[n + 1];
        return climbStairsMemory(n,memoryArray);
    }
    private int climbStairsMemory(int n, int[] memoryArray) {
        if (memoryArray[n] > 0) {
            return memoryArray[n];
        }
        if (n == 1) {
            memoryArray[n] = 1;
            return memoryArray[n];
        }
        if (n == 2) {
            memoryArray[n] = 2;
            return memoryArray[n];
        }
        memoryArray[n] = climbStairsMemory(n-1,memoryArray)+climbStairsMemory(n-2,memoryArray);
        return memoryArray[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
