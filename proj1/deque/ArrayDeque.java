package deque;

public class ArrayDeque <T> {
    private T[] items;
    private int size;
    /** Create a empty list*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }
    /**Add an item at the first position of the list*/
    public void addFirst(T item){
        if(size == 0){
            items[0] = item;
        } else if (size < items.length){
            items = addFirst(item,items.length);
        } else {
            items = addFirst(item,items.length * 2);
        }
        size += 1;
    }
    /**Helper function for addFirst. If using resize function, the array will be copy twice. */
    private T[] addFirst(T item, int capacity){
        T[] copyItems = (T[]) new Object[capacity];
        System.arraycopy(items,0,copyItems,1,size);
        copyItems[0] = item;
        return copyItems;
    }
    /**Add an item at the last position of the list*/
    public void addLast(T item){
        if (size  == items.length){
            resize(size*2);
        }
        items[size] = item;
        size += 1;
    }
    /**Resize the list.*/
    public void resize(int capacity){
        T[] copyItems = (T[]) new Object[capacity];
        System.arraycopy(items,0,copyItems,0,size);
        items = copyItems;
    }
    /**Returns True if the list is empty*/
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else{
            return false;
        }
    }
    /**Returns the number of items in the deque.*/
    public int size(){
        return  size;
    }
    /**Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
        for (int i =0; i < size-1;i++){
            System.out.print(items[i] + " ");
        }
        System.out.println(items[size-1]);
    }
    /**Removes and returns the item at the front of the deque. */
    public T removeFirst(){
        int capacity = items.length;
        T removedItem= items[0];
        T[] copyItems = (T[]) new Object[capacity];
        System.arraycopy(items,1,copyItems,0,size-1);
        items = copyItems;
        return removedItem;
    }

}
