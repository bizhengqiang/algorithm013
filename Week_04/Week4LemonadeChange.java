package leetcode.editor.cn;
//[860]:柠檬水找零
//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。 
//
// 顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 示例 1： 
//
// 输入：[5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 输入：[5,5,10]
//输出：true
// 
//
// 示例 3： 
//
// 输入：[10,10]
//输出：false
// 
//
// 示例 4： 
//
// 输入：[5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 0 <= bills.length <= 10000 
// bills[i] 不是 5 就是 10 或是 20 
// 
// Related Topics 贪心算法 
// 👍 128 👎 0

public class Week4LemonadeChange {
    public static void main(String... args) {

    }
}

/**
 * @Date 2020/8/23
 * @Description 这里我们用贪心算法解决。为什么是属于贪心算法范畴呢？因为我们在找20的零钱时候，我们应该优先考虑
 * 用10块加5块，而不是用三张5块。因为5块比起10块，对于之后的找零更有利。所以我们只要考虑这次找零的最优，而不考虑最后结果最优
 * 但是，很明显，最后结果也肯定是最优的。
 * 时间复杂度为O(n) 空间复杂度O(1)
 * @Param
 * @Return
 **/
//leetcode submit region begin(Prohibit modification and deletion)
class LemonadeChangeSolution {
    public boolean lemonadeChange(int[] bills) {
        int fiveMount = 0;
        int tenMount = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveMount++;
                continue;
            }
            if (bill == 10) {
                if (fiveMount < 1) {
                    return false;
                }
                fiveMount--;
                tenMount++;
                continue;
            }
            if (bill == 20) {
                if (tenMount > 0 && fiveMount > 0) {
                    tenMount--;
                    fiveMount--;
                    continue;
                }
                if (tenMount == 0 && fiveMount > 2) {
                    fiveMount = fiveMount - 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
