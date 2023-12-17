import java.util.ArrayList;

public class Towers {
    
    public static int minimizeTowers(int[] blocks){
        ArrayList<Integer> vec = new ArrayList<>();
        
        for (int i = 0; i < blocks.length; i++){
            int low = 0;
            int high = vec.size();

            while(low < high){
                int mid = (low + high) / 2;

                if(vec.get(mid) > blocks[i]){
                    high = mid;
                }
                else{
                    low = mid + 1;
                }
            }
            if( low == vec.size()){
                vec.add(blocks[i]);
            }
            else{
                vec.set(low, blocks[i]);
            }

        }
        return vec.size();
    }
}
