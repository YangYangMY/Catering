package rsf2s1g2.adt;

public class Map<K, V> implements MapInterface <K, V> {
    
    private MapTable<K, V>[] hashTable;		
    private int numOfEntries;
    private static final int SIZE = 100;

    public Map(){
        this(SIZE);
    }

    public Map(int tableSize) {
        hashTable = new MapTable[tableSize];
        numOfEntries = 0;
    }

    @Override
    public boolean add(K key, V value) {
        hashTable[numOfEntries] = new MapTable<K, V>(key, value);
        numOfEntries++;

        return true;
    }

    @Override
    public void remove(K key) {
        V valueToRemove = null;
        
        int index = getValueIndex(key);

        if(index != -1){
            valueToRemove = hashTable[index].getValue();
            hashTable[index].toRemove();
            numOfEntries--;
        }
    }

    @Override
    public int getValueIndex(K key) {
        int index = 0;

        for(int i = 0; i < hashTable.length; i++){
            if(key == hashTable[i].getKey()){
                index = i;
            }
        }
        return index;
    }

    @Override
    public V getValue(K key) {
        V dataValue = null;

        int index = getValueIndex(key);

        if(index != -1){
            dataValue = hashTable[index].getValue();
        }

        return dataValue;
    }

    @Override
    public boolean isEmpty() {
        return numOfEntries == 0;
    }

    @Override
    public boolean contains(K key) {
        return getValue(key) != null;
    }

    private class MapTable<K,V>{
        private K key;
        private V value;
        private boolean inTable;
        
        private MapTable(K uniqueKey, V dataValue){
            key = uniqueKey;
            value = dataValue;
            inTable = true;
        }

        private K getKey(){
            return key;
        }

        private V getValue(){
            return value;
        }

        private void setValue(V newValue){
            value = newValue;
        }

        private boolean isExist(){
            return inTable;
        }

        private void toRemove(){
            key = null;
            value = null;
            inTable = false;
        }

    }
}
