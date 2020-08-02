package leetcode.editor.cn;//package leetcode.editor.cn;
//[15]:三数之和
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2427 👎 0

import java.util.*;

public class ThreeSum {
    public static void main(String... args) {
        int[] nums = new int[]{0, 1, 1, 2, -2, -1};
        List<List<Integer>> resultList = new ThreeSumSolution1().threeSum(nums);
        System.out.println(resultList);

    }
}

/**
 * @Date 2020/7/29
 * @Description 暴力解法：三层loop,时间复杂度是O(n3)
 * 1.先排序
 * 2.要去重
 * 这种方法超时了
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class ThreeSumSolution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> returnList = new LinkedHashSet<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(returnList);
        }
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[j] > (-nums[i])) {
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[j] + nums[k] == (-nums[i])) {
                        List<Integer> temList = new ArrayList<Integer>();
                        temList.add(nums[i]);
                        temList.add(nums[j]);
                        temList.add(nums[k]);
                        returnList.add(temList);
                    }
                }
            }
        }
        //判重
        return new ArrayList<>(returnList);
    }
}
/**
*@Date 2020/8/2
*@Description 夹逼法则来遍历，能减少一次遍历，时间复杂度降到O(n2)
*@Param
*@Return
**/
class ThreeSumSolution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> returnList = new LinkedHashSet<>();
        if (nums == null || nums.length < 3) {
            return new ArrayList<>(returnList);
        }
        //先排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                //直接返回，没必要再继续执行循环
                if(nums[j]>(-nums[i])){
                    return new ArrayList<>(returnList);
                }
                if((-nums[i])>(nums[j]+nums[k])){
                    j++;
                }else if((-nums[i])<(nums[j]+nums[k])){
                    k--;
                }else{
                    List<Integer> tmpList = new ArrayList<>(3);
                    tmpList.add(nums[i]);
                    tmpList.add(nums[j]);
                    tmpList.add(nums[k]);
                    returnList.add(tmpList);
                    j++;
                }
            }
        }
        //判重
        return new ArrayList<>(returnList);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
