package com.allen.demo;

/**
 * 计算两个正整数的最大公约数
 *
 * @author ligenfeng
 * @date 2020/8/23 9:37 上午
 */
public class CommonDivisor {

    public static void main(String[] args) {
        System.out.println("暴力破解法：" + getGreatestCommonDivisor1(15, 25));
        System.out.println("辗转相除法：" + getGreatestCommonDivisor2(15, 25));

        System.out.println("更相减损术：" + getGreatestCommonDivisor3(15, 25));
        System.out.println("最优解：" + getGreatestCommonDivisorBestWay(9, 3));
    }

    /**
     * 1. 先看较大数是否能整除较小数，如果可以，则最大公约数为较小数；否则执行第二步
     * 2. 从两个数的较小的数的一半开始计算，逐次减一，遍历是否可以同时被较小数和较大数整除
     *
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int getGreatestCommonDivisor1(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        for (int i = min / 2; i > 1; i--) {
            if ((max % i == 0) && (min % i == 0)) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 辗转相处法：a和b的最大公约数等于a除以b的余数c和b之间的最大公约数
     * 频繁取余，当数字较大时，会有性能问题
     *
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int getGreatestCommonDivisor2(int a, int b) {
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if (max % min == 0) {
            return min;
        }
        return getGreatestCommonDivisor2(min, max % min);
    }

    /**
     * 更相减损术：a和b的最大公约数等于较大数a减去较小数b的差c和b之间的最大公约数
     *
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int getGreatestCommonDivisor3(int a, int b) {
        if (a == b) {
            return a;
        }
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return getGreatestCommonDivisor3(max - min, min);
    }


    /**
     * @param a
     * @param b
     * @return 最大公约数
     */
    public static int getGreatestCommonDivisorBestWay(int a, int b) {
        if (a == b) {
            return a;
        }

        // a,b都为偶数
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisorBestWay(a >> 1, b >> 1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {// a为偶数，b为奇数
            return getGreatestCommonDivisorBestWay(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {// a为奇数，b为偶数
            return getGreatestCommonDivisorBestWay(a, b >> 1);
        } else {// a,b皆为奇数
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            return getGreatestCommonDivisorBestWay(min, max - min);
        }

    }
}
