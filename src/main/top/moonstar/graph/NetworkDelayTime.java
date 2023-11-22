package top.moonstar.graph;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = new int[][] {
                { 1, 2, 1 }
               
        };
        int n = 2;
        int k = 2;

        System.out.println(new NetworkDelayTime().networkDelayTime(times, n, k));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        k = k - 1;
        int[][] timeMatrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                timeMatrix[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < times.length; i++) {
            int[] time = times[i];
            timeMatrix[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] toNodes = timeMatrix[k];
        for (int i = 0; i < toNodes.length; i++) {
            int dist = toNodes[i];
            if (dist == Integer.MAX_VALUE) {
                continue;
            }
            traverse(timeMatrix, k, i);
        }

        int minTime = 0;
        for (int i = 0; i < n; i++) {
            int toNodeTime = timeMatrix[k][i];
            if (toNodeTime == Integer.MAX_VALUE) {
                return -1;
            }
            minTime = Math.max(toNodeTime, minTime);
        }
        return minTime;
    }

    public void traverse(int[][] timeMatrix, int k, int next) {
        int[] toNodes = timeMatrix[next];
        int existingDist = timeMatrix[k][next];

        for (int i = 0; i < toNodes.length; i++) {
            int dist = toNodes[i];
            if (dist == Integer.MAX_VALUE) {
                continue;
            }

            if (existingDist + dist < timeMatrix[k][i]) {
                timeMatrix[k][i] = existingDist + dist;
                traverse(timeMatrix, k, i);
            }
        }
    }
}