import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



public class P2J4 {
    
    public static List<Integer> runningMedianOfThree(List<Integer> items){

        List<Integer> res = new ArrayList<>();

        if(items.size() <= 2){
            for(int i = 0; i < items.size(); i++){
                res.add(items.get(i));
            }

        }
        else{
            res.add(items.get(0));
            res.add(items.get(1));

            for(int i = 2; i < items.size(); i++){
            
                
                List<Integer> sortList = new ArrayList<>(3);
                sortList.add(items.get(i - 2));
                sortList.add(items.get(i - 1));
                sortList.add(items.get(i));

                Collections.sort(sortList);
                res.add(sortList.get(1));
            }
        }

        return res;
    }

    public static int firstMissingPositive(List<Integer> items){
        
        List<Integer> sortList = new ArrayList<>();
        for(int i = 0; i < items.size(); i++){
        sortList.add(items.get(i));
        }
        
        for(int i = 1; i <= sortList.size() + 1; i++){
            if(!sortList.contains(i)){
                return i ;
            }
        }
        return sortList.size();
    }

    public static void sortByElementFrequency(List<Integer> items){

        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();

        
        for(Object element : items){
            Integer i = (Integer) element;
            
            if(freq.containsKey(i)){
                freq.put(i, freq.get(i) + 1);
            } 
            else{
                freq.put(i, 1);
            }

        }
        
        Collections.sort(items, new Comparator<Integer>() {
        
            @Override
            public int compare(Integer obj1, Integer obj2) {
                int diff = freq.get(obj2) - freq.get(obj1);
                
                if(diff != 0){
                    return diff;
                }

                return obj1.compareTo(obj2);
            }
        
        });

    }

    /*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~C    H    A    N    G    E~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    public static List<Integer> factorFactorial(int n){
        List<Integer> element = new ArrayList<Integer>();

        for(int i = 2; i <= n; i++){
            addFactors(i,element);
        }
        
        Collections.sort(element);
        return element;

    }

    public static void addFactors(int n, List<Integer> list){
        int val = n;
        
        while( val %2 ==0 ){
            list.add(2);
            val = val /2;
        }
        for(int i = 3; i <= val; i+=2){
            while( val %i == 0){
                list.add(i);
                val = val /i;
            }
        }
        if( val > 1)
        list.add(val);
    }
}
