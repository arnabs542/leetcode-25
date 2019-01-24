package array;

import org.junit.Assert;

/*
799. Champagne Tower
Medium

230

13

Favorite

Share
We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  Each glass holds one cup (250ml) of champagne.

Then, some champagne is poured in the first glass at the top.  When the top most glass is full, any excess liquid poured will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has it's excess champagne fall on the floor.)

For example, after one cup of champagne is poured, the top most glass is full.  After two cups of champagne are poured, the two glasses on the second row are half full.  After three cups of champagne are poured, those two cups become full - there are 3 full glasses total now.  After four cups of champagne are poured, the third row has the middle glass half full, and the two outside glasses are a quarter full, as pictured below.



Now after pouring some non-negative integer cups of champagne, return how full the j-th glass in the i-th row is (both i and j are 0 indexed.)



Example 1:
Input: poured = 1, query_glass = 1, query_row = 1
Output: 0.0
Explanation: We poured 1 cup of champange to the top glass of the tower (which is indexed as (0, 0)). There will be no excess liquid so all the glasses under the top glass will remain empty.

Example 2:
Input: poured = 2, query_glass = 1, query_row = 1
Output: 0.5
Explanation: We poured 2 cups of champange to the top glass of the tower (which is indexed as (0, 0)). There is one cup of excess liquid. The glass indexed as (1, 0) and the glass indexed as (1, 1) will share the excess liquid equally, and each will get half cup of champange.
 */
public class ChampagneTower {
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double[] res = new double[101];
        res[0] = poured;
        for(int row=1; row<=query_row; row++)
            // i th glass
            for(int i=row; i>=0; i--) {
                res[i] = Math.max(0.0, (res[i]-1)/2);
                res[i+1] += res[i];
            }
            /*
            res[row] = Math.max(0.0, (res[row]-1)/2);
            res[row+1] += res[row];

            res[row - 1] = Math.max(0.0, (res[row - 1]-1)/2);
            res[row] += res[row - 1];

            res[row - 2] = Math.max(0.0, (res[row - 2]-1)/2);
            res[row - 1] += res[row - 2];
             */

        return Math.min(res[query_glass], 1.0);
    }

    public static void main(String[] args) {
        int poured = 2, query_glass = 1, query_row = 1;
        double res = ChampagneTower.champagneTower(poured, query_row, query_glass);
        double expected = 0.5;
        double  threshold = (double) (1/ Math.pow(2, 32));
        Assert.assertTrue(Math.abs(expected - res) < threshold);
    }
}
