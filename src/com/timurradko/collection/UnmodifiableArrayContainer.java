package com.timurradko.collection;

public class UnmodifiableArrayContainer implements IndexedStructure {
    private Object[] elements;

    public UnmodifiableArrayContainer(Object[] elements) {
        this.elements = elements;
    }

    private void tryingModification() {
        throw new RuntimeException("This collection is unmodifiable");
    }

    @Override
    public void add(Object o) {
        tryingModification();
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
        tryingModification();
        return false;
    }

    @Override
    public int size() {
        return elements.length;
    }

    @Override
    public Object get(int index) {
        return elements[index];
    }

    @Override
    public boolean remove(int index) {
        tryingModification();
        return false;
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
        return elements;
    }

    @Override
    public void add(int index, Object o) {
        tryingModification();
    }
}
