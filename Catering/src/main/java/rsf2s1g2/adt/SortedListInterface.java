package rsf2s1g2.adt;

/**
 *
 * @author Wee Yan
 * @param <T>
 */
public interface SortedListInterface<T extends Comparable<T>> {

  public boolean insert(T newData);

  public boolean delete(T anData);

  public boolean check(T anData);

  public void clear();

  public int getCount();

  public boolean isEmpty();

}