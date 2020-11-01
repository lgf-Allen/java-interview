package com.allen.leetcode;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ligenfeng
 * @date 2020/10/21 10:03 下午
 */
public class ThiefSolution {

    /**
     * leetcode 198 打家劫舍
     * 你是一个专业的小偷，计划偷窃沿街的房屋。
     * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
     * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
     *  
     * <p>
     * 示例 1：
     * 输入：[1,2,3,1]
     * 输出：4
     * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     *      偷窃到的最高金额 = 1 + 3 = 4 。
     * 示例 2：
     * <p>
     * 输入：[2,7,9,3,1]
     * 输出：12
     * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
     * <p>
     * 提示：
     * 0 <= nums.length <= 100
     * 0 <= nums[i] <= 400
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        // 只有一间房屋时，直接返回该房屋的存放金额
        if (length == 1) {
            return nums[0];
        }
        // 只有两件房屋时，返回两个房间中存放金额较大的
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 空间复杂度O(n)
        int[] dp = new int[nums.length];
        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        // 时间复杂度O(n)
        for (int i = 2; i < length; i++) {
            // 动态转移方程
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[length - 1];
    }

    public int robAdvance(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int length = nums.length;
        // 只有一间房屋时，直接返回该房屋的存放金额
        if (length == 1) {
            return nums[0];
        }
        // 只有两件房屋时，返回两个房间中存放金额较大的
        if (length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        // 第一间房子的存放金额
        int first = nums[0];
        // 有两间房子的最大偷盗金额
        int second = Math.max(nums[0], nums[1]);
        // 空间复杂度O(1)
        int max = 0;
        for (int i = 2; i < length; i++) {
            int temp = second;
            max = Math.max(second, first + nums[i]);
            second = max;
            first = temp;
        }
        return max;
    }

    public static void main(String[] args) {
        ThiefSolution solution = new ThiefSolution();
        System.out.println(solution.robAdvance(new int[]{1, 2, 3, 1}));
    }
}
