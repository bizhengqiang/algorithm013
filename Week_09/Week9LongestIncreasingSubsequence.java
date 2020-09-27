package leetcode.editor.cn;
//[300]:最长上升子序列
//给定一个无序的整数数组，找到其中最长上升子序列的长度。 
//
// 示例: 
//
// 输入: [10,9,2,5,3,7,101,18]
//输出: 4 
//解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。 
//
// 说明: 
//
// 
// 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。 
// 你算法的时间复杂度应该为 O(n2) 。 
// 
//
// 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗? 
// Related Topics 二分查找 动态规划 
// 👍 1033 👎 0

import java.util.Arrays;

public class Week9LongestIncreasingSubsequence{
    public static void main(String... args){
    
    }
}
//leetcode submit region begin(Prohibit modification and deletion)
/**
*@Date 2020/9/27
*@Description 动态规划 时间复杂度 O(N^2)
 * ： 遍历计算dp列表需 O(N)，计算每个 dp[i] 需 O(N)。
 * 空间复杂度 O(N)： dpdp 列表占用线性大小额外空间。

*@Param
*@Return
**/
class LongestIncreasingSubsequenceSolution1 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
/**
*@Date 2020/9/27
*@Description 动态规划+二分查找
*@Param       时间复杂度 O(NlogN) 空间复杂度O(N)
*@Return 
**/
class LongestIncreasingSubsequenceSolution2 {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
