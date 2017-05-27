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


/* Delete Operation for two Strings*/

public class Solution{
  public int minDistance(String word1, String word2){
    int[][] dp = new int[word1.length()+1][word2.length()];
    for(int i = 0; i < word1.length(); i++){
      for(int j = 0; j < word2.length(); j++){
        if(i==0||j==0) dp[i][j]=0;
        else{
          if(word1.charAt(i-1)==word2.charAt(j-1)){
            dp[i][j]=dp[i-1][j-1]+1;
          }else{
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
          }
        }
      }
    }
    return word1.length()+word2.length()-dp[word1.length()][word2.length()]*2;
  }
}

/*Erect the Fence*/
public class Solution{
  public int oriention(Point p, Point q, Point r){
    return (q.y-p.y)*(r.x-q.x)-(q.x-p.x)*(r.y-q.y);
  }
  public boolean inBetween(Point p, Point i, Point q){
    boolean a = i.x >= p.x && i.x <= q.x || i.x <= p.x && i.x >= q.x;
    boolean b = i.y >= p.y && i.y <= q.y || i.y <= p.y && i.y >= q.y;
    return a && b;
  }
  public List<Point> outerTrees(Point[] points){
    ArrayList<Point> hull = new ArryList<>();
    if(points.length < 4){
      for(Point p: points) hull.add(p);
      return hull;
    }
    int left_most = 0;
    for (int i = 0; i < points.length; i++)
    if (points[i].x < points[left_most].x) left_most=i;
    int p = left_most;
    do{
      int q = (p + 1)%points.length;
      for(int i = 0; i < points.length; i++){
        if (oriention(points[p],points[i],points[q]) < 0){
          q = i;
        }
      }
      for (int i = 0; i < points.length; i++){
        if (i != p && i != q && oriention(points[p],points[i],points[q])==0&& inBetween(points[p],points[i],points[q])){
          hull.add(points[i]);
        }
      }
      hull.add(points[q]);
      p=q;
    }while( p != left_most);
    return hull;
  }
}
