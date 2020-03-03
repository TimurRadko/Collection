package com.timurradko.collection;

public interface IndexedStructure extends DataStructure {
    Object get(int index);
    boolean remove(int index);
    int indexOf(Object o);
    Object[] asArray();
    void add(int index, Object o);
}
