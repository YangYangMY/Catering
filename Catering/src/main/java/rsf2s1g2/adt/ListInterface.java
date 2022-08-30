package rsf2s1g2.adt;

public interface ListInterface<T> {

  public boolean add(T newObj);

  public T remove(int posOfObj);

  public T get(int posOfObj);

  public int size();

  public boolean isEmpty();

  public boolean isFull();

  public void clear();

  public boolean set(int givenPos, T newObj);

  public void undo();
}

  
