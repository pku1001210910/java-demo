package top.moonstar.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
    int from;
    int to;

    public Interval(int from, int to) {
        this.from = from;
        this.to = to;
    }
}

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] { { 2, 6 }, { 15, 18 }, { 1, 3 }, { 8, 10 } };
        intervals = new MergeIntervals().merge(intervals);
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + ", " + intervals[i][1]);
        }
    }

    public int[][] merge(int[][] intervals) {
        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        list = mergeHelper(list);
        int[][] merged = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            Interval interval = list.get(i);
            merged[i][0] = interval.from;
            merged[i][1] = interval.to;
        }

        return merged;
    }

    public List<Interval> mergeHelper(List<Interval> intervals) {
        // sort
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval first, Interval second) {
                if (first.from < second.from || first.from == second.from && first.to < second.to) {
                    return -1;
                } else if (first.from == second.from && first.to == second.to) {
                    return 0;
                }
                return 1;
            };
        });

        // merge
        List<Interval> newIntervals = new ArrayList<>();
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval first = intervals.get(i);
            Interval second = intervals.get(i + 1);

            if (first.to < second.from) {
                newIntervals.add(first);
                continue;
            }

            second.from = first.from;
            second.to = Math.max(first.to, second.to);
        }
        newIntervals.add(intervals.get(intervals.size() - 1));

        return newIntervals;
    }
}
