import java.util.List;
/**
 * Simple hash table implementation using linear probing.
 *
 * @author Stephan Jamieson
 * @version 24/4/2015
 */
public class LPHashTable extends HashTable {

    /**
     * Create an LPHashTable with DEFAULT_SIZE table.
     */
    public LPHashTable() { super(); }

    /**
     * Create an LPHashTable with the given default size table.
     */
    public LPHashTable(final int size) { super(size); }

    /**
     * Find the index for entry: if entry is in the table, then returns its position;
     * if it is not in the table then returns the index of the first free slot.
     * Returns -1 if a slot is not found (such as when the table is full under LP).
     *
     */
    protected int findIndex(String key) {
      int hash = hashFunction(key); 

      int index = hash;
      int i=0;

      // Loop until an empty slot is found or the table is full
      while (i< tableSize() && table[index] != null && !table[index].equals(key)) {
         i++;
         incProbeCount();
         index = (hash + i) % tableSize();
      }

      // If an empty slot is found or the key is found, return the index
      if (table[index] == null || table[index].equals(key)) {
         return index;
       } else {
         return -1;
      }
      
      
   }
}
