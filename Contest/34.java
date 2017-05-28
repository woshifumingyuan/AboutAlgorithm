public class Solution{
  public int findIntegers(int num){
      long[] zero = new long[35];
      long[] one = new long[35];
      zero[0] = 1;
      one[0] = 1;
      for(int i = 1; i < 35; i++){
        zero[i] = zero[i-1] + one[i-1];
        one[i] = zero[i-1];
      }
      long n = num;
      n++;
      long answer = 0;
      tag:
      while (n>0){
        long range = Long.lowestOneBit(n);
        long from = n - range;
        int len = Long.numberOfTrailingZeros(range);
        for(int i = 60; i >= 1; i--){
          if(((from&(1l << i )) != 0)&&((from&(1l<<(i-1)))!=0)){
            n = from;
            continue tag;
          }
        }
        answer += zero[len];
        n = from;
      }
      return (int) answer;
  }
}
