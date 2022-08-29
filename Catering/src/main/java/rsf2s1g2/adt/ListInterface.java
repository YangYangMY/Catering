package rsf2s1g2.adt;

public interface ListInterface<T> {

  public boolean add(T newObj);

  public T remove(int posOfObj);

  public T getObj(int posOfObj);

  public int getQuantity();

  public boolean isEmpty();

  public boolean isFull();

  public void clear();
}

  //public boolean contains(T anObj);

  //public boolean replace(int givenPos, T newObj);