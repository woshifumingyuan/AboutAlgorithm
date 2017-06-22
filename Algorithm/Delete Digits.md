# 2 Delete Digits
Given string A representative a positive integer which has N digits, remove any k digits of the number, the remaining digits are arranged according to the original order to become a new positive integer.

Find the smallest integer after remove k digits.
### Example
Given an integer A = "178542", k = 4

return a string "12"
### Idea
Write a while loop to have every time the digit be the largest one for the next time.
```java
public String DeleteDigits(String A, int k) {
        // write your code here
        String s = A;
        int i = 0;
        while(k>0){
            if(k>s.length()){
                s = "0";
                break;
            }
            if(s.length()!= 1&&s.charAt(0)=='0'){
                s = s.substring(1);
                continue;
            }
            while(i!=s.length()-1&&s.charAt(i)<=s.charAt(i+1)) i++;
            s = s.substring(0,i)+s.substring(i+1);
            k--;
            i = 0;
        }
        return s;
    }
