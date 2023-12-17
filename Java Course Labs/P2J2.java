import java.util.HashSet;

public class P2J2 {
    
    public static String removeDuplicates(String text){

        String res = "";
            for (int i = 0; i < text.length(); i++) {
                if (i == 0 || text.charAt(i) != res.charAt(res.length() - 1)) {
                    res = res + text.charAt(i);
                }
            }
            return res;
    }

    public static String uniqueCharacters(String text){
        StringBuffer uString = new StringBuffer(); 
        
        for(int i = 0; i < text.length();i++){
            char letter = text.charAt(i);
            boolean check = false;
             
            for(int  j = 0; j < i; j++){
                if(letter == text.charAt(j)){
                    check = true;
                    break; 
                }
            }
            if(!check){
            uString.append(letter);
            }
        } 
        return uString.toString();
    }

    public static int countSafeSquaresRooks(int n, boolean[][] rooks){
        int numCol = 0;
        int numRow = 0;
        int safeCount = 0;

        HashSet<Integer> setcol = new HashSet <Integer>();
        HashSet<Integer> setrow = new HashSet <Integer>();
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(rooks[i][j] == true){
                    setcol.add(j);
                    setrow.add(i);
                }
                else{
                    continue;
                }
            }
        }
        numCol = n - setcol.size();
        numRow = n - setrow.size();
        safeCount = numRow * numCol;
        return safeCount;
    }

    public static int recaman(int n){
        
        boolean tracker[] = new boolean[10 * n];
        int res[] = new int[n + 1];
        tracker[0] = true;
        res[0] = 0;

        for(int i = 1; i <= n; i++){
            int moveUp = res[i - 1] + i;
            int moveBk = res[i - 1] - i;

             if((moveBk > 0) && (!tracker[moveBk])){
                res[i] = moveBk;
                tracker[moveBk] = true;
             }
             else{
                 res[i] = moveUp;
                 tracker[moveUp] = true;
             }
        }
        return res[n];
    }
}
