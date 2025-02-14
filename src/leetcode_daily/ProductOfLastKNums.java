package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

public class ProductOfLastKNums {
    private List<Integer> list;

    public ProductOfLastKNums() {
        list = new ArrayList<>();
    }

    public void add(int num) {
        if (num == 0) {
            list.clear();
            return;
        }
        if (list.isEmpty()) {
            list.add(num);
            return;
        }
        int n = list.size();
        list.add(num * list.get(n-1));
    }

    public int getProduct(int k) {
        int n = list.size();
        if (k > n) {
            return 0;
        }
        if (k == n) {
            return list.get(n-1);
        }

        int cumProd =  list.get(n-1);
        int currProd = list.get(n-k-1);

        return cumProd/currProd;
    }


    public static void main(String[] args) {
        ProductOfLastKNums productOfNumbers = new ProductOfLastKNums();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]
        System.out.println(productOfNumbers.getProduct(2)); // return 20
        System.out.println(productOfNumbers.getProduct(3)); // return 40
        System.out.println(productOfNumbers.getProduct(4)); // return 0
        productOfNumbers.add(8);        // [3,0,2,5,4,8]
        System.out.println(productOfNumbers.getProduct(2)); // return 32
    }
}
