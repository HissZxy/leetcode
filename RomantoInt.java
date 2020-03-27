import java.util.HashMap;
import java.util.Map;

class Solution{

    public int romanToInt(String s) {
        Map<Character,Integer> Map = new HashMap<>();
        Map.put('I',1);
        Map.put('V',5);
        Map.put('X',10);
        Map.put('L',50);
        Map.put('C',100);
        Map.put('D',500);
        Map.put('M',1000);
        int last = 0;
        int result = 0;
        for(int i = 0;i<s.length();i++){
            if(last == 0){
                last = Map.get(s.charAt(i));
                result += last;
            }else{
                if(last >= Map.get(s.charAt(i))){
                    last = Map.get(s.charAt(i));
                    result += last;
                }else{
                    result = result + (Map.get(s.charAt(i))-last*2);
                    last = Map.get(s.charAt(i));
                }
            }
        }
        return result;
    }
}