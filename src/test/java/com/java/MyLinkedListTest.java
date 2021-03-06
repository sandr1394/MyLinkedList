package com.java;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.java.lists.ArrayList.MyLinkedList;

import java.util.Iterator;

public class MyLinkedListTest {

    @Test
     void getSizeTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Assertions.assertEquals(list.getSize(), 5);

    }

    @Test
    void getFirstTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Assertions.assertEquals(list.getFirstElement(), 1);
    }

    @Test
    void getLastTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Assertions.assertEquals(list.getLastElement(),5);
    }


    @Test
    void getByIndexTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Assertions.assertEquals(list.get(4), 4);
    }

    @Test
    void removeByValueTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeByValue(3);

        Iterator it = list.iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }



    }
    @Test
    void removeByIndexTest(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        list.removeByIndex(4);

        Iterator it = list.iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }
    }

    @Test
    void printList(){
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
        list.addLast(5);

        Iterator it = list.iterator();

        while(it.hasNext()){

            System.out.println(it.next());
        }

    }

}
