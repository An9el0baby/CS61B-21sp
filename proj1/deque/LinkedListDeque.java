package deque;

public class LinkedListDeque<T> {
    private class typeNode{
        public T item;
        public typeNode next;
        public typeNode previous;
        public typeNode (T i, typeNode n, typeNode p){
            item =  i;
            next = n;
            previous = p;
        }
    }

    private typeNode pointNode;
    private int size;

    public LinkedListDeque(){
        pointNode =  new typeNode(null, null, null);
        pointNode.next =  pointNode;
        pointNode.previous =  pointNode;
        size = 0;
    }

    public LinkedListDeque(T i){
        pointNode =  new typeNode(null,null,null);
        pointNode.next =  new typeNode(i, null, null);
        pointNode.previous = pointNode.next;
        pointNode.next.next =  pointNode;
        pointNode.next.previous =  pointNode;
        size = 1;
    }

    public void addFirst(T i){
        typeNode newNode  = new typeNode(i,null,null);
        pointNode.next.previous = newNode;
        newNode.next =  pointNode.next;
        newNode.previous =  pointNode;
        pointNode.next =  newNode;
        size += 1;
    }
    public void addLast(T i){
        typeNode newNode = new typeNode(i,null,null);
        newNode.next  = pointNode;
        newNode.previous =  pointNode.previous;
        pointNode.previous.next =  newNode;
        pointNode.previous =  newNode;
        size += 1;
    }
    public boolean isEmpty(){
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        typeNode current = pointNode.next;
        while (current.next != pointNode){
            System.out.print(current.item + " ");
            current =  current.next;
        }
        System.out.println(current.item);
    }
    public T removeFirst(){
        if (size == 0){
            return null;
        } else{
            T firstVal =  pointNode.next.item;
            pointNode.next =  pointNode.next.next;
            pointNode.next.previous =  pointNode;
            size -= 1;
            return firstVal;
        }
    }
    public T removeLast(){
        if (size == 0){
            return  null;
        }else{
            T lastVal = pointNode.previous.item;
            pointNode.previous = pointNode.previous.previous;
            pointNode.previous.next = pointNode;
            size -= 1;
            return lastVal;
        }
    }
    public T get(int i){
        if (i > size-1){
            return null;
        }
        typeNode node = pointNode.next;
        for (int currentIndex = 0 ; currentIndex < i;currentIndex ++){
            node = node.next;
        }
        return  node.item;
    }
    public T getRecursive(int i){
        if (i> size-1){
            return null;
        }
       return getRecursive(i,0,pointNode.next);
    }
    private T getRecursive(int index, int currentIndex,typeNode currentNode){
        if (currentIndex == index){
            return currentNode.item;
        }else{
            return getRecursive(index, currentIndex+1,currentNode.next);
        }
    }
}
