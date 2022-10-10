package deque;

public class ArrayDeque <T> {
    private T[] items;
    private int size;
    private int nextFirst  = 0;
    private int nextLast = 0;

    /** Create an empty list*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }
    /**Add an item at the first position of the list*/
    public void addFirst(T item){
        if (size == 0){
            items[nextFirst] = item;
            nextFirst = items.length - 1;
            nextLast =  1;
        }else if (size < items.length){
            items[nextFirst] = item;
            nextFirst = indexMinusOne(nextFirst);
        } else {
            resize(size * 2);
            items[items.length - 1] = item;
            nextFirst = items.length - 2;
            nextLast = size;
        }
        size += 1;
    }
    /**Add an item at the last position of the list*/
    public void addLast(T item){
        if (size == 0){
            items[0] =  item;
            nextLast = 1;
            nextFirst = items.length -1;
        }else if (size < items.length){
            items[nextLast] =  item;
            nextLast =  indexPlusOne(nextLast);
        }else{
            resize(size * 2);
            items[size] = item;
            nextFirst = items.length - 1;
            nextLast = size + 1;
        }
        size += 1;
    }
    /** Get next index of current index. */
    public int indexPlusOne(int currentIndex){
        if (currentIndex+1 == items.length) {
            return 0;
        }else {
            return currentIndex+1;
        }
    }
    /** Get former index of current index. */
    public int indexMinusOne(int currentIndex){
        if (currentIndex-1 == -1){
            return items.length-1;
        }else{
            return currentIndex - 1;
        }
    }

    /**Resize the list.*/
    public void resize(int capacity){
        T[] copyItems = (T[]) new Object[capacity];
        System.arraycopy(items,nextLast,copyItems,0,size-nextLast);
        if (nextLast != 0 ){
            System.arraycopy(items,0,copyItems,size-nextLast,nextLast);
        }
        items =  copyItems;
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
        if(nextFirst != items.length - 1){
            for (int i = indexPlusOne((nextFirst)); i < items.length; i++){
                System.out.print(items[i] + " ");
            }
            for (int i = 0; i < nextLast; i++){
                if (i != nextLast -1){
                    System.out.print(items[i] + " ");
                }else{
                    System.out.println(items[i]);
                }
            }
        } else{
            for (int i = 0; i < nextLast; i++){
                if (i != nextLast -1){
                    System.out.print(items[i] + " ");
                }else{
                    System.out.println(items[i]);
                }
            }
        }
    }
    /**Removes and returns the item at the front of the deque. */
    public T removeFirst(){
        if (size == 0 ){
            return null;
        }
        nextFirst = indexPlusOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        return item;
    }

    /** Removes and returns the item at the end of the deque. */
    public T removeLast(){
        if (size == 0 ){
            return null;
        }
        nextLast = indexMinusOne(nextLast);
        T item  = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        return item;
    }


    /** Get the item at index i. */
    public T get(int i) {
        if (i > size - 1) {
            return null;
        }
        if (nextFirst == items.length - 1) {
            return items[i];
        } else{
            if (i < items.length - nextFirst){
                return items[indexPlusOne(nextFirst) + i];
            }
        }
    }




}
