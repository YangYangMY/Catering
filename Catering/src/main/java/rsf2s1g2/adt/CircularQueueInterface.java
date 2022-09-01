package rsf2s1g2.adt;



/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public interface CircularQueueInterface<T>{
    
    public boolean enqueue(T newEntry);
    
    public T dequeue();
	
    public T peek();
	
    public boolean isEmpty();
    
    public boolean isFull();
    
    public T getEntry(int position);
	
    public int getCount();
	
    public void clear();

    public int getFront();

    public int getRear();


}
