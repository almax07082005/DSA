package leetcode.interview.array_string;

public class T274 {
    private boolean isThis(int hIndex, int[] citations) {
        int count = 0;
        for (int citation : citations) {
            if (citation >= hIndex) {
                count++;
            }
        }
        return count >= hIndex;
    }

    public int hIndex(int[] citations) {
        for (int i = 1; i <= citations.length; i++) {
            if (!isThis(i, citations)) {
                return i - 1;
            } else if (i == citations.length) {
                return i;
            }
        }

        return -1;
    }
}
