package rsf2s1g2.adt;
/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public class OrderQueue <T extends Comparable<? super T>> implements OrderQueueInterface<T>{
    
	private Node firstNode;
	private Node lastNode;
	private int length;

	
	public PriorityQueue() {
		firstNode=null;
		lastNode=null;
		length=0;
		
	}
	public T last() {
		return lastNode.data;}
	
        @Override
	public boolean add(T newEntry) {
	Node newNode = new Node(newEntry);
        Node previous = null;
        Node current = firstNode;
        if(newEntry != null) {
        while (current != null && newEntry.compareTo(current.data)<0) {
            previous = current;
            current = current.next;
        }

        if (previous == null) {
            newNode.next = firstNode;
            firstNode = newNode;
        }

        else {
            previous.next = newNode;
            newNode.next = current;
        }
      length++;
      return true;
        }
        
        else 
        	
            return false;
	}			

	
        @Override
	public boolean isEmpty() {
		return length == 0;
	}
	
        @Override
	public void clear() {
		firstNode=null;
		lastNode=null;
		length=0;
	}
        @Override
	public int getSize() {
		return length;
	}

        @Override
        public void remove(T anEntry) {
         if(anEntry==null){return;}
        Node temp = firstNode, prev = null;
        
        if (temp != null && temp.data == anEntry) {
            firstNode = temp.next; 
            length--;
            return;
        }
 
     
        while (temp != null && temp.data != anEntry) {
            prev = temp;
            temp = temp.next;
            
            if(temp.data==anEntry){
            length--;
            }
           
        }
 
        //not found
        if (temp == null)
        
            return ;
        prev.next = temp.next;
    }
        
        @Override
        public T getEntry(int position){
        
        Node current = firstNode;
        int count = 0; 
        while (current != null)
        {
            if (count == position)
                return current.data;
            count++;
            current = current.next;
        }
        
        
        return null;
    
        };
	
        private class Node {
		
		private T data;
		private Node next;
		
		private Node(T dataPortion) {
			this(dataPortion,null);
		}
		private Node(T dataPortion, Node nextNode) {
			this.data = dataPortion;
			this.next = nextNode;
		}
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node getNextNode() {
			return next;
		}
		public void setNextNode(Node next) {
			this.next = next;
		}
	}

        @Override
        public boolean dequeue() {
	
        T front = null;
        

        if (!isEmpty()) {
        front = firstNode.data;
        firstNode = firstNode.next;

        if (firstNode == null) {
        lastNode = null;
         }
        length--;
        return true;
        
     } else return false;
   // end dequeue
        /*int endnumber=length;
        
        if(firstNode != null) {
		result = firstNode.getData();
		firstNode = firstNode.next;
		length--;}
        

    return result;*/
}

        


        @Override
	public T peek() {
	if(isEmpty()) 
		return null;
	return firstNode.getData();
	}
	
	
	
	/*public String[] toArray(){
		int index = 0;
		String[] array = new String[10];
		Node temp = firstNode;
		
		while(temp != null) {
			array[index]= temp.data.toString();
			index++;
			temp = temp.next;
		}
		return array;
	}*/
        
        
       

}
