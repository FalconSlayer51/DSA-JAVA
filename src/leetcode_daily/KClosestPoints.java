package leetcode_daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KClosestPoints {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        double[][] pointToDistance = new double[n][3];

        for (int i = 0; i < n; i++) {
            double distance = calculateDistanceFromOrigin(points[i]);
            pointToDistance[i][0] = points[i][0];
            pointToDistance[i][1] = points[i][1];
            pointToDistance[i][2] = distance;
        }

        PriorityQueue<double[]> pq = new PriorityQueue<>((a,b) -> Double.compare(a[2],b[2]));
        Collections.addAll(pq, pointToDistance);

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            double[] currentPoint = pq.poll();
            result[i][0] = (int) currentPoint[0];
            result[i][1] = (int) currentPoint[1];
        }

        return result;
    }

    private double calculateDistanceFromOrigin(int[] coordinates) {
        int x = coordinates[0];
        int y = coordinates[1];

        return Math.sqrt(Math.pow((x-0),2) + Math.pow(y-0,2));
    }

    public static void main(String[] args) {
        KClosestPoints solution = new KClosestPoints();

        // Example 1
        int[][] points1 = {{1, 3}, {-2, 2}};
        int k1 = 1;
        System.out.println(Arrays.deepToString(solution.kClosest(points1, k1))); // Expected output: [[-2, 2]]

        // Example 2
        int[][] points2 = {{3, 3}, {5, -1}, {-2, 4}};
        int k2 = 2;
        System.out.println(Arrays.deepToString(solution.kClosest(points2, k2))); // Expected output: [[3, 3], [-2, 4]]
    }
}
