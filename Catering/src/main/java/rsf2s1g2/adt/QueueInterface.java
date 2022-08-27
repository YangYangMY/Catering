package rsf2s1g2.adt;

import java.util.Date;

/**
 *
 * @author Wee Yan
 * @param <T>
 */
public interface QueueInterface<T extends Comparable <? super T>> {
    
    public boolean Enqueue(String name, Date date);
    
    public void remove(T anEntry);
    
    public boolean dequeue();
    
    public T peek();
    
    public boolean isEmpty();
    
    public T getEntry(int position);
    
    public int getSize();
    
    public void clear();
}
