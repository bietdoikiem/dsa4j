package data_structures;

public class SimpleArrayHashTable<T> {

  /**
   * Simple array hash table with the hash function that follows alphabetical
   * order
   */
  public final static int MAX_CAPACITY = 26; // Maximum of English Alphabet
  private final int ALPHABET_CONVERTER_VALUE = 97; // For lowercase ASCII code;
  protected int size;
  protected T[] array;

  public SimpleArrayHashTable() {
    this.array = (T[]) new Object[MAX_CAPACITY];
  }

  /**
   * Return the current size of Hash Table
   */
  public int size() {
    return this.size;
  }

  /**
   * Add an item to the Hash Table
   * 
   * @param key   Key for retrieval in HashTable
   * @param value Value to be added
   * @return Added value
   */
  public T put(String key, T value) {
    return this.array[this.hash(key)] = value;
  }

  public T get(String key) {
    return this.array[this.hash(key)];
  }

  /**
   * Hash the key to array index
   * 
   * @param key Key of Hash Table
   * @return Array index
   */
  private int hash(String key) {
    char firstChar = key.toLowerCase().charAt(0);
    int alphabetIdx = ((int) firstChar) - ALPHABET_CONVERTER_VALUE;
    return alphabetIdx;
  }
}