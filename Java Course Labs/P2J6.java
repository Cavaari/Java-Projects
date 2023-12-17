//import java.util.ArrayList;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.*;

public class P2J6 {

    public static List<Integer> sumOfDistinctCubes(int n){
        
        int c = 1;
        LinkedList<Integer> list = new LinkedList<Integer>();
        while(c * c * c < n){
            c++;
        }
        
        sumOfDistinctCubes(n , c, list);
        return list;
    }


    private static boolean sumOfDistinctCubes(int n, int c, LinkedList<Integer> soFar){
        if(n == 0){
            return true;
        }
        if(c == 0){
            return false;
        }
    
        int cubed = c * c * c;

        if(n >= cubed) {
            soFar.add(c);
            if(sumOfDistinctCubes(n - (cubed) , c - 1 , soFar)){
                return true;
            }
            soFar.remove(soFar.size() - 1);
       }
       return sumOfDistinctCubes(n, c - 1, soFar);
    }

    public static List<String> forbiddenSubstrings(String alphabet, int n, List<String> tabu){
       
        String list = "";
        List<String> result = new ArrayList<String>();
        forbiddenSubstrings( alphabet,  n, tabu, list, result);
        Collections.sort(result);
        return result;
    }

    private static void forbiddenSubstrings(String alphabet, int n, List<String> tabu, String soFar, List<String> result){
        if(soFar.length() == n){
            result.add(soFar);
        }
        else{
            labelOutLoop:
            for(int i = 0; i < alphabet.length(); i++){
                String next = soFar + alphabet.charAt(i);
                for(String str:tabu){
                    if(next.endsWith(str)){
                        continue labelOutLoop;
                    }
                }
                forbiddenSubstrings( alphabet,  n, tabu, next, result);
            }
        }
    }
    
}
