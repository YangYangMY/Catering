package rsf2s1g2.adt;
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
        return (size() == 0);
    }
    
    //Add new data into Queue
    @Override
    public void Enqueue(String name, String date){
        //Check Overflow
        if (isFull()){
            System.out.println("Array is Full!! Cannot add more values.");
        }
        else{
            backIndex = (backIndex + 1) % this.cap;
            nameArray[count] = name;
            dateArray[count] = date;
            System.out.println("Data has been succesfully enqueued!" + nameArray[count] + dateArray[count]);
            count++;
        }
    }

    //Remove first data in Queue and return data
    @Override
    public String[] Dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty!! Cannot Dequeue values.");
            return null;
        }
        else{
            String[] temp = new String[]{nameArray[frontIndex], dateArray[frontIndex]};
            frontIndex = (frontIndex + 1 )& this.cap;
            count--;
            return temp;
        }
    }
    
       //Peek the front element of the queue
    @Override
    public String[] peek(){
        if(isEmpty()){
            System.out.println("Queue is Empty!! Cannot Dequeue values.");
            return null;
        }
        String[] temp = new String[]{nameArray[frontIndex], dateArray[frontIndex]};
        return temp;
    }

    //Print all Queue
    @Override
    public String toString() {
        if (isEmpty()) {
        return "Queue is Empty!";
        }
        else{
            for (int i = frontIndex; i <= backIndex; i++){
                System.out.println("Queue "+ (i+1) + ":");
                System.out.println("========================");
                System.out.println("Name: "+ nameArray[i] + "\nDate: " + dateArray[i]);
            }
        return "";
        }
    }
    
    
    
    @Override
    public int getSize(){
        return count;
    }
    
    
    //Delete everything
    @Override
    public void clear(){
        count = 0;
        cap = 0;
        frontIndex = 0;
        backIndex = 0;
        nameArray = null;
        dateArray = null;
    }
}
