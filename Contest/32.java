/* Given an integer array, you need to find one continuous subarray
that if you only sort this subarray in ascending order, then the whole
array will be sorted in ascending odder*/

public class Solution {
  public int findUnsortedSubarray(int[] nums){
  int n = nums.length;
  int[] a = Arrays.copyOf(nums, n);
  Arrays.sort(a);
  if(Arrays.equals(a,nums)){
    return 0;
  }
  int len = n;
  for(int i = 0; i < n; i++){
    if(a[i] nums[i]){
      len--;
    }else{
      break;
    }
  }
  for(int i = n-1; i >= 0; i--){
    if (a[i] == nums[i]){
      len--;
    }else{
      break;
    }
  }
  return len;
}
}

/* Given n PID and PPID and kill id return list of which process have
been killed*/
public class Solution{
  public  List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill ){
    int n = pid.size();
    Map<Interger, List<Interger>> map = new HashMap<>();
    for(int i = 0; i < n; i++){
      if(ppid.get(i)!=0){
        int x = pid.get(i);
        int y = ppid.get(i);
        if(!map.containsKey(y)){
          map.put(y,new ArrayList<>());
        }
        map.get(y).add(x);
      }
    }
    List<Integer> ans = new ArrayList<>();
    Queue<Interger> q = new ArrayDeque<>();
    q.add(kill);
    ans.add(kill);
    while(!q.isEmpty()){
      int cur = q.poll();
      List<Integer> row = map.get(cur);
      if(row != null){
        for(int u : row){
          q.add(u);
          ans.add(u);
        }
      }
    }
    return ans;
  }
}
