package com.worker.bee.solution.leetcode;

import com.worker.bee.solution.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 题目标题:
 * 89. Gray Code
 * 题目描述：
 * <p>
 * &emsp;&emsp;格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。格雷编码序列必须以 0 开头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,3,2]
 * 解释:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * <p>
 * 对于给定的 n，其格雷编码序列并不唯一。
 * 例如，[0,2,3,1] 也是一个有效的格雷编码序列。
 * <p>
 * 00 - 0
 * 10 - 2
 * 11 - 3
 * 01 - 1
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0
 * 输出: [0]
 * 解释: 我们定义格雷编码序列必须以 0 开头。
 *      给定编码总位数为 n 的格雷编码序列，其长度为 2的n次方。当 n = 0 时，长度为 2的0次方 = 1。
 *      因此，当 n = 0 时，其格雷编码序列为 [0]。
 * <p>
 * Related Topics 回溯算法
 */
public class _89_GrayCode {

    public static void main(String[] args) {
        Solution solution = new _89_GrayCode().new Solution();
        int n = 2;
        PrintUtils.println(Arrays.toString(solution.grayCode(n).toArray()));
    }


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 思路：
         * 1、grayCode(n)=grayCode(n-1)+(grayCode(n-1)倒序情况下的的每一个值+2的n-1次方)
         * 例如
         * n=0  n=1 n=2 n=3 ....
         * 0    00   00 000 ....
         *      01   01 001 ....
         *           11 011 ....
         *           10 010 ....
         *              110 ....
         *              111 ....
         *              101 ....
         *              100 ....
         *                  ....
         *
         * 2、grayCode(n)=grayCode(n-1)即每个前面加0   +   grayCode(n-1)倒序 每个前面加+1
         * 3、grayCode(n-1)加一倒序否则不符合格雷码定义
         */
        public List<Integer> grayCode(int n) {
            List<Integer> resultList = new ArrayList<>();
            resultList.add(0);
            int head = 1;
            for (int index = 0; index < n; index++) {
                for (int appendIndex = resultList.size() - 1; appendIndex >= 0; appendIndex--) {
                    resultList.add(head + resultList.get(appendIndex));
                }
                head <<= 1;
            }
            return resultList;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}