package deque;
import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T>{
    /**The Iterator class for ArrayDeque. */
    private class ArrayDequeIterator implements Iterator<T>{
       private int wizPos;
       public ArrayDequeIterator(){
           wizPos = 0;
       }
       @Override
        public boolean hasNext(){
           if (wizPos < size){
               return true;
           }
           return false;
       }
       @Override
        public T next(){
           T item = get(wizPos);
           wizPos += 1;
           return item;
       }
    }
    /** Enhanced For Loop.*/
    @Override
    public Iterator<T> iterator(){
        return new ArrayDequeIterator();
    }
    /**Attributes for ArrayDeque class. */
    private T[] items;
    private int size;
    private int nextFirst = 0;
    private int nextLast = 0;

    /** Create an empty list*/
    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
    }
    /** Create a list with first item.*/
    public ArrayDeque(T item){
        items = (T[]) new Object[8];
        size = 1;
        addFirst(item);
    }
    @Override
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
    @Override
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
    private int indexPlusOne(int currentIndex){
        return (currentIndex + 1) % items.length;
    }
    /** Get former index of current index. */
    private int indexMinusOne(int currentIndex){
        return (currentIndex - 1 + items.length) % items.length;
    }

    /**Resize the list.*/
    private void resize(int capacity) {
        T[] copyItems = (T[]) new Object[capacity];
        int currentFirst = indexPlusOne(nextFirst);
        int currentLast = indexMinusOne(nextLast);
        if ( currentFirst < currentLast) {
            System.arraycopy(items, currentFirst, copyItems, 0,Math.min(items.length,currentLast+1)-currentFirst);
        } else {
            int tailSize =  Math.min(items.length,nextLast) - currentFirst;
            System.arraycopy(items, indexPlusOne(nextFirst), copyItems, 0, tailSize);
            System.arraycopy(items, 0, copyItems, tailSize, size - tailSize);
        }
        items = copyItems;
    }
    @Override
    /** Returns the number of items in the deque.*/
    public int size(){
        return  size;
    }
    @Override
    /** Prints the items in the deque from first to last, separated by a space. */
    public void printDeque(){
     for (T item : this){
         System.out.print(item +" ");
     }
     System.out.println();
    }
    @Override
    /**Removes and returns the item at the front of the deque. */
    public T removeFirst(){
        if (size == 0 ){
            return null;
        }
        nextFirst = indexPlusOne(nextFirst);
        T item = items[nextFirst];
        items[nextFirst] = null;
        size -= 1;
        if (items.length == 8){
            return item;
        }
        if (size < (items.length / 4)){
            resize(Math.max(8, items.length / 4));
            nextFirst = items.length -1;
            nextLast = size;
        }
        return item;
    }

    @Override
    /** Removes and returns the item at the end of the deque. */
    public T removeLast(){
        if (size == 0 ){
            return null;
        }
        nextLast = indexMinusOne(nextLast);
        T item  = items[nextLast];
        items[nextLast] = null;
        size -= 1;
        if (items.length == 8){
            return item;
        }
        if (size < (items.length / 4)){
            resize(Math.max(8, items.length / 4));
            nextFirst = items.length -1;
            nextLast = size;
        }
        return item;
    }

    @Override
    /** Get the item at index i. */
    public T get(int i) {
        if (i > size - 1) {
            return null;
        }
        int trueIndex = (indexPlusOne(nextFirst) + i) % items.length;
        return  items[trueIndex];
    }
    @Override
    /** Returns whether the parameter o is equal to the Deque. */
    public boolean equals(Object o){
        if (this == o) {
            return true;
        }
        if (o instanceof Deque){
            Deque<T> otherList = (Deque<T>) o;
            if (this.size() != otherList.size()){
                return false;
            }
            for (int i = 0; i < size; i++){
                if (!(get(i).equals(otherList.get(i)))) {
                    return false;
                }
            }
            return true;
        } else{
            return false;
        }
    }
//    private boolean contains(T checkItem){
//        for (T item : this){
//            if (item.equals(checkItem)){
//                return true;
//            }
//        }
//        return false;
//    }

}
