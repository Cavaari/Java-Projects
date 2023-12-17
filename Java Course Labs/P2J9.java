public class P2J9 {
    public static boolean[] sumOfTwoDistinctSquares(int n){
        
        int first = 1; 
        int second = 2;
        boolean[] res = new boolean[n];

        while(n > ((first * first) + (second * second))){
            res[first * first + second * second] = true;
            second++;

            if(((first * first) + (second * second)) >= n ){
                first++;
                second = first + 1;
            }
        }
        return res;
    }

    public static boolean[] subtractSquare(int n){
        boolean res[] = new boolean[n];
        int move = 0;

        for(int i = 1; i < n; i++){
            move = 1;
            while(0 <= (i - move * move)){
                if(!res[(i - move * move)]) {
                res[i] = true;
                break;
                }
            move++;
            }
        }
        return res;
    }
}
