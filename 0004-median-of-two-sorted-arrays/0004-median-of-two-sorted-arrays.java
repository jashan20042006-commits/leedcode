class Solution {
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }

    int m = nums1.length;
    int n = nums2.length;

    int left = 0;
    int right = m;

    while (left <= right) {

        int p1 = left + (right - left) / 2;
        int p2 = (m + n + 1) / 2 - p1;

        int max1 = (p1 == 0) ? Integer.MIN_VALUE : nums1[p1 - 1];
        int min1 = (p1 == m) ? Integer.MAX_VALUE : nums1[p1];

        int max2 = (p2 == 0) ? Integer.MIN_VALUE : nums2[p2 - 1];
        int min2 = (p2 == n) ? Integer.MAX_VALUE : nums2[p2];

        if (max1 <= min2 && max2 <= min1) {

            if ((m + n) % 2 == 1) {
                return Math.max(max1, max2);
            }

            return (Math.max(max1, max2) + Math.min(min1, min2)) / 2.0;

        } else if (max1 > min2) {
            right = p1 - 1;

        } else {
            left = p1 + 1;
        }
    }

    return 0.0;
}}