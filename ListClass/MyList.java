package ListClass;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<T> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;

    private Object[] elements;

    public  MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    public  MyList(int capacity){
        elements = new Object[capacity];
    }

    public int size(){
        return size;
    }
    public int getCapacity(){
        return elements.length;
    }
    public void add(T data){
        if(size == elements.length){
            int newSize = elements.length * 2;
            elements = Arrays.copyOf(elements,newSize);
        }
        elements[size++] = data;
    }

    public T get(int index){
        if(index >= size || index < 0){
            return null;
        }
        return (T) elements[index];
    }
    public T remove(int index){
        if(index >= size || index < 0){
            return null;
        }
        Object item = elements[index];
        int numberElements = elements.length - (index +1);
        System.arraycopy(elements, index +1, elements, index, numberElements);
        size--;
        return (T) item;
    }
    public T set(int index , T data){
        if(index >= size || index < 0){
            return null;
        }
        elements[index] = data;
        return (T) elements[index];
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            if(elements[i]!=null) {
                sb.append(elements[i].toString());
            }
            if (i < size - 1) {
                if(elements[i]!=null) {
                    sb.append(",");
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public int indexOf(T data){
        for (int i = 0; i < size ; i++) {
            if(elements[i] == data){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T data){
        for (int i = size-1; i >= 0 ; i--) { //
            if(data == elements[i]){
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        if(size == 0){
            return true;
        }
        else{
            return false;
        }
    }
    public T[] toArray(){
        Object array = Arrays.copyOf(elements,size);
        return (T[]) array;
    }
    public void clear(){
        Arrays.fill(elements,null);
    }
    public MyList<T> subList(int start,int finish){
        if (start >= size || start < 0 || finish >= size || finish < 0) {
            System.out.println("Error invalid input !");
            return null;
        }
        MyList<T> subList = new MyList<>(finish - start);
        for (int i = start; i <= finish; i++) {
            subList.add((T) elements[i]);
        }
        return subList;
    }
    public boolean contains(T data){
        for (int i = 0; i < size; i++) {
            if(elements[i] == data){
                return true;
            }
        }
        return false;
    }
}
