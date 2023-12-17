import java.util.List;
import java.util.ArrayList;

public class WordCount extends FileProcessor<List<Integer>>{

    private int cCount;
    private int wCount;
    private int lCount;

    @Override
    protected void startFile() {
        this.cCount = 0;
        this.wCount = 0;
        this.lCount = 0;
    }

    @Override
    protected void processLine(String line) {
        int i = 0;
        lCount = lCount + 1;
        cCount = cCount + line.length();
        
        while(i < line.length()){
               
            if(!Character.isWhitespace(line.charAt(0)) && i == 0){
                wCount++;
            } 
            else if(Character.isWhitespace(line.charAt(i - 1)) && !Character.isWhitespace(line.charAt(i))){
                wCount++;
            } 
        i++;
        }
    }

    @Override
    protected List<Integer> endFile() {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(cCount);
        res.add(wCount);
        res.add(lCount);

        return res;
    }
    
}

