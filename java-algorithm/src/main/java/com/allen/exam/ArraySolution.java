package com.allen.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ligenfeng
 * @date 2020/10/7 2:45 下午
 */
public class ArraySolution {


    public static void main(String[] args) {
        System.out.println(getMaxDistance(new int[][]{
                {12, 15}, {12, 12}, {10, 10}
        }));
    }

    public static int getMaxDistance(int[][] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Pair> pairs = new ArrayList<>();
        for (int[] lines : arr) {
            int min = lines[0];
            int max = lines[1];
            pairs.add(new Pair(min, max));
        }
        List<Pair> collect = pairs.stream().sorted(Comparator.comparingInt(Pair::getMin)).collect(Collectors.toList());
        int result = 0;
        int min = 0;
        int max = 0;
        for (Pair pair : collect) {
            if (min == 0 && max == 0) {
                min = pair.getMin();
                max = pair.getMax();
                continue;
            }
            if (max != 0 && pair.getMin() > max) {
                result += max - min;
                max = pair.getMax();
                min = pair.getMin();
                continue;
            }
            if (max != 0 && pair.getMax() > max) {
                max = pair.getMax();
            }
            if (min != 0 && pair.getMin() < min) {
                min = pair.getMin();
            }
        }
        return result + (max - min);
    }

    private static class Pair {
        private int min;
        private int max;

        public Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

}
