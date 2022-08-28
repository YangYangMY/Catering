package rsf2s1g2.adt;



/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public interface OrderQueueInterface<T extends Comparable <? super T>>{
    
    public boolean add(T newEntry);
  
    public void remove(T EntryData);
    
    public boolean dequeue();
	
    public T peek();
	
    public boolean isEmpty();
    
    public T getEntry(int position);
	
    public int getSize();
	
    public void clear();
}
