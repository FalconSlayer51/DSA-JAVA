package leetcode_daily;

public class MinimizeXOR {
    public int minimizeXor(int num1, int num2) {
        int x = num1;
        int currentBitCount = Integer.bitCount(x);
        int targetBitCount = Integer.bitCount(num2);

        int bit = 0;
        if (currentBitCount < targetBitCount) {
            while (currentBitCount < targetBitCount) {
                if (!isSet(x,bit)) {
                    x = setBit(x,bit);
                    currentBitCount++;
                }
                bit++;
            }
        } else if (currentBitCount > targetBitCount) {
            while (currentBitCount > targetBitCount) {
                if (isSet(x,bit)) {
                    x = unSet(x,bit);
                    currentBitCount--;
                }
                bit++;
            }
        }

        return x;
    }

    private int unSet(int x, int bit) {
        return x &= ~(1<<bit);
    }

    private int setBit(int x, int bit) {
        return x |= (1 << bit);
    }

    private boolean isSet(int x, int bit) {
        return (x & (1 << bit)) != 0;
    }

    public static void main(String[] args) {
        MinimizeXOR mx = new MinimizeXOR();
        System.out.println(mx.minimizeXor(3, 5)); // Output: 3
        System.out.println(mx.minimizeXor(1, 12)); // Output: 3
    }
}
