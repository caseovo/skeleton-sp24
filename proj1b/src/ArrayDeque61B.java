import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.spi.LocaleNameProvider;

public class ArrayDeque61B<T> implements Deque61B<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    public ArrayDeque61B() {
         items = (T[]) new Object[8];
         size = 0;
         nextFirst = -1;
         nextLast = 0;

    }
    private int multiplyOrDivide(boolean x){
        if (x){
            return items.length * 2;
        }
        else {
            return items.length / 2;
        }
    }
    private void changeArraySize(boolean x) {
        if (x) {
            T[] newArray = (T[]) new Object[multiplyOrDivide(x)];
            for (int i = 0; i<size; i++){
                newArray[i] = this.get(0);
            }
            nextFirst = -1;
            nextLast = size;
        }
    }
    @Override
    public void addFirst(T x) {
        if (size >= items.length){
            changeArraySize(true);
            addFirst(x);
            return;
        }
        if (nextFirst >= 0) {
            items[nextFirst] = x;
            nextFirst -= 1;
            size += 1;
        }
        else {
            items[items.length + nextFirst] = x;
            nextFirst -= 1;
            size += 1;
        }
    }

    @Override
    public void addLast(T x) {
        if (size >= items.length){
            changeArraySize(true);
            addLast(x);
            return;
        }
        items[nextLast] = x;
        nextLast += 1;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        for (int i = 0; i < size;i++){
            returnList.add(this.get(i));
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        nextFirst += 1;
        T item = this.get(0);
        items[nextFirst] =(T) null;
        size -= 1;
        if (size < items.length/4){
            changeArraySize(false);
        }
        return item;
    }

    @Override
    public T removeLast() {
        if (size == 0){
            return null;
        }
        nextLast -= 1;
        T item = this.get(size - 1);
        items[nextLast] =(T) null;
        size -= 1;
        if (size < items.length/4){
            changeArraySize(false);
        }
        return item;
    }

    @Override
    public T get(int index) {
        if (index >= size){
            return null;
        }
        if (index < 0){
            int realIndex = nextLast + index;
            if (realIndex <0){
                return items[items.length + realIndex];
            }
            return items[realIndex];
        }
        int realIndex = nextFirst + index + 1;
        if (realIndex <0){
            return items[items.length + realIndex];
        }
        return items[realIndex];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
