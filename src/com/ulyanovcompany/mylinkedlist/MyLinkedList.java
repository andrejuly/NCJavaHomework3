package com.ulyanovcompany.mylinkedlist;

import java.util.Collections;
import java.util.Iterator;

import java.util.NoSuchElementException;

public class MyLinkedList<E> implements ILinkedList<E> {

    private Node<E> first = null;
    private Node<E> last = null;
    private int size = 0;

    private final String msgException = "The element is not found.";

    private boolean isEmpty() {
        return size == 0;
    }

    private void insertLast(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Null");
        }
        Node<E> lastNode = last;
        Node<E> newNode = new Node<>(element,lastNode,null);
        last = newNode;
        if (lastNode == null)
            first = new Node<>(element);
        else {
            lastNode.setNext(newNode);

        }
        size++;
    }

    private void insertBefore(E element) {
        if (element == null) {
            throw new IllegalArgumentException("Null");
        }
        if (size == 0) {
            first = new Node<>(element);
            last = first;
        } else {
            first.setPrevious(new Node<>(element, null, first));
            first = first.getPrevious();
        }
        size++;
    }

    private Node<E> getLinkByIndex(int index)
    {
        Node<E> result;
        if (this.size >> 1 >= index) {
            result = this.first;
            for (int i = 0; i < index; i++) {
                result = result.getNext();
            }
        } else {
            result = this.last;
            for (int i = this.size - 1; i > index; i--) {
                result = result.getPrevious();
            }
        }
        return result;
    }

    private boolean checkIndex(int index) {
        return index >= 0 && index < size;
    }

    @Override
    public E get(int index) {
        if (checkIndex(index)) {
            return getLinkByIndex(index).getElement();
        } else {
            throw new NoSuchElementException(msgException);
        }
    }

    @Override
    public void add(E element) {
        insertLast(element);
    }

    @Override
    public void add(int index, E element) {

        checkIndex(index);

        if (size == 0 || index == 0) {
            insertBefore(element);
            return;
        }

        if (index == size - 1) {
            insertLast(element);
            return;
        }

        Node<E> cur = getLinkByIndex(index);

        cur.getPrevious().setNext(new Node<>(element, cur.getPrevious(), cur));
        cur.setPrevious(cur.getPrevious().getNext());
        size++;
    }

    @Override
    public void clear() {
        size = 0;
        last = null;
        first = null;
    }

    @Override
    public int indexOf(Object element) {
        int index = 0;
        if (element == null) {
            for (Node<E> firstNode = first; firstNode != null; firstNode = firstNode.getNext(), index++) {
                if (firstNode.getElement() == null) {
                    return index;
                }
            }
        } else {
            for (Node<E> firstNode = first; firstNode != null; firstNode = firstNode.getNext(), index++) {
                if (element.equals(firstNode.getElement())) {
                    return index;
                }
            }
        }
        return -1;
    }

    private E removeByLink(Node<E> lastNode) {
        E element = lastNode.getElement();
        Node<E> next = lastNode.getNext();
        Node<E> prev = lastNode.getPrevious();

        if (prev == null)
            first = next;
        else {
            prev.setNext(next);
            lastNode.setPrevious(null);
        }

        if (next == null)
            last = prev;
        else {
            next.setPrevious(prev);
            lastNode.setNext(null);
        }
        lastNode.setElement(null);
        size--;
        return  element;
    }

    @Override
    public E remove(int index) {
        if (checkIndex(index)) {
            return removeByLink(getLinkByIndex(index));
        }
        else throw new NoSuchElementException(msgException);

    }

    @Override
    public E set(int index, E element) {
        if (checkIndex(index)) {
            Node<E> nodeIndex = getLinkByIndex(index);
            nodeIndex.setElement(element);
        } else {
            throw new NoSuchElementException(msgException);
        }
        return element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E[] toArray(E[] array) {
        if (array.length < size)
            array = (E[]) java.lang.reflect.Array.newInstance(
                    array.getClass().getComponentType(), size);
        Node<E> curNode = first;
        for (int i = 0; i < size; i++) {
            array[i] = curNode.getElement();
            curNode = curNode.getNext();
        }

        if (array.length > size)
            array[size] = null;

        return array;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (size == 0) {
            stringBuilder.append("Empty list.");
            return stringBuilder.toString();
        }

        Node<E> temp = first;
        int i = 0;
        while (temp != null) {
            stringBuilder.append(i + ". " + temp.getElement().toString() + "; ");
            i++;
            temp = temp.getNext();
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator() {
        if (isEmpty()) {
            return Collections.emptyIterator();
        }
        return new Iterator<E>() {

            private Node<E> currentNode = first;

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException(msgException);
                }
                E result = currentNode.getElement();
                currentNode = currentNode.getNext();
                return result;
            }
        };
    }
}

