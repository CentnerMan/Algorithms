package ru.lebedev.se.linkedlist.iterator;


import ru.lebedev.se.linkedlist.twoside.Link;

public class LinkIterator {
    private Link current;
    private Link previous;
    private LinkedList list;

    public LinkIterator(LinkedList list) {
        this.list = list;
        this.reset();
    }

    // Сброс итератора
    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd() {
        return (current.next == null);
    }

    // Перемещение к следующему
    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public Link getCurrent() {
        return current;
    }

    public void insertAfter(String name, int age) {
        Link newLink = new Link(name, age);
        if (list.isEmpty()) {
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String name, int age) {
        Link newLink = new Link(name, age);
        if (previous == null) {
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        } else {
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent() {
        String name = current.name;
        if (previous == null) {
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return name;
    }
}
