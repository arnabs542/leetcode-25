package array;

import java.util.Arrays;

/*
805. Split Array With Same Average
Hard
191
39
Favorite
Share
In a given integer array A, we must move every element of A to either list B or list C. (B and C initially start empty.)
Return true if and only if after such a move, it is possible that the average value of B is equal to the average value
of C, and B and C are both non-empty.
Example :
Input:
[1,2,3,4,5,6,7,8]
Output: true
Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 */
public class SplitArrayWithSameAverage {
    public boolean splitArraySameAverage(int[] A) {

        int length=A.length;
        int sum=0;
        for (int i = 0; i < length; i++) {
            sum=sum+A[i];
        }
        Arrays.sort(A);
        for (int i = 1; i <= length/2; i++) {
            if(sum*i%length==0){
                if(checkNSum(A,i,i*sum/length,0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkNSum(int[] nums,int n,int target,int startIndex){
        if(target==0 && n==0){
            return true;
        }
        if(n!=0){
            for (int i = startIndex; i < nums.length+1-n; i++) {
                if(i>startIndex && nums[i]==nums[i-1]){
                    continue;
                }
                if(target<nums[i]*n || target>nums[nums.length-1]*n){
                    break;
                }
                if(checkNSum(nums,n-1,target-nums[i],i+1)){
                    return true;
                }
            }
        }
        return false;
    }
}
