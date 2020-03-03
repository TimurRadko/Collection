package com.timurradko.collection;

public class ResizableList implements IndexedStructure {
    private Object[] elements;
    private int size = 0;
    private int lengthArray = 0;

    public ResizableList(Object[] elements) {
        this.elements = elements;
        size = elements.length;
    }

    public ResizableList(int startSize) {
        elements = new Object[startSize];
    }

    public ResizableList() {
        elements = new Object[15];
    }

    @Override
    public Object get(int index) {
        checkAccessIndex(index);
        return elements[index];
    }

    private void checkAccessIndex(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkSize(int size) {
        if (size >= elements.length) {
            expand();
        }
    }

    @Override
    public boolean remove(int index) {
        checkAccessIndex(index);
        int leftLength = index;
        int rightLength = elements.length - index - 1;
        Object[] left = new Object[leftLength];
        Object[] right = new Object[rightLength];
        System.arraycopy(elements, 0, left, 0, left.length);
        System.arraycopy(elements, index + 1, right, 0, right.length);
        elements = unionOfArrays(left,right,leftLength,rightLength);
        size--;
        return true;
    }

    private Object[] unionOfArrays(Object[] left, Object[] right, int leftLength, int rightLength) {
        Object[] unite = new Object[leftLength + rightLength];
        System.arraycopy(left,0,unite,0,leftLength);
        System.arraycopy(right,0,unite,leftLength,rightLength);
        return unite;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < elements.length; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object[] asArray() {
        lengthArray = lengthArray(elements);
        Object[] newArray = new Object[lengthArray];
        System.arraycopy(elements,0,newArray,0,lengthArray);
        return newArray;
    }

    private int lengthArray(Object[] elements) {
        int result = 0;
        for (Object element : elements) {
            if (element == null) {
                break;
            }
            result++;
        }
        return result;
    }

    @Override
    public void add(int index, Object o) {
        checkAccessIndex(index);
        checkSize(size);
        Object[] left = new Object[index];
        Object[] right = new Object[elements.length - index];
        System.arraycopy(elements,0,left,0,left.length);
        System.arraycopy(elements,index,right,0,right.length);
        Object[] unite = new Object[elements.length + 1];
        System.arraycopy(left,0,unite,0,left.length);
        System.arraycopy(right,0,unite,left.length + 1,right.length);
        unite[index] = o;
        size++;
        elements = unite;
    }

    @Override
    public void add(Object o) {
        checkSize(size);
        elements[size] = o;
        size++;
    }

    private void expand() {
        int newLength = getNewLength(elements.length);
        Object[] expandArray = new Object[newLength];
        System.arraycopy(elements,0,expandArray,0,elements.length);
        elements = expandArray;
    }

    private int getNewLength(int currentLength) {
        return (int) (currentLength * 1.5 + 1);
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : elements) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        int indexOfElement = indexOf(o);
        if (indexOfElement < 0) {
            return false;
        } else {
            return remove(indexOfElement);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return cutList();
    }

    private String cutList() {
        lengthArray = lengthArray(elements);
        Object[] newArray = new Object[lengthArray];
        System.arraycopy(elements,0,newArray,0,lengthArray);
        String s = "[";
        for (int i = 0; i < newArray.length; i++) {
            if (i == newArray.length - 1) {
                s = s + newArray[i] + "]";
                break;
            }
            s = s + newArray[i] + ", ";
        }
        return s;
    }
}
