package com.allen.demo;

/**
 * 判断一个正整数是否是2的整数次幂
 *
 * @author ligenfeng
 * @date 2020/8/23 10:57 上午
 */
public class IntegerPower {
    public static void main(String[] args) {
        System.out.println(judgeNumber1(10));
        System.out.println(judgeNumber1(128));
    }

    /**
     * 2的整数次幂数的特点：2的整数次幂的数与原数减1进行与运算，结果都为0
     * 十进制    二进制     原值减1
     * 2        10        01
     * 4        100       011
     * 8        1000      0111
     * 16       10000     01111
     * 32       100000    011111
     *
     * @param a
     * @return 是否是2的整数次幂
     */
    public static boolean judgeNumber1(int a) {
        return (a & a - 1) == 0;
    }

}
