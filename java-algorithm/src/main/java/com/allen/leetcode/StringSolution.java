package com.allen.leetcode;

/**
 * @author ligenfeng
 * @date 2020/8/11 11:40 下午
 */
public class StringSolution {

    public static void main(String[] args) {
        isUnique("abcdd");
    }

    public static boolean isUnique(String astr) {
        long low64 = 0;
        long high64 = 0;

        for (char c : astr.toCharArray()) {
            if (c >= 64) {
                long bitIndex = 1L << c - 64;
                if ((high64 & bitIndex) != 0) {
                    return false;
                }

                high64 |= bitIndex;
            } else {
                long bitIndex = 1L << c;
                if ((low64 & bitIndex) != 0) {
                    return false;
                }

                low64 |= bitIndex;
            }

        }

        return true;
    }

}
