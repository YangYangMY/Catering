package rsf2s1g2.adt;

import rsf2s1g2.catering.Font;


/**
 *
 * @author Wee Yan
 * 
 */
public class OrderQueue implements OrderQueueInterface {
   
String[] nameArray; // array of name entries
String[] dateArray;   //array of date
int frontIndex; // index of the front entry
int backIndex; // index of the back entry
int count;
int cap;
    
    public OrderQueue(int n){
        count = 0;
        cap = n;
        frontIndex = 0;
        backIndex = -1;
        nameArray = new String[cap];
        dateArray = new String[cap];
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
        if (size() == 0){
                    System.out.println(" EMPTY!");
        }
        else{
            System.out.println(count);
        }

        return (size() == 0);
    }
    
    //Add new data into Queue
    @Override
    public boolean Enqueue(String name, String date){
        //Check Overflow
        if (isFull()){
            System.out.println("Array is Full!! Cannot add more values.");
            return false;
        }
        else{
            nameArray[count] = name;
            dateArray[count] = date;
            System.out.println("Data has been succesfully enqueued!" + nameArray[count] + dateArray[count]);
            count++;
            return true;
        }
    }


    
    
    
    
}
