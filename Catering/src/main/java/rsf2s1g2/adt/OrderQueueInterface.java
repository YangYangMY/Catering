package rsf2s1g2.adt;



/**
 *
 * @author Wee Yan
 * 
 */
public interface OrderQueueInterface {
    
    public void Enqueue(String name, String date);

    public String[] Dequeue();
    
    public String[] peek();
    
    public boolean isEmpty();
   
    public int getSize();
    
    public void clear();
}
