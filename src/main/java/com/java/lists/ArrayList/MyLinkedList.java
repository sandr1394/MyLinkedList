package com.java.lists.ArrayList;

import java.util.Iterator;

/**
 * В данном пакете нужно написать свою реализацию LinkedList
 * Немного упрощенную
 * В этом классе будет пример ячейки списка (ноды) используя этот класс, нужно сделать реализацию списка
 * <p>
 * Список должен уметь:
 * Вернуть первый элемент
 * Вернуть последний элемент
 * Добавить новый элемент в конец списа (просто операция add)
 * Добавить элемент в начало списка
 * Добавить элемент в конец списка
 * Удалить элемент по индексу
 * Удалить элемент по значению (в этом и предыдущем нужно перегрузить метод удаления)
 * Вернуть длину списка
 * <p>
 * <p>
 * ***(Со зведочкой) реализовать возможность прохождения итератором по списку
 * <p>
 * Далее методов main не будет, на каждое задание нужно писать тесты, проверяющие его, пример теста лежит в
 * одноименном пакете в папке test
 * <p>
 * Гуглить реализацию нельзя! Только в полном отчаянии. Можно бесконечно читать про листы, заглядывать в LinkedList в jdk.
 */
public class MyLinkedList<Element> implements Iterable {

    private Node firstNode;
    private Node lastNode;
    private int size = 0;

    public MyLinkedList() {
        firstNode = new Node(null, null, null);
        lastNode = new Node(firstNode, null, null);
        firstNode.setNextElement(lastNode);
    }

    private Node getFirstNode() {
        return firstNode;
    }

    private Node getLastNode() {
        return lastNode;
    }

    private class Node<Element> {

        Element currentElement;
        Node<Element> nextElement;
        Node<Element> previousElement;

        private Node(Node<Element> previousElement, Element currentElement, Node<Element> nextElement) {
            this.currentElement = currentElement;
            this.nextElement = nextElement;
            this.previousElement = previousElement;
        }

        private Element getCurrentElement() {
            return currentElement;
        }

        private void setCurrentElement(Element currentElement) {
            this.currentElement = currentElement;
        }

        private Node<Element> getNextElement() {
            return nextElement;
        }

        private void setNextElement(Node<Element> nextElement) {
            this.nextElement = nextElement;
        }

        private Node<Element> getPreviousElement() {
            return previousElement;
        }

        private void setPreviousElement(Node<Element> previousElement) {
            this.previousElement = previousElement;
        }
    }


    public void addLast(Element newElement) {

        Node<Element> newNode = lastNode;
        newNode.setCurrentElement(newElement);
        lastNode = new Node(newNode, null, null);
        newNode.setNextElement(lastNode);
        size++;
    }


    public void addFirst(Element newElement) {

        Node<Element> newNode = firstNode;
        newNode.setCurrentElement(newElement);
        firstNode = new Node(null, null, newNode);
        newNode.setPreviousElement(firstNode);

        size++;
    }

    public Element getFirstElement() {

        Node fe = firstNode;
        Element firste =  (Element)fe.getNextElement().currentElement;
        return firste;
        // return (Element) getFirstNode().getNextElement().getCurrentElement();
    }


    public Element getLastElement() {

        return (Element) getLastNode().getPreviousElement().getCurrentElement();
    }


    public Element getByIndex(Integer index){

        Integer countIndex=0;
        Element el = null;
        for (Node<Element> x = firstNode; x != null; x = x.nextElement) {
//            if (x.currentElement == null) {
//                x = x.nextElement;
//            }

            if(countIndex==index){
                el = x.getCurrentElement();
            }
            countIndex++;
        }
        return el;
    }

    public int getSize() {
        return size;
    }

    public void removeByValue(Element value) {

        for (Node<Element> x = firstNode; x != null; x = x.nextElement)
        {
            if(x.currentElement == null){
                x = x.nextElement;
            }

            if(x.currentElement.equals(value)){

                Node<Element> nextEl = x.nextElement;
                Node<Element> prevEl = x.previousElement;

                nextEl.setPreviousElement(prevEl);
                prevEl.setNextElement(nextEl);

                x.setNextElement(null);
                x.setPreviousElement(null);
                x.setCurrentElement(null);
            }
        }
        size--;
    }

    public void removeByIndex(Integer index) {

        Integer indexCount = 1;

        for (Node<Element> x = firstNode; x != null; x = x.nextElement)
        {
            if(x.currentElement == null){
                x = x.nextElement;
            }

            if(indexCount == index){

                Node<Element> nextEl = x.nextElement;
                Node<Element> prevEl = x.previousElement;

                nextEl.setPreviousElement(prevEl);
                prevEl.setNextElement(nextEl);

                x.setNextElement(null);
                x.setPreviousElement(null);
                x.setCurrentElement(null);
            }
            indexCount++;
        }
        size--;

    }

    @Override
    public Iterator iterator() {
        return null;
        //Реализовать здесь свой итератор
    }
}
