package leetcode_daily;

import java.util.PriorityQueue;

public class MaximumPassRatio {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length;
        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(b[0],a[0]));

        for (int i = 0; i < n; i++) {
            double currentPR = (double) classes[i][0] / classes[i][1];
            double newPR = (double) (classes[i][0]+1) / (classes[i][1]+1);

            pq.offer(new double[]{newPR - currentPR,i});
        }

        while (extraStudents-- > 0) {
            double[] curr = pq.poll();
            int idx = (int) curr[1];

            classes[idx][0]++;
            classes[idx][1]++;

            double currentPR = (double) classes[idx][0] / classes[idx][1];
            double newPR = (double) (classes[idx][0]+1) / (classes[idx][1]+1);

            pq.offer(new double[]{newPR - currentPR,idx});
        }

        double sum = 0.0;
        for (int i = 0;i < n; i++) {
            sum += (double) classes[i][0]/classes[i][1];
        }

        return sum/n;
    }

    public static void main(String[] args) {
        int[][] classes1 = {{1, 2}, {3, 5}, {2, 2}};
        int extraStudents1 = 2;
        MaximumPassRatio mpr = new MaximumPassRatio();
        System.out.println(mpr.maxAverageRatio(classes1, extraStudents1)); // Expected output: 0.78333

        int[][] classes2 = {{2, 4}, {3, 9}, {4, 5}, {2, 10}};
        int extraStudents2 = 4;
        System.out.println(mpr.maxAverageRatio(classes2, extraStudents2)); // Expected output: 0.53485
    }
}
