import java.util.*;

public class Tail extends FileProcessor<List<String>>{
    private int numberOfLastLines;
    private LinkedList <String> nLastList;


    public Tail(int n){
        this.numberOfLastLines = n;
    }

    @Override
    protected void startFile() {
        nLastList = new LinkedList<String>();
        
    }

    @Override
    protected void processLine(String line) {
        if(nLastList.size() == this.numberOfLastLines){
            this.nLastList.removeFirst();
        }
        nLastList.addLast(line);
    }

    @Override
    protected List<String> endFile() {
        return this.nLastList;
    }
}
