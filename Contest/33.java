/* Longgest Harmonious Subsequence*/
/*The Longgest subArray the different between max and min is one */
public class Solution {
public int findLHS(int[] nums){
        HashMap <Integer,Integer> map = new HashMap<>();
        int res = 0;
        for(int num:nums) {
                map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int key: map.KeySet()) {
                if(map.containsKey(key+1))
                        res = Math.max(res,map.get(key)+map.get(key+1));
        }
        return res;
}
}

/*Valid Square*/
/* Given the point and determine whether it is a square*/

public class Solution {
public double dist(int[] p1, int[] p2){
        return (p2[1]-p1[1])*(p2[1]-p1[1])+(p2[0]-p1[0])*(p2[0]-p1[0]);
}
public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4){
        int[][] p = {p1,p2,p3,p4};
        Arrays.sort(p,(l1,l2)->l2[0]==l1[0] ? l1[1]-l2[1] : l1[0]-l2[0]);
        return dist(p[0],p[1]) != 0 && dist(p[0],p[1]) ==dist(p[1],p[3])&&dist(p[1],p[3])==dist(p[3],p[2])&&dist(p[3],p[2])==dist(p[2],p[0])&& dist(p[0],p[3])==dist(p[1],p[2]);
}
}
/*Fraction Addition and Subtraction*/
public class Solution {
public String fractionAddition(String expression){
        List<Character> sign = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++) {
                if(expression.charAt(i)=='+'||expression.charAt()=='-')
                        sign.add(expression.charAt(i));
        }
        List<Integer> num = new ArrayList<>();
        List<Integer> den = new ArrayList<>();
        for(String sub: expression.split("\\+")) {
                for (String subsub : sub.split("-")) {
                        if(subsub.length()>0) {
                                String[] faction = subsub.split("/");
                                num.add(Integer.parseInt(fraction[0]));
                                den.add(Integer.parseInt(fraction[1]));
                        }
                }
        }
        if(expression.charAt(0) == '-') {
                num.set(0,-num.get(0));
                sign.remove(0);
        }
        int lcm = 1;
        for(int x : den) {
                lcm = lcm_(lcm,x);
        }
        int res = lcm/den.get(0)*num.get(0);
        for(int i = 1; i< num.size(); i++) {
                if(sign.get(i-1)=='+')
                        res+=lcm/den.get(i)*num.get(i);
                else
                        res-=lcm/den.get(i)*num.get(i);
        }
        int g = gcd(Math.abs(res),Math.abs(lcm));
        return (res/g)+"/"+(lcm/g);
}
public int lcm_(int a, int b){
        return a*b/gcd(a,b);
}
public int gcd(int a, int b){
        while(b!=0) {
                int t = b;
                b = a % b;
                a =t;
        }
        return a;
}
}

/* Design In-Memory File System*/
public class FileSystem{
  class Dir{
    HashMap<String,Dir> dirs = new HashMap<>();
    HashMap<String,String> files = new HashMap<>();
  }
  Dir root;
  public FileSystem(){
    root = new Dir();
  }
  public　List<String> ls(String path){
    Dir t = root;
    List <String> files = new ArrayList<>();
    if(!path.equals("/")){
      for(int i = 1; i < d.length-1; i++){
        t = t.dirs.get(d[i]);
      }
      if(t.file.containsKey(d[d,length-1])){
        files.add(d[d.length-1]);
        return files;
      }else{
        t = t.dirs.get(d[d.length-1]);
      }
    }
    files.addAll(new ArrayList<>(t.dirs.KeySet()));
    files.addAll(new ArrayList<>(t.files.KeySet()));
    Collections.sort(files);
    return files;
  }

  public void mkdir(String path){
    Dir t = root;
    String[] d = path.split("/");
    for(int i = 1; i < d.length; i++){
      if(!t.dirs.containsKey(d[i]))
        t.dirs.put(d[i],new Dir());
      t = t.dirs.get(d[i]);
    }
  }
  public void addContentToFile(String filePath, String content){
    Dir t = root;
    String[] d = filePath.split("/");
    for(int i = 1; i< d.length-1; i++){
      t = t.dirs.get(d[i]);
    }
    t.files.put(d[d.length-1],t.files.getOrDefault(d[d.length-1],"")+content);
  }
  public String readContentFromFile(String filePath){
    Dir t = root;
    String[] d = filePath.split("/");
    for(int i = 1; i < d.length-1; i++){
      t = t.dirs.get(d[i]);
    }
    return t.files.get(d[d.length-1]);
  }
}
