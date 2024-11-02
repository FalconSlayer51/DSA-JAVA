package leetcode_daily;

import java.util.*;

public class MinimumTotalDistance {
    public static long minimumTotalDistance(List<Integer> robot,int[][] factory) {
        List<Integer> robotList = new ArrayList<>(robot);

        // Sort the mutable list
        Collections.sort(robotList);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));
        ArrayList<Integer> factoryPos = new ArrayList<>();
        for (int[] row: factory) {
            for (int i = 0; i < row[1]; i++) {
                factoryPos.add(row[0]);
            }
        }


        long[][] dp = new long[robotList.size()][factoryPos.size()];
        for (long[] row: dp) {
            Arrays.fill(row,-1);
        }

        return minDistance(0,0,robotList,factoryPos,dp);
    }

    private static long minDistance(int currRobot,int currFactory,List<Integer> robot,List<Integer> factories,long[][] dp) {
        if (currRobot == robot.size()) return 0;
        if(currFactory == factories.size()) return (long) 1e12;

        if (dp[currRobot][currFactory] != -1) {
            return dp[currRobot][currFactory];
        }


        long assign = Math.abs(robot.get(currRobot) - factories.get(currFactory)) + minDistance(currRobot+1,currFactory+1,robot,factories,dp);

        long skip = minDistance(currRobot,currFactory+1,robot,factories,dp);

        dp[currRobot][currFactory] = Math.min(assign,skip);
        return dp[currRobot][currFactory];
    }

    public static void main(String[] args) {
        List<Integer> robot1 = List.of(0, 4, 6);
        int[][] factory1 = {{2, 2}, {6, 2}};
        System.out.println(minimumTotalDistance(robot1, factory1)); // Output: 4

        List<Integer> robot2 = List.of(1, -1);
        int[][] factory2 = {{-2, 1}, {2, 1}};
        System.out.println(minimumTotalDistance(robot2, factory2)); // Output: 2
    }
}
