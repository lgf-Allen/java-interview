package com.allen.leetcode;

/**
 * @author ligenfeng
 * @date 2020/8/22 11:24 上午
 */
public class StarsSolution {

    private static int[] meno;

    public static int climbStars(int number) {
        meno = new int[number + 1];
        return getStars(number);
    }

    public static int getStars(int starsNumber) {
        if (starsNumber == 0) {
            return 0;
        }
        if (starsNumber == 1) {
            return 1;
        }
        if (starsNumber == 2) {
            return 2;
        }

        if (meno[starsNumber] == 0) {
            meno[starsNumber] = getStars(starsNumber - 2) + getStars(starsNumber - 1);
        }
        return meno[starsNumber];

    }


    public static int judeStars(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
//        System.out.println(climbStars(40));
        System.out.println(judeStars(40));
        System.out.println((System.nanoTime() - startTime) / 1000);
    }
}
