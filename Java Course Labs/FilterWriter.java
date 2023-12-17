import java.io.IOException;
import java.io.Writer;
import java.util.function.BiPredicate;

public class FilterWriter extends Writer {
    private Writer writer;
    private BiPredicate<Character, Character> pred;
    private char previous;

    public FilterWriter(Writer writer, BiPredicate < Character, Character > pred, char previous){
        this.writer = writer;
        this.pred = pred;
        this.previous = previous;
}

    @Override
    public void write(char[] data, int off, int len) throws IOException {
        for(int i = off; i < len; i++){
    
            if(pred.test(previous, data[i])){
                writer.write(data[i]);
                previous = data[i];
            }
        }
    }

    @Override
    public void flush() throws IOException {
        writer.flush();
        
    }

    @Override
    public void close() throws IOException {
        writer.close();
        
    }
    
}
