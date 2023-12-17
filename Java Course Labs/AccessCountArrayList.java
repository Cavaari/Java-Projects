import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    private int count = 0;

    @Override
    public E get(int idx){
        count = count + 1;
        return super.get(idx);
    }

    @Override
    public E set(int idx, E item){
        count = count + 1;
        return super.set(idx, item);
    }

    public int getAccessCount(){
        return count;
    }

    public void resetCount(){
        count = 0;
    }
}
