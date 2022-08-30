package rsf2s1g2.adt;

import java.io.Serializable;
import rsf2s1g2.Entity.FoodBeverage;

public class List<T> implements ListInterface<T>, Serializable {

  private T[] listArray;
  private T[] tempListArray;
  private int entryNum, tempEntryNum;
  private static final int CAPACITY = 50;

  public List() {
    this(CAPACITY);
  }

  public List(int initialSize) {
    entryNum = 0;
    listArray = (T[]) new Object[initialSize];
  }

  @Override
  public boolean add(T newObj) {
    process();
    listArray[entryNum] = newObj;
    entryNum++;
    return true;
  }

  @Override
  public T remove(int posOfObj) {
    process();
    T result = null;

    if ((posOfObj >= 1) && (posOfObj <= entryNum)) {
      result = listArray[posOfObj - 1];
      if (posOfObj < entryNum) {
        removeGap(posOfObj);
      }
      entryNum--;
    }

    return result;
  }

  @Override
  public T get(int posOfObj) {
    T result = null;

    if ((posOfObj >= 1) && (posOfObj <= entryNum)) {
      result = listArray[posOfObj - 1];
    }

    return result;
  }

  @Override
  public int size() {
    return entryNum;
  }

  @Override
  public boolean isEmpty() {
    return entryNum == 0;
  }

  @Override
  public boolean isFull() {
    return entryNum == listArray.length;
  }

  @Override
  public void clear() {
    process();
    entryNum = 0;
  }

  @Override
  public boolean set(int posOfObj, T newObj) {
    process();
    boolean isSuccessful = true;

    if ((posOfObj >= 1) && (posOfObj <= entryNum)) {
      listArray[posOfObj - 1] = newObj;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public void undo(){
    listArray = tempListArray.clone();
    entryNum = tempEntryNum;
    FoodBeverage.resetFinalTotal();
  }

  private void removeGap(int posOfObj) {
    int deletedIndex = posOfObj - 1;
    int lastIndex = entryNum - 1;

    for (int i = deletedIndex; i < lastIndex; i++) {
      listArray[i] = listArray[i + 1];
    }
  }

  @Override
  public String toString() {
    String outputStr = "";
    for (int i = 0; i < entryNum; ++i) {
      outputStr += listArray[i] + "\n";
    }

    return outputStr;
  }

  public void process(){
    tempListArray = listArray.clone();
    tempEntryNum = entryNum;
    FoodBeverage.resetFinalTotal();
  }
}