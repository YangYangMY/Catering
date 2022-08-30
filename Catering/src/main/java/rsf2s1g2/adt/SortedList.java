package rsf2s1g2.adt;
/**
 *
 * @author Wee Yan
 * @param <T>
 */
public class SortedList <T extends Comparable<T>> implements SortedListInterface<T>{
  
  private T[] array;
  private int count;
  private static final int DEFAULT_CAPACITY = 30;
  
  public SortedList() {
    this(DEFAULT_CAPACITY);
  }
  
    public SortedList(int initialCapacity) {
    count = 0;
    array = (T[]) new Comparable[initialCapacity];
  }
    
  @Override
  public boolean add(T newEntry){
      int i = 0;
      while(i < count && newEntry.compareTo(array[i]) > 0){
          if(newEntry.compareTo(array[i]) == 0){
              System.out.println("Duplicated data");
              return false;
          }
          i++;
      }
      makeSpace(i+1);
      array[i] = newEntry;
      count++;
      
      return true;
  }
  
    @Override
  public boolean remove(T anEntry){
      
      int i = 0;
      while(i < count && !anEntry.equals(array[i])){
          i++;
      }
      removeGap(i);
      count --;
      return true;
  }
  

  
    @Override
  public void clear() {
    count = 0;
  }
  
    @Override
  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < count); index++) {
      if (anEntry.equals(array[index])) {
        found = true;
      }
    }
    return found;
  }

  @Override
  public int getCount(){
      return count;
  }

  @Override
  public boolean isEmpty(){
      return (count == 0);
  }
  
  @Override
  public String toString(){
      String output = "";
      for (int i = 0; i < count; ++i){
          output += array[i] + "\n";
      }
      return output;
  }
  
  public boolean isArrayFull(){
      return count == array.length; 
  }
  

    private void doubleArray() {
    T[] oldList = array;
    int oldSize = oldList.length;

    array = (T[]) new Object[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      array[index] = oldList[index];
    }
  }
  
      private void makeSpace(int newPosition) {
    int newIndex = newPosition - 1; 
    int lastIndex = count - 1;      

    for (int index = lastIndex; index >= newIndex; index--) {
      array[index + 1] = array[index];
    }
  }

  private void removeGap(int givenPosition) {
    int removedIndex = givenPosition - 1;   
    int lastIndex = count - 1;             

    
    for (int index = removedIndex; index < lastIndex; index++) {
      array[index] = array[index + 1];
    }
  }






    
}
