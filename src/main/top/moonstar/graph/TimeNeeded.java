package top.moonstar.graph;

import java.util.ArrayList;
import java.util.List;

public class TimeNeeded {
    public static void main(String[] args) {
        System.out.println(
                new TimeNeeded().numOfMinutes(6, 2, new int[] { 2, 2, -1, 2, 2, 2 }, new int[] { 0, 0, 1, 0, 0, 0 }));
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>> array = getSubordinateArray(manager);

        return numOfMinutesHelper(n, headID, array, informTime);
    }

    public int numOfMinutesHelper(int n, int headID, List<List<Integer>> manager, int[] informTime) {
        int minutes = informTime[headID];

        int max = 0;
        List<Integer> subordinates = manager.get(headID);
        for (int i = 0; i < subordinates.size(); i++) {
            int subId = subordinates.get(i);
            int subordinateMinutes = numOfMinutesHelper(n, subId, manager, informTime);
            max = Math.max(subordinateMinutes, max);
        }

        return minutes + max;
    }

    public List<List<Integer>> getSubordinateArray(int[] manager) {
        List<List<Integer>> employees = new ArrayList<>();

        // init
        for (int i = 0; i < manager.length; i++) {
            List<Integer> sub = new ArrayList<>();
            employees.add(sub);
        }

        // fill data
        for (int i = 0; i < manager.length; i++) {
            int managerId = manager[i];
            if (managerId != -1) {
                employees.get(managerId).add(i);
            }
        }
        return employees;

    }
}
