package binarySearch;

import org.junit.Assert;

/*
875. Koko Eating Bananas
Medium

260

26

Favorite

Share
Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and will come back in H hours.

Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.

Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.

Return the minimum integer K such that she can eat all the bananas within H hours.



Example 1:

Input: piles = [3,6,7,11], H = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], H = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], H = 6
Output: 23
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int H) {
        int lo = 1, hi = getMaxPile(piles);

        // Binary search to find the smallest valid K.
        while (lo < hi) {
            int K = lo + ((hi - lo) >> 1);
            if (canEatAll(piles, K, H)) {
                hi = K;
            } else {
                lo = K + 1;
            }
        }

        return hi;
    }

    private boolean canEatAll(int[] piles, int K, int H) {
        int countHour = 0; // Hours take to eat all bananas at speed K.

        for (int pile : piles) {
            countHour += pile / K;
            if (pile % K != 0)
                countHour++;
        }
        return countHour <= H;
    }

    private int getMaxPile(int[] piles) {
        int maxPile = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPile = Math.max(pile, maxPile);
        }
        return maxPile;
    }

    public static void main(String[] args) {
        //int[] piles = {3, 6, 7, 11};
        int[] piles = {21, 22, 23, 100};
        int H = 8;
        KokoEatingBananas solution = new KokoEatingBananas();
        int K = solution.minEatingSpeed(piles, H);
        int expected = 4;
        Assert.assertEquals(expected, K);
    }
}
