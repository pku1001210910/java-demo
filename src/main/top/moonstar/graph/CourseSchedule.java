package top.moonstar.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(new CourseSchedule().canFinish(2, new int[][] { { 1, 0 } }));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            pList.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int[] p = prerequisites[i];
            pList.get(p[0]).add(p[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (pList.get(i).isEmpty()) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer course = queue.poll();

            for (int i = 0; i < numCourses; i++) {
                List<Integer> p = pList.get(i);
                if(p.contains(course)) {
                    p.remove(course);
                    if(p.isEmpty()) {
                        queue.add(i);
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (!pList.get(i).isEmpty()) {
                return false;
            }
        }

        return true;
    }
}