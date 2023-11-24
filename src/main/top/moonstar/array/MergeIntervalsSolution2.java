package top.moonstar.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervalsSolution2 {
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 2, 6 }, { 15, 18 }, { 1, 3 }, { 8, 10 } };
        intervals = new MergeIntervals().merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + ", " + intervals[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] first, int[] second) {
                return first[0] - second[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length - 1; i++) {
            int[] first = intervals[i];
            int[] second = intervals[i + 1];

            if (first[1] < second[0]) {
                merged.add(first);
                continue;
            }

            second[0] = first[0];
            second[1] = Math.max(second[1], first[1]);
        }
        merged.add(intervals[intervals.length - 1]);

        int[][] ret = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            ret[i] = merged.get(i);
        }
        return ret;
    }

}
