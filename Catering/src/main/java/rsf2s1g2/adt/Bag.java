package rsf2s1g2.adt;

public final class Bag<T> implements BagInterface<T> {

    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    
    private boolean initialized = false;
    private static final int MAX_CAPACITY = 10000;

    /** Creates an empty bag whose initial capacity is 25. */
    public Bag() {
        this(DEFAULT_CAPACITY);
    }

    //Creates an empty bag having a given initial capacity
    public Bag(int desiredCapacity) {
        if (desiredCapacity <= MAX_CAPACITY) {

            // The cast is safe because the new array contains null entries.
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity];
            bag = tempBag;
            numberOfEntries = 0;
            initialized = true;
        }
        else
            throw new IllegalStateException("Attempt to create a bag " +
                                            "whose capacity exceeds " +
                                            "allowed maximum.");
    }

    // Adds a new entry to this bag.
    public boolean add(T newEntry) {
        checkInitialization();
        boolean result = true;
        if (isArrayFull()) {
            result = false;
        } else {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        } 
        return result;
 
    }

    // Throws an exception if this object is not initialized.
    private void checkInitialization()
    {
        if (!initialized)
             throw new SecurityException("Bag object is not initialized " +
                                        "properly.");
   }
    
    // Retrieves all entries that are in this bag.
    public T[] toArray() {
        
        // the cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; 
        for (int index = 0; index < numberOfEntries; index++) {
            result[index] = bag[index];
        }
        return result;
    }

    public T get(int position){
        T result = null;

        if ((position >= 1) && (position <= numberOfEntries)) {
          result = bag[position - 1];
        }

        return result;
    }

    // Sees whether this bag is full.
    private boolean isArrayFull() {
        return numberOfEntries >= bag.length;
    }

    // Sees whether this bag is empty.
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // Gets the current number of entries in this bag.
    public int getCurrentSize() {
        return numberOfEntries;
    }

    // Counts the number of times a given entry appears in this bag.
    public int getFrequencyOf(T anEntry) {
        checkInitialization();
        int counter = 0;
        for (int index = 0; index < numberOfEntries; index++) {
            if (anEntry.equals(bag[index])) {
                counter++;
            } 
        } // end for
        return counter;
    } 

    // Tests whether this bag contains a given entry.
    public boolean contains(T anEntry) {
        checkInitialization();
        return getIndexOf(anEntry) > -1;
    }

    // Removes all entries from this bag.
    public void clear() {
        while (!isEmpty()) {
            remove();
        }
    } 

    // Removes one unspecified entry from this bag, if possible.
    public T remove() {
        checkInitialization();
        
    // MODIFY THIS METHOD TO REMOVE A RANDOM ITEM FROM THE BAG
        T result = removeEntry(numberOfEntries - 1);

        return result;
    } 

    // Removes one occurrence of a given entry from this bag.
    public boolean remove(T anEntry) {
        checkInitialization();
        int index = getIndexOf(anEntry);
        T result = removeEntry(index);
        return anEntry.equals(result);
    }

// Removes and returns the entry at a given array index within the array bag.
    private T removeEntry(int givenIndex) {
        T result = null;
        if (!isEmpty() && (givenIndex >= 0)) {
            result = bag[givenIndex];                   // entry to remove
            bag[givenIndex] = bag[numberOfEntries - 1]; // Replace entry with last entry
            bag[numberOfEntries - 1] = null;            // remove last entry
           numberOfEntries--;
         }
        return result;
    } 

// Locates a given entry within the array bag.
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean stillLooking = true;
        int index = 0;
        while ( stillLooking && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                stillLooking = false;
                where = index;
            } 
            index++;
        } // end for
// Assertion: If where > -1, anEntry is in the array bag, and it
// equals bag[where]; otherwise, anEntry is not in the array
        return where;
    } 
    
    
    // converts the bag to a string
    @Override
    public String toString() {
        String result = "\n";
        for (int i = 0; i < numberOfEntries; i++) {
            System.out.println(bag[i]);
        }
        return result;
    }
    
    // Check to see if two bags are equals.  
    public boolean equals(Bag<T> aBag) {
        boolean result = true; 

        T[] t = toArray();
        T[] s = aBag.toArray();
        
        for(int i = 0; i < t.length; i++){
        	for(int j = 0; j < s.length; j++){
        		if(s[j] != null && s[j].equals(t[i])){
        			t[i] = null;
        			s[j] = null;
        		}
        	}
        }
        
        for(int i = 0; i < numberOfEntries; i++)
        	if(t[i] != null)
        		result = false;
        
        for(int i = 0; i < aBag.numberOfEntries; i++)
        	if(s[i] != null)
        		result = false;

        return result;
    }  // end equals

    // Duplicate all the items in a bag.
    public boolean duplicateAll() {
        checkInitialization();
        boolean success = false; 

        if(numberOfEntries * 2 > bag.length)
        	return success;
        
        for(int i = 0; i < numberOfEntries; i++)
        	bag[i + numberOfEntries] = bag[i];
        success = true;

        return success;
    }
    
    // Remove all duplicate items from a bag
    public void removeDuplicates() {
        checkInitialization();
 
        if(numberOfEntries <= 1)
        	return;
        
        for(int i = 0; i < numberOfEntries - 1; i++){
        	for(int j = i + 1; j < numberOfEntries; j++){
        		if(bag[i].equals(bag[j])){
        			remove(bag[j]);
        			j--;
        		}
        	}
        }

        return;
    }

}

