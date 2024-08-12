package leetcode.interview.array_string;

public class T88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] numsRes = new int[m + n];

        for (int i = 0, im = 0, in = 0; i < m + n; i++) {
            if (im >= m) {
                numsRes[i] = nums2[in++];
            } else if (in >= n) {
                numsRes[i] = nums1[im++];
            } else {
                numsRes[i] = (nums1[im] < nums2[in] ? nums1[im++] : nums2[in++]);
            }
        }

        if (m + n >= 0) System.arraycopy(numsRes, 0, nums1, 0, m + n);
    }
}
