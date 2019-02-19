package com.java.lists.ArrayList;

import java.util.Iterator;


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
        Element firste = (Element) fe.getNextElement().currentElement;
        return firste;
        // return (Element) getFirstNode().getNextElement().getCurrentElement();
    }


    public Element getLastElement() {

        return (Element) getLastNode().getPreviousElement().getCurrentElement();
    }


    public Element get(int index) {

        int countIndex = 0;
        for (Node<Element> x = firstNode; x != null; x = x.nextElement) {
//            if (x.currentElement == null) {
//                x = x.nextElement;
//            }

            if (countIndex == index) {
                return x.getCurrentElement();
            }
            countIndex++;
        }
        throw new IndexOutOfBoundsException();
    }

    public int getSize() {
        return size;
    }

    public void removeByValue(Element value) {

        for (Node<Element> x = firstNode; x != null; x = x.nextElement) {
            if (x.currentElement == null) {
                x = x.nextElement;
            }

            if (x.currentElement.equals(value)) {

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

        for (Node<Element> x = firstNode; x != null; x = x.nextElement) {
            if (x.currentElement == null) {
                x = x.nextElement;
            }

            if (indexCount == index) {

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

    public Iterator<Element> iterator() {
        return new Iterator<Element>() {

            Node current = firstNode.nextElement;


            @Override
            public boolean hasNext() {
                if (current.currentElement != null) {
                    return current != null;
                } else
                    return false;
            }

            @Override
            public Element next() {
                if (hasNext()) {
                    Element data = (Element) current.currentElement;
                    current = current.nextElement;
                    return data;
                }
                return null;
            }
        };
    }
}
