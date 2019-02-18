package com.java.lists.ArrayList;

import java.util.ArrayList;

/**
 * В данном классе нужно написать методы, которые вызывают различные методы ArrayList
 *
 * В тесте нужно проверить каждый метод, перед этим заполнив список какими-нибудь элементами
 *
 * Добавить элемент
 * Добавить элемент по индексу
 * Вызвать метод trimToSize() посмотреть на его результат
 * Вызвать метод indexOf()
 * Вызвать метод contains()
 * Удалить элемент
 * Вызвать метод set, понять чем он отличается от add
 * Вызвать метод очитски списка
 */

public class Arraylist {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList(5) ;

        for(int i =0;i<10;i++){
            list.add(i);
        }

        //Add element
        list.add(7);

        //Add element by index
        list.add(3,13);



        //Delete element
        list.remove(5);

        list.trimToSize();

//        //Set value
//        list.set(5, 777);
//
//        //Erase list
//        //list.clear();
        //print(list);

        System.out.println(list.size());
    }


    public static void print(ArrayList<Integer> list){
        for(Integer element: list){
            System.out.println(element);
        }
    }
}
