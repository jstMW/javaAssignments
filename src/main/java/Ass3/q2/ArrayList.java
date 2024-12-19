package Ass3.q2;

public class ArrayList<E> implements List<E> {
    private E[] data;
    private final int CAPACITY = 10;

    public ArrayList() {
        data = (E[]) new object[CAPACITY];
    }
    public ArrayList(int capacity) {
        data = (E[]) new object[capacity];
    }


    public int size() {return size;}
    public isEmpty() {return size==0;}

    public E get(int i) {
        checkIndex(i, size());
        return data[i];
    }

    public E set(int i, E e) {
        checkIndex(i, size());
        E toReturn = data[i];
        data[i] = e;
        return toReturn;
    }

    public void add(int index, E element) {
        checkIndex(index, size());
        if (size == data.length) {
            E[] newData = new E[data.length*2];
            for (int i=0; i<data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }

        for (int i=index; i<data.length; i++) {
            data[i+1] = data[i];
        }

        data[i] = element;
        size++;
    }

    public E remove(int index) {
        checkIndex(index, size());
        if (isEmpty()) {return null;}

        E toReturn = data[i];

        for (int i=index; i<size; i++) {
            data[i] = data[i+1];
        }

        size--;
        return toReturn;
    }


    protected void checkIndex(int index, int size) throws IndexOutofBoundException {
        if (index < 0 || index >= size) {throw new IndexOutofBoundException("Illegal Index: " + index);}
     }




}
