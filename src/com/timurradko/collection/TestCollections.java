package com.timurradko.collection;

public class TestCollections {
    public static void main(String[] args) {
        String[] arrayStrings = {"Java", "Python", "C++", "Javascript", "C#"};
        DataStructure structure = new UnmodifiableArrayContainer(arrayStrings);
        System.out.println(structure.contains("Java"));
        System.out.println(structure.size());
        IndexedStructure indexedStructure = new UnmodifiableArrayContainer(arrayStrings);
        for (int i = 0; i < indexedStructure.size(); i++) {
            System.out.println(indexedStructure.get(i));
        }
        IndexedStructure resizableList = new ResizableList();
        for (int i = 0; i < 10; i++) {
            resizableList.add("Note" + i);
        }
        System.out.println(resizableList);
        resizableList.add(3, 65);
        System.out.println(resizableList.toString());
        System.out.println("Size of resizable list: " + resizableList.size());
        resizableList.remove(5);
        System.out.println(resizableList.toString());
        System.out.println("Size of resizable list: " + resizableList.size());
        resizableList.remove("Note3");
        System.out.println(resizableList.toString());
        System.out.println("Size of resizable list: " + resizableList.size());

        Object[] elements = resizableList.asArray();
        for (Object element : elements) {
            System.out.print(element + " ");
        }

    }
}
