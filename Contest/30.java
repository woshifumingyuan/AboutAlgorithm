/*matrixReshape*/
public class Solution {
public int[][] matrixReshape(int[][] nums, int r, int c){
        int n = nums.length, m = nums[0].length, k = 0;
        if(r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++,k++) {
                        res[i][j] = nums[k/m][k%m];
                }
        }
        return res;
}
}
/*subarraySum*/
public class Solution {
public int subarraySum(int[] nums, int k){
        int sum = 0, result = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0,1);
        for(int i = 0; i < nums.length; i++) {
                sum += nums[i];
                result += preSum.getOrDefault(sum-k,0);
                preSum.put(sum,preSum.getOrDefault(sum,0)+1);

        }
        return result;
}
}
