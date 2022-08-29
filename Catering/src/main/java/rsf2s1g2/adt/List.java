package rsf2s1g2.adt;

import java.io.Serializable;

public class List<T> implements ListInterface<T>, Serializable {

  private T[] listArray;
  private int entryNum;
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
    listArray[entryNum] = newObj;
    entryNum++;
    return true;
  }

  @Override
  public T remove(int posOfObj) {
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
  public T getObj(int posOfObj) {
    T result = null;

    if ((posOfObj >= 1) && (posOfObj <= entryNum)) {
      result = listArray[posOfObj - 1];
    }

    return result;
  }

  @Override
  public int getQuantity() {
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
  public String toString() {
    String outputStr = "";
    for (int i = 0; i < entryNum; ++i) {
      outputStr += listArray[i] + "\n";
    }

    return outputStr;
  }

  @Override
  public void clear() {
    entryNum = 0;
  }

  private void removeGap(int posOfObj) {
    int deletedIndex = posOfObj - 1;
    int lastIndex = entryNum - 1;

    for (int i = deletedIndex; i < lastIndex; i++) {
      listArray[i] = listArray[i + 1];
    }
  }
}

  // @Override
  // public boolean replace(int posOfObj, T newObj) {
  //   boolean isSuccessful = true;

  //   if ((posOfObj >= 1) && (posOfObj <= entryNum)) {
  //     listArray[posOfObj - 1] = newObj;
  //   } else {
  //     isSuccessful = false;
  //   }

  //   return isSuccessful;
  // }
  /**
   * Task: Makes room for a new Obj at newPos. Precondition: 1 <=
   * newPos <= entryNum + 1; entryNum is listArray's
 entryNum before addition.
   */
  // private void makeRoom(int newPos) {
  //   int newIndex = newPos - 1;
  //   int lastIndex = entryNum - 1;

  //   // move each Obj to next higher index, starting at end of
  //   // listArray and continuing until the Obj at newIndex is moved
  //   for (int index = lastIndex; index >= newIndex; index--) {
  //     listArray[index + 1] = listArray[index];
  //   }
  // }

  /**
   * Task: Shifts entries that are beyond the Obj to be removed to the next
   * lower Pos. Precondition: listArray is not empty; 1 <= posOfObj <
 entryNum; entryNum is listArray's entryNum before removal.
   */

     // @Override
  // public boolean contains(T anObj) {
  //   boolean found = false;
  //   for (int index = 0; !found && (index < entryNum); index++) {
  //     if (anObj.equals(listArray[index])) {
  //       found = true;
  //     }
  //   }
  //   return found;
  // }
