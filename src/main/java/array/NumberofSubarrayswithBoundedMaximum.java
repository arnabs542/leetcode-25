package array;

/*
795. Number of Subarrays with Bounded Maximum
Medium

312

30

Favorite

Share
We are given an array A of positive integers, and two positive integers L and R (L <= R).

Return the number of (contiguous, non-empty) subarrays such that the value of the maximum array element in that subarray is at least L and at most R.

Example :
Input:
A = [2, 1, 4, 3]
L = 2
R = 3
Output: 3
Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 */
public class NumberofSubarrayswithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int j = 0, count = 0, res = 0;

        for (int i = 0; i < A.length; i++) {
            if (A[i] >= L && A[i] <= R) {
                res += i - j + 1;
                count = i - j + 1;
            } else if (A[i] < L) {
                res += count;
            } else {
                j = i + 1;
                count = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 4, 3};
        int L = 2;
        int R = 3;
        NumberofSubarrayswithBoundedMaximum solution =
                new NumberofSubarrayswithBoundedMaximum();
        int number = solution.numSubarrayBoundedMax(A, L, R);
        System.out.println(number);
    }
}
