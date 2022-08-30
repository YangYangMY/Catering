package rsf2s1g2.adt;

public interface MapInterface<K, V> {
    
    public boolean add(K key, V value);

    public void remove(K key);

    public int getValueIndex(K key);

    public V getValue(K key);

    public boolean isEmpty();

    public boolean contains(K key);

}