package leetcode_daily;

import java.util.*;

public class NumberContainers {
    private HashMap<Integer, Integer> idxToNum;
    private HashMap<Integer, TreeSet<Integer>> numToIndices;

    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIndices = new HashMap<>();
    }

    public void change(int index, int number) {
        if (idxToNum.containsKey(index)) {
            int num = idxToNum.get(index);
            idxToNum.put(index, number);
            numToIndices.get(num).remove(index);
            numToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
            return;
        }
        idxToNum.put(index, number);
        numToIndices.computeIfAbsent(number, k -> new TreeSet<>()).add(index);
    }

    public int find(int number) {
        if (!numToIndices.containsKey(number)) {
            return -1;
        }
        TreeSet<Integer> indices = numToIndices.getOrDefault(number, new TreeSet<>());
        if (indices.isEmpty()) {
            return -1;
        }
        return indices.iterator().next();
    }

    public static void main(String[] args) {
        NumberContainers nc = new NumberContainers();
        System.out.println(nc.find(10)); // -1
        nc.change(2, 10);
        nc.change(1, 10);
        nc.change(3, 10);
        nc.change(5, 10);
        System.out.println(nc.find(10)); // 1
        nc.change(1, 20);
        System.out.println(nc.find(10)); // 2

        NumberContainers nc2 = new NumberContainers();
        nc2.change(1, 10);
        System.out.println(nc2.find(10)); // 1
        nc2.change(1, 20);
        System.out.println(nc2.find(10)); // -1
        System.out.println(nc2.find(20)); // 1
        System.out.println(nc2.find(30)); // -1
    }
}
