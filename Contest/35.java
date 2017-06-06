/* Flower cannot be flanted on adjancent plots*/

public class Solution{
  public boolean canPlaceFlowers(int[] flowerbed, int n){
    int i = 0, count = 0;
    while(i< flowerbed.length){
      if(flowerbed[i]==0&&(i==0||flowerbed[i-1]==0)&&(i==flowerbed.length-1||flowerbed[i+1]==0)){
        flowerbed[i] = 1;
        count++;
      }
      if(count>=n) return true;
      i++;
    }
    return false;
  }
}

/* Construct String from Binary Tree
Input: Binary tree: [1,2,3,4]
       1
     /   \
    2     3
   /
  4

Output: "1(2(4))(3)"
*/
public class Solution{
  public String tree2str(TreeNode t){
    if(t==null) return "";
    if(t.left == null && t.right == null) return t.val+"";
    if(t.right==null) return t.val+"("+tree2str(t.left)+")";
    return t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";
  }
}

/*Find duplicate file in System
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
*/
public class Solution{
  public List<list<String>> findDuplicate(String[] paths){
    HashMap <String, List<String>> map = new HashMap<>();
    for(String path: paths){
      String[] values = path.split(" ");
      for (int i = 1;i < values.length ;i++ ) {
        String[] name_cont = values[i].split("\\()");
        name_cont[1] = name_cont[1].replace(")","");
        List<String> list = map.getOrdefault(name_cont[1],new ArrayList<String>());
        list.add(values[0]+"/"+name_cont[0]);
        map.put(name_cont[1],list);
      }
    }
    List<List<String>> res = new ArrayList<>();
    for(String key: map.keySet()){
      if(map.get(key).size()>1) res.add(map.get(key));
    }
    return res;
  }
}
/* tag validator */
public class Solution{
  Stack<String> stack = new Stack<>();
  boolean contains_tag = false;
  public boolean isValidTagName(String s, boolean ending){
    if(s.length()<1||s.length()>9) return false;
    for(int i = 0; i < s.length(); i++){
      if(!Character.isUpperCase(s.charAt(i))) return false;
    }
    if(ending){
      if(!stack.isEmpty()&&stack.peek().equals(s)) stack.pop();
      else return false;
    }else{
      contains_tag = true;
      stack.push(s);
    }
    return true;
  }
  public boolean isValideCdata(String s){
    return s.indexOf("[CDATA[") == 0;
  }
  public boolean isValid(String code){
    if(code.charAt(0)!='<'||code.charAt(code.length()-1)!='>') return false;
    for(int i = 0; i < code.length(); i++){
      boolean ending = false;
      int closeindex;
      if(stack.isEmpty()&&contains_tag) return false;
      if(code.charAt(i) == '<'){
        if(!stack.isEmpty()&&code.charAt(i+1)=='!'){
          closeindex = code.indexOf("]]>",i+1);
          if(closeindex < 0 || isValideCdata(code.substring(i+2,closeindex)))
          return false;

        }else{
          if(code.charAt(i+1)=='/'){
            i++;
            ending = true;
          }
          closeindex = code.indexOf('>',i+1);
          if(closeindex < 0 || !isValidTagName(code.substring(i+1,closeindex),ending))
          return false;
        }
        i == closeindex;
      }
    }
 return stack.isEmpty()&&contains_tag;
  }
}
