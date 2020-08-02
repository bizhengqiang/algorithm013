package leetcode.editor.cn;
//[11]:盛最多水的容器
//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1676 👎 0

public class ContainerWithMostWater {
    public static void main(String... args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = new ContainerWithMostWaterSolution1().maxArea(heights);
        System.out.println(maxArea);
    }
}

/**
 * @Date 2020/7/29
 * @Description 暴力解法：用两个loop来遍历，用一个变量maxArea来记录最大面积
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class ContainerWithMostWaterSolution1 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArear = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = 0; j < height.length; j++) {
                int minHeight = height[i] <= height[j] ? height[i] : height[j];
                int multiplyResult = minHeight * (j - i);
                if (multiplyResult > maxArear) {
                    maxArear = multiplyResult;
                }
            }

        }
        return maxArear;
    }
}

/**
 * @Date 2020/7/29
 * @Description 双指针解法：两个指针从两边遍历，只需要遍历一遍，时间复杂度能降到O(n).那怎么确定移动哪个坐标呢？
 * 因为面积大小是由较小的那个数来决定的，应该移动较小的那个数的坐标。
 * @Param
 * @Return
 **/

class ContainerWithMostWaterSolution2 {
    public int maxArea(int[] height) {
        if (height == null || height.length <= 1) {
            return 0;
        }
        int maxArear = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int minHeight = height[i] <= height[j] ? height[i] : height[j];
            int multiplyResult = minHeight * (j - i);
            maxArear = maxArear >= multiplyResult ? maxArear : multiplyResult;
            if (minHeight == height[i]) {
                i++;
            } else {
                j--;
            }
        }
        return maxArear;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
