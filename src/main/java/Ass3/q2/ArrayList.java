package Ass3.q2;
import java.lang.IndexOutOfBoundsException;

public class ArrayList<E> implements List<E> {
    private E[] data;
    private int size = 0;
    private final int CAPACITY = 10;

    public ArrayList() {
        data = (E[]) new Object[CAPACITY];
    }
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }


    public int size() {return size;}
    public boolean isEmpty() {return size==0;}

    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size());
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size());
        E toReturn = data[i];
        data[i] = e;
        return toReturn;
    }

    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size());
        if (size == data.length) {
            E[] newData = new E[data.length*2];
            for (int i=0; i<data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        for (int i=size()-1; i>=index; i--) {
            data[i+1] = data[i];
        }

        data[index] = element;
        size++;
    }

    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size());
        if (isEmpty()) {return null;}

        E toReturn = data[index];

        for (int i=index; i<size; i++) {
            data[i] = data[i+1];
        }

        size--;
        return toReturn;
    }
    

    protected void checkIndex(int index, int size) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {throw new IndexOutOfBoundsException("Illegal Index: " + index);}
     }





}
