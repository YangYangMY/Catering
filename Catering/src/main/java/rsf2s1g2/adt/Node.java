package rsf2s1g2.adt;

public class Node<E> {

    private int value;
    private E key;
    private Node<E> next;

    public Node(E k) {
        value = 1;
        key = k;
        next = null;

    }

    public void setValue(int newValue)
    {
        value = newValue;
    }

    public void setNext(Node<E> newNext)
    {
        next = newNext;
    }

    public void setKey(E newKey)
    {
        key = newKey;
    }

    public int getValue()
    {
        return value;
    }

    public Node<E> getNext() 
    {
        return next;
    }

    public E getKey() 
    {
        return key;
    }

    public void incrementValue() 
    {
        value++;
    }

    public void decreaseValue() 
    {
        value--;
    }

    
}