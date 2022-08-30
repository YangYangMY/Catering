package rsf2s1g2.adt;

import java.util.Arrays;



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
    private int front;          //For dequeing element from the front.
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
        if(isFull()){
            System.out.println("Queue is Full. Cannot add more data!");
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
    public T dequeue(){
        T RemovedElement;
        if(isEmpty()){
            System.out.println("Queue is Empty. Cannot delete data!");
            return null;
        }else{
            RemovedElement = array[front];
            array[front] = null;
            front = (front + 1)% array.length;
            count--;
        }
        return RemovedElement;
    }
    
    @Override
    public T peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty.");
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
    public int getSize(){
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
        
        while(array[current] != null){
            if(current == position){
                return array[position];
            }
            n++;
            current++;
        }
       return null; 
    }
}
