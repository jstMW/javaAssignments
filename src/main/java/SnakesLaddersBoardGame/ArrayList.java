package SnakesLaddersBoardGame;

import java.util.NoSuchElementException;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private int size;
    private final int CAPACITY = 20;
    private E[] data;

    public ArrayList() {
        data = (E[]) new Object[CAPACITY];
    }

    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * check if index is in boundaries (0-size of arraylist)
     *
     * @param index the specified index to be checked
     * @param s     the maximum number could be index
     * @throws IndexOutOfBoundsException if the above condition fails
     */
    private void checkIndex(int index, int s) throws IndexOutOfBoundsException {
        if (index < 0 || index > s) {
            throw new IndexOutOfBoundsException("index out of bound: " + index);
        }
    }

    /**
     * doubles the size of arraylist by making a new array and copy the values over
     * the new array and set it as data field
     *
     */
    private void resize() {
        E[] newArray = (E[]) new Object[2 * data.length];
        for (int index = 0; index < data.length; index++) {
            newArray[index] = data[index];
        }
        data = newArray;
    }

    /**
     * Returns (but does not remove) the element at index i.
     *
     * @param index the index of the element to return
     * @return the element at the specified index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E get(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        return data[index];
    }

    /**
     * Replaces the element at the specified index, and returns the element
     * previously stored.
     *
     * @param index   the index of the element to replace
     * @param element the new element to be stored
     * @return the previously stored element
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()-1
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E toReturn = data[index];

        return toReturn;
    }

    /**
     * Inserts the given element at the specified index of the list, shifting
     * all subsequent elements in the list one position further to make room.
     *
     * @param index   the index at which the new element should be stored
     * @param element the new element to be stored
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkIndex(index, size + 1);
        if (size == data.length) {
            resize();
        }

        for (int i = size; i > index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = element;
        size++;
    }

    /**
     * Removes and returns the element at the given index, shifting all
     * subsequent elements in the list one position closer to the front.
     *
     * @param index the index of the element to be removed
     * @return the element that had be stored at the given index
     * @throws IndexOutOfBoundsException if the index is negative or greater
     *                                   than size()
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        checkIndex(index, size);
        E toReturn = data[index];

        for (int i = index; i > size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return toReturn;
    }

    private class ArrayListIterator implements Iterator<E> {

        private int j;

        /**
         * check whether there is at least one more element
         *
         * @return true if there is at least oen element, otherwise false
         */
        public boolean hasNext() {
            return j < size;
        }

        /**
         * if there is an element it will return it
         *
         * @reutrn next element
         * @throws NoSuchElementException if no further element exists
         */
        public E next() {
            if (size == j) {
                throw new NoSuchElementException("No next element");
            }
            return data[j++];
        }
    }

    /**
     * Returns an iterator of the elements stored in the list.
     *
     * @return iterator of the list's elements
     */
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

}
