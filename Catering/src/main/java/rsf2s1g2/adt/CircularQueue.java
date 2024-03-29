package rsf2s1g2.adt;
import java.util.Arrays;
import rsf2s1g2.utility.Font;

/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public class CircularQueue <T> implements CircularQueueInterface<T>{
    private int count;        //Current Queue size
    private T[] array;           // Data stored
    private final int capacity;       // Maximum size for circular queue
    private int rear;           //For adding new element at back or rear
    private int front;          //For dequeuing element from the front.
    private static final int DEFAULT_CAPACITY = 50;
    
    public CircularQueue(){
        this(DEFAULT_CAPACITY);
    }
    
    public CircularQueue(int size){
        this.capacity = size;
        array = (T[]) new Comparable[this.capacity];
        count = 0;
        front = -1;
        rear = -1;
    }
    @Override
    public boolean enqueue(T newEntry){
        if(newEntry == null){
            Font.print(Font.ANSI_RED,"Data cannot be empty!");
            return false;
        }
        if(isFull()){
            Font.print(Font.ANSI_RED,"Queue is Full. Cannot add more data!");
            return false;
        }
        else{
            rear = (rear + 1)% array.length;
            array[rear] = newEntry;
            count++;
            
            if(front == -1){
                front = rear;
            }
            return true;
        }
    }
    @Override
    public boolean dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty. Cannot delete data!");
            return false;
        }else{
            array[front] = null;
            front = (front + 1)% array.length;
            count--;
        }
        return true;
    }
    
    @Override
    public T peek(){
        if(isEmpty()){
            Font.print(Font.ANSI_RED,"Queue is Empty.");
            return null;
        }
        else{
           return array[front]; 
        }
    }
    
    @Override
    public boolean isFull(){
        return (count == array.length);
    }
    @Override
    public boolean isEmpty(){
        return(count == 0);
    }
    
    @Override
    public int getCount(){
        return count;
    }
    
    @Override
    public void clear(){
            array = null;
            count = 0;
            front = -1;
            rear = -1;
    }

    @Override
    public T getEntry(int position) {
        int current = front;
        int n = 0;
        if(current != -1){
            while(array[current] != null){
                if(current == position){
                    return array[position];
                }
                n++;
                current++;
            }
        }
       return null; 
    }

    @Override
    public int getRear() {
        return rear;
    }

    @Override
    public int getFront() {
        return front;
    }
}