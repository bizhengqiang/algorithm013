package leetcode.editor.cn;
//[剑指 Offer 40]:最小的k个数
//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 118 👎 0

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class ZuiXiaoDeKgeShuLcof {
    public static void main(String... args) {

    }
}

/**
 * @Date 2020/8/5
 * @Description 第一种方法用堆，构建一个大顶堆（优先队列），如果数组中元素大于堆顶元素就不用放入堆中了，小于就放入堆中，弹出堆顶元素。最后剩下的堆就是最小的k个数。
 * 同理，要是找最大的k个数，就可以通过构建一个小顶堆，如果数组中元素小于堆顶元素直接返回，否则放入堆中重新构建，弹出堆顶元素。
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class SolutionZuiXiaoDeKgeShuLcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (arr.length < k) {
            return arr;
        }
        //构建大顶堆
        Queue<Integer> maxHeap = new PriorityQueue<>(k, (i1, i2) -> Integer.compare(i2, i1));
        for (int e : arr) {
            if (maxHeap.isEmpty() || maxHeap.size() < k || e < maxHeap.peek()) {
                //offer相对与add方法来说，对于有容量限制的队列，插入失败返回false,不像add要抛出异常。推荐offer
                maxHeap.offer(e);
            }
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        int[] returnArray = new int[k];
        int i = 0;
        for (Integer heapNumber : maxHeap) {
            returnArray[i] = heapNumber;
            i++;
        }
        return returnArray;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

/**
 * @Date 2020/8/5
 * @Description 第二种方法：可以用快排的思想，快排通过选定一个数作为分割点，然后小于这个数就放在左边，否则放在右边
 * @Param
 * @Return
 **/
class SolutionZuiXiaoDeKgeShuLcof2 {
    public int[] getLeastNumbers(int [] input, int k) {
        fastSort(input,0,input.length-1,k);
        return Arrays.copyOf(input,k);
    }
    private void fastSort(int[] a,int s,int e,int k){
        if(s > e)return;
        int p = partation(a,s,e);
        if(p+1 == k){
            return;
        }else if(p+1 < k){
            fastSort(a,p+1,e,k);
        }else{
            fastSort(a,s,p-1,k);
        }
    }

    private int partation(int[] a,int s ,int e){
        int privot = a[e];//取最后一个数作为分区点
        int i = s;
        for(int j = s;j < e;j++){
            if(a[j] < privot){
                swap(a,i,j);
                i++;
            }
        }
        swap(a,i,e);
        return i;
    }

    private void swap(int[] a ,int i ,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}