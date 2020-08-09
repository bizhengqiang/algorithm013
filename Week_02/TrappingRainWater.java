package leetcode.editor.cn;
//[42]:接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1516 👎 0

public class TrappingRainWater {
    public static void main(String... args) {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int Result = new SolutionTrappingRainWater3().trap(height);
        System.out.println("result area:" + Result);
    }
}

/**
 * @Date 2020/8/8
 * @Description 暴力解法：遍历每列的水容积。只需要找到左边最高和右边最高的那一列，容积是由较矮的那一边决定的。因每一列都要计算容积，复杂度为O(n)
 * 加上找左右最高加起来也要遍历n，所以时间复杂度是O(n2)
 * 空间复杂度为o(1)
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class SolutionTrappingRainWater {
    public int trap(int[] height) {
        int sumVolume = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int leftHeightest = 0;
            int rightHeightest = 0;
            for (int j = 0; j < i; ++j) {
                if (height[j] > leftHeightest) {
                    leftHeightest = height[j];
                }
            }
            for (int k = i; k < height.length; ++k) {
                if (height[k] > rightHeightest) {
                    rightHeightest = height[k];
                }
            }
            if (leftHeightest <= height[i] || rightHeightest <= height[i]) {
                continue;
            }
            if (leftHeightest >= rightHeightest) {
                sumVolume += (rightHeightest - height[i]);
            } else {
                sumVolume += (leftHeightest - height[i]);
            }
        }
        return sumVolume;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * @Date 2020/8/9
 * @Description 可以用动态规划的方法, 可以用两个数组分别存放每一列左边最大的列和右边最大的列。所以需要遍历三次数组，3n次，那时间复杂度为O(n)
 * 需要额外的2n个数组。空间复杂度为O(n)
 * @Param
 * @Return
 **/
class SolutionTrappingRainWater2 {
    public int trap(int[] height) {
        int sumVolume = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];
        //获取左边最高列数组
        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        //获取右边最高列数组
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        //最后遍历
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sumVolume += min - height[i];
            }
        }
        return sumVolume;
    }
}

/**
 * @Date 2020/8/9
 * @Description 用双指针，主要是用来降低空间复杂度，没必要用数组来存储左边和右边最高的列，我们只用一次，可以在遍历的时候存储一个变量即可。
 * @Param
 * @Return
 **/
class SolutionTrappingRainWater3 {
    public int trap(int[] height) {
        int sumVolume = 0;
        int left = 1;
        int right = height.length - 2;
        int max_left = 0;
        int max_right = 0;
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sumVolume = sumVolume + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sumVolume = sumVolume + (min - height[right]);
                }
                right--;
            }

        }

        return sumVolume;
    }
}
