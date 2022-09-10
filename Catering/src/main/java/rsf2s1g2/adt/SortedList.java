package rsf2s1g2.adt;

import rsf2s1g2.utility.Font;
import rsf2s1g2.utility.Screen;

/**
 *
 * @author Wee Yan
 * @param <T>
 */
public class SortedList <T extends Comparable<T>> implements SortedListInterface<T>{
  
  private T[] data;
  private int count;
  private static final int DEFAULT_CAPACITY = 30;
  
  public SortedList() {
    this(DEFAULT_CAPACITY);
  }
  
    public SortedList(int initialCapacity) {
    count = 0;
    data = (T[]) new Comparable[initialCapacity];
  }
    
  @Override
  public boolean insert(T newData){
      int i = 0;
      if(newData == null){
        Font.print(Font.ANSI_RED,"Data cannot be empty.");
          return false;
      }
      if(isdataFull()){
        ExpandData();
      }
      while(i < count && newData.compareTo(data[i]) > 0){
          if(newData.compareTo(data[i]) == 0){
            Font.print(Font.ANSI_RED,"Duplicated data");
              return false;
          }
          i++;
      }
      makeSpace(i+1);
      data[i] = newData;
      count++;
      
      return true;
  }
  
    @Override
  public boolean delete(T anData){
    boolean DataExist = false;
    int tempI = 0;
    T[] cloneData = data;
  

      for (int i = 0; i < getCount(); i++) {
        if (anData.equals(data[i])) {
            DataExist = true;
            tempI = i;
        }
      }
      if(DataExist){
        count--;

        int a = 0;
        // Move Entire  array to a temp array except the chosen delete id
        for (int ia = 0; ia < getCount() + 1; ia++) { //50
            if (!data[ia].equals(anData)) {
                cloneData[a] = data[ia];
                a++;
            }
        }
        cloneData[getCount()] = null;
        return true;

      }else {
        return false;
    }
  
}
  
  
  public T getEntry(int position){
        int n = 0;
        
        while(data[n] != null){
            if(n == position){
                return data[position];
            }
            n++;
        }
       return null; 
  }

  
    @Override
  public void clear() {
    count = 0;
  }
  
    @Override
  public boolean check(T anData) {
    boolean found = false;
    for (int index = 0; !found && (index < count); index++) {
      if (anData.equals(data[index])) {
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
          output += data[i] + "\n";
      }
      return output;
  }
  
  public boolean isdataFull(){
      return count == data.length; 
  }
  

    private void ExpandData() {
    T[] oldList = data;
    int oldSize = oldList.length;

    data = (T[]) new Object[2 * oldSize];

    for (int index = 0; index < oldSize; index++) {
      data[index] = oldList[index];
    }
  }
  
      private void makeSpace(int newPosition) {
    int newIndex = newPosition - 1; 
    int lastIndex = count - 1;      

    for (int index = lastIndex; index >= newIndex; index--) {
      data[index + 1] = data[index];
    }
  }






    
}
