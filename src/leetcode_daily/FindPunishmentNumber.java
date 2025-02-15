package leetcode_daily;

class FindPunishmentNumber {
    private boolean check(int sq, int currSum, int sum) {
        if (sq == 0) {
            return currSum == sum;
        }

        return check(sq / 10, currSum + sq % 10, sum) || check(sq / 100, currSum + sq % 100, sum) || check(sq / 1000, currSum + sq % 1000, sum) || check(sq / 10000, currSum + sq % 10000, sum);
    }

    public int punishmentNumber(int n) {
        int punishment = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, 0, i)) {
                punishment += i * i;
            }
        }

        return punishment;
    }
}
