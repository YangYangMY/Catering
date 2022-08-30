package rsf2s1g2.adt;

/**
 *
 * @author Wee Yan
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {

  public boolean add(T newEntry);

  public boolean remove(T anEntry);

  public boolean contains(T anEntry);

  public void clear();

  public int getCount();

  public boolean isEmpty();

}