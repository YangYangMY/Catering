package rsf2s1g2.adt;
/**
 *
 * @author Wee Yan
 * @param <T>
 * 
 */
public class OrderQueue <T extends Comparable<? super T>> implements OrderQueueInterface<T>{
    
	private Node FirstNode;
	private Node LastNode;
	private int length;

	public OrderQueue(){
            FirstNode = null;
            LastNode = null;
            length = 0;
        }
        
        public T last(){
            return LastNode.data;
        }
        
        @Override
        public boolean add(T newEntry){
            Node newNode = new Node(newEntry);
            Node previous = null;
            Node current = FirstNode;
            
            if(newEntry != null){
                while(current != null && newEntry.compareTo(current.data)<0){
                    previous = current;
                    current = current.next;
                }
                
                if(previous == null){
                    newNode.next = FirstNode;
                    FirstNode = newNode;
                }
                else{
                    previous.next = newNode;
                    newNode.next = current;
                }
                length++;
                return true;
            }
            else{
                return false;
            }
        }
        
        @Override
        public boolean isEmpty(){
            return (length == 0);
        }
        
        @Override
        public void clear(){
            FirstNode = null;
            LastNode = null;
            length = 0;
        }
        
        @Override
        public int getSize(){
            return length;
        }
        
        @Override
        public void remove(T EntryData){
            if (EntryData == null){
                return;
            }
            Node temp = FirstNode;
            Node previous = null;
            
            if(temp != null && temp.data == EntryData){
                FirstNode = temp.next;
                length --;
                return;
            }
            
            while(temp != null && temp.data != EntryData){
                previous = temp;
                temp = temp.next;
                
                if(temp.data == EntryData){
                    length--;
                }
            }
            
            //IF data is not found in queue
            if (temp == null)
                return;
            previous.next = temp.next;
        }
        
        @Override
        public T getEntry(int position){
            Node current = FirstNode;
            int count = 0;
            
            while(current != null){
                if(count == position){
                    return current.data;
                }
                else{
                    count++;
                    current = current.next;
                }
            }
            
            return null;
        }
        
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
        public boolean dequeue(){
            
           T front = null;
           
           if(!isEmpty()){
               front = FirstNode.data;
               FirstNode = FirstNode.next;
           
               if(FirstNode == null){
                   LastNode = null;
               }
               length--;
               return true;
           }
           else{
               return false;
           }
        }
        
       @Override
       public T peek(){
           if(isEmpty()){
               return null;
           }
           else{
               return FirstNode.getData();
           }
       }

      
       
}
