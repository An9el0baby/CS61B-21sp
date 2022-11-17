package deque;
import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {

    /** TypeNode class.
    Two pointer: next and previous
    One Item.*/
    private class TypeNode {
        public T item;
        public TypeNode next;
        public TypeNode previous;
        public TypeNode(T i, TypeNode n, TypeNode p) {
            item =  i;
            next = n;
            previous = p;
        }
    }

    /** LinkedList Iterator.*/
    private class LinkedListDequeIterator implements Iterator<T> {
        private TypeNode wizNode;
        public LinkedListDequeIterator(){
            wizNode =  pointNode;
        }
        @Override
        public boolean hasNext() {
            if (wizNode.next == pointNode) {
                return false;
            }
            return true;
        }

        @Override
        public T next() {
            T item = wizNode.next.item;
            wizNode = wizNode.next;
            return item;
        }
    }
    /** Make the Linked List iterable.*/
    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
    }
    private TypeNode pointNode;
    private int size;

    /** Constructor for Linked List */
    public LinkedListDeque() {
        pointNode =  new TypeNode(null, null, null);
        pointNode.next =  pointNode;
        pointNode.previous =  pointNode;
        size = 0;
    }

//    public LinkedListDeque(T i) {
//        pointNode =  new TypeNode(null,null,null);
//        pointNode.next =  new TypeNode(i, null, null);
//        pointNode.previous = pointNode.next;
//        pointNode.next.next =  pointNode;
//        pointNode.next.previous =  pointNode;
//        size = 1;
//    }

    @Override
    public void addFirst(T i) {
        TypeNode newNode  = new TypeNode(i, null, null);
        pointNode.next.previous = newNode;
        newNode.next =  pointNode.next;
        newNode.previous =  pointNode;
        pointNode.next =  newNode;
        size += 1;
    }
    @Override
    public void addLast(T i) {
        TypeNode newNode = new TypeNode(i,null,null);
        newNode.next  = pointNode;
        newNode.previous =  pointNode.previous;
        pointNode.previous.next =  newNode;
        pointNode.previous =  newNode;
        size += 1;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        TypeNode current = pointNode.next;
        while (current.next != pointNode) {
            System.out.print(current.item + " ");
            current =  current.next;
        }
        System.out.println(current.item);
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else {
            T firstVal =  pointNode.next.item;
            pointNode.next =  pointNode.next.next;
            pointNode.next.previous =  pointNode;
            size -= 1;
            return firstVal;
        }
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return  null;
        }else {
            T lastVal = pointNode.previous.item;
            pointNode.previous = pointNode.previous.previous;
            pointNode.previous.next = pointNode;
            size -= 1;
            return lastVal;
        }
    }
    @Override
    public T get(int i) {
        if (i > size-1) {
            return null;
        }
        TypeNode node = pointNode.next;
        for (int currentIndex = 0 ; currentIndex < i;currentIndex ++) {
            node = node.next;
        }
        return  node.item;
    }
    /**Recursive for get method. */
    public T getRecursive(int i) {
        if (i> size-1) {
            return null;
        }
       return getRecursive(i,0,pointNode.next);
    }
    private T getRecursive(int index, int currentIndex,TypeNode currentNode) {
        if (currentIndex == index) {
            return currentNode.item;
        }else {
            return getRecursive(index, currentIndex+1,currentNode.next);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Deque) {
            Deque<T> otherList = (Deque<T>) o;
            if (this.size() != otherList.size()) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (!(get(i).equals(otherList.get(i)))) {
                    return false;
                }
            }
            return true;
        } else {
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
