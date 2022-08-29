package rsf2s1g2.adt;



/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public interface CircularQueueInterface<T extends Comparable <? super T>>{
    
    public boolean enqueue(T newEntry);
    
    public T dequeue();
	
    public T peek();
	
    public boolean isEmpty();
    
    public boolean isFull();
    
    public T getEntry(int position);
	
    public int getSize();
	
    public void clear();
}
