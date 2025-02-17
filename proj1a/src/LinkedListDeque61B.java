import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    class Node{
        private Node next;
        private Node prev;
        private  T item;
        private Node(T i, Node n, Node p){
            prev = p;
            item = i;
            next = n;
        }
    }
    private Node sentinel;
    private int size;
    public LinkedListDeque61B(){
        size = 0;
        sentinel = new Node((T) Integer.valueOf(0),null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    @Override
    public void addFirst(T x) {
        Node newFirst = new Node(x ,sentinel.next,sentinel);
        sentinel.next.prev = newFirst;
        sentinel.next = newFirst;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node newLast = new Node(x ,sentinel,sentinel.prev);
        sentinel.prev.next = newLast;
        sentinel.prev = newLast;
        size += 1;
    }

    @Override
    public T getFirst() {
        return (T) sentinel.next.item;
    }


    @Override
    public T removeFirst() {
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size -= 1;
        return (T) sentinel.next.next;
    }

    @Override
    public List<T> toList() {
        List returnList = new ArrayList<>();
        Node a = sentinel.next;
        for (int i = 0; i<size; i++){
            returnList.add(a.item);
            a = a.next;
        }
        return returnList;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index >= size) {return null;}
        Node a = sentinel.next;
        for (int i = 0; i<=size; i++){
            a = a.next;
        }
        return a.item;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }
    @Override
    public int getSize() {
        return size;
    }
}