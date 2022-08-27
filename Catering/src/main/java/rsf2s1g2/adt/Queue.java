package rsf2s1g2.adt;

import java.util.Date;
import rsf2s1g2.catering.Font;

/**
 *
 * @author Wee Yan
 * @param <T>
 */
public class Queue <T extends Comparable<? super T>> implements QueueInterface<T> {
   
String[] nameArray; // array of name entries
Date[] dateArray;   //array of date
int frontIndex; // index of the front entry
int backIndex; // index of the back entry
int count;
int cap;
    
    Queue(int n){
        count = 0;
        cap = n;
        frontIndex = 0;
        backIndex = -1;
        nameArray = new String[cap];
        dateArray = new Date[cap];
    }
    
    // returns the size of the queue
    public int size(){
	return count;
    }
    
    //return true if array is full
    public boolean isFull(){
        return (size() == cap);
    }
    
    // Utility function to check if the queue is empty or not
    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }
    
    //Add new data into Queue
    @Override
    public boolean Enqueue(String name, Date date){
        //Check Overflow
        if (isFull()){
            System.out.println("Array is Full!! Cannot add more values.");
            return false;
        }
        else{
            nameArray[count] = name;
            dateArray[count] = date;
            Font.print(Font.ANSI_GREEN,"Data has been succesfully enqueued!");
            count++;
            return true;
        }
    }
    
    
    
    
    
    
}
